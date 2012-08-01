package com.sinosoft.platform.platformDemo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "t_goods")
public class GoodsModel  {
	
	  private String id;
	  private String goodsName;
	  private Integer amountNow;
	  private String stockPerson;
	  private String receivingPerson;
	  private Date receivingDate;
	  private String sortId;
	  
	  
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * @return the stockPerson
	 */
	public String getStockPerson() {
		return stockPerson;
	}
	/**
	 * @param stockPerson the stockPerson to set
	 */
	public void setStockPerson(String stockPerson) {
		this.stockPerson = stockPerson;
	}
	/**
	 * @return the receivingPerson
	 */
	public String getReceivingPerson() {
		return receivingPerson;
	}
	/**
	 * @param receivingPerson the receivingPerson to set
	 */
	public void setReceivingPerson(String receivingPerson) {
		this.receivingPerson = receivingPerson;
	}
	/**
	 * @return the receivingDate
	 */
	public Date getReceivingDate() {
		return receivingDate;
	}
	/**
	 * @param receivingDate the receivingDate to set
	 */
	public void setReceivingDate(Date receivingDate) {
		this.receivingDate = receivingDate;
	}
	/**
	 * @return the sortId
	 */
	public String getSortId() {
		return sortId;
	}
	/**
	 * @param sortId the sortId to set
	 */
	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
	public Integer getAmountNow() {
		return amountNow;
	}
	public void setAmountNow(Integer amountNow) {
		this.amountNow = amountNow;
	}
	  
	
}
