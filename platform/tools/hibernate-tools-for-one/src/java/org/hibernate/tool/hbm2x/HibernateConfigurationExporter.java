/*
 * Created on 2004-12-03
 *
 */
package org.hibernate.tool.hbm2x;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.RootClass;

/**
 * @author max
 *
 */
public class HibernateConfigurationExporter extends AbstractExporter {

	private Writer output;
    private Properties customProperties = new Properties();

	public HibernateConfigurationExporter(Configuration configuration, File outputdir) {
		super(configuration, outputdir);
	}

	public HibernateConfigurationExporter() {
		
	}
	
	public Properties getCustomProperties() {
		return customProperties;
	}

	public void setCustomProperties(Properties customProperties) {
		this.customProperties = customProperties;
	}

	public Writer getOutput() {
		return output;
	}

	public void setOutput(Writer output) {
		this.output = output;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.tool.hbm2x.Exporter#finish()
	 */
	public void doStart() throws ExporterException {
		PrintWriter pw = null;
		File file = null;
		try  {
        if(output==null) {
            file = new File(getOutputDirectory(), "hibernate.cfg.xml");
            getTemplateHelper().ensureExistence(file);
			pw = new PrintWriter(new FileWriter(file) );
			getArtifactCollector().addFile(file, "cfg.xml");
        } 
        else {
            pw = new PrintWriter(output);
        }
		
		
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE hibernate-configuration PUBLIC\r\n" + 
				"		\"-//Hibernate/Hibernate Configuration DTD 3.0//EN\"\r\n" + 
				"		\"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd\">\r\n" + 
				"<hibernate-configuration>");

        boolean ejb3 = Boolean.valueOf((String)getProperties().get("ejb3")).booleanValue();
        
        Map props = new TreeMap();
        if(getConfiguration()!=null) {
            props.putAll(getConfiguration().getProperties() );
        }
        if(customProperties!=null) {
            props.putAll(customProperties);             
        }
        
        String sfname = (String) props.get(Environment.SESSION_FACTORY_NAME);
        pw.println("    <session-factory" + (sfname==null?"":" name=\"" + sfname + "\"") + ">");
        
        Set set = props.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext() ) {
            Map.Entry element = (Map.Entry) iterator.next();
            String key = (String) element.getKey();
            if(!key.equals(Environment.SESSION_FACTORY_NAME) && key.startsWith("hibernate.") ) { // if not starting with hibernate. not relevant for cfg.xml
                pw.println("        <property name=\"" + key + "\">" + element.getValue() + "</property>");
            }
        }
        
		if(getConfiguration()!=null) {
		    Iterator classMappings = getConfiguration().getClassMappings();
		    while (classMappings.hasNext() ) {
		        PersistentClass element = (PersistentClass) classMappings.next();
		        if(element instanceof RootClass) {
		            dump(pw, ejb3, element);
		        }
		    }
		}
		pw.println("    </session-factory>\r\n" + 
				"</hibernate-configuration>");
				
		} 
		
		catch (IOException e) {
			throw new ExporterException("Problems while creating hibernate.cfg.xml", e);
		} 
		finally {
			if(pw!=null) {
				pw.flush();
				pw.close();
			}				
		}
		
	}

	/**
	 * @param pw
	 * @param element
	 */
	private void dump(PrintWriter pw, boolean useClass, PersistentClass element) {
		if(useClass) {
			pw.println("<mapping class=\"" + element.getClassName() + "\"/>");
		} else {
			pw.println("<mapping resource=\"" + getMappingFileResource(element) + "\"/>");
		}
			
		Iterator directSubclasses = element.getDirectSubclasses();
		while (directSubclasses.hasNext() ) {
			PersistentClass subclass = (PersistentClass) directSubclasses.next();
			dump(pw, useClass, subclass);		
		}
		
	}

	/**
	 * @param element
	 * @return
	 */
	private String getMappingFileResource(PersistentClass element) {
		
		return element.getClassName().replace('.', '/') + ".hbm.xml";
	}
	
	public String getName() {
		return "cfg2cfgxml";
	}
}
