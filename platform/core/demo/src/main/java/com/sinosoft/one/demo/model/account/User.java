package com.sinosoft.one.demo.model.account;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sinosoft.one.demo.model.IdEntity;
import com.sinosoft.one.demo.utils.Collections3;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.google.common.collect.Lists;

/**
 * 用户.
 * 
 * 使用JPA annotation定义ORM关系. 使用Hibernate annotation定义JPA未覆盖的部分.
 * 
 * @author calvin
 */
@Entity
// 表名与类名不相同时重新定义表名.
@Table(name = "acct_user")
// 默认的缓存策略.
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends IdEntity {

   // @NotNull(message = "登录名不能为空")
    private String loginName;
	private String password;// 为简化演示使用明文保存的密码
   // @Pattern( regexp = "[A-Za-z0-9]{4,30}",message = "用户名必须是英文或者数字，长度4到30位")
	private String name;
  //  @Size(min=4,max=20,message = "邮箱长度必须是4-20之间")
	private String email;
	private List<Group> groupList = Lists.newArrayList();// 有序的关联对象集合
	private Date createTime;

    @Valid
	private UserInfo userInfo;

	/*
	 * 
	 * 嵌套属性封装 例如私密信息
	 * 
	 * 
	 * 增加date，emun类型
	 */

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Transient
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// 多对多定义
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "acct_user_group", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "group_id") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序.
	@OrderBy("id")
	// 集合中对象id的缓存.
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	/**
	 * 用户拥有的权限组名称字符串, 多个权限组名称用','分隔.
	 */
	// 非持久化属性.
	@Transient
	public String getGroupNames() {
		return Collections3.extractToString(groupList, "name", ", ");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}