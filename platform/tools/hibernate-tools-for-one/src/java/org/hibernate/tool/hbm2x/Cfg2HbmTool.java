/*
 * Created on 2004-12-03
 */
package org.hibernate.tool.hbm2x;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.Versioning;
import org.hibernate.engine.query.sql.NativeSQLQueryCollectionReturn;
import org.hibernate.engine.query.sql.NativeSQLQueryJoinReturn;
import org.hibernate.engine.query.sql.NativeSQLQueryReturn;
import org.hibernate.engine.query.sql.NativeSQLQueryRootReturn;
import org.hibernate.mapping.Any;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.Bag;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Component;
import org.hibernate.mapping.DependantValue;
import org.hibernate.mapping.Formula;
import org.hibernate.mapping.IdentifierBag;
import org.hibernate.mapping.JoinedSubclass;
import org.hibernate.mapping.List;
import org.hibernate.mapping.ManyToOne;
import org.hibernate.mapping.OneToMany;
import org.hibernate.mapping.OneToOne;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.PersistentClassVisitor;
import org.hibernate.mapping.PrimitiveArray;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.RootClass;
import org.hibernate.mapping.SimpleValue;
import org.hibernate.mapping.SingleTableSubclass;
import org.hibernate.mapping.Subclass;
import org.hibernate.mapping.UnionSubclass;
import org.hibernate.mapping.Value;
import org.hibernate.mapping.ValueVisitor;
import org.hibernate.persister.entity.JoinedSubclassEntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.persister.entity.UnionSubclassEntityPersister;
import org.hibernate.tool.hbm2x.visitor.EntityNameFromValueVisitor;
import org.hibernate.tool.hbm2x.visitor.HBMTagForPersistentClassVisitor;
import org.hibernate.tool.hbm2x.visitor.HBMTagForValueVisitor;

/**
 * @author David Channon and Max
 */
public class Cfg2HbmTool {

	private final class HasEntityPersisterVisitor implements PersistentClassVisitor {
		private final String name;

		private HasEntityPersisterVisitor(String name) {
			this.name = name;
		}

		public Object accept(Subclass subclass) {
			return bool(!SingleTableEntityPersister.class.getName().equals(name));
		}

		private Object bool(boolean b) {
			return Boolean.valueOf( b );
		}

		public Object accept(JoinedSubclass subclass) {
			return bool(!JoinedSubclassEntityPersister.class.getName().equals(name));
		}

		public Object accept(SingleTableSubclass subclass) {
			return bool(!SingleTableEntityPersister.class.getName().equals(name));							
		}

		public Object accept(UnionSubclass subclass) {
			return bool(!UnionSubclassEntityPersister.class.getName().equals(name));
		}

		public Object accept(RootClass class1) {
			return bool(!SingleTableEntityPersister.class.getName().equals(name));
		}
	}

	public String getTag(PersistentClass pc) {
		return (String) pc.accept(HBMTagForPersistentClassVisitor.INSTANCE);
	}
	
	public String getTag(Property property) {
		PersistentClass persistentClass = property.getPersistentClass();
		if(persistentClass!=null) {
			if(persistentClass.getVersion()==property) {
				String typeName = ((SimpleValue)property.getValue()).getTypeName();
				if("timestamp".equals(typeName) || "dbtimestamp".equals(typeName)) {
					return "timestamp";
				} else {
					return "version";
				}
			}
		}
		return (String) property.getValue().accept(HBMTagForValueVisitor.INSTANCE);
	}
	
	public boolean isUnsavedValue(Property property) {
		SimpleValue sv = (SimpleValue) property.getValue();
		return ((sv.getNullValue()==null) || "undefined".equals(sv.getNullValue())) ? false : true;
	}
	
	public String getUnsavedValue(Property property) {
		return ( (SimpleValue) property.getValue() ).getNullValue();
	}

	/**
	 * 
	 * @param property
	 * @return
	 */
	public boolean isIdentifierGeneratorProperties(Property property) {
		Properties val = this.getIdentifierGeneratorProperties(property);
		return (val==null) ? false : true;
	}
	
