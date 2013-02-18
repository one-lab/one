package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GE_BC_CITY")
public class BcCity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String cityCode;
  private BcProvince bcRrovince;
  private String cityName;
  private String comCode;
  private String postCode;
  private String isValidate;
  private String pinyin;
  private List<BcDistrict> bcDistricts = new ArrayList(0);

  @Id
  @Column(name="CITYCODE")
  public String getCityCode()
  {
    return this.cityCode;
  }

  public void setCityCode(String cityCode)
  {
    this.cityCode = cityCode;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="PROVINCECODE", nullable=false)
  public BcProvince getBcRrovince()
  {
    return this.bcRrovince;
  }

  public void setBcRrovince(BcProvince bcRrovince)
  {
    this.bcRrovince = bcRrovince;
  }

  @Column(name="CITYNAME")
  public String getCityName()
  {
    return this.cityName;
  }

  public void setCityName(String cityName)
  {
    this.cityName = cityName;
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

  @Column(name="POSTCODE")
  public String getPostCode()
  {
    return this.postCode;
  }

  public void setPostCode(String postCode)
  {
    this.postCode = postCode;
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

  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="bcCity")
  public List<BcDistrict> getBcDistricts()
  {
    return this.bcDistricts;
  }

  public void setBcDistricts(List<BcDistrict> bcDistricts)
  {
    this.bcDistricts = bcDistricts;
  }
}

/* Location:           D:\M2\repository_platform\com\sinosoft\ebusiness\basic\0.1.0-SNAPSHOT\basic-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.basic.model.BcCity
 * JD-Core Version:    0.6.0
 */