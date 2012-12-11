package com.sinosoft.one.bpm.util;

import javax.persistence.EntityManagerFactory;

import org.springframework.orm.jpa.JpaTransactionManager;

public class BpmEnvironment {

	public static JpaTransactionManager bpmTxManager = null;
	public static EntityManagerFactory bpmEmf = null;

   
}    