package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.EmployeInfo;
import com.sinosoft.one.uiutil.Gridable;

@Service
public interface EmployeeService {
	
	/**
	 * 根据userCode和password查询用户
	 * 
	 * @param userCode
	 * @param password
	 * @return
	 */
	public Employe findEmployeByUserCodePassword(String userCode,String password);
	
	/**
	 * 将数据库中的用户记录查出，并保存在Gridable对象中返回
	 * 
	 * @param gridable
	 * @param pageable
	 * @param userAttribute
	 * @return
	 */
	public Gridable<EmployeInfo> getGridable(Gridable<EmployeInfo> gridable,Pageable pageable,List<String> userAttribute);

	/**
	 * 根据userCode和comCode，将数据库中的用户记录查出，并保存在Gridable对象中返回
	 * 
	 * @param gridable
	 * @param userCode
	 * @param comCode
	 * @param pageable
	 * @param userAttribute
	 * @return
	 */
	public Gridable<EmployeInfo> getGridable(Gridable<EmployeInfo> gridable,String userCode,String comCode,Pageable pageable,List<String> userAttribute);
	
	
}
