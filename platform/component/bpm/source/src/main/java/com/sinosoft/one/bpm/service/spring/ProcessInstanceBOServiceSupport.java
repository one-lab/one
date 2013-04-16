package com.sinosoft.one.bpm.service.spring;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.drools.persistence.TransactionManager;
import org.jbpm.task.service.TaskException;
import org.jbpm.task.service.TaskServiceSession.TransactedOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.bpm.model.ProcessInstanceBOInfo;
import com.sinosoft.one.bpm.service.facade.ProcessInstanceBOService;

public class ProcessInstanceBOServiceSupport implements ProcessInstanceBOService{
	private final static int STATUS_ROLLBACK_ONLY = 5;
	private EntityManager em;
	private TransactionManager tm;
    private boolean useJTA;
	
	public ProcessInstanceBOServiceSupport(EntityManagerFactory emf,
			TransactionManager tm, boolean useJTA) {
		this.em = emf.createEntityManager();
		this.tm = tm;
		this.useJTA = useJTA;
		
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
	
	public void doOperationInTransaction(final TransactedOperation operation) {

        boolean txOwner = false;
        boolean operationSuccessful = false;
        boolean txStarted = false;
        try {
            this.begin();
            txStarted = true;
            
            operation.doOperation();
            operationSuccessful = true;
            
            this.commit(txOwner);
        } catch(Exception e) {
            this.rollback(txOwner);
            
            String message; 
            if( !txStarted ) { message = "Could not start transaction."; }
            else if( !operationSuccessful ) { message = "Operate ProcessInstanceBOInfo failed"; }
            else { message = "Could not commit transaction"; }
            
            if (e instanceof TaskException) {
                throw (TaskException) e;
            } else {
                throw new RuntimeException(message, e);
            }
        }
        
    }

	public void createProcessInstanceBOInfo(final ProcessInstanceBOInfo info) {
		doOperationInTransaction(new TransactedOperation() {
			public void doOperation() throws Exception {
				em.persist(info);
			}
			
		});
	}
	
		
	public void attachPersistenceContext() { 
        if( useJTA ) { 
            em.joinTransaction();
        }
    }
    
    public boolean begin() {
        boolean owner =  tm.begin();
        attachPersistenceContext();
        return owner;
    }

    public void commit(boolean txOwner) {
        tm.commit(txOwner);
    }

    public void rollback(boolean txOwner) {
        int status = tm.getStatus();
        switch(status) { 
        case TransactionManager.STATUS_NO_TRANSACTION:
        case TransactionManager.STATUS_COMMITTED:
        case TransactionManager.STATUS_ROLLEDBACK:
            // do nothing
            break;
        case TransactionManager.STATUS_ACTIVE:
        case STATUS_ROLLBACK_ONLY:
            tm.rollback(txOwner);
            break;
        case TransactionManager.STATUS_UNKNOWN:
        default:
            throw new RuntimeException("Unknown transaction state when rolling back.");
        }
    }

    public int getStatus(EntityManager em) {
        return tm.getStatus();
    }



	public ProcessInstanceBOInfo getProcessInstanceBOInfo(long processInstanceId) {
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

	public void removeProcessInstanceBOInfo(final ProcessInstanceBOInfo info) {
		info.setModifyTime(new Date());
		info.setStatus(String.valueOf(ProcessInstanceBOInfo.Status.REMOVE.ordinal()));
		doOperationInTransaction(new TransactedOperation() {
			
			public void doOperation() throws Exception {
				em.merge(info);
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<ProcessInstanceBOInfo> getAllNormalProcessInstanceBOInfo() {
		List<ProcessInstanceBOInfo> result = null;
		try {
	        Query query = em.createNamedQuery("AllNormalProcessInstanceBOInfoes");
	        result = query.getResultList();
		} catch(NoResultException exception) {
			logger.warn(exception.getLocalizedMessage());
		}
		return result;
	}
}
