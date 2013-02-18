package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GE_BC_PROVINCE")
public class BcProvince
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String provinceCode;
  private String provinceName;
  private String isValidate;
  private String pinyin;
  private List<BcCity> bcCities = new ArrayList(0);

  @Id
  @Column(name="PROVINCECODE")
  public String getProvinceCode()
  {
    return this.provinceCode;
  }

  public void setProvinceCode(String provinceCode)
  {
    this.provinceCode = provinceCode;
  }

  @Column(name="PROVINCENAME")
  public String getProvinceName()
  {
    return this.provinceName;
  }

  public void setProvinceName(String provinceName)
  {
    this.provinceName = provinceName;
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

  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="bcRrovince")
  public List<BcCity> getBcCities()
  {
    return this.bcCities;
  }

  public void setBcCities(List<BcCity> bcCities)
  {
    this.bcCities = bcCities;
  }
}

/* Location:           D:\M2\repository_platform\com\sinosoft\ebusiness\basic\0.1.0-SNAPSHOT\basic-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.basic.model.BcProvince
 * JD-Core Version:    0.6.0
 */