package org.hibernate.cfg.reveng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.dom4j.Document;
import org.dom4j.Element;
import org.hibernate.MappingException;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.ForeignKey;
import org.hibernate.mapping.Table;
import org.hibernate.tool.hbm2x.MetaAttributeHelper;
import org.hibernate.util.StringHelper;


public final class OverrideBinder {

	private OverrideBinder() {
		// empty
	}
	
	public static void bindRoot(OverrideRepository repository, Document doc) {
		
		Element rootElement = doc.getRootElement();
		
		Element element;
		List elements;

		elements = rootElement.elements("schema-selection");
		bindSchemaSelection(elements, repository);
		
		element = rootElement.element("type-mapping");
		
		if(element!=null) {
			bindTypeMappings(element, repository);
		}
		
		
		elements = rootElement.elements("table-filter");
		bindTableFilters(elements, repository);
		
		List tables = rootElement.elements("table");
		bindTables(tables, repository);
		
	}

	private static void bindSchemaSelection(List selection, OverrideRepository repository) {
		Iterator iterator = selection.iterator();
		
		while ( iterator.hasNext() ) {
			Element element = (Element) iterator.next();
			SchemaSelection schemaSelection = new SchemaSelection();
			schemaSelection.setMatchCatalog( element.attributeValue("match-catalog") );
			schemaSelection.setMatchSchema( element.attributeValue("match-schema") );
			schemaSelection.setMatchTable( element.attributeValue("match-table") );
			
			repository.addSchemaSelection(schemaSelection);
			
		}		
	}

	private static void bindTables(List tables, OverrideRepository repository) {
		Iterator iterator = tables.iterator();
		
		while ( iterator.hasNext() ) {
			Element element = (Element) iterator.next();
			Table table = new Table();
			table.setCatalog( element.attributeValue("catalog") );
			table.setSchema( element.attributeValue("schema") );
			table.setName( element.attributeValue("name") );
			
			String wantedClassName = element.attributeValue("class");
			
			Element primaryKey = element.element("primary-key");			
			bindPrimaryKey(primaryKey, table, repository);
			List columns = element.elements("column");
			bindColumns(columns, table, repository);
			
			
			List foreignKeys = element.elements("foreign-key");
			bindForeignKeys(foreignKeys, table, repository);
			
			bindMetaAttributes(element, table, repository);
			
			repository.addTable(table,wantedClassName);
			
		}
		
	}

	private static void bindMetaAttributes(Element element, Table table, OverrideRepository repository) {
		MultiMap map = MetaAttributeBinder.loadAndMergeMetaMap( element, new MultiHashMap());
		if(map!=null && !map.isEmpty()) {
			repository.addMetaAttributeInfo( table, map);
		} 
	}

	private static void bindPrimaryKey(Element identifier, Table table, OverrideRepository repository) {
		if(identifier==null) return;
		
		String propertyName = identifier.attributeValue("property");
		String compositeIdName = identifier.attributeValue("id-class");
		
		Element element = identifier.element("generator");
		if(element!=null) {
			String identifierClass = element.attributeValue("class");
			
			Properties params = new Properties();
			Iterator iter = element.elementIterator( "param" );
			while ( iter.hasNext() ) {
				Element childNode = (Element) iter.next();
				params.setProperty( childNode.attributeValue( "name" ), childNode.getText() );
			}
			
			repository.addTableIdentifierStrategy(table, identifierClass, params);
		}
		
		List boundColumnNames = bindColumns(identifier.elements("key-column"), table, repository);
		
		repository.addPrimaryKeyNamesForTable(table, boundColumnNames, propertyName, compositeIdName);
		
	}

