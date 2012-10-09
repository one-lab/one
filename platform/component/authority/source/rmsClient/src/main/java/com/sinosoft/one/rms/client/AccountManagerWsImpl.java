package com.sinosoft.one.rms.client;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.one.rms.client.webservice.RmsClientService;
import com.sinosoft.one.rms.client.webservice.RmsClientServiceImplService;
import com.sinosoft.one.rms.clientService.DataPower;
import com.sinosoft.one.rms.clientService.Menu;
import com.sinosoft.one.rms.clientService.User;

public class AccountManagerWsImpl implements AccountManager{

	//远程调用 需要将webService的中的对象类型 转化成MODEL
	public User findUserByLoginName(String loginName, 
			String comCode,String sysFlags) {
		RmsClientService rmsServiceClient = new RmsClientServiceImplService().getRmsClientServiceImplPort();
		com.sinosoft.one.rms.client.webservice.User user =rmsServiceClient.login(loginName, comCode);
		List<Menu> menus=new ArrayList<Menu>();
		creatMenuList(user.getMenuList(), menus);
		List<DataPower> dataPowers=new ArrayList<DataPower>();
		creatDataPowerList(user.getDataPowers(), dataPowers,loginName,comCode);
		return new User(user.getUserCode(), user.getPassWord(), user.getUserName(), user.getLoginComCode(), user.getLoginComName(), user.getRoleIdList(), user.getTaskIdList(),menus , dataPowers);
	}
	
	
	private void creatMenuList(List<com.sinosoft.one.rms.client.webservice.Menu> webServiceMenuList, List<Menu> localMenuList) {
		for (com.sinosoft.one.rms.client.webservice.Menu menu : webServiceMenuList) {
			Menu m=new Menu(menu.getId(), menu.getUrl(), menu.getName());
			if(menu.getChildren().size()>0){
				List<Menu> menus=new ArrayList<Menu>();
				creatMenuList( menu.getChildren(),menus);
			}
			localMenuList.add(m);
		}
	}
	
	private void creatDataPowerList(List<com.sinosoft.one.rms.client.webservice.DataPower> webServiceDataPowers ,List<DataPower>localDataPowers,String userCode,String comCode){
		for (com.sinosoft.one.rms.client.webservice.DataPower dataPower : webServiceDataPowers) {
			DataPower localPower=new DataPower(userCode,comCode,dataPower.getRuleId(), dataPower.getRuleId(), dataPower.getParam(), dataPower.getRule(),null);
			localDataPowers.add(localPower);
		}
	}
}
