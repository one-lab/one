package org.hibernate.cfg.reveng.dialect;

import java.util.Iterator;

import org.hibernate.connection.ConnectionProvider;
import org.hibernate.exception.SQLExceptionConverter;

/**
 * Interface for fetching metadata from databases.
 * The dialect is configured with a ConnectionProvider but is not
 * required to actually use any connections.
 * 
 * The metadata methods all returns Iterator and allows for more efficient and partial reads
 * for those databases that has "flakey" JDBC metadata implementions. 
 *  
 * @author Max Rydahl Andersen
 *
 */
public interface MetaDataDialect {

	/**
	 * Configure the metadatadialect. 
	 * @param provider a connectionprovider. It is the responsibility of the metadatadialect to open/close any used connections via this provider.
	 * @param sec sqlexceptionConverter, use to convert any possible SQLExceptionsConverter.
	 */
	public void configure(ConnectionProvider provider, SQLExceptionConverter sec);
	
	/** 
	 * Return iterator over the tables that mathces catalog, schema and table
	 * 
	 * @param catalog name or null
	 * @param schema name or null
	 * @param table name or null 
	 * @return iterator with map elements that has "TABLE_NAME", "TABLE_SCHEMA", "TABLE_CAT", "TABLE_TYPE" keys. 
	 */
	Iterator getTables(String catalog, String schema, String table);

	/**
	 * Close the iterator.
	 * @param iterator an iterator returned from one of methods on this dialect
	 */
	void close(Iterator iterator);

	/** 
	 * Return iterator over the indexes that mathces catalog, schema and table
	 * 
	 * @param catalog name or null
	 * @param schema name or null
	 * @param table name or null 
	 * @return iterator with map elements that has "TABLE_NAME", "TABLE_SCHEMA", "TABLE_CAT", "INDEX_NAME", "COLUMN_NAME", "NON_UNIQUE", "TYPE" keys. 
	 */
	Iterator getIndexInfo(String catalog, String schema, String table);

	/**
	 * Return iterator over the columns that mathces catalog, schema and table
	 * 
	 * @param catalog name or null
	 * @param schema name or null
	 * @param table name or null
	 * @param column name or null
	 * @return iterator with map elements that has "TABLE_NAME", "TABLE_SCHEMA", "TABLE_CAT", "DATA_TYPE", "TYPE_NAME", "COLUMN_NAME", "NULLABLE", "COLUMN_SIZE", "DECIMAL_DIGITS"
	 */
	Iterator getColumns(String catalog, String schema, String table, String column);

	/**
	 * Return iterator over the columns that mathces catalog, schema and table
	 * 
	 * @param catalog name or null
	 * @param schema name or null
	 * @param table name or null
	 * @return iterator with map elements that has "TABLE_NAME", "TABLE_SCHEMA", "TABLE_CAT", "COLUMN_NAME", "KEY_SEQ", "PK_NAME",
	 */
	Iterator getPrimaryKeys(String catalog, String schema, String name);


	/**
	 * Return iterator over the exported foreign keys that mathces catalog, schema and table
	 * 
	 * @param catalog name or null
	 * @param schema name or null
	 * @param table name or null
	 * @return iterator with map elements that has "TABLE_NAME", "TABLE_SCHEMA", "TABLE_CAT", "FKTABLE_CAT", "FKTABLE_SCHEM", "FKTABLE_NAME", "FK_NAME", "KEY_SEQ"
	 */
	Iterator getExportedKeys(String catalog, String schema, String table);

	/**
	 * Does this name need quoting
	 * 
	 * @param name
	 * @return
	 */
	boolean needQuote(String name);
	
	/**
	 * Close any resources this dialect might have used.
	 */
	void close();
}