	private static void bindForeignKeys(List foreignKeys, Table table, OverrideRepository repository) {
		Iterator iterator = foreignKeys.iterator();
		
		while( iterator.hasNext() ) {
			Element element = (Element) iterator.next();
			
			String constraintName = element.attributeValue("constraint-name");
			
			String foreignTableName = element.attributeValue("foreign-table");
			if(foreignTableName!=null) {
				Table foreignTable = new Table();
				foreignTable.setName(foreignTableName);
				foreignTable.setCatalog(getValue(element.attributeValue( "foreign-catalog"), table.getCatalog()) );
				foreignTable.setSchema(getValue(element.attributeValue( "foreign-schema"), table.getSchema()) );

				List localColumns = new ArrayList();
				List foreignColumns = new ArrayList();
				
				Iterator columnRefs = element.elements("column-ref").iterator();
				while ( columnRefs.hasNext() ) {
					Element columnRef = (Element) columnRefs.next();
					String localColumnName = columnRef.attributeValue("local-column");
					String foreignColumnName = columnRef.attributeValue("foreign-column");
					
					Column localColumn = new Column(localColumnName);
					Column foreignColumn = new Column(foreignColumnName);
					
					localColumns.add(localColumn);
					foreignColumns.add(foreignColumn);
				}
								
				ForeignKey key = table.createForeignKey(constraintName, localColumns, foreignTableName, foreignColumns);
				key.setReferencedTable(foreignTable); // only possible if foreignColumns is explicitly specified (workaround on aligncolumns)				
			}
			
			if(StringHelper.isNotEmpty(constraintName)) {
				String manyToOneProperty = null;
				Boolean excludeManyToOne = null;
				
				Element manyToOne = element.element("many-to-one");
				if(manyToOne!=null) {
					manyToOneProperty = manyToOne.attributeValue("property");
					excludeManyToOne = BooleanValue(manyToOne.attributeValue("exclude"));					
				}
				
				String collectionProperty = null;
				Boolean excludeCollection = null;
				Element collection = element.element("set");
				if(collection!=null) {
					collectionProperty = collection.attributeValue("property");
					excludeCollection = BooleanValue(collection.attributeValue("exclude"));
				}
				repository.addForeignKeyInfo(constraintName, manyToOneProperty, excludeManyToOne, collectionProperty, excludeCollection);
			}
			
		}
		
	}

	private static Boolean BooleanValue(String string) {
		if(string==null) return null;
		return Boolean.valueOf(string);		
	}

	private static String getValue(String first, String second) {
		if(first==null) {
			return second;		
		} else { 
			return first;
		}
	}

	private static List bindColumns(List columns, Table table, OverrideRepository repository) {
		Iterator iterator = columns.iterator();
		List columnNames = new ArrayList();
		while( iterator.hasNext() ) {
			Element element = (Element) iterator.next();
			Column column = new Column();
			column.setName( element.attributeValue("name") );
			String attributeValue = element.attributeValue("jdbc-type");
			if(StringHelper.isNotEmpty(attributeValue)) {
				column.setSqlTypeCode(new Integer(JDBCToHibernateTypeHelper.getJDBCType(attributeValue)));
			}
						
			TableIdentifier tableIdentifier = TableIdentifier.create(table);
			if(table.getColumn(column)!=null) {
				throw new MappingException("Column " + column.getName() + " already exists in table " + tableIdentifier );
			}
			
			MultiMap map = MetaAttributeBinder.loadAndMergeMetaMap( element, new MultiHashMap());
			if(map!=null && !map.isEmpty()) {
				repository.addMetaAttributeInfo( tableIdentifier, column.getName(), map);
			} 
			
			table.addColumn(column);
			columnNames.add(column.getName());
			repository.setTypeNameForColumn(tableIdentifier, column.getName(), element.attributeValue("type"));
			repository.setPropertyNameForColumn(tableIdentifier, column.getName(), element.attributeValue("property"));
			
			boolean excluded = booleanValue( element.attributeValue("exclude") );
			if(excluded) {
				repository.setExcludedColumn(tableIdentifier, column.getName());
			}
			
			String foreignTableName = element.attributeValue("foreign-table");
			if(foreignTableName!=null) {
				List localColumns = new ArrayList();
				localColumns.add(column);
				List foreignColumns = new ArrayList();
				
				Table foreignTable = new Table();
				foreignTable.setName(foreignTableName);
				foreignTable.setCatalog(getValue(element.attributeValue( "foreign-catalog"),table.getCatalog()) );
				foreignTable.setSchema(getValue(element.attributeValue( "foreign-schema"), table.getSchema()) );
				
				String foreignColumnName = element.attributeValue("foreign-column");
				if(foreignColumnName!=null) {
					Column foreignColumn = new Column();
					foreignColumn.setName(foreignColumnName);
					foreignColumns.add(foreignColumn);
				} 
				else {
					throw new MappingException("foreign-column is required when foreign-table is specified on " + column);
				}
				
				ForeignKey key = table.createForeignKey(null, localColumns, foreignTableName, foreignColumns);
				key.setReferencedTable(foreignTable); // only possible if foreignColumns is explicitly specified (workaround on aligncolumns)
			}
			
			
			
		}
		
		return columnNames;
	}

