package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="GE_PRO_RISK")
public class ProRisk
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private ProRiskId id;
  private ProOrder proOrder;
  private String classCode;
  private Date startDate;
  private Date endDate;
  private String currency;
  private BigDecimal sumAmount;
  private BigDecimal sumBasePremium;
  private BigDecimal discount;
  private BigDecimal sumDiscount;
  private BigDecimal sumPremium;
  private BigDecimal sumSubPremium;

  @EmbeddedId
  @AttributeOverrides({@javax.persistence.AttributeOverride(name="orderNo", column=@Column(name="ORDERNO")), @javax.persistence.AttributeOverride(name="riskCode", column=@Column(name="RISKCODE"))})
  public ProRiskId getId()
  {
    return this.id;
  }

  public void setId(ProRiskId id)
  {
    this.id = id;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="ORDERNO", nullable=false, insertable=false, updatable=false)
  public ProOrder getProOrder() {
    return this.proOrder;
  }

  public void setProOrder(ProOrder proOrder)
  {
    this.proOrder = proOrder;
  }

  @Column(name="CLASSCODE")
  public String getClassCode()
  {
    return this.classCode;
  }

  public void setClassCode(String classCode)
  {
    this.classCode = classCode;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="STARTDATE")
  public Date getStartDate()
  {
    return this.startDate;
  }

  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ENDDATE")
  public Date getEndDate()
  {
    return this.endDate;
  }

  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
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

  @Column(name="SUMAMOUNT")
  public BigDecimal getSumAmount()
  {
    return this.sumAmount;
  }

  public void setSumAmount(BigDecimal sumAmount)
  {
    this.sumAmount = sumAmount;
  }

  @Column(name="SUMBASEPREMIUM")
  public BigDecimal getSumBasePremium()
  {
    return this.sumBasePremium;
  }

  public void setSumBasePremium(BigDecimal sumBasePremium)
  {
    this.sumBasePremium = sumBasePremium;
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

  @Column(name="SUMDISCOUNT")
  public BigDecimal getSumDiscount()
  {
    return this.sumDiscount;
  }

  public void setSumDiscount(BigDecimal sumDiscount)
  {
    this.sumDiscount = sumDiscount;
  }

  @Column(name="SUMPREMIUM")
  public BigDecimal getSumPremium()
  {
    return this.sumPremium;
  }

  public void setSumPremium(BigDecimal sumPremium)
  {
    this.sumPremium = sumPremium;
  }

  @Column(name="SUMSUBPREMIUM")
  public BigDecimal getSumSubPremium()
  {
    return this.sumSubPremium;
  }

  public void setSumSubPremium(BigDecimal sumSubPremium)
  {
    this.sumSubPremium = sumSubPremium;
  }

  @Transient
  public List<ProKind> getProKinds()
  {
    List proKinds = new ArrayList(0);

    for (ProKind proKind : this.proOrder.getProKinds()) {
      if (this.id.getRiskCode().equals(proKind.getRiskCode())) {
        proKinds.add(proKind);
      }
    }

    return proKinds;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProRisk
 * JD-Core Version:    0.6.0
 */