package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.EmployeInfo;
import com.sinosoft.one.ams.repositories.CompanyDao;
import com.sinosoft.one.ams.repositories.GeRmsUserPowerRepository;
import com.sinosoft.one.ams.repositories.UserDao;
import com.sinosoft.one.ams.service.facade.EmployeeService;
import com.sinosoft.one.uiutil.Gridable;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="geRmsUserPowerRepository")
	private GeRmsUserPowerRepository geRmsUserPowerRepository;
	@Resource(name="companyDao")
	private CompanyDao companyDao;

	//将数据库中的用户记录查出，并保存在Gridable对象中返回
	public Gridable<EmployeInfo> getGridable(Gridable<EmployeInfo> gridable,
			Pageable pageable, List<String> userAttribute) {
		Page<Employe> page = userDao.findAll(pageable);
		List<Employe> userList = page.getContent();
		
		gridable = getGridable(userList, gridable, userAttribute, pageable);
		
		return gridable;
	}

	//根据userCode和comCode，将数据库中的用户记录查出，并保存在Gridable对象中返回
	public Gridable<EmployeInfo> getGridable(Gridable<EmployeInfo> gridable,
			String userCode, String comCode, Pageable pageable,
			List<String> userAttribute) {
			Page<Employe> page =null;

			if(userCode.equals("null") && comCode.equals("null")){
				
				//userCode和comCode都为空时，查询全部
				page = userDao.findAll(pageable);
			}else if(!userCode.equals("null") && comCode.equals("null")){
				
				//userCode不为空，comCode为空时，根据userCode，进行查询
				page = userDao.findUserByUserCode("%"+userCode+"%",pageable);
				
			}else if(userCode.equals("null") && !comCode.equals("null")){
				
				//userCode为空，comCode不为空时，根据comCode，进行查询
				page = userDao.findUserByComCode("%"+comCode+"%",pageable);

			}else {
				
				//userCode不为空，comCode不为空时，根据userCode和comCode，进行查询
				page = userDao.findUserByComCodeUserCode("%"+comCode+"%", "%"+userCode+"%",pageable);

			}
			List<Employe> userList = page.getContent();
			gridable = getGridable(userList, gridable, userAttribute, pageable);
			return gridable;
	}
	
	//生成getGridable对象
	public Gridable<EmployeInfo> getGridable(List<Employe> userList,Gridable<EmployeInfo> gridable ,List<String> userAttribute ,Pageable pageable){
		String button = "<a href='javascript:;' class='set' onclick='openQX(this);'>权限设置</a><a href='#' class='set' onclick='openSJ(this);'>数据设置</a>";
		String button_ = "<a href='javascript:;' class='set' onclick='openQX(this);'>权限设置</a><a href='#' title='该人员未配置权限，无法操作' class='set dis'>数据设置</a>";
		String button2 = "<a href='#' class='agency' onclick='openWindow(this)'></a>";
		
		List<EmployeInfo> employeInfos = new ArrayList<EmployeInfo>();
		
		for(Employe user: userList){
			List<String> userPowerId = geRmsUserPowerRepository.findUserPowerIdByUserCode(user.getUserCode());
			String comCodeUser = userDao.findComCodeByUserCode(user.getUserCode());
			Company com = companyDao.findOne(comCodeUser);
			
			EmployeInfo employeInfo = new EmployeInfo();
			employeInfo.setUserCode(user.getUserCode());
			employeInfo.setUserName(user.getUserName());
			employeInfo.setComCName(com.getComCName());
			
			if(!userPowerId.isEmpty()){
				employeInfo.setOpenQXAndSJ(button);
			}else{
				employeInfo.setOpenQXAndSJ(button_);
			}
			
			employeInfo.setOpenWindow(button2);
			employeInfos.add(employeInfo);
		}
		List<Employe> userAll = (List<Employe>) userDao.findAll();
		int total = userAll.size();
		Page<EmployeInfo> EmployeInfoPage = new PageImpl<EmployeInfo>(employeInfos, pageable, total);
		gridable.setPage(EmployeInfoPage);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("comCName");
		userAttribute.add("openWindow");
		userAttribute.add("openQXAndSJ");
		gridable.setCellListStringField(userAttribute);
		return gridable;
	}

	//根据id和password查询用户
	public Employe findEmployeByUserCodePassword(String userCode,
			String password) {
		Employe user = null;
		if(password == null){
			user = userDao.findUserById(userCode);
		}else{
			user = userDao.findUserByIdPassowrd(userCode, password);
		}
		return user;
	}

}
