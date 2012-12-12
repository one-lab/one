package com.sinosoft.one.ams.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.repositories.GeRmsCompanyRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskAuthRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.service.facade.TaskAuthService;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;
import com.sinosoft.one.mvc.web.Invocation;

@Component
public class TaskAuthServiceImpl implements TaskAuthService{
	
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private GeRmsCompanyRepository geRmsCompanyRepository;
	@Autowired
	private GeRmsTaskAuthRepository geRmsTaskAuthRepository;
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private Invocation inv;
	public void push(NodeEntity nodeEntity, List<Company> companies) {
		// TODO Auto-generated method stub
		
	}
	public void recursionCompany(NodeEntity nodeEntity, String comCode) {
		// TODO Auto-generated method stub
		
	}
	public void pushTask(NodeEntity nodeEntity, List<Task> taskList,
			String comCode) {
		// TODO Auto-generated method stub
		
	}
	public void recursionTask(NodeEntity nodeEntity, String parentId,
			String comCode) {
		// TODO Auto-generated method stub
		
	}
	public Treeable<NodeEntity> treeAble(String comCode) {
		// TODO Auto-generated method stub
		return null;
	}
	public void save(String strId, String comCode, TaskAuth taskAuth) {
		// TODO Auto-generated method stub
		
	}

//	public void push(NodeEntity nodeEntity, List<GeRmsCompany> companies) {
//		List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();
//		for (GeRmsCompany company : companies) {
//
//			NodeEntity ne = new NodeEntity();
//			ne.setId(company.getComCode());
//			ne.setTitle(company.getComCName());
//			nodeEntities.add(ne);
//		}
//		nodeEntity.setChildren(nodeEntities);
//		
//	}
//	//递归机构，并将机构存入NodeEntity对象
//	public void recursionCompany(NodeEntity nodeEntity, String comCode) {
//		List<GeRmsCompany> companies;
//		if(comCode != null){
//			//查询上级机构不为空的机构
//			companies = geRmsCompanyRepository.findCompanyByUpperComCode(comCode);
//			
//		}else{
//			//查询上级机构为空的机构
//			companies = geRmsCompanyRepository.findCompanyByUpperComCode();
//		}
//
//		if (companies != null) {
//			push(nodeEntity, companies);
//			for (NodeEntity ne : nodeEntity.getChildren()) {
//				recursionCompany(ne, ne.getId());
//			}
//		}
//
//	}
//	
//	//将功能集合送入NodeEntity对象保存
//		public void pushTask(NodeEntity nodeEntity, List<GeRmsTask> taskList, String comCode) {
//			List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();
//			List<String> taskIdAuth = geRmsTaskAuthRepository.findTaskIdByComCode(comCode);
//
//			for (GeRmsTask task : taskList) {
//				NodeEntity ne = new NodeEntity();
//
//				ne.setId(task.getTaskID());
//				ne.setTitle(task.getName());
//				ne.setState("close");
//				if (taskIdAuth != null)
//					for (int i = 0; i < taskIdAuth.size(); i++) {
//						if (task.getTaskID().equals(taskIdAuth.get(i))
//								&& task.getParentID() != null
//								&& !(task.getParentID().equals("RMS001"))) {
//							ne.setState("rms");
//						}
//					}
//				nodeEntities.add(ne);
//			}
//			nodeEntity.setChildren(nodeEntities);
//			
//		}
//		
//		//递归功能，并存入nodeEntity
//		public void recursionTask(NodeEntity nodeEntity, String parentId,String comCode) {
//			List<GeRmsTask> taskList;
//			if(parentId != null){
//				 taskList = geRmsTaskRepository.findTaskByParentId(parentId);
//				
//			}else{
//				//根据parentId为空查询出Task集合
//				taskList = geRmsTaskRepository.findTaskByParentId();
//			}
//			pushTask(nodeEntity, taskList, comCode);
//			if (taskList != null)
//				for (NodeEntity ne : nodeEntity.getChildren()) {
//					recursionTask(ne, ne.getId(),comCode);
//				}
//		}
//		
//		//
//		public void recursionChildComTask(NodeEntity nodeEntity, String parentId,String comCode,String upperComCode) {
//			List<GeRmsTask> taskList;
//			if(parentId != null){
//				 taskList = geRmsTaskRepository.findChildTaskByParentId(parentId,upperComCode);
//				 System.out.println(taskList.size()+"========================");
//			}else{
//				//根据parentId为空查询出Task集合
//				taskList = geRmsTaskRepository.findChildTaskByParentId(upperComCode);
//				System.out.println(taskList.size()+"+++++++++++++++++++++++");
//			}
//			pushTask(nodeEntity, taskList, comCode);
//			if (taskList != null)
//				for (NodeEntity ne : nodeEntity.getChildren()) {
//					recursionChildComTask(ne, ne.getId(),comCode,upperComCode);
//				}
//		}
//		
//		@SuppressWarnings({ "unchecked", "rawtypes" })
//		public Treeable<NodeEntity> treeAble(String comCode) {
//			GeRmsCompany company = accountManager.company(comCode);
//
//			String parentComCode = company.getUpperComCode();
//			String grandComCode = null;
//			if (parentComCode != null) {
//				GeRmsCompany parentCom = accountManager.company(company.getUpperComCode());
//				grandComCode = parentCom.getUpperComCode();
//			}
//			
//			NodeEntity nodeEntity = new NodeEntity("TaskId", "权限管理", "close");
//			if (parentComCode == null || grandComCode == null) {
//				//递归
//				recursionTask(nodeEntity, null,comCode);
//				Treeable<NodeEntity> treeable = new Treeable.Builder(nodeEntity.getChildren(), "id", "title", "children","state").builder();
//				return treeable;
//			} else {
//				//递归，子机构根据父机构的功能，来赋功能
//				recursionChildComTask(nodeEntity, null,comCode,parentComCode);
//				Treeable<NodeEntity> treeable = new Treeable.Builder(nodeEntity.getChildren(), "id", "title", "children","state").builder();
//				return treeable;
//			}
//		}
//		
//		//保存机构的功能
//		public void save(String strId, String comCode,GeRmsTaskAuth taskAuth) {
//			User user = (User) inv.getRequest().getSession().getAttribute("user");
//			String name = user.getUserName();
//			
//			//查询当前机构已有的功能
//			List<String> taskIdAuth = geRmsTaskAuthRepository.findTaskIdByComCode(comCode);
//			
//			//统计此次操作后还有的功能
//			List<String> count = new ArrayList<String>();
//
//			String[] taskId = strId.split(",");
//
//			for (int i = 0; i < taskId.length; i++) {
//				if (taskIdAuth.contains(taskId[i])) {
//					//已有功能
//					System.out.println("功能已有：" + taskId[i]);
//					String parentId = geRmsTaskRepository.findParentIdByTaskId(taskId[i]);
//					count.add(taskId[i]);
//					count.add(parentId);
//				} else {
//					//新增功能
//					String parentId = geRmsTaskRepository.findParentIdByTaskId(taskId[i]);
//					System.out.println(parentId+ ",===============================");
//					
//					//如果没有父功能，先保存子功能的父功能
//					if (!taskIdAuth.contains(parentId)) {
//						taskAuth.setTaskAuthID(parentId + comCode);
//						taskAuth.setComCode(comCode);
//						taskAuth.setOperateUser(name);
//						taskAuth.setTaskID(parentId);
//						geRmsTaskAuthRepository.save(taskAuth);
//					}
//					count.add(taskId[i]);
//					count.add(parentId);
//					taskIdAuth.add(parentId);
//					taskIdAuth.add(taskId[i]);
//					
//					taskAuth.setTaskAuthID(taskId[i] + comCode);
//					taskAuth.setComCode(comCode);
//					taskAuth.setOperateUser(name);
//					taskAuth.setTaskID(taskId[i]);
//					geRmsTaskAuthRepository.save(taskAuth);
//				}
//			}
//			
//			//删除功能，父机构删除此功能，子机构也会被删除
//			for (int j = 0; j < taskIdAuth.size(); j++) {
//				
//				//判断此功能是否要删除
//				if (!count.contains(taskIdAuth.get(j))) {
//					geRmsTaskAuthRepository.deleteTask(comCode, taskIdAuth.get(j));
//					List<GeRmsCompany> comZi = geRmsCompanyRepository.findCompanyByUpperComCode(comCode);
//					if (comZi != null)
//						for (int i = 0; i < comZi.size(); i++) {
//							List<String> comZiTaskId = geRmsTaskAuthRepository.findTaskIdByComCode(comZi.get(i).getComCode());
//							if (comZiTaskId.contains(taskIdAuth.get(j))) {
//								geRmsTaskAuthRepository.deleteTask(comZi.get(i).getComCode(),taskIdAuth.get(j));
//							}
//						}
//				}
//			}
//			
//		}
	

}
