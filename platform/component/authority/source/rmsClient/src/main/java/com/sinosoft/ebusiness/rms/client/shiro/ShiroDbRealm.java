package com.sinosoft.ebusiness.rms.client.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.sinosoft.ebusiness.rms.client.AccountManager;
import com.sinosoft.ebusiness.rms.clientService.User;


public class ShiroDbRealm  extends AuthorizingRealm{

	@Autowired
	private AccountManager accountManager;

	public void setAccountManager(AccountManager accountManager) {
		System.out.println("account Manager:"+accountManager);
		this.accountManager = accountManager;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = accountManager.findUserByLoginName(token.getUsername(), "00");
		if (user != null) {
			return new SimpleAuthenticationInfo(user,user.getPassWord(),getName());
		} else {
			return null;
		}
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		User user = (User) principals.fromRealm(getName()).iterator().next();

		if (user != null) {
			System.out.println(333);
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//			for (Group group : user.getGroupList()) {
//				//基于Permission的权限信息
//				info.addStringPermissions(group.getPermissionList());
//			}
			return info;
		} else {
			return null;
		}
			
	}

}
