package org.hibernate.tool.hbm2x.seam;

import java.io.File;
import java.util.Map;
import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2x.AbstractExporter;
import org.hibernate.tool.hbm2x.GenericExporter;
import org.hibernate.tool.hbm2x.POJOExporter;
import org.hibernate.tool.hbm2x.pojo.POJOClass;

public class SeamExporter extends AbstractExporter {

    public SeamExporter() {
    }
    
    public SeamExporter(Configuration cfg, File outputdir) {
        super(cfg, outputdir);
        init();
    }

    private void init() {
    			
	}

    protected void setupContext() {
    	if(!getProperties().contains("seam_appname")) {
    		getProperties().put("seam_appname", "SeamApplication");	
    	}				
    	if(!getProperties().contains("seam_shortname")) {
    		getProperties().put("seam_shortname", "seamapp");	
    	}				
    	
    	super.setupContext();
    }
	protected void exportComponent(Map additionalContext, POJOClass element) {
    	// noop - we dont want components
    }
	
	public String getName() {
		return "hbm2seam";
	}

	public void doStart() {		
		
		configureExporter( "seam/build.xml.ftl", "build.xml").start();
		configureExporter( "seam/build.properties.ftl", "build.properties").start();
		configureExporter( "seam/components.xml.ftl", "resources/WEB-INF/components.xml").start();
		configureExporter( "seam/readme.txt.ftl", "readme.txt").start();
		new File( getOutputDirectory(), "lib" ).mkdir();
		
		configureExporter( "seam/seam.properties.ftl", "resources/seam.properties").start();
		configureExporter( "seam/messages.properties.ftl", "resources/WEB-INF/classes/messages.properties").start();

		configureExporter( "seam/web.xml.ftl", "resources/WEB-INF/web.xml").start();
		configureExporter( "seam/faces-config.xml.ftl", "resources/WEB-INF/faces-config.xml").start();
		new File( getOutputDirectory(), "resources/WEB-INF/lib" ).mkdir();
		
		configureExporter( "seam/persistence.xml.ftl", "resources/META-INF/persistence.xml").start();
		
		configureExporter( "seam/application.xml.ftl", "resources/META-INF/application.xml").start();
		configureExporter( "seam/jboss-app.xml.ftl", "resources/META-INF/jboss-app.xml").start();

		configureExporter( "seam/edit.jsp.ftl", "resources/jsp/edit{class-name}.jsp").start();
		configureExporter( "seam/find.jsp.ftl", "resources/jsp/find{class-name}.jsp").start();
		configureExporter( "seam/index.html.ftl", "resources/jsp/index.html").start();
		configureExporter( "seam/screen.css.ftl", "resources/jsp/style/default/screen.css").start();

		POJOExporter exporter = new POJOExporter(getConfiguration(),getOutputDirectory());
		exporter.setProperties((Properties) getProperties().clone());
		exporter.setTemplatePath(getTemplatePaths());
		exporter.setArtifactCollector(getArtifactCollector());
        exporter.getProperties().setProperty("ejb3", "true");
        exporter.getProperties().setProperty("jdk5", "true");
		exporter.setFilePattern("src/{package-name}/{class-name}.java");
		exporter.start();
		
		configureExporter( "seam/finder.java.ftl", "src/{package-name}/{class-name}Finder.java").start();
		configureExporter( "seam/finderbean.java.ftl", "src/{package-name}/{class-name}FinderBean.java").start();
		configureExporter( "seam/selector.java.ftl", "src/{package-name}/{class-name}Selector.java").start();
		  
		configureExporter( "seam/editor.java.ftl", "src/{package-name}/{class-name}Editor.java").start();
		configureExporter( "seam/editorbean.java.ftl", "src/{package-name}/{class-name}EditorBean.java").start();
		
	}

	private GenericExporter configureExporter(String template, String pattern) {
		GenericExporter exporter = new GenericExporter(getConfiguration(),getOutputDirectory());
		exporter.setProperties((Properties) getProperties().clone());
		exporter.setTemplatePath(getTemplatePaths());
		exporter.setTemplateName(template);
		exporter.setFilePattern(pattern);
		exporter.setArtifactCollector(getArtifactCollector());
		return exporter;
	}
}
