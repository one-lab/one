package com.sinosoft.one.newRms.client.annotationtest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.repositories.UserDao;
import com.sinosoft.one.newRms.client.annotation.DataAuthority;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class AnnotationTestService implements TestService  {
	
	@Autowired
	private UserDao userDao;

	
	@DataAuthority("RMS001")
	public Page<Employe> testFindByHql() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Employe> page =  userDao.findUserByComCode("00", pageable);
		return page;
	}
	
	@DataAuthority("RMS001")
	public List<Employe> testFindAll() {
		List<Employe> users = (List<Employe>) userDao.findAll();
		return users;
	}
		
	
}
