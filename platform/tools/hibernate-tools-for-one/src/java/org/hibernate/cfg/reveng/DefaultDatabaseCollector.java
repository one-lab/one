package org.hibernate.cfg.reveng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Table;
import org.hibernate.util.StringHelper;

public class DefaultDatabaseCollector implements DatabaseCollector  {

	Map tables;
		
	Map qualifiers;
	
	static class TableContainer {
		List tables = new ArrayList();
	}
	
	public DefaultDatabaseCollector() {
		tables = new HashMap();
		qualifiers = new HashMap();		
	}
	
	private Map oneToManyCandidates;
	
	public Iterator iterateTables() {
		return tables.values().iterator();
	}

	public Table addTable(String schema, 
			String catalog, 
			String name) {
		
        String key = Table.qualify(catalog, schema, name);
		Table table = (Table) tables.get(key);
		
		if (table == null) {
			table = new Table();
			table.setAbstract(false);
			table.setName(name);
			table.setSchema(schema);
			table.setCatalog(catalog);
			tables.put(key, table);
			
			String qualifier = StringHelper.qualifier(key);
			List schemaList = (List) qualifiers.get(qualifier);
			if(schemaList==null) {
				schemaList = new ArrayList();
				qualifiers.put(qualifier, schemaList);				
			}
			schemaList.add(table);
		}
		else {
			table.setAbstract(false);
		}
		
		return table;
	}

	public void setOneToManyCandidates(Map oneToManyCandidates) {
		this.oneToManyCandidates = oneToManyCandidates;
	}

	public Table getTable(String schema, String catalog, String name) {
        String key = Table.qualify(catalog, schema, name);
		return (Table) tables.get(key);
	}

	public Map getOneToManyCandidates() {
		return oneToManyCandidates;
	}

	public Iterator getQualifierEntries() {
		return qualifiers.entrySet().iterator();
	}
}