	private static boolean booleanValue(String value) {
		return Boolean.valueOf(value).booleanValue();
	}

	private static void bindTableFilters(List filters, OverrideRepository respository) {
		Iterator iterator = filters.iterator();
		
		while(iterator.hasNext() ) {
			Element element = (Element) iterator.next();
			TableFilter filter = new TableFilter();
			filter.setMatchCatalog(element.attributeValue("match-catalog") );
			filter.setMatchSchema(element.attributeValue("match-schema") );
			filter.setMatchName(element.attributeValue("match-name") );
			filter.setExclude(Boolean.valueOf(element.attributeValue("exclude") ) );
			filter.setPackage(element.attributeValue("package") );
			
			MultiMap map = MetaAttributeBinder.loadAndMergeMetaMap( element, new MultiHashMap());
			if(map!=null && !map.isEmpty()) {
				filter.setMetaAttributes( map );
			} else {
				filter.setMetaAttributes( null );				
			}
			respository.addTableFilter(filter);
		}
		
	}

	private static void bindTypeMappings(Element typeMapping, OverrideRepository repository) {
		Iterator iterator = typeMapping.elements("sql-type").iterator();
		
		while (iterator.hasNext() ) {
			Element element = (Element) iterator.next();
			int jdbcType = JDBCToHibernateTypeHelper.getJDBCType(element.attributeValue("jdbc-type") );
			SQLTypeMapping mapping = new SQLTypeMapping(jdbcType );
			mapping.setHibernateType( getHibernateType( element ) );			
			mapping.setLength(getInteger(element.attributeValue("length"), SQLTypeMapping.UNKNOWN_LENGTH) );
			mapping.setPrecision(getInteger(element.attributeValue("precision"), SQLTypeMapping.UNKNOWN_PRECISION) );
			mapping.setScale(getInteger(element.attributeValue("scale"), SQLTypeMapping.UNKNOWN_SCALE) );
			String notNull = element.attributeValue("not-null");
			if(notNull==null) {
				mapping.setNullable(null);
			} else {
				boolean nullable = notNull.equals( "false" );
				mapping.setNullable( Boolean.valueOf(nullable) );
			}
			
			if(StringHelper.isEmpty(mapping.getHibernateType())) {
				throw new MappingException("No hibernate-type specified for " + element.attributeValue("jdbc-type") + " at " + element.getUniquePath());
			}
			repository.addTypeMapping(mapping);
		}
		
	}

	private static String getHibernateType(Element element) {
		String attributeValue = element.attributeValue("hibernate-type");
		
		if(StringHelper.isEmpty(attributeValue)) {
			Element child = element.element("hibernate-type");
			if(child==null) {
				return null;
			} else {
				return child.attributeValue("name");
			}
			
		}
		
		return attributeValue;
	}
	
	private static int getInteger(String string, int defaultValue) {
		if(string==null) {
			return defaultValue;
		} 
		else {
			return Integer.parseInt(string);
		}		
	}

	String getMatchString(String input) {
		return input.toUpperCase();
	}
	

}
