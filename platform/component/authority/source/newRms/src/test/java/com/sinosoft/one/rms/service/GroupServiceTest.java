package com.sinosoft.one.rms.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.ams.service.facade.GroupService;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
public class GroupServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private GroupService groupService;
	
	/**
	 * 测试根据机构Id，查询机构的用户组
	 */
	@Test
	public void testFindGroupByComCode(){
		List<Group> groups = groupService.findGroupByComCode("00");
		if(!groups.isEmpty()){
			int i = 0;
			for(Group group : groups){
				System.out.println(i+","+group.getGroupID());
				i++;
			}
		}
	}
	
	/**
	 * 测试根据机构Id，查询机构的用户组,并对已引入用户的组进行标记
	 */
	@Test
	public void testFindGroupByComCode2(){
		List<Group> groups = groupService.findGroupByComCode("00","admin");
		if(!groups.isEmpty()){
			int i = 0;
			for(Group group : groups){
				System.out.println(i+","+group.getGroupID());
				i++;
			}
		}
	}
	
	/**
	 * 测试根据用户组ID查询用户组
	 */
	@Test
	public void testFindGroupById(){
		List<String> groupIds = new ArrayList<String>();
		groupIds.add("group10001");
		groupIds.add("group10002");
		List<Group> groups = groupService.findGroupById(groupIds);
		if(!groups.isEmpty()){
			int i = 0;
			for(Group group : groups){
				System.out.println(i+","+group.getGroupID());
				i++;
			}
		}
	}
	
	/**
	 * 测试根据用户组ID查询用户组
	 */
	@Test
	public void testFindGroupById2(){
		
		Group group = groupService.findGroupById("group10001");
		Assert.assertEquals("group10001", group.getGroupID());
	}
	
	/**
	 * 添加用户组
	 */
	@Test
	public void testAddGroup(){
		List<String> roleIds = new ArrayList<String>();
		roleIds.add("role100001");
		roleIds.add("role100002");
		groupService.addGroup("group00000", "all", roleIds, "测试", "00", "admin");
	}

}
