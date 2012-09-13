
package org.hibernate.cfg.reveng.dialect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.mapping.Table;

/**
 * Oracle Specialised MetaData dialect that uses standard JDBC 
 * and querys on the Data Dictionary for reading metadata.
 * 
 * @author David Channon
 */
public class OracleMetaDataDialect extends AbstractMetaDataDialect {

	
	
	
	public Iterator getTables(final String catalog, final String schema, String table) {
		try {		
			log.debug("getTables(" + catalog + "." + schema + "." + table + ")");
			// Collect both Tables and Views from the 'ALL' data dicitonary tables.
			// Note: This will potentally collect more tables that the jdbc meta data 
	        Statement stmt = this.getConnection().createStatement();
	        StringBuffer query = new StringBuffer();
	        query.append("select  table_name, owner, 'TABLE' from all_tables ");
	        if (schema != null || table != null)
	        	query.append("where ");
			if (schema != null) {
				query.append("owner='" + schema + "' ");
			}
			if (table != null) {
				if (schema != null)
					query.append("and ");
				query.append("table_name = '" + table + "' ");
			}
			query.append("union all ");
			query.append("select view_name, owner, 'VIEW' from all_views ");
	        if (schema != null || table != null)
	        	query.append("where ");
			if (schema != null) {
				query.append("owner='" + schema + "' ");
			}
			if (table != null) {
				if (schema != null)
					query.append("and ");
				query.append("view_name = '" + table + "' ");
			}
			if (log.isDebugEnabled())
				log.debug("getTables Query:" + query.toString());
			
	        ResultSet tableRs = stmt.executeQuery(query.toString());
			
			return new ResultSetIterator(stmt, tableRs, getSQLExceptionConverter()) {
				
				Map element = new HashMap();
				protected Object convertRow(ResultSet tableRs) throws SQLException {
					element.clear();
					element.put("TABLE_NAME", tableRs.getString(1));
					element.put("TABLE_SCHEM", tableRs.getString(2));
					element.put("TABLE_CAT", null);
					element.put("TABLE_TYPE", tableRs.getString(3));
					element.put("REMARKS", null);
					return element;					
				}
				protected Throwable handleSQLException(SQLException e) {
					// schemaRs and catalogRs are only used for error reporting if
					// we get an exception
					String databaseStructure = getDatabaseStructure( catalog, schema );
					throw getSQLExceptionConverter().convert( e,
							"Could not get list of tables from database. Probably a JDBC driver problem. "
									+ databaseStructure, null );					
				}
			};
		} catch (SQLException e) {
			// schemaRs and catalogRs are only used for error reporting if we get an exception
			String databaseStructure = getDatabaseStructure(catalog,schema);
			throw getSQLExceptionConverter().convert(e, "Could not get list of tables from database. Probably a JDBC driver problem. " + databaseStructure, null);		         
		} 		
	}

	public Iterator getIndexInfo(final String catalog, final String schema, final String table) {
		try {		
			log.debug("getIndexInfo(" + catalog + "." + schema + "." + table + ")");
			// Collect both Indexes from the 'ALL' data dicitonary table.
			// It is assumed that atleast the TABLE name is supplied.
	        Statement stmt = this.getConnection().createStatement();
	        StringBuffer query = new StringBuffer();
	        
	        query.append("select a.column_name, decode(b.uniqueness,'UNIQUE','false','true'), a.index_owner, a.index_name, a.table_name ");
	        query.append("from all_ind_columns a, all_indexes b ");
	        query.append("where a.table_name = b.table_name ");
	        query.append("AND  a.table_owner = b.table_owner ");
	        query.append("AND  a.index_name  = b.index_name ");
			if (schema != null) {
				query.append("AND a.table_owner='" + schema + "' ");
			}
			query.append("AND a.table_name = '" + table + "' ");
			query.append("order by a.table_name, a.column_position ");
			
			if (log.isDebugEnabled())
				log.debug("getIndexInfo Query:" + query.toString());
			
	        ResultSet indexRs = stmt.executeQuery(query.toString());
						
			return new ResultSetIterator(stmt, indexRs, getSQLExceptionConverter()) {
				
				Map element = new HashMap();
				protected Object convertRow(ResultSet rs) throws SQLException {
					element.clear();
					element.put("COLUMN_NAME", rs.getString(1));
					element.put("TYPE", new Short((short)1));		// CLUSTERED INDEX	
					element.put("NON_UNIQUE", Boolean.valueOf( rs.getString(2) ));
					element.put("TABLE_SCHEM", rs.getString(3));
					element.put("INDEX_NAME", rs.getString(4));					
					element.put("TABLE_CAT", null);
					element.put("TABLE_NAME", rs.getString(5));

					return element;					
				}
				protected Throwable handleSQLException(SQLException e) {
					throw getSQLExceptionConverter().convert(e, "Exception while getting index info for " + Table.qualify(catalog, schema, table), null);
				}
			};
		} catch (SQLException e) {
			throw getSQLExceptionConverter().convert(e, "Exception while getting index info for " + Table.qualify(catalog, schema, table), null);
		} 		
	}

