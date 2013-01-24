package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GE_PRO_COMBO")
public class ProCombo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String serialNo;
  private ProOrder proOrder;
  private String comboCode;
  private String riskCode;
  private String packageNo;
  private String schema;
  private String value;
  private String dayUnit;
  private String perUnit;
  private String noDeductFlag;

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

  @Column(name="COMBOCODE")
  public String getComboCode()
  {
    return this.comboCode;
  }

  public void setComboCode(String comboCode)
  {
    this.comboCode = comboCode;
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

  @Column(name="PACKAGENO")
  public String getPackageNo()
  {
    return this.packageNo;
  }

  public void setPackageNo(String packageNo)
  {
    this.packageNo = packageNo;
  }

  @Column(name="SCHEMA")
  public String getSchema()
  {
    return this.schema;
  }

  public void setSchema(String schema)
  {
    this.schema = schema;
  }

  @Column(name="VALUE")
  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
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

  @Column(name="NODEDUCTFLAG")
  public String getNoDeductFlag()
  {
    return this.noDeductFlag;
  }

  public void setNoDeductFlag(String noDeductFlag)
  {
    this.noDeductFlag = noDeductFlag;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProCombo
 * JD-Core Version:    0.6.0
 */