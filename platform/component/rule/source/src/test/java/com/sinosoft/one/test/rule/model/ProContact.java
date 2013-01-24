package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
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
@Table(name="GE_PRO_CONTACT")
public class ProContact
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String orderNo;
  private ProOrder proOrder;
  private String name;
  private String gender;
  private Date birthday;
  private String addrProvince;
  private String addrCity;
  private String addrDistrict;
  private String address;
  private String zipCode;
  private String phone;
  private String mobile;
  private String email;
  private String flag;
  private String remark;

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

  @Column(name="NAME")
  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Column(name="GENDER")
  public String getGender()
  {
    return this.gender;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
  }

  @Temporal(TemporalType.DATE)
  @Column(name="BIRTHDAY")
  public Date getBirthday()
  {
    return this.birthday;
  }

  public void setBirthday(Date birthday)
  {
    this.birthday = birthday;
  }

  @Column(name="ADDRPROVINCE")
  public String getAddrProvince()
  {
    return this.addrProvince;
  }

  public void setAddrProvince(String addrProvince)
  {
    this.addrProvince = addrProvince;
  }

  @Column(name="ADDRCITY")
  public String getAddrCity()
  {
    return this.addrCity;
  }

  public void setAddrCity(String addrCity)
  {
    this.addrCity = addrCity;
  }

  @Column(name="ADDRDISTRICT")
  public String getAddrDistrict()
  {
    return this.addrDistrict;
  }

  public void setAddrDistrict(String addrDistrict)
  {
    this.addrDistrict = addrDistrict;
  }

  @Column(name="ADDRESS")
  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  @Column(name="ZIPCODE")
  public String getZipCode()
  {
    return this.zipCode;
  }

  public void setZipCode(String zipCode)
  {
    this.zipCode = zipCode;
  }

  @Column(name="PHONE")
  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  @Column(name="MOBILE")
  public String getMobile()
  {
    return this.mobile;
  }

  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }

  @Column(name="EMAIL")
  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email)
  {
    this.email = email;
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

  @Column(name="REMARK")
  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = remark;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProContact
 * JD-Core Version:    0.6.0
 */