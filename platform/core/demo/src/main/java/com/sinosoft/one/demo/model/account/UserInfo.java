/**
 * 
 */
package com.sinosoft.one.demo.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sinosoft.one.demo.model.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author seline
 *
 */
@Entity
@Table(name = "acct_userinfo")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserInfo extends IdEntity {

	private String phone;
	private String idcode;
	private String strGender;
	private Gender gender;
	private  long  userId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdcode() {
		return idcode;
	}
	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}
	@Transient
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Column(name="gender")
	public String getStrGender() {
		return strGender;
	}
	public void setStrGender(String strGender) {
		this.strGender = strGender;
	}
	
	
}
