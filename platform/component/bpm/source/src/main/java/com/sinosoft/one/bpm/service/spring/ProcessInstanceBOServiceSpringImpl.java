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

public class ProcessInstanceBOServiceSpringImpl implements ProcessInstanceBOService{
	private EntityManager em;
	
	public ProcessInstanceBOServiceSpringImpl(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	private static Logger logger = LoggerFactory.getLogger(ProcessInstanceBOServiceSpringImpl.class);
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
		} finally {
			if(em != null) {
				em.close();
			}
		}
		return result;
	}

	public void createProcessInstanceBOInfo(final ProcessInstanceBOInfo info) {
		try {
			final EntityTransaction tx = em.getTransaction();
	        try {
	            if (!tx.isActive()) {
	                tx.begin();
	            }
	            em.persist(info);
	            tx.commit();
	        } finally {
	            if( tx.isActive() ) {
	                tx.rollback();
	            }
	        }
		} finally {
			if(em != null) {
				em.close();
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
		} finally {
			if(em != null) {
				em.close();
			}
		}
		return result;
	}
}
