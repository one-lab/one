package ins.platform.service.spring;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.platform.model.UtiMenu;
import ins.platform.service.facade.UserPowerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import ins.platform.common.InstonyMd5Encrypt;


public class UserPowerServiceSpringImpl extends GenericDaoHibernate<PrpDuser, String> implements UserPowerService {
	
	/**
	 * 登陆调用此方法
	 * @param prpDuser 页面传递进来的userCode和password
	 * @return
	 */
	@Override
	public PrpDuser login(PrpDuser prpDuser) {
		
		String password = InstonyMd5Encrypt.md5(prpDuser.getPassword());
		password = password.toUpperCase();
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("userCode", prpDuser.getUserCode());
		queryRule.addEqual("password", password);
		return this.findUnique(queryRule);
	}
	/**
	 * 自动加载当前用户的机构
	 * @param userCode 用户编号
	 * @return
	 */
	@Override
	public List<PrpDcompany> loadCompany(String userCode) {
		String findCompanySqlString = "select {pdc.*} from prpdcompany pdc where pdc.comcode in (select comcode from utiusergrade where usercode = '"+userCode+"') ";
		SQLQuery sql = this.getSession().createSQLQuery(findCompanySqlString).addEntity("pdc",PrpDcompany.class);
		List<PrpDcompany> companys = sql.list();
		return companys;
	}
	/**
	 * 拉取菜单列表
	 * @param userCode  用户编号
	 * @param comCode  机构代码
	 * @param string  systemCode系统代码
	 * @param string2  语言选择，暂时只是中文
	 * @return
	 */
	@Override
	public JSONObject showTree(String userCode, String comCode, String systemCode,
			String string2) {

		Session session = this.getSession();
		//----------------查询三级菜单 begin--------------------
		String initMenu = "select {um.*} from utimenu um where um.taskCode in ( select ugt.taskCode from utigradetask ugt where ugt.gradeCode in"+ 
        " (select uug.gradeCode from utiusergrade uug where uug.userCode = '"+userCode+"' and uug.comCode = '"+comCode+"')"+ 
        ") and um.validStatus = 1 and um.systemCode='"+systemCode+"' and um.menulevel = 3 order by um.uppermenuid , um.displayNo";
		//this.findBySql(initMenu, null);
		SQLQuery menuQuery = session.createSQLQuery(initMenu).addEntity("um",UtiMenu.class);
		List<UtiMenu> menuLevelOneList = menuQuery.list();
		
		//QueryRule q = QueryRule.getInstance();
		
		//q.addSql(initMenu);
		//List<UtiMenu> menuLevelOneList = super.find(UtiMenu.class, q);
		//以jsonarray为单位，分组依据是父节点的menuId相同
		Map<String, JSONArray> menuMap = new HashMap<String, JSONArray>();
		//存放map的键值
		String upperId = "";
		for(int i = 0 ; i < menuLevelOneList.size() ; ){
			upperId = menuLevelOneList.get(i).getUpperMenuId();
			JSONArray ja = new JSONArray();
			for(int j = i ; j < menuLevelOneList.size() ; j++){
				if(menuLevelOneList.get(i).getUpperMenuId().equals(menuLevelOneList.get(j).getUpperMenuId())){
					JSONObject jo = new JSONObject();
					jo.element("id", menuLevelOneList.get(j).getMenuId());
					jo.element("text", menuLevelOneList.get(j).getMenuCName());
					//{id:"21", text:"child",userdata:[{name:'url',content:'http://g.cn#3'}]}
					jo.element("userdata", "[{name:'url',content:'"+menuLevelOneList.get(j).getUrl()+"'}]");
					ja.add(jo);
				}else{
					i = j;
					break;
				}
				if(j == menuLevelOneList.size()-1){
					i = j+1;
				}
			}
			menuMap.put(upperId,ja);
		}
		//----------------查询三级菜单 end--------------------
		
		//----------------查询二级菜单 begin--------------------
		String initMenu2 = "select {um.*} from utiMenu um "+
        " where um.taskCode in ( select ugt.taskCode from utigradetask ugt where ugt.gradeCode in"+ 
        " (select uug.gradeCode from utiusergrade uug where uug.userCode = '"+userCode+"' and uug.comCode = '"+comCode+"')"+ 
        ") and um.validStatus = 1 and um.systemCode='"+systemCode+"' and um.menulevel = 2 order by um.uppermenuid , um.displayNo";

		SQLQuery menuQuery2 = session.createSQLQuery(initMenu2).addEntity("um",UtiMenu.class);
		List<UtiMenu> menuLevel2List = menuQuery2.list();
		//以jsonarray为单位，分组依据是父节点的menuId相同
		Map<String, JSONArray> menuMap2 = new HashMap<String, JSONArray>();
		//存放map的键值
		String upperId2 = "";
		for(int i = 0 ; i < menuLevel2List.size() ; ){
			upperId2 = menuLevel2List.get(i).getUpperMenuId();
			JSONArray ja = new JSONArray();
			for(int j = i ; j < menuLevel2List.size() ; j++){
				//将二级菜单下的子菜单取到，并且放到该菜单下.如果没有子菜单那么不添加item属性
				
				JSONObject jo = new JSONObject();
				jo.element("id", menuLevel2List.get(j).getMenuId());
				jo.element("text", menuLevel2List.get(j).getMenuCName());
				JSONArray jaTemp = menuMap.get(menuLevel2List.get(j).getMenuId());
				if(jaTemp != null){					
					jo.element("item", jaTemp);
				}
				jo.element("userdata", "[{name:'url',content:'"+menuLevel2List.get(j).getUrl()+"'}]");
				//将二级菜单父节点id相同的分到一组去
				if(menuLevel2List.get(i).getUpperMenuId().equals(menuLevel2List.get(j).getUpperMenuId())){
					ja.add(jo);
				}else{
					i = j;
					break;
				}
				if(j == menuLevel2List.size() - 1){
					i = j+1 ;
				}
			}
			menuMap2.put(upperId2,ja);
		}
		//----------------查询二级菜单 end--------------------
		
		//----------------查询一级菜单 begin--------------------
		String initMenu3 = "select {um.*} from utiMenu um "+
        " where um.taskCode in ( select ugt.taskCode from utigradetask ugt where ugt.gradeCode in"+ 
        " (select uug.gradeCode from utiusergrade uug where uug.userCode = '"+userCode+"' and uug.comCode = '"+comCode+"')"+ 
        ") and um.validStatus = 1 and um.systemCode='"+systemCode+"' and um.menulevel = 1 order by um.uppermenuid , um.displayNo";

		SQLQuery menuQuery3 = session.createSQLQuery(initMenu3).addEntity("um",UtiMenu.class);
		List<UtiMenu> menuLevel3List = menuQuery3.list();
		//以jsonarray为单位，分组依据是父节点的menuId相同
		Map<String, JSONArray> menuMap3 = new HashMap<String, JSONArray>();
		//存放map的键值
		String upperId3 = "";
		for(int i = 0 ; i < menuLevel3List.size() ; ){
			upperId3 = menuLevel3List.get(i).getUpperMenuId();
			JSONArray ja = new JSONArray();
			for(int j = i ; j < menuLevel3List.size() ; j++){
				//将一级菜单下二级子菜单取到，并且放到该菜单下.如果没有子菜单那么不添加item属性
				
				JSONObject jo = new JSONObject();
				jo.element("id", menuLevel3List.get(j).getMenuId());
				jo.element("text", menuLevel3List.get(j).getMenuCName());
				JSONArray jaTemp = menuMap2.get(menuLevel3List.get(j).getMenuId());
				if(jaTemp != null){					
					jo.element("item", jaTemp);
				}
				jo.element("userdata", "[{name:'url',content:'"+menuLevel3List.get(j).getUrl()+"'}]");
				//将一级菜单父节点id相同的分到一组去
				if(menuLevel3List.get(i).getUpperMenuId().equals(menuLevel3List.get(j).getUpperMenuId())){
					ja.add(jo);
				}else{
					i = j;
					break;
				}
				if(j == menuLevel3List.size() - 1){
					i = j+1 ;
				}
			}
			menuMap3.put(upperId3,ja);
		}
		JSONObject father = new JSONObject();
		father.element("id", 0);
		father.element("item", menuMap3.get("0"));
		System.out.println(father);
		return father;
	
	}
	/**
	 * 根据comCode机构编号查询出机构的信息
	 * @param comCode
	 * @return
	 */
	@Override
	public PrpDcompany findCompanyByComCode(String comCode) {
		QueryRule qr = QueryRule.getInstance();
		qr.addEqual("comCode", comCode);
		PrpDcompany company = this.findUnique(PrpDcompany.class, qr);
		return company;
	}
	/**
	 * 双击带出人员
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public Page findByPage(int pageNo, int pageSize) {
		Page page = this.findByHqlNoLimit("select new ins.platform.vo.QueryCodeVo(u.userCode , u.userName) from PrpDuser u ",pageNo,pageSize,null);
		return page;
	}

}
