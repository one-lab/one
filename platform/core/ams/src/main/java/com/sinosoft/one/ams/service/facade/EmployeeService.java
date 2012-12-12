package com.sinosoft.one.ams.service.facade;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Employe;
@Service
public interface EmployeeService {
	public Employe findEmployeByUserCode(String userCode);
}
