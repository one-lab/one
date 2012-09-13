package org.hibernate.cfg;

import java.util.Properties;

import org.hibernate.cfg.reveng.JDBCReader;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.dialect.JDBCMetaDataDialect;
import org.hibernate.cfg.reveng.dialect.MetaDataDialect;
import org.hibernate.util.ReflectHelper;

final public class JDBCReaderFactory {

	
	public static JDBCReader newJDBCReader(Properties cfg, Settings settings,
			ReverseEngineeringStrategy revengStrategy) {

		MetaDataDialect mdd = newMetaDataDialect( cfg );

		return newJDBCReader( settings, revengStrategy, mdd );
	}

	public static JDBCReader newJDBCReader(Settings settings, ReverseEngineeringStrategy revengStrategy, MetaDataDialect mdd) {
		return new JDBCReader( mdd, settings.getConnectionProvider(), settings
				.getSQLExceptionConverter(), settings.getDefaultCatalogName(), settings.getDefaultSchemaName(), revengStrategy );
	}

	//TODO: how to get the current dialect to decide depenendent on the dialect.
	public static MetaDataDialect newMetaDataDialect(Properties cfg) {
		String property = cfg.getProperty( "hibernatetool.metadatadialect" );
		if ( property != null ) {
			try {
				return (MetaDataDialect) ReflectHelper.classForName( property,
						JDBCReaderFactory.class ).newInstance();
			}
			catch (Exception e) {
				throw new JDBCBinderException(
						"Could not load MetaDataDialect: " + property, e );
			}
		}
		return new JDBCMetaDataDialect();
	}

}