	public Iterator getColumns(final String catalog, final String schema, final String table, String column) {
		try {			  
			log.debug("getColumns(" + catalog + "." + schema + "." + table + "." + column + ")");
			// Collect Columns from the 'ALL' data dicitonary table.
			// A decode is used to map the type name to the JDBC Type ID
	        Statement stmt = this.getConnection().createStatement();
	        StringBuffer query = new StringBuffer();

	        query.append("select column_name as COLUMN_NAME, owner as TABLE_SCHEM, decode(nullable,'N',0,1) as NULLABLE, ");
	        query.append("decode(data_type, 'FLOAT',decode(data_precision,null, data_length, data_precision), 'NUMBER', decode(data_precision,null, data_length, data_precision), data_length) as COLUMN_SIZE, ");
	        query.append("decode(data_type,'CHAR',1, 'DATE',91, 'FLOAT',6, 'LONG',-1, 'NUMBER',2, 'VARCHAR2',12, 'BFILE',-13, ");
	        query.append("'BLOB',2004, 'CLOB',2005, 'MLSLABEL',1111, 'NCHAR',1, 'NCLOB',2005, 'NVARCHAR2',12, ");
	        query.append("'RAW',-3, 'ROWID',1111, 'UROWID',1111, 'LONG RAW', -4, 'TIMESTAMP', 93, 'XMLTYPE',2005, 1111) as DATA_TYPE, ");
	        query.append("table_name as TABLE_NAME, data_type as TYPE_NAME, decode(data_scale, null, 0 ,data_scale) as DECIMAL_DIGITS ");
	        query.append("from all_tab_columns ");
	        if (schema != null || table != null || column != null)
	        	query.append("where ");
			if (schema != null) {
				query.append("owner='" + schema + "' ");
			}
			if (table != null) {
				if (schema != null)
					query.append("and ");
				query.append("table_name = '" + table + "' ");
			}
			if (column != null) {
				if (schema != null || table != null)
					query.append("and ");
				query.append("column_name = '" + column + "' ");				
			}
			query.append("order by column_id ");
			
			if (log.isDebugEnabled())
				log.debug("getIndexInfo Query:" + query.toString());
			
	        ResultSet columnRs = stmt.executeQuery(query.toString());
			
			return new ResultSetIterator(stmt, columnRs, getSQLExceptionConverter()) {
				
				Map element = new HashMap();
				protected Object convertRow(ResultSet rs) throws SQLException {
					element.clear();
					element.put("COLUMN_NAME", rs.getString(1));
					element.put("TABLE_SCHEM", rs.getString(2));
					element.put("NULLABLE", new Integer(rs.getInt(3)));
					element.put("COLUMN_SIZE", new Integer(rs.getInt(4)));
					element.put("DATA_TYPE", new Integer(rs.getInt(5)));
					element.put("TABLE_NAME", rs.getString(6));
					element.put("TYPE_NAME", rs.getString(7));
					element.put("DECIMAL_DIGITS", new Integer(rs.getInt(8)));					
					element.put("TABLE_CAT", null);
					element.put("REMARKS", null);
					return element;
				}
				protected Throwable handleSQLException(SQLException e) {
					throw getSQLExceptionConverter().convert(e, "Error while reading column meta data for " + Table.qualify(catalog, schema, table), null);
				}
			};
		} catch (SQLException e) {
			throw getSQLExceptionConverter().convert(e, "Error while reading column meta data for " + Table.qualify(catalog, schema, table), null);
		}	
	}

