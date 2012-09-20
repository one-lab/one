package com.sinosoft.one.data.strategy;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * User: Morgan
 * Date: 12-9-13
 * Time: 下午5:22
 */
public class ImprovedTableNamingStrategy extends ImprovedNamingStrategy {
	public String tableName(String tableName) {
		System.out.println("----------------------tableName:"+tableName);
		return super.tableName(tableName);
	}

	public String classToTableName(String className) {
		System.out.println("----------------------className:"+className);
		return super.classToTableName(className);
	}

	public String propertyToColumnName(String propertyName) {
		System.out.println("----------------------propertyToColumnName");
		return super.propertyToColumnName(propertyName);
	}

	public String columnName(String columnName) {
		System.out.println("----------------------columnName");
		return super.columnName(columnName);
	}

	public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity, String associatedEntityTable, String propertyName) {
		System.out.println("----------------------collectionTableName");
		return super.collectionTableName(ownerEntity, ownerEntityTable, associatedEntity, associatedEntityTable, propertyName);
	}
}
