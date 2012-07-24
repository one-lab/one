package com.sinosoft.ebusiness.rms.client.operation;

import ins.framework.common.EncryptUtils;

import java.util.ArrayList;
import java.util.List;


import com.sinosoft.ebusiness.rms.client.EnvContext;
import com.sinosoft.ebusiness.rms.client.cxf.RMSWebServiceSpirngImplService;
import com.sinosoft.ebusiness.rms.client.cxf.WebServiceDTO;
import com.sinosoft.ebusiness.rms.client.cxf.RMSWebService;
import com.sinosoft.ebusiness.rms.client.model.Employe;
import com.sinosoft.ebusiness.rms.client.model.LoginInfoDO;

public class ClientOperation {
//	private RMSWebService rmsServiceClient;
	
	static RMSWebService creatClient(){
		RMSWebService rmsServiceClient = new RMSWebServiceSpirngImplService().getRMSWebServiceSpirngImplPort();
		return rmsServiceClient;
	}
	
	public List<String> getServerMaseege(String userCode,String passWord){
		List<String> maseege=new ArrayList<String>();
		maseege=creatClient().webServiceSelectCom("admin",  EncryptUtils.md5( "000000"));
		return maseege;
	}
	
	//获取登陆用户信息 访问服务端
	public LoginInfoDO getLoginUserInfoByClient(){
		//获取服务中SESSION信息
//		HttpSession session=ServletActionContext.getRequest().getSession();
//		session.setAttribute("loginUser", "loginUser");
//		if(session.getAttribute("loginUser")!=null){
//		loginEmpInfoDTO.setEmploye(employe)
		//获取用户信息
		WebServiceDTO webServiceDTO= new WebServiceDTO();
		webServiceDTO=creatClient().webServiceLogin("admin", EncryptUtils.md5( "000000"), "00");
		LoginInfoDO loginInfoDO=new LoginInfoDO();
		loginInfoDO.setUserCode(webServiceDTO.getEmploye().getUserCode());
		loginInfoDO.setUserName(webServiceDTO.getEmploye().getUserName());
		loginInfoDO.setPassword(webServiceDTO.getEmploye().getPassword());
		loginInfoDO.setValidStatus(webServiceDTO.getEmploye().getValidStatus());
		loginInfoDO.setTasks(webServiceDTO.getTasks());
		loginInfoDO.setBusPowers(webServiceDTO.getBusPowers());
		EnvContext.setLoginInfo(loginInfoDO);
		return loginInfoDO;
	}
}
