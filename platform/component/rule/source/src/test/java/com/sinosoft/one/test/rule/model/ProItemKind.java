package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="GE_PRO_ITEMKIND")
public class ProItemKind
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String serialNo;
  private ProKind proKind;
  private String itemCode;
  private String itemName;
  private String currency;
  private BigDecimal unitAmount;
  private BigDecimal count;
  private BigDecimal amount;
  private BigDecimal deductible;
  private BigDecimal rate;
  private BigDecimal basePremium;
  private BigDecimal benchMarkPremium;
  private BigDecimal discount;
  private BigDecimal adjustRate;
  private BigDecimal premium;
  private String flag;
  private String packNo;

  @Id
  @GeneratedValue(generator="system-uuid")
  @Column(name="SERIALNO")
  public String getSerialNo()
  {
    return this.serialNo;
  }

  public void setSerialNo(String serialNo)
  {
    this.serialNo = serialNo;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="KINDSERIALNO")
  public ProKind getProKind() {
    return this.proKind;
  }

  public void setProKind(ProKind proKind)
  {
    this.proKind = proKind;
  }

  @Column(name="ITEMCODE")
  public String getItemCode()
  {
    return this.itemCode;
  }

  public void setItemCode(String itemCode)
  {
    this.itemCode = itemCode;
  }

  @Column(name="ITEMNAME")
  public String getItemName()
  {
    return this.itemName;
  }

  public void setItemName(String itemName)
  {
    this.itemName = itemName;
  }

  @Column(name="CURRENCY")
  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String currency)
  {
    this.currency = currency;
  }

  @Column(name="UNITAMOUNT")
  public BigDecimal getUnitAmount()
  {
    return this.unitAmount;
  }

  public void setUnitAmount(BigDecimal unitAmount)
  {
    this.unitAmount = unitAmount;
  }

  @Column(name="COUNT")
  public BigDecimal getCount()
  {
    return this.count;
  }

  public void setCount(BigDecimal count)
  {
    this.count = count;
  }

  @Column(name="AMOUNT")
  public BigDecimal getAmount()
  {
    return this.amount;
  }

  public void setAmount(BigDecimal amount)
  {
    this.amount = amount;
  }

  @Column(name="DEDUCTIBLE")
  public BigDecimal getDeductible()
  {
    return this.deductible;
  }

  public void setDeductible(BigDecimal deductible)
  {
    this.deductible = deductible;
  }

  @Column(name="RATE")
  public BigDecimal getRate()
  {
    return this.rate;
  }

  public void setRate(BigDecimal rate)
  {
    this.rate = rate;
  }

  @Column(name="BASEPREMIUM")
  public BigDecimal getBasePremium()
  {
    return this.basePremium;
  }

  public void setBasePremium(BigDecimal basePremium)
  {
    this.basePremium = basePremium;
  }

  @Column(name="BENCHMARKPREMIUM")
  public BigDecimal getBenchMarkPremium()
  {
    return this.benchMarkPremium;
  }

  public void setBenchMarkPremium(BigDecimal benchMarkPremium)
  {
    this.benchMarkPremium = benchMarkPremium;
  }

  @Column(name="DISCOUNT")
  public BigDecimal getDiscount()
  {
    return this.discount;
  }

  public void setDiscount(BigDecimal discount)
  {
    this.discount = discount;
  }

  @Column(name="ADJUSTRATE")
  public BigDecimal getAdjustRate()
  {
    return this.adjustRate;
  }

  public void setAdjustRate(BigDecimal adjustRate)
  {
    this.adjustRate = adjustRate;
  }

  @Column(name="PREMIUM")
  public BigDecimal getPremium()
  {
    return this.premium;
  }

  public void setPremium(BigDecimal premium)
  {
    this.premium = premium;
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

  public void setPackNo(String packNo) {
    this.packNo = packNo;
  }
  @Transient
  public String getPackNo() {
    return this.packNo;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProItemKind
 * JD-Core Version:    0.6.0
 */