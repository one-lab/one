package com.sinosoft.one.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.uiutil.Treeable;

/**
 * 公共使用业务接口 人员/机构
 * @author Administrator
 *
 */
@Component
public class AccountManager {

	//----------------------------------工具------------------------------//
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Treeable<NodeEntity> creatTaskTreeAble(List<Task> checkedTasks,List<Task> showTasks){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		
		for (Task geRmsTask : showTasks) {
			if(geRmsTask.getParent()==null){
				NodeEntity nodeEntity=new NodeEntity();
				nodeEntity.setId(geRmsTask.getTaskID());
				nodeEntity.setTitle(geRmsTask.getName());
				nodeEntity.setChildren(creatSubNode(geRmsTask,checkedTasks, showTasks));
				for (Task checkedTask : checkedTasks) {
					if(checkedTask.getTaskID().toString().equals(geRmsTask.getTaskID().toString())){
						nodeEntity.setClassField("jstree-checked");
					}
				}
				nodeEntitys.add(nodeEntity);
			}
		}
		Treeable<NodeEntity> treeable =new Treeable.Builder(nodeEntitys,"id", "title", "children", "state").classField("classField").urlField("urlField").builder();
		return treeable;
	}
	
	List<NodeEntity> creatSubNode(Task superTask ,List<Task> checkedTasks,List<Task> showTasks){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		for (Task geRmsTask : showTasks) {
			if(geRmsTask.getParent()!=null&&!geRmsTask.getParent().getTaskID().toString().equals("")){
				if (geRmsTask.getTaskID().toString().toString().equals(superTask.getTaskID().toString())) {
					NodeEntity nodeEntity = new NodeEntity();
					nodeEntity.setId(geRmsTask.getTaskID());
					nodeEntity.setTitle(geRmsTask.getName());
					nodeEntity.setChildren(creatSubNode(geRmsTask,checkedTasks,showTasks));
					for (Task checkedTask : checkedTasks) {
						if(checkedTask.getTaskID().toString().equals(geRmsTask.getTaskID().toString())){
							nodeEntity.setClassField("jstree-closed jstree-unchecked");
						}
					}
					nodeEntitys.add(nodeEntity);
				}
			}
		}
		return nodeEntitys;
	}

}