	public Iterator getPrimaryKeys(final String catalog, final String schema, final String table) {
		try {		
			log.debug("getPrimaryKeys(" + catalog + "." + schema + "." + table + ")");
			// Collect PrimaryKeys from the 'ALL' data dicitonary tables.
	        Statement stmt = this.getConnection().createStatement();
	        StringBuffer query = new StringBuffer();
	        
	        query.append("select c.table_name, c.column_name, c.position,  c.constraint_name, c.owner ");
	        query.append("from all_cons_columns c, all_constraints k ");
	        query.append("where k.constraint_type = 'P' ");
	        query.append("AND k.constraint_name = c.constraint_name ");
	        query.append("AND k.table_name = c.table_name ");
	        query.append("AND k.owner = c.owner ");	        
			if (schema != null) {
				query.append("AND k.owner='" + schema + "' ");
			}
			if (table != null) {
				query.append("AND k.table_name = '" + table + "' ");
			}
			query.append("order by c.table_name, c.constraint_name, c.position desc ");
			
			if (log.isDebugEnabled())
				log.debug("getPrimaryKeys Query:" + query.toString());
			
	        ResultSet pkeyRs = stmt.executeQuery(query.toString());	
	        
			return new ResultSetIterator(stmt, pkeyRs, getSQLExceptionConverter()) {
				
				Map element = new HashMap();
				protected Object convertRow(ResultSet rs) throws SQLException {
					element.clear();
					element.put("TABLE_NAME", rs.getString(1));
					element.put("COLUMN_NAME", rs.getString(2));
					element.put("KEY_SEQ", new Short(rs.getShort(3)));
					element.put("PK_NAME", rs.getString(4));
					element.put("TABLE_SCHEM", rs.getString(5));
					element.put("TABLE_CAT", null);
					return element;					
				}
				protected Throwable handleSQLException(SQLException e) {
					throw getSQLExceptionConverter().convert(e, "Error while reading primary key meta data for " + Table.qualify(catalog, schema, table), null);
				}
			};
		} catch (SQLException e) {
			throw getSQLExceptionConverter().convert(e, "Error while reading primary key meta data for " + Table.qualify(catalog, schema, table), null);
		}	
	}

	public Iterator getExportedKeys(final String catalog, final String schema, final String table) {
		try {		
			log.debug("getExportedKeys(" + catalog + "." + schema + "." + table + ")");
			// Collect ExportedKeys from the 'ALL' data dicitonary tables.

	        Statement stmt = this.getConnection().createStatement();
	        StringBuffer query = new StringBuffer();

	        query.append("select p.table_name, p.owner, f.owner, f.table_name, fc.column_name, pc.column_name, f.constraint_name, fc.position ");
	        query.append("from all_cons_columns pc, all_constraints p, all_cons_columns fc, all_constraints f ");
	        query.append("where f.constraint_type = 'R' ");
	        query.append("AND  p.owner = f.r_owner ");
	        query.append("AND  p.constraint_name = f.r_constraint_name ");
	        query.append("AND  p.constraint_type = 'P' ");
	        query.append("AND  pc.owner = p.owner ");
	        query.append("AND  pc.constraint_name = p.constraint_name ");
	        query.append("AND  pc.table_name = p.table_name ");
	        query.append("AND  fc.owner = f.owner ");
	        query.append("AND  fc.constraint_name = f.constraint_name ");
	        query.append("AND  fc.table_name = f.table_name ");
	        query.append("AND  fc.position = pc.position ");	        
			if (schema != null) {
				query.append("AND p.owner='" + schema + "' ");
			}
			if (table != null) {
				query.append("AND p.table_name = '" + table + "' ");
			}
			query.append("order by f.table_name, f.constraint_name, fc.position ");
			
			if (log.isDebugEnabled())
				log.debug("getExportedKeys Query:" + query.toString());
			
	        ResultSet pExportRs = stmt.executeQuery(query.toString());	
			
			return new ResultSetIterator(stmt, pExportRs, getSQLExceptionConverter()) {
				
				Map element = new HashMap();
				protected Object convertRow(ResultSet rs) throws SQLException {
					element.clear();
					element.put( "PKTABLE_NAME", rs.getString(1));
					element.put( "PKTABLE_SCHEM", rs.getString(2));
					element.put( "PKTABLE_CAT", null);
					element.put( "FKTABLE_CAT", null);
					element.put( "FKTABLE_SCHEM",rs.getString(3));
					element.put( "FKTABLE_NAME", rs.getString(4));
					element.put( "FKCOLUMN_NAME", rs.getString(5));
					element.put( "PKCOLUMN_NAME", rs.getString(6));
					element.put( "FK_NAME", rs.getString(7));
					element.put( "KEY_SEQ", new Short(rs.getShort(8)));					
					return element;					
				}
				protected Throwable handleSQLException(SQLException e) {
					throw getSQLExceptionConverter().convert(e, "Error while reading exported keys meta data for " + Table.qualify(catalog, schema, table), null);
				}
			};
		} catch (SQLException e) {
			throw getSQLExceptionConverter().convert(e, "Error while reading exported keys meta data for " + Table.qualify(catalog, schema, table), null);
		}	
	}
	
}
