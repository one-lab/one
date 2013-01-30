package com.sinosoft.one.rms.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.RoleDesignateInfo;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.service.facade.RoleService;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
public class RoleServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private RoleService roleService;
	
	@Test
	public void testFindRoleById(){
		Role role = roleService.findRoleById("role100011");
		Assert.assertEquals("role100011", role.getRoleID());
	}
	
	/**
	 * 根据角色ID查询角色关联的功能
	 */
	@Test
	public void testFindTaskByRole(){
		List<Task> tasks = roleService.findTaskByRole("role100012");
		for(Task task : tasks){
			System.out.println(task.getTaskID());
		}
	}
	
	/**
	 * 根据机构查询所有可用的功能
	 */
	@Test
	public void testFindTaskByComCode(){
		List<Task> tasks = roleService.findTaskByComCode("00");
		for(Task task : tasks){
			System.out.println(task.getTaskID());
		}
	}
	
	/**
	 * 查询机构下所有可见的角色
	 */
	@Test
	public void testFindRole(){
		Pageable pageable = new PageRequest(0, 10);
		Page<Role> page = roleService.findRole("00", null, pageable);
		List<Role> roles = page.getContent();
		for(Role role : roles){
			System.out.println(role.getRoleID());
		}
	}
	
	/**
	 * 根据父机构ID查询角色
	 */
	@Test
	public void testFindRoleDesignate(){
		Pageable pageable = new PageRequest(0, 10);
		Page<RoleDesignateInfo> page = roleService.findRoleDesignate("00", pageable);
		List<RoleDesignateInfo> RoleDesignateInfos = page.getContent();
		for(RoleDesignateInfo rdi : RoleDesignateInfos){
			System.out.println(rdi.getRoleId());
		}
	}

}
