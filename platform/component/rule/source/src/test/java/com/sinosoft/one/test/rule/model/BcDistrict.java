package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GE_BC_DISTRICT")
public class BcDistrict
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String districtCode;
  private BcCity bcCity;
  private String districtname;
  private String comCode;
  private String isValidate;
  private String pinyin;

  @Id
  @Column(name="DISTRICTCODE")
  public String getDistrictCode()
  {
    return this.districtCode;
  }

  public void setDistrictCode(String districtCode)
  {
    this.districtCode = districtCode;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="CITYCODE", nullable=false)
  public BcCity getBcCity()
  {
    return this.bcCity;
  }

  public void setBcCity(BcCity bcCity)
  {
    this.bcCity = bcCity;
  }

  @Column(name="DISTRICTNAME")
  public String getDistrictname()
  {
    return this.districtname;
  }

  public void setDistrictname(String districtname)
  {
    this.districtname = districtname;
  }

  @Column(name="COMCODE")
  public String getComCode()
  {
    return this.comCode;
  }

  public void setComCode(String comCode)
  {
    this.comCode = comCode;
  }

  @Column(name="ISVALIDATE")
  public String getIsValidate()
  {
    return this.isValidate;
  }

  public void setIsValidate(String isValidate)
  {
    this.isValidate = isValidate;
  }

  @Column(name="PINYIN")
  public String getPinyin()
  {
    return this.pinyin;
  }

  public void setPinyin(String pinyin)
  {
    this.pinyin = pinyin;
  }
}

/* Location:           D:\M2\repository_platform\com\sinosoft\ebusiness\basic\0.1.0-SNAPSHOT\basic-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.basic.model.BcDistrict
 * JD-Core Version:    0.6.0
 */