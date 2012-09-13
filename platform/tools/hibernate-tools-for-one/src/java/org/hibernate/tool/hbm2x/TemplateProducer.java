package org.hibernate.tool.hbm2x;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class TemplateProducer {

	private static final Log log = LogFactory.getLog(TemplateProducer.class);
	private final TemplateHelper th;
	private ArtifactCollector ac;
	
	public TemplateProducer(TemplateHelper th, ArtifactCollector ac) {
		this.th = th;
		this.ac = ac;
	}
	
	void produce(Map additionalContext, String templateName, File destination, String identifier, String fileType) {
		
		String tempResult = produceToString( additionalContext, templateName );
		
		if(tempResult.trim().length()==0) {
			log.warn("Generated output is empty. Skipped creation for file " + destination);
			return;
		}
		//FileWriter fileWriter = null;
		Writer fileWriter = null;
		try {
			
			th.ensureExistence( destination );    
	     
			ac.addFile(destination, fileType);
			log.debug("Writing " + identifier + " to " + destination.getAbsolutePath() );
			//fileWriter = new FileWriter(destination);
			fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), "UTF-8"));
            fileWriter.write(tempResult);			
		} 
		catch (Exception e) {
		    throw new ExporterException("Error while writing result to file", e);	
		} finally {
			if(fileWriter!=null) {
				try {
					fileWriter.flush();
					fileWriter.close();
				}
				catch (IOException e) {
					log.warn("Exception while flushing/closing " + destination,e);
				}				
			}
		}
		
	}


	private String produceToString(Map additionalContext, String templateName) {
		Map contextForFirstPass = additionalContext;
		putInContext( th, contextForFirstPass );		
		StringWriter tempWriter = new StringWriter();
		BufferedWriter bw = new BufferedWriter(tempWriter);
		// First run - writes to in-memory string
		th.processTemplate(templateName, bw);
		removeFromContext( th, contextForFirstPass );
		try {
			bw.flush();
		}
		catch (IOException e) {
			throw new RuntimeException("Error while flushing to string",e);
		}
		return tempWriter.toString();
	}

	private void removeFromContext(TemplateHelper th, Map context) {
		Iterator iterator = context.entrySet().iterator();
		while ( iterator.hasNext() ) {
			Map.Entry element = (Map.Entry) iterator.next();
			th.removeFromContext((String) element.getKey(), element.getValue());
		}
	}

	private void putInContext(TemplateHelper th, Map context) {
		Iterator iterator = context.entrySet().iterator();
		while ( iterator.hasNext() ) {
			Map.Entry element = (Map.Entry) iterator.next();
			th.putInContext((String) element.getKey(), element.getValue());
		}
	}

	public void produce(Map additionalContext, String templateName, File outputFile, String identifier) {
		String fileType = outputFile.getName();
		fileType = fileType.substring(fileType.indexOf('.')+1);
		produce(additionalContext, templateName, outputFile, identifier, fileType);
	}
}
