package com.sinosoft.one.rule.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.drools.SystemEventListener;
import org.drools.SystemEventListenerFactory;
import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentConfiguration;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.io.Resource;
import org.drools.io.ResourceChangeScannerConfiguration;
import org.drools.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KnowledgeAgentManager {
	private HashMap<String, KnowledgeAgent> kAgentMap = new HashMap<String, KnowledgeAgent>();
	private static Properties droolsProperties;
	private static final KnowledgeAgentManager instance = new KnowledgeAgentManager();

	private KnowledgeAgentManager() {
	}

	static {
		droolsProperties = new Properties();
		try {
			// load properties
			droolsProperties.load(getFileStream("drools.properties"));
			// start Resource Service
			System.setProperty("drools.resource.urlcache",
					droolsProperties.getProperty("drools.resource.urlcache"));
			ResourceChangeScannerConfiguration sconf = ResourceFactory
					.getResourceChangeScannerService()
					.newResourceChangeScannerConfiguration();
			sconf.setProperty("drools.resource.scanner.interval",
					droolsProperties
							.getProperty("drools.resource.scanner.interval"));
			ResourceFactory.getResourceChangeScannerService().configure(sconf);
			SystemEventListenerFactory
					.setSystemEventListener(new LogSystemEventListener());
			ResourceFactory.getResourceChangeNotifierService().start();
			ResourceFactory.getResourceChangeScannerService().start();
		} catch (IOException e) {
			Logger logger = LoggerFactory.getLogger("KnowledgeAgentManager");
			logger.error("fail to load properties:", e);
		}
	}

	public static KnowledgeAgentManager getInstance() {
		return instance;
	}

	public KnowledgeAgent getKnowledgeAgent(String changeSetFilePath) {
		KnowledgeAgent kAgent = null;
		synchronized (this) {
			if (kAgentMap.containsKey(changeSetFilePath)) {
				kAgent = kAgentMap.get(changeSetFilePath);
			} else {
				kAgent = newKnowledgeAgent(changeSetFilePath);
				kAgentMap.put(changeSetFilePath, kAgent);
			}
		}
		return kAgent;
	}

	private KnowledgeAgent newKnowledgeAgent(String changeSetFilePath) {
		Resource r = null;
		if (changeSetFilePath.startsWith("http")) {
			r = ResourceFactory.newUrlResource(changeSetFilePath);
		} else {
			r = ResourceFactory.newClassPathResource(changeSetFilePath);
		}
		// ResourceFactory.newReaderResource(reader);
		// r=ResourceFactory.newClassPathResource("ChangeSet.xml");
		// ((UrlResource)r).setBasicAuthentication("enabled");
		// ((UrlResource)r).setUsername("admin");
		// ((UrlResource)r).setPassword("");
		// ((UrlResource)r).setResourceType(ResourceType.PKG);

		KnowledgeAgentConfiguration kaconf = KnowledgeAgentFactory
				.newKnowledgeAgentConfiguration();
		kaconf.setProperty("drools.agent.scanDirectories",
				droolsProperties.getProperty("drools.agent.scanDirectories"));
		kaconf.setProperty("drools.agent.newInstance",
				droolsProperties.getProperty("drools.agent.newInstance"));

		KnowledgeAgent kAgent = KnowledgeAgentFactory.newKnowledgeAgent(
				changeSetFilePath, kaconf);

		kAgent.applyChangeSet(r);
		return kAgent;
	}

	private static InputStream getFileStream(String propertiesFilePath) {
		InputStream is = null;
		is = KnowledgeAgentManager.class.getClassLoader().getResourceAsStream(
				propertiesFilePath);
		return is;
	}
}

class LogSystemEventListener implements SystemEventListener {
	private Logger logger = LoggerFactory.getLogger("LogSystemEventListener");

	public void info(String message) {
		// TODO Auto-generated method stub
		this.info(message, null);
	}

	public void info(String message, Object object) {
		// TODO Auto-generated method stub
		logger.info(message, object);
	}

	public void warning(String message) {
		// TODO Auto-generated method stub
		this.warning(message, null);
	}

	public void warning(String message, Object object) {
		// TODO Auto-generated method stub
		logger.warn(message, object);
	}

	public void exception(String message, Throwable e) {
		// TODO Auto-generated method stub
		logger.error(message, e);
	}

	public void exception(Throwable e) {
		// TODO Auto-generated method stub
		this.exception("", e);
	}

	public void debug(String message) {
		// TODO Auto-generated method stub
		this.debug(message, null);
	}

	public void debug(String message, Object object) {
		// TODO Auto-generated method stub
		logger.debug(message, object);
	}
}
