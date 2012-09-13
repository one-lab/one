/*
 * Created on 14-Feb-2005
 *
 */
package org.hibernate.tool.ant;

import org.apache.tools.ant.BuildException;
import org.hibernate.tool.hbm2x.Exporter;
import org.hibernate.tool.hbm2x.GenericExporter;
import org.hibernate.util.ReflectHelper;

/**
 * @author max
 *
 */
public class GenericExporterTask extends ExporterTask {

	public GenericExporterTask(HibernateToolTask parent) {
		super(parent);
	}

	String templateName;
	String exporterClass;
	String filePattern;
	
	/**
	 * The FilePattern defines the pattern used to generate files.
	 * @param filePattern
	 */
	public void setFilePattern(String filePattern) {
		this.filePattern = filePattern;
	}
	
	public void setTemplate(String templateName) {
		this.templateName = templateName;
	}
	
	public void setExporterClass(String exporterClass) {
		this.exporterClass = exporterClass;
	}
	
	protected Exporter createExporter() {
		if (exporterClass == null) {
			return new GenericExporter();
		} else {
			try {
				Class theClass = ReflectHelper.classForName(exporterClass);
				return (Exporter) theClass.newInstance();
			} catch (ClassNotFoundException e) {
				throw new BuildException("Could not find custom exporter class: " + exporterClass, e);
			} catch (InstantiationException e) {
				throw new BuildException("Could not create custom exporter class: " + exporterClass, e);
			} catch (IllegalAccessException e) {
				throw new BuildException("Could not access custom exporter class: " + exporterClass, e);
			}
		}		
	}
	
	protected Exporter configureExporter(Exporter exp) {
		super.configureExporter(exp);
		
		if(exp instanceof GenericExporter) {
			GenericExporter exporter = (GenericExporter) exp;
			if(filePattern!=null) exporter.setFilePattern(filePattern);
			if(templateName!=null) exporter.setTemplateName(templateName);			
		}
		
		return exp;
	}

	public String getName() {
		return "generic exporter " + ((exporterClass==null) ? "" : exporterClass);
	}
}
