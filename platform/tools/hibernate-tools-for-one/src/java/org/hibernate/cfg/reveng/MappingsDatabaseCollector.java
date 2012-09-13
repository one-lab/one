package org.hibernate.cfg.reveng;

import java.util.Iterator;
import java.util.Map;

import org.hibernate.cfg.Mappings;
import org.hibernate.mapping.Table;

public class MappingsDatabaseCollector implements DatabaseCollector {

	private final Mappings mappings;
	private Map oneToManyCandidates;

	public MappingsDatabaseCollector(Mappings mappings) {
		this.mappings = mappings;
	}

	public Iterator iterateTables() {
		return mappings.iterateTables();
	}

	public Table addTable(String schema, String catalog, String name) {
		return mappings.addTable(schema, catalog, name, null, false);
	}

	public void setOneToManyCandidates(Map oneToManyCandidates) {
		this.oneToManyCandidates = oneToManyCandidates;
	}

	public Table getTable(String schema, String catalog, String name) {
		return mappings.getTable(schema, catalog, name);
	}

	public Map getOneToManyCandidates() {
		return oneToManyCandidates;
	}
}
