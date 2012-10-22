package org.hibernate.cfg.reveng.dialect;

import org.hibernate.mapping.Table;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author ddukker
 *
 */
public class SQLServerMetaDataDialect extends JDBCMetaDataDialect {

	private static final String SQL_COLUMN_BASE = "SELECT VW_SysObj.name AS TableName" +
			" , VW_SysObj.id AS TableID" +
			" , VW_SysCol.name AS ColumnName" +
			" , VW_SysTypes.name AS DataType" +
			" , VW_SysCol.length AS Length" +
			" , VW_SysCom.text AS DefaultValue" +
			" , VW_SysIdxKeys.indid AS IsPrimarykey" +
			" , cast(isnull(VW_ExtPrpt.value, ' ')as   varchar) AS Description" +
			" , VW_SysCol.status AS Status" +
			" , VW_SysCol.isnullable AS AllowNulls" +
			" FROM sysobjects VW_SysObj" +
			"  LEFT JOIN syscolumns VW_SysCol ON VW_SysObj.id=VW_SysCol.id" +
			"  LEFT JOIN systypes VW_SysTypes ON VW_SysCol.xusertype=VW_SysTypes.xusertype" +
			"  LEFT JOIN syscomments VW_SysCom ON VW_SysCol.cdefault=VW_SysCom.id" +
			"  LEFT JOIN sysindexkeys VW_SysIdxKeys ON VW_SysCol.id=VW_SysIdxKeys.id AND VW_SysCol.colid=VW_SysIdxKeys.colid AND VW_SysIdxKeys.indid=1" +
			"  LEFT JOIN sys.extended_properties VW_ExtPrpt ON VW_SysCol.id=VW_ExtPrpt.major_id AND VW_SysCol.colid=VW_ExtPrpt.minor_id" +
			" WHERE VW_SysObj.name=?" +
			" AND VW_SysCol.name=?";

	private PreparedStatement prepSqlColumnBase;

	public Iterator getSuggestedPrimaryKeyStrategyName(String catalog, String schema, String table) {
		String sql = null;
			try {			
				catalog = caseForSearch( catalog );
				schema = caseForSearch( schema );
				table = caseForSearch( table );
				
				log.debug("geSuggestedPrimaryKeyStrategyName(" + catalog + "." + schema + "." + table + ")");
				
				sql = "SELECT a.TABLE_CATALOG, a.TABLE_SCHEMA, a.TABLE_NAME as table_name, c.DATA_TYPE as data_type, b.CONSTRAINT_TYPE,  OBJECTPROPERTY(OBJECT_ID(a.TABLE_NAME),'TableHasIdentity') as hasIdentity " +
						"FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE a " +
						"INNER JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS b on a.CONSTRAINT_NAME = b.CONSTRAINT_NAME " +
						"INNER JOIN INFORMATION_SCHEMA.Columns c on a.TABLE_CATALOG = c.TABLE_CATALOG AND a.TABLE_SCHEMA = c.TABLE_SCHEMA AND a.TABLE_NAME = c.TABLE_NAME AND a.COLUMN_NAME = c.COLUMN_NAME " +
						"WHERE a.TABLE_NAME='"+table+"' AND a.TABLE_SCHEMA='"+schema+"' AND a.TABLE_CATALOG='"+catalog+"' AND b.CONSTRAINT_TYPE = 'Primary key'";
				
				PreparedStatement statement = getConnection().prepareStatement( sql );
				
				final String sc = schema;
				final String cat = catalog;
				return new ResultSetIterator(statement.executeQuery(), getSQLExceptionConverter()) {
					
					Map element = new HashMap();
					protected Object convertRow(ResultSet tableRs) throws SQLException {
						element.clear();
						element.put("TABLE_NAME", tableRs.getString("table_name"));
						element.put("TABLE_SCHEM", sc);
						element.put("TABLE_CAT", cat);
						
						String string = tableRs.getString("data_type");
						
						boolean bool = tableRs.getBoolean("hasIdentity");
						if(string!=null) {
							if(string.equalsIgnoreCase("uniqueidentifier")){
								element.put("HIBERNATE_STRATEGY", "guid");
							}else if(bool){
								element.put("HIBERNATE_STRATEGY", "identity");
							}else{
								element.put("HIBERNATE_STRATEGY", null);
							} 
						}else {
							element.put("HIBERNATE_STRATEGY", null);
						}
						return element;					
					}
					protected Throwable handleSQLException(SQLException e) {
						// schemaRs and catalogRs are only used for error reporting if
						// we get an exception
						throw getSQLExceptionConverter().convert( e,
								"Could not get list of suggested identity strategies from database. Probably a JDBC driver problem. ", null);					
					}
				};
			} catch (SQLException e) {
				throw getSQLExceptionConverter().convert(e, "Could not get list of suggested identity strategies from database. Probably a JDBC driver problem. ", sql);		         
			} 		
		}

