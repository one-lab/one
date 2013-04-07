package com.sinosoft.one.bpm.service.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.bpm.model.ProcessInstanceBOInfo;
import com.sinosoft.one.bpm.service.facade.ProcessInstanceBOService;

public class ProcessInstanceBOServiceSupport implements ProcessInstanceBOService{
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public ProcessInstanceBOServiceSupport() {
		
	}
	
	private static Logger logger = LoggerFactory.getLogger(ProcessInstanceBOServiceSupport.class);
	public ProcessInstanceBOInfo getProcessInstanceBOInfo(
			String processId, String businessId) {
		ProcessInstanceBOInfo result = null;
		try {
	        Query query = em.createNamedQuery("ProcessInstanceBOInfoForProcessIdAndBusinessId");
	        query.setParameter("processId", processId);
	        query.setParameter("businessId", businessId);
	        result = (ProcessInstanceBOInfo) query.getSingleResult();
		} catch(NoResultException exception) {
			logger.warn(exception.getLocalizedMessage());
		} 
		return result;
	}

	public void createProcessInstanceBOInfo(final ProcessInstanceBOInfo info) {
		if(!em.isOpen()) {
			em = emf.createEntityManager();
		}
		final EntityTransaction tx = em.getTransaction();
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            em.persist(info);
            tx.commit();
        } catch(Throwable throwable) {
        	logger.warn("save process instance bo info exception.", throwable);
        } finally {
            if( tx.isActive() ) {
                tx.rollback();
            }
        }
	}


	public ProcessInstanceBOInfo getProcessInstanceBOInfo(Long processInstanceId) {
		ProcessInstanceBOInfo result = null;
		try {
	        Query query = em.createNamedQuery("ProcessInstanceBOInfoForProcessInstanceId");
	        query.setParameter("processInstanceId", processInstanceId);
	        result = (ProcessInstanceBOInfo) query.getSingleResult();
		} catch(NoResultException exception) {
			logger.warn(exception.getLocalizedMessage());
		}
		return result;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
		this.em = emf.createEntityManager();
	}
}
