package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GE_PRO_KIND")
public class ProKind
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String serialNo;
  private ProOrder proOrder;
  private String riskCode;
  private String kindCode;
  private String kindName;
  private String traffic;
  private String currency;
  private BigDecimal unitAmount;
  private BigDecimal count;
  private BigDecimal amount;
  private BigDecimal deductible;
  private String rateType;
  private BigDecimal rate;
  private String shortRateType;
  private BigDecimal shortRate;
  private BigDecimal basePremium;
  private BigDecimal benchMarkPremium;
  private BigDecimal discount;
  private BigDecimal adjustRate;
  private BigDecimal premium;
  private String flag;
  private String dayUnit;
  private String perUnit;
  private String scheme;
  private String version;
  private List<ProItemKind> proItemKinds = new ArrayList(0);
  private String packNo;

  @Id
  @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy="uuid.hex")
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
  @JoinColumn(name="ORDERNO", nullable=false)
  @JsonIgnore
  public ProOrder getProOrder() {
    return this.proOrder;
  }

  public void setProOrder(ProOrder proOrder)
  {
    this.proOrder = proOrder;
  }

  @Column(name="RISKCODE")
  public String getRiskCode()
  {
    return this.riskCode;
  }

  public void setRiskCode(String riskCode)
  {
    this.riskCode = riskCode;
  }

  @Column(name="KINDCODE")
  public String getKindCode()
  {
    return this.kindCode;
  }

  public void setKindCode(String kindCode)
  {
    this.kindCode = kindCode;
  }

  @Column(name="KINDNAME")
  public String getKindName()
  {
    return this.kindName;
  }

  public void setKindName(String kindName)
  {
    this.kindName = kindName;
  }

  @Column(name="TRAFFIC")
  public String getTraffic()
  {
    return this.traffic;
  }

  public void setTraffic(String traffic)
  {
    this.traffic = traffic;
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

  @Column(name="RATETYPE")
  public String getRateType()
  {
    return this.rateType;
  }

  public void setRateType(String rateType)
  {
    this.rateType = rateType;
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

  @Column(name="SHORTRATETYPE")
  public String getShortRateType()
  {
    return this.shortRateType;
  }

  public void setShortRateType(String shortRateType)
  {
    this.shortRateType = shortRateType;
  }

  @Column(name="SHORTRATE")
  public BigDecimal getShortRate()
  {
    return this.shortRate;
  }

  public void setShortRate(BigDecimal shortRate)
  {
    this.shortRate = shortRate;
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

  @Column(name="DAYUNIT")
  public String getDayUnit()
  {
    return this.dayUnit;
  }

  public void setDayUnit(String dayUnit)
  {
    this.dayUnit = dayUnit;
  }

  @Column(name="PERUNIT")
  public String getPerUnit()
  {
    return this.perUnit;
  }

  public void setPerUnit(String perUnit)
  {
    this.perUnit = perUnit;
  }

  @Column(name="SCHEME")
  public String getScheme()
  {
    return this.scheme;
  }

  public void setScheme(String scheme)
  {
    this.scheme = scheme;
  }

  @Column(name="VERSION")
  public String getVersion()
  {
    return this.version;
  }

  public void setVersion(String version)
  {
    this.version = version;
  }

  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="proKind")
  public List<ProItemKind> getProItemKinds()
  {
    return this.proItemKinds;
  }

  public void setProItemKinds(List<ProItemKind> proItemKinds)
  {
    this.proItemKinds = proItemKinds;
  }
  @Transient
  public String getPackNo() {
    return this.packNo;
  }

  public void setPackNo(String packNo) {
    this.packNo = packNo;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProKind
 * JD-Core Version:    0.6.0
 */