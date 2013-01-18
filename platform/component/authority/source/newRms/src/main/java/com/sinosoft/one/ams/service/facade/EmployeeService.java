package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.uiutil.Gridable;
@Service
public interface EmployeeService {
	public Employe findEmployeByUserCode(String userCode);
	
	//将数据库中的用户记录查出，并保存在Gridable对象中返回
	public Gridable<Employe> getGridable(Gridable<Employe> gridable,Pageable pageable,List<String> userAttribute);

	//根据userCode和comCode，将数据库中的用户记录查出，并保存在Gridable对象中返回
	public Gridable<Employe> getGridable(Gridable<Employe> gridable,String userCode,String comCode,Pageable pageable,List<String> userAttribute);
	
	//根据userCode查询归属机构
	public Company findComByUserCode(String userCode);
	
	
}
