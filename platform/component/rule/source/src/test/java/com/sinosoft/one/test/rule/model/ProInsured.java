package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GE_PRO_INSURED")
public class ProInsured
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String serialNo;
  private ProOrder proOrder;
  private String insuredType;
  private String name;
  private String gender;
  private Date birthday;
  private String identifyType;
  private String identifyNumber;
  private String drivingLicenseType;
  private String province;
  private String city;
  private String district;
  private String zipCode;
  private String companyPhone;
  private String homePhone;
  private String mobile;
  private String email;
  private BcProvince addrProvince;
  private BcCity addrCity;
  private BcDistrict addrDistrict;
  private String address;
  private String occupation;
  private String occupationType;
  private String insRelationApp;
  private String insFlag;
  private String remark;
  private String flag;
  private String scheme;
  private int orderIndex;

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

  @Column(name="INSUREDTYPE")
  public String getInsuredType()
  {
    return this.insuredType;
  }

  public void setInsuredType(String insuredType)
  {
    this.insuredType = insuredType;
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

  @Column(name="IDENTIFYTYPE")
  public String getIdentifyType()
  {
    return this.identifyType;
  }

  public void setIdentifyType(String identifyType)
  {
    this.identifyType = identifyType;
  }

  @Column(name="IDENTIFYNUMBER")
  public String getIdentifyNumber()
  {
    return this.identifyNumber;
  }

  public void setIdentifyNumber(String identifyNumber)
  {
    this.identifyNumber = identifyNumber;
  }

  @Column(name="DRIVINGLICENSETYPE")
  public String getDrivingLicenseType()
  {
    return this.drivingLicenseType;
  }

  public void setDrivingLicenseType(String drivingLicenseType)
  {
    this.drivingLicenseType = drivingLicenseType;
  }

  @Column(name="PROVINCE")
  public String getProvince()
  {
    return this.province;
  }

  public void setProvince(String province)
  {
    this.province = province;
  }

  @Column(name="CITY")
  public String getCity()
  {
    return this.city;
  }

  public void setCity(String city)
  {
    this.city = city;
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

  @Column(name="COMPANYPHONE")
  public String getCompanyPhone()
  {
    return this.companyPhone;
  }

  public void setCompanyPhone(String companyPhone)
  {
    this.companyPhone = companyPhone;
  }

  @Column(name="HOMEPHONE")
  public String getHomePhone()
  {
    return this.homePhone;
  }

  public void setHomePhone(String homePhone)
  {
    this.homePhone = homePhone;
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

  @Column(name="ADDRESS")
  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  @Column(name="OCCUPATION")
  public String getOccupation()
  {
    return this.occupation;
  }

  public void setOccupation(String occupation)
  {
    this.occupation = occupation;
  }

  @Column(name="OCCUPATIONTYPE")
  public String getOccupationType()
  {
    return this.occupationType;
  }

  public void setOccupationType(String occupationType)
  {
    this.occupationType = occupationType;
  }

  @Column(name="INSRELATIONAPP")
  public String getInsRelationApp()
  {
    return this.insRelationApp;
  }

  public void setInsRelationApp(String insRelationApp)
  {
    this.insRelationApp = insRelationApp;
  }

  @Column(name="INSFLAG")
  public String getInsFlag()
  {
    return this.insFlag;
  }

  public void setInsFlag(String insFlag)
  {
    this.insFlag = insFlag;
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

  @Column(name="FLAG")
  public String getFlag()
  {
    return this.flag;
  }

  public void setFlag(String flag)
  {
    this.flag = flag;
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

  @Column(name="DISTRICT")
  public String getDistrict()
  {
    return this.district;
  }

  public void setDistrict(String district)
  {
    this.district = district;
  }

  @ManyToOne
  @JoinColumn(name="ADDRPROVINCE")
  @JsonIgnore
  public BcProvince getAddrProvince()
  {
    return this.addrProvince;
  }

  public void setAddrProvince(BcProvince addrProvince)
  {
    this.addrProvince = addrProvince;
  }

  @ManyToOne
  @JoinColumn(name="ADDRCITY")
  @JsonIgnore
  public BcCity getAddrCity() {
    return this.addrCity;
  }

  public void setAddrCity(BcCity addrCity)
  {
    this.addrCity = addrCity;
  }

  @ManyToOne
  @JoinColumn(name="ADDRDISTRICT")
  @JsonIgnore
  public BcDistrict getAddrDistrict() {
    return this.addrDistrict;
  }

  public void setAddrDistrict(BcDistrict addrDistrict)
  {
    this.addrDistrict = addrDistrict;
  }
  @Column(name="ORDERINDEX")
  public int getOrderIndex() {
    return this.orderIndex;
  }

  public void setOrderIndex(int orderIndex) {
    this.orderIndex = orderIndex;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProInsured
 * JD-Core Version:    0.6.0
 */