	public Iterator getColumns(String xcatalog, String xschema, String xtable, String xcolumn) {
		try {
			final String catalog = caseForSearch( xcatalog );
			final String schema = caseForSearch( xschema );
			final String table = caseForSearch( xtable );
			final String column = caseForSearch( xcolumn );

			log.debug("getColumns(" + catalog + "." + schema + "." + table + "." + column + ")");
			ResultSet tableRs = getMetaData().getColumns(catalog, schema, table, column);

			return new ResultSetIterator(tableRs, getSQLExceptionConverter()) {

				Map element = new HashMap();
				protected Object convertRow(ResultSet rs) throws SQLException {
					element.clear();
					putTablePart(element, rs);
					element.put("DATA_TYPE", new Integer(rs.getInt("DATA_TYPE")));
					element.put("TYPE_NAME", rs.getString("TYPE_NAME"));
					element.put("COLUMN_NAME", rs.getString("COLUMN_NAME"));
					element.put("NULLABLE", new Integer(rs.getInt("NULLABLE")));
					element.put("COLUMN_SIZE", new Integer(rs.getInt("COLUMN_SIZE")));
					element.put("DECIMAL_DIGITS", new Integer(rs.getInt("DECIMAL_DIGITS")));
					ResultSet remarksRs = getColumnsResultSet(null, table, rs.getString("COLUMN_NAME"));
					if(remarksRs.next()){
						element.put("REMARKS", remarksRs.getString("Description"));
					} else {
						element.put("REMARKS", rs.getString("REMARKS"));
					}
					return element;
				}
				protected Throwable handleSQLException(SQLException e) {
					throw getSQLExceptionConverter().convert(e, "Error while reading column meta data for " + Table.qualify(catalog, schema, table), null);
				}
			};
		} catch (SQLException e) {
			throw getSQLExceptionConverter().convert(e, "Error while reading column meta data for " + Table.qualify(xcatalog, xschema, xtable), null);
		}
	}

	private ResultSet getColumnsResultSet(final String schema, final String table, String column) throws SQLException{
		if(prepSqlColumnBase == null) {
			Connection conn = getConnection();
			prepSqlColumnBase = conn.prepareStatement(SQL_COLUMN_BASE);
		}

		ResultSet columnRs = null;

		if (schema == null && table != null && column != null) {
			prepSqlColumnBase.setString(1,table);
			prepSqlColumnBase.setString(2,column);
			columnRs = prepSqlColumnBase.executeQuery();
		}

		return columnRs;
	}

	private PreparedStatement close(PreparedStatement ps) {
		if(ps==null) {
			return null;
		} else {
			try {
				ps.close();
			}
			catch (SQLException e) {
				throw getSQLExceptionConverter().convert(e,
						"Problem while closing prepared statement", null);
			}
			return null;
		}

	}

	public void close() {
		try{
			prepSqlColumnBase = close(prepSqlColumnBase);
		} finally {
			super.close();
		}

	}
}
	