	public Properties getIdentifierGeneratorProperties(Property property) {
		return ( (SimpleValue) property.getValue() ).getIdentifierGeneratorProperties();
	}

	/**
	 * Remove any internal keys from the set, eg, any Keys that are prefixed by
	 * 'target_' and return the filtered collection.
	 * 
	 * @param property
	 * @return
	 */
	public Set getFilteredIdentifierGeneratorKeySet(Property property) {
		Set sval = new HashSet();
		Properties pval = this.getIdentifierGeneratorProperties(property);
		Iterator itr = pval.keySet().iterator();
		while (itr.hasNext() ) {
			String key = (String) itr.next();
			if (! key.startsWith("target_") )
				sval.add(key);
		}
		return sval;
	}

    public boolean isOneToMany(Property property) {
        return isOneToMany(property.getValue());
    }

    public boolean isManyToMany(Property property) {
    	Value value = property.getValue();
    	if(value instanceof Collection && !((Collection)value).isOneToMany()) {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    public boolean isOneToMany(Value value) {
        if(value instanceof Collection) {
            return ( (Collection)value ).isOneToMany();
        }else if(value instanceof OneToMany){
        	return true;
        }
        return false;
    }

	public boolean isCollection(Property property) {
        return property.getValue() != null && property.getValue() instanceof Collection;
    }

	public boolean isOneToManyCollection(Property property) {
		return isCollection(property) && ((Collection)property.getValue()).isOneToMany();
	}
	
	public boolean isManyToOne(Property property) {
        return (property.getValue()!=null) && (property.getValue() instanceof ManyToOne);
    }
    
    public boolean isNamedQueries(Configuration cfg) {
		Map nqry = cfg.getNamedQueries();
		return nqry == null || nqry.isEmpty() ? false : true;
	}

	public boolean isNamedSQLQueries(Configuration cfg) {
		Map nsqlqry = cfg.getNamedSQLQueries();
		return nsqlqry == null || nsqlqry.isEmpty() ? false : true;
	}
	
	public String getNamedSQLReturnTag(NativeSQLQueryReturn sqlret) {
		String retVal = "return";
		if (isNamedSQLReturnRole(sqlret) ) {
			retVal = "return-join";
		}
		else if (isNamedSQLReturnCollection(sqlret) ) {
			retVal = "load-collection";
		}
		return retVal;
	}
	
	public String getNamedSQLReturnProperty(NativeSQLQueryJoinReturn o) {
		/*if(o instanceof NativeSQLQueryCollectionReturn) {
			return ((NativeSQLQueryCollectionReturn)o).getOwnerEntityName() + "." + ((NativeSQLQueryCollectionReturn)o).getOwnerProperty();
		}*/
		return o.getOwnerAlias() + "." + o.getOwnerProperty();		
	}
	
	public String getNamedSQLReturnRole(NativeSQLQueryCollectionReturn o) {
		return o.getOwnerEntityName() + "." + o.getOwnerProperty();
	}
	
	public boolean isNamedSQLReturnRoot(NativeSQLQueryReturn sqlret) {
		return sqlret instanceof NativeSQLQueryRootReturn;
	}
	
	public boolean isNamedSQLReturnCollection(NativeSQLQueryReturn sqlret) {
		return sqlret instanceof NativeSQLQueryCollectionReturn;
	}

	public boolean isNamedSQLReturnRole(NativeSQLQueryReturn sqlret) {
		return sqlret instanceof NativeSQLQueryJoinReturn;
	}

	public boolean isFilterDefinitions(Configuration cfg) {
		Map filterdefs = cfg.getFilterDefinitions();
		return filterdefs == null || filterdefs.isEmpty() ? false : true;
	}
	
	public boolean isClassLevelOptimisticLockMode(PersistentClass pc) {
		return pc.getOptimisticLockMode() != Versioning.OPTIMISTIC_LOCK_VERSION;
	}
	
	public String getClassLevelOptimisticLockMode(PersistentClass pc) {
		int oMode = pc.getOptimisticLockMode();
		if ( oMode == Versioning.OPTIMISTIC_LOCK_DIRTY ) {
			return "dirty";
		}
		else if ( oMode == Versioning.OPTIMISTIC_LOCK_ALL ) {
			return "all";
		}
		else if ( oMode == Versioning.OPTIMISTIC_LOCK_NONE ) {
			return "none";
		} 
		else {
			return "version";
		}
	}
	
	public boolean hasFetchMode(Property property) {
		String fetch = getFetchMode(property);
		if(fetch==null || "default".equals(fetch)) {
			return false;
		} else {
			return true;
		}
	}
	public String getFetchMode(Property property) {
		FetchMode fetchMode = property.getValue().getFetchMode();
		return fetchMode.toString().toLowerCase();
	}
	
	
	public Formula getFormulaForProperty(Property prop) {
		Iterator iter = prop.getValue().getColumnIterator();
		while ( iter.hasNext() ) {
			Object o = iter.next();
			if (o instanceof Formula) 
				return (Formula) o;
		}
		return null;
	}

	public String columnAttributes(Column col) {
		return columnAttributes(col, false);
	}
	
	public String columnAttributes(Column column, boolean isPrimaryKeyColumn) {
		StringBuffer sb = new StringBuffer();
		if (column.getPrecision() != Column.DEFAULT_PRECISION) {
			sb.append("precision=\"").append(column.getPrecision() ).append("\" ");			
		}
		if (column.getScale() != Column.DEFAULT_SCALE) {
			sb.append("scale=\"").append(column.getScale() ).append("\" ");
		}
		else if (column.getLength() != Column.DEFAULT_LENGTH){
			sb.append("length=\"").append(column.getLength() ).append("\" ");
		}
		if (!isPrimaryKeyColumn) {
			if (!column.isNullable() ) {
				sb.append("not-null=\"true\" ");
			}
			if (column.isUnique() ) {
				sb.append("unique=\"true\" ");
			}
		}
		if (column.getSqlType() != null) {
			sb.append("sql-type=\""); sb.append(column.getSqlType() ); sb.append("\" ");			
		}
		return sb.toString();
	}
	
	public String getClassName(PersistentClass pc) {
		if (pc.hasPojoRepresentation() ) {
			return pc.getClassName();
		} 
		else {
			// todo: return null?
			throw new ExporterException(pc + " does not have a pojo rep.");
		}
	}
	
	public String getClassName(OneToMany om) {
		return om.getAssociatedClass().getClassName();
	}
	
	public String getProxyInterfaceName(PersistentClass pc) {
		if (pc.hasPojoRepresentation() ) {
			return pc.getClassName();
		} 
		else {
			throw new ExporterException(pc + " does not have a pojo rep.");
		}
	}
	
	public boolean isImportData(Configuration cfg) {
		return !(cfg.getImports().isEmpty());
	}

	public boolean needsDiscriminator(PersistentClass clazz) {
		
		return clazz instanceof Subclass 
		  && !(clazz instanceof UnionSubclass) && !(clazz instanceof JoinedSubclass);
	}


	public boolean needsTable(PersistentClass clazz) {
		return !(clazz instanceof org.hibernate.mapping.Subclass
				 && clazz instanceof org.hibernate.mapping.SingleTableSubclass);
	}

	public boolean isSubclass(PersistentClass clazz) {
		return clazz instanceof org.hibernate.mapping.Subclass;
	}
	
	public boolean isJoinedSubclass(PersistentClass clazz) {
		return clazz instanceof JoinedSubclass;
	}
	
	public boolean hasCustomEntityPersister(PersistentClass clazz) {
		Class entityPersisterClass = clazz.getEntityPersisterClass();
		if(entityPersisterClass==null) return false;
		final String name = entityPersisterClass.getName();
			
		Boolean object = (Boolean) clazz.accept( new HasEntityPersisterVisitor( name ) );
		return object.booleanValue();
	}

	public String getHibernateTypeName(Property p) {
		return (String) p.getValue().accept(new EntityNameFromValueVisitor());
	}
}
