package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProRiskId
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String orderNo;
  private String riskCode;

  @Column(name="ORDERNO")
  public String getOrderNo()
  {
    return this.orderNo;
  }

  public void setOrderNo(String orderNo)
  {
    this.orderNo = orderNo;
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

  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (!(other instanceof ProRiskId)) {
      return false;
    }
    ProRiskId castOther = (ProRiskId)other;

    return ((getOrderNo() == castOther.getOrderNo()) || ((getOrderNo() != null) && (castOther.getOrderNo() != null) && (getOrderNo().equals(castOther.getOrderNo())))) && ((getRiskCode() == castOther.getRiskCode()) || ((getRiskCode() != null) && (castOther.getRiskCode() != null) && (getRiskCode().equals(castOther.getRiskCode()))));
  }

  public int hashCode()
  {
    int result = 17;

    result = 37 * result + (getOrderNo() == null ? 0 : getOrderNo().hashCode());

    result = 37 * result + (getRiskCode() == null ? 0 : getRiskCode().hashCode());

    return result;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProRiskId
 * JD-Core Version:    0.6.0
 */