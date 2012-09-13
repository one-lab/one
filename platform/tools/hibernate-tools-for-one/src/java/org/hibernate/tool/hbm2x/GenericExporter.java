package org.hibernate.tool.hbm2x;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Component;
import org.hibernate.tool.hbm2x.pojo.ComponentPOJOClass;
import org.hibernate.tool.hbm2x.pojo.POJOClass;
import org.hibernate.util.StringHelper;


public class GenericExporter extends AbstractExporter {

	private String templateName;
	private String filePattern;
	
	public GenericExporter(Configuration cfg, File outputdir) {
		super(cfg,outputdir);
	}

	public GenericExporter() {
	}
	
	public String getTemplateName() {
		return templateName;
	}
	
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
			
	protected void doStart() {
				
		if(filePattern==null) throw new ExporterException("File pattern not set on " + this.getClass());
		if(templateName==null) throw new ExporterException("Template name not set on " + this.getClass());
		
		if(filePattern.indexOf("{class-name}")>=0) {				
			exportClasses();
		} else {
			TemplateProducer producer = new TemplateProducer(getTemplateHelper(),getArtifactCollector());
			producer.produce(new HashMap(), getTemplateName(), new File(getOutputDirectory(),filePattern), templateName);
		}
	}

	private void exportClasses() {
		Map components = new HashMap();
		
		Iterator iterator = getCfg2JavaTool().getPOJOIterator(getConfiguration().getClassMappings());
		Map additionalContext = new HashMap();
		while ( iterator.hasNext() ) {					
			POJOClass element = (POJOClass) iterator.next();
			ConfigurationNavigator.collectComponents(components, element);						
			exportPersistentClass( additionalContext, element );
		}
				
		iterator = components.values().iterator();
		while ( iterator.hasNext() ) {					
			Component component = (Component) iterator.next();
			ComponentPOJOClass element = new ComponentPOJOClass(component,getCfg2JavaTool());
			exportComponent( additionalContext, element );
		}
				        
	}

	protected void exportComponent(Map additionalContext, POJOClass element) {
		exportPOJO(additionalContext, element);		
	}

	protected void exportPersistentClass(Map additionalContext, POJOClass element) {
		exportPOJO(additionalContext, element);		
	}

	protected void exportPOJO(Map additionalContext, POJOClass element) {
		TemplateProducer producer = new TemplateProducer(getTemplateHelper(),getArtifactCollector());					
		additionalContext.put("pojo", element);
		additionalContext.put("clazz", element.getDecoratedObject());
		String filename = resolveFilename( element );
		if(filename.endsWith(".java") && filename.indexOf('$')>=0) {
			log.warn("Filename for " + getClassNameForFile( element ) + " contains a $. Innerclass generation is not supported.");
		}
		producer.produce(additionalContext, getTemplateName(), new File(getOutputDirectory(),filename), templateName);
	}

	protected String resolveFilename(POJOClass element) {
		String filename = StringHelper.replace(filePattern, "{class-name}", getClassNameForFile( element )); 
		String packageLocation = StringHelper.replace(getPackageNameForFile( element ),".", "/");
		if(StringHelper.isEmpty(packageLocation)) {
			packageLocation = "."; // done to ensure default package classes doesn't end up in the root of the filesystem when outputdir=""
		}
		filename = StringHelper.replace(filename, "{package-name}", packageLocation);
		return filename;
	}

	protected String getPackageNameForFile(POJOClass element) {
		return element.getPackageName(); 
	}

	protected String getClassNameForFile(POJOClass element) {
		return element.getDeclarationName();
	}

	public void setFilePattern(String filePattern) {
		this.filePattern = filePattern;		
	}
	
	public String getFilePattern() {
		return filePattern;
	}
}
