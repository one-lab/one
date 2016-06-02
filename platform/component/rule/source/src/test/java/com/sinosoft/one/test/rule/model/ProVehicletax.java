package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="GE_PRO_VEHICLETAX")
public class ProVehicletax
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String orderNo;
  private ProOrder proOrder;
  private String taxitem;
  private String taxType;
  private String taxFlag;
  private String taxPayerClass;
  private String identifyType;
  private String identifyNumber;
  private String taxPayerAdd;
  private String taxPayerName;
  private String payNo;
  private String freeNo;
  private String taxDepartment;
  private String taxPayerNo;
  private String curryear;
  private String currmonth;
  private BigDecimal currentTax;
  private BigDecimal formerTax;
  private BigDecimal lateFee;
  private Date currTaxDate;
  private Date frontTaxDate;
  private String flag;

  @Id
  @GeneratedValue(generator="generator")
  @Column(name="ORDERNO")
  public String getOrderNo()
  {
    return this.orderNo;
  }

  public void setOrderNo(String orderNo)
  {
    this.orderNo = orderNo;
  }

  @OneToOne(fetch=FetchType.LAZY)
  @PrimaryKeyJoinColumn
  public ProOrder getProOrder()
  {
    return this.proOrder;
  }

  public void setProOrder(ProOrder proOrder)
  {
    this.proOrder = proOrder;
  }

  @Column(name="TAXITEM")
  public String getTaxitem()
  {
    return this.taxitem;
  }

  public void setTaxitem(String taxitem)
  {
    this.taxitem = taxitem;
  }

  @Column(name="TAXTYPE")
  public String getTaxType()
  {
    return this.taxType;
  }

  public void setTaxType(String taxType)
  {
    this.taxType = taxType;
  }

  @Column(name="TAXFLAG")
  public String getTaxFlag()
  {
    return this.taxFlag;
  }

  public void setTaxFlag(String taxFlag)
  {
    this.taxFlag = taxFlag;
  }

  @Column(name="TAXPAYERCLASS")
  public String getTaxPayerClass()
  {
    return this.taxPayerClass;
  }

  public void setTaxPayerClass(String taxPayerClass)
  {
    this.taxPayerClass = taxPayerClass;
  }

  @Column(name="IDENTIFYTYPE")
  public String getIdentifyType()
  {
    return this.identifyType;
  }

  public void setIdentifyType(String identifyType)
  {
    this.identifyType = identifyType;
  }

  @Column(name="IDENTIFYNUMBER")
  public String getIdentifyNumber()
  {
    return this.identifyNumber;
  }

  public void setIdentifyNumber(String identifyNumber)
  {
    this.identifyNumber = identifyNumber;
  }

  @Column(name="TAXPAYERADD")
  public String getTaxPayerAdd()
  {
    return this.taxPayerAdd;
  }

  public void setTaxPayerAdd(String taxPayerAdd)
  {
    this.taxPayerAdd = taxPayerAdd;
  }

  @Column(name="TAXPAYERNAME")
  public String getTaxPayerName()
  {
    return this.taxPayerName;
  }

  public void setTaxPayerName(String taxPayerName)
  {
    this.taxPayerName = taxPayerName;
  }

  @Column(name="PAYNO")
  public String getPayNo()
  {
    return this.payNo;
  }

  public void setPayNo(String payNo)
  {
    this.payNo = payNo;
  }

  @Column(name="FREENO")
  public String getFreeNo()
  {
    return this.freeNo;
  }

  public void setFreeNo(String freeNo)
  {
    this.freeNo = freeNo;
  }

  @Column(name="TAXDEPARTMENT")
  public String getTaxDepartment()
  {
    return this.taxDepartment;
  }

  public void setTaxDepartment(String taxDepartment)
  {
    this.taxDepartment = taxDepartment;
  }

  @Column(name="TAXPAYERNO")
  public String getTaxPayerNo()
  {
    return this.taxPayerNo;
  }

  public void setTaxPayerNo(String taxPayerNo)
  {
    this.taxPayerNo = taxPayerNo;
  }

  @Column(name="CURRYEAR")
  public String getCurryear()
  {
    return this.curryear;
  }

  public void setCurryear(String curryear)
  {
    this.curryear = curryear;
  }

  @Column(name="CURRMONTH")
  public String getCurrmonth()
  {
    return this.currmonth;
  }

  public void setCurrmonth(String currmonth)
  {
    this.currmonth = currmonth;
  }

  @Column(name="CURRENTTAX")
  public BigDecimal getCurrentTax()
  {
    return this.currentTax;
  }

  public void setCurrentTax(BigDecimal currentTax)
  {
    this.currentTax = currentTax;
  }

  @Column(name="FORMERTAX")
  public BigDecimal getFormerTax()
  {
    return this.formerTax;
  }

  public void setFormerTax(BigDecimal formerTax)
  {
    this.formerTax = formerTax;
  }

  @Column(name="LATEFEE")
  public BigDecimal getLateFee()
  {
    return this.lateFee;
  }

  public void setLateFee(BigDecimal lateFee)
  {
    this.lateFee = lateFee;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="CURRTAXDATE")
  public Date getCurrTaxDate()
  {
    return this.currTaxDate;
  }

  public void setCurrTaxDate(Date currTaxDate)
  {
    this.currTaxDate = currTaxDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="FRONTTAXDATE")
  public Date getFrontTaxDate()
  {
    return this.frontTaxDate;
  }

  public void setFrontTaxDate(Date frontTaxDate)
  {
    this.frontTaxDate = frontTaxDate;
  }

  @Column(name="FLAG")
  public String getFlag()
  {
    return this.flag;
  }

  public void setFlag(String flag)
  {
    this.flag = flag;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProVehicletax
 * JD-Core Version:    0.6.0
 */