package org.hibernate.cfg.reveng;

import java.util.Iterator;
import java.util.Map;

import org.hibernate.mapping.Table;

public interface DatabaseCollector {

	public abstract Iterator iterateTables();

	public abstract Table addTable(String schema, String catalog, String name);

	public abstract void setOneToManyCandidates(Map oneToManyCandidates);

	public abstract Table getTable(String schema, String catalog, String name);

	public abstract Map getOneToManyCandidates();

}