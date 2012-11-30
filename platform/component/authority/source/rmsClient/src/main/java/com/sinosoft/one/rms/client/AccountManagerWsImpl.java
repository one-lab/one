package com.sinosoft.one.rms.client;


import com.sinosoft.one.rms.User;
import com.sinosoft.one.rms.client.webservice.RmsClientService;
import com.sinosoft.one.rms.client.webservice.RmsClientServiceImplService;

public class AccountManagerWsImpl implements AccountManager{

	//远程调用webService :RmsClientService
	public com.sinosoft.one.rms.client.webservice.User findUserByLoginNameWs(
			String loginName, String comCode, String sysFlag) {
		RmsClientService rmsClientService = new RmsClientServiceImplService().getRmsClientServiceImplPort();
		//返回的是webService生成的客户端包的对象
		com.sinosoft.one.rms.client.webservice.User user =rmsClientService.login(loginName, comCode,sysFlag);
		return user;
	}
	

	public User findUserByLoginName(String loginName, String comCode,
			String sysFlag) {
		return null;
	}
	
//	private void creatMenuList(List<com.sinosoft.one.rms.client.webservice.Menu> webServiceMenuList, List<Menu> localMenuList) {
//		for (com.sinosoft.one.rms.client.webservice.Menu menu : webServiceMenuList) {
//			Menu m=new Menu(menu.getId(), menu.getUrl(), menu.getName());
//			if(menu.getChildren().size()>0){
//				List<Menu> menus=new ArrayList<Menu>();
//				creatMenuList( menu.getChildren(),menus);
//			}
//			localMenuList.add(m);
//		}
//	}
//	
//	private void creatDataPowerList(List<com.sinosoft.one.rms.client.webservice.DataPower> webServiceDataPowers ,List<DataPower>localDataPowers,String userCode,String comCode){
//		for (com.sinosoft.one.rms.client.webservice.DataPower dataPower : webServiceDataPowers) {
//			DataPower localPower=new DataPower(userCode,comCode,dataPower.getRuleId(), dataPower.getRuleId(), dataPower.getParam(), dataPower.getRule(),null);
//			localDataPowers.add(localPower);
//		}
//	}
//
//
//	
//	
//	public User findUserByLoginName(String loginName, 
//			String comCode,String sysFlags) {
//		RmsClientService rmsServiceClient = new RmsClientServiceService().getRmsClientServicePort();
//		com.sinosoft.one.rms.client.webservice.User user =rmsServiceClient.login(loginName, comCode,sysFlags);
//		List<Menu> menus=new ArrayList<Menu>();
//		creatMenuList(user.getMenuList(), menus);
//		List<DataPower> dataPowers=new ArrayList<DataPower>();
//		creatDataPowerList(user.getDataPowers(), dataPowers,loginName,comCode);
//		return new User(user.getUserCode(), user.getPassWord(), user.getUserName(), user.getLoginComCode(), user.getLoginComName(), user.getRoleIdList(), user.getTaskIdList(),menus , dataPowers);
//	}
}
