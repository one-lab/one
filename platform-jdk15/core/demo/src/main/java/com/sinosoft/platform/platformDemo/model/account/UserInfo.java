/**
 * 
 */
package com.sinosoft.platform.platformDemo.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sinosoft.platform.platformDemo.model.IdEntity;

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
	private String strGeneral;
	private General general;
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
	public General getGeneral() {
		return general;
	}
	public void setGeneral(General general) {
		this.general = general;
	}
	@Column(name="general")
	public String getStrGeneral() {
		return strGeneral;
	}
	public void setStrGeneral(String strGeneral) {
		this.strGeneral = strGeneral;
	}
	
	
}
