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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GE_PRO_COMMFACTOR")
public class ProCommFactor
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String orderNo;
  private ProOrder proOrder;
  private String querySequenceNo;
  private Date queryDate;
  private Date queryPastDate;
  private BigDecimal claimAdjustValue;
  private BigDecimal loyaltyAdjustValue;
  private BigDecimal kindAdjustValue;
  private BigDecimal specifiedFactoryValue;
  private BigDecimal mileageAdjustValue;
  private BigDecimal travelAdjustValue;
  private BigDecimal lossAdjustValue;
  private BigDecimal theftAdjustValue;
  private BigDecimal safeDriveValue;

  @GenericGenerator(name="generator", strategy="foreign", parameters={@org.hibernate.annotations.Parameter(name="property", value="proOrder")})
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

  @Column(name="QUERYSEQUENCENO")
  public String getQuerySequenceNo()
  {
    return this.querySequenceNo;
  }

  public void setQuerySequenceNo(String querySequenceNo)
  {
    this.querySequenceNo = querySequenceNo;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="QUERYDATE")
  public Date getQueryDate()
  {
    return this.queryDate;
  }

  public void setQueryDate(Date queryDate)
  {
    this.queryDate = queryDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="QUERYPASTDATE")
  public Date getQueryPastDate()
  {
    return this.queryPastDate;
  }

  public void setQueryPastDate(Date queryPastDate)
  {
    this.queryPastDate = queryPastDate;
  }

  @Column(name="CLAIMADJUSTVALUE")
  public BigDecimal getClaimAdjustValue()
  {
    return this.claimAdjustValue;
  }

  public void setClaimAdjustValue(BigDecimal claimAdjustValue)
  {
    this.claimAdjustValue = claimAdjustValue;
  }

  @Column(name="LOYALTYADJUSTVALUE")
  public BigDecimal getLoyaltyAdjustValue()
  {
    return this.loyaltyAdjustValue;
  }

  public void setLoyaltyAdjustValue(BigDecimal loyaltyAdjustValue)
  {
    this.loyaltyAdjustValue = loyaltyAdjustValue;
  }

  @Column(name="KINDADJUSTVALUE")
  public BigDecimal getKindAdjustValue()
  {
    return this.kindAdjustValue;
  }

  public void setKindAdjustValue(BigDecimal kindAdjustValue)
  {
    this.kindAdjustValue = kindAdjustValue;
  }

  @Column(name="SPECIFIEDFACTORYVALUE")
  public BigDecimal getSpecifiedFactoryValue()
  {
    return this.specifiedFactoryValue;
  }

  public void setSpecifiedFactoryValue(BigDecimal specifiedFactoryValue)
  {
    this.specifiedFactoryValue = specifiedFactoryValue;
  }

  @Column(name="MILEAGEADJUSTVALUE")
  public BigDecimal getMileageAdjustValue()
  {
    return this.mileageAdjustValue;
  }

  public void setMileageAdjustValue(BigDecimal mileageAdjustValue)
  {
    this.mileageAdjustValue = mileageAdjustValue;
  }

  @Column(name="TRAVELADJUSTVALUE")
  public BigDecimal getTravelAdjustValue()
  {
    return this.travelAdjustValue;
  }

  public void setTravelAdjustValue(BigDecimal travelAdjustValue)
  {
    this.travelAdjustValue = travelAdjustValue;
  }

  @Column(name="LOSSADJUSTVALUE")
  public BigDecimal getLossAdjustValue()
  {
    return this.lossAdjustValue;
  }

  public void setLossAdjustValue(BigDecimal lossAdjustValue)
  {
    this.lossAdjustValue = lossAdjustValue;
  }

  @Column(name="THEFTADJUSTVALUE")
  public BigDecimal getTheftAdjustValue()
  {
    return this.theftAdjustValue;
  }

  public void setTheftAdjustValue(BigDecimal theftAdjustValue)
  {
    this.theftAdjustValue = theftAdjustValue;
  }

  @Column(name="SAFEDRIVEVALUE")
  public BigDecimal getSafeDriveValue()
  {
    return this.safeDriveValue;
  }

  public void setSafeDriveValue(BigDecimal safeDriveValue)
  {
    this.safeDriveValue = safeDriveValue;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProCommFactor
 * JD-Core Version:    0.6.0
 */