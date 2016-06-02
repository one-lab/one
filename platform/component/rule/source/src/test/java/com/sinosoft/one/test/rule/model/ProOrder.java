package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



public class ProOrder
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String orderNo;
  private String productCode;
  private String businessNature;
  private String areaCode;
  private String comboCode;
  private String channelCode;
  private String renewalFlag;
  private String oldlPolicyNo;
  private String currency;
  private BigDecimal sumDiscount;
  private BigDecimal sumPremium;
  private BigDecimal sumBasePremium;
  private Date inputDate;
  private String inputHour;
  private Date invalidDate;
  private String custService;
  private String status;
  private String printType;
  private String flow;
  private String flag;
  private List<ProInsured> proInsureds = new ArrayList(0);

  private List<ProKind> proKinds = new ArrayList(0);

  private List<ProRisk> proRisks = new ArrayList(0);

  private List<ProItemHouse> proItemHouses = new ArrayList(0);

  private List<ProCombo> proCombos = new ArrayList(0);
  private ProCommFactor proCommFactor;
  private ProVehicletax proVehicletax;
  private ProForceFactor proForceFactor;
  private ProDelivery proDelivery;
  private ProVehicle proVehicle;
  private ProContact proContact;

  public String getOrderNo()
  {
    return this.orderNo;
  }

  public void setOrderNo(String orderNo)
  {
    this.orderNo = orderNo;
  }

  public String getProductCode()
  {
    return this.productCode;
  }

  public void setProductCode(String productCode)
  {
    this.productCode = productCode;
  }

  public String getBusinessNature()
  {
    return this.businessNature;
  }

  public void setBusinessNature(String businessNature)
  {
    this.businessNature = businessNature;
  }

  public String getAreaCode()
  {
    return this.areaCode;
  }

  public void setAreaCode(String areaCode)
  {
    this.areaCode = areaCode;
  }

  public String getComboCode()
  {
    return this.comboCode;
  }

  public void setComboCode(String comboCode)
  {
    this.comboCode = comboCode;
  }

  public String getChannelCode()
  {
    return this.channelCode;
  }

  public void setChannelCode(String channelCode)
  {
    this.channelCode = channelCode;
  }

  public String getRenewalFlag()
  {
    return this.renewalFlag;
  }

  public void setRenewalFlag(String renewalFlag)
  {
    this.renewalFlag = renewalFlag;
  }

  public String getOldlPolicyNo()
  {
    return this.oldlPolicyNo;
  }

  public void setOldlPolicyNo(String oldlPolicyNo)
  {
    this.oldlPolicyNo = oldlPolicyNo;
  }

  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String currency)
  {
    this.currency = currency;
  }

  public BigDecimal getSumDiscount()
  {
    return this.sumDiscount;
  }

  public void setSumDiscount(BigDecimal sumDiscount)
  {
    this.sumDiscount = sumDiscount;
  }

  public BigDecimal getSumPremium()
  {
    return this.sumPremium;
  }

  public void setSumPremium(BigDecimal sumPremium)
  {
    this.sumPremium = sumPremium;
  }

  public BigDecimal getSumBasePremium()
  {
    return this.sumBasePremium;
  }

  public void setSumBasePremium(BigDecimal sumBasePremium)
  {
    this.sumBasePremium = sumBasePremium;
  }

  public Date getInputDate()
  {
    return this.inputDate;
  }

  public void setInputDate(Date inputDate)
  {
    this.inputDate = inputDate;
  }

  public String getInputHour()
  {
    return this.inputHour;
  }

  public void setInputHour(String inputHour)
  {
    this.inputHour = inputHour;
  }

  public Date getInvalidDate()
  {
    return this.invalidDate;
  }

  public void setInvalidDate(Date invalidDate)
  {
    this.invalidDate = invalidDate;
  }

  public String getCustService()
  {
    return this.custService;
  }

  public void setCustService(String custService)
  {
    this.custService = custService;
  }

  public String getStatus()
  {
    return this.status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public String getPrintType()
  {
    return this.printType;
  }

  public void setPrintType(String printType)
  {
    this.printType = printType;
  }

  public String getFlow()
  {
    return this.flow;
  }

  public void setFlow(String flow)
  {
    this.flow = flow;
  }

  public String getFlag()
  {
    return this.flag;
  }

  public void setFlag(String flag)
  {
    this.flag = flag;
  }

  public List<ProInsured> getProInsureds()
  {
    return this.proInsureds;
  }

  public void setProInsureds(List<ProInsured> proInsureds)
  {
    this.proInsureds = proInsureds;
  }

  public List<ProKind> getProKinds()
  {
    return this.proKinds;
  }

  public void setProKinds(List<ProKind> proKinds)
  {
    this.proKinds = proKinds;
  }

  public List<ProRisk> getProRisks()
  {
    return this.proRisks;
  }

  public void setProRisks(List<ProRisk> proRisks)
  {
    this.proRisks = proRisks;
  }

  public List<ProItemHouse> getProItemHouses()
  {
    return this.proItemHouses;
  }

  public void setProItemHouses(List<ProItemHouse> proItemHouses)
  {
    this.proItemHouses = proItemHouses;
  }

  public ProDelivery getProDelivery()
  {
    return this.proDelivery;
  }

  public void setProDelivery(ProDelivery proDelivery)
  {
    this.proDelivery = proDelivery;
  }

  public List<ProCombo> getProCombos()
  {
    return this.proCombos;
  }

  public void setProCombos(List<ProCombo> proCombos)
  {
    this.proCombos = proCombos;
  }

  public ProVehicle getProVehicle()
  {
    return this.proVehicle;
  }

  public ProCommFactor getProCommFactor()
  {
    return this.proCommFactor;
  }

  public void setProCommFactor(ProCommFactor proCommFactor)
  {
    this.proCommFactor = proCommFactor;
  }

  public ProVehicletax getProVehicletax()
  {
    return this.proVehicletax;
  }

  public void setProVehicletax(ProVehicletax proVehicletax)
  {
    this.proVehicletax = proVehicletax;
  }

  public ProForceFactor getProForceFactor()
  {
    return this.proForceFactor;
  }

  public void setProForceFactor(ProForceFactor proForceFactor)
  {
    this.proForceFactor = proForceFactor;
  }

  public void setProVehicle(ProVehicle proVehicle)
  {
    this.proVehicle = proVehicle;
  }

  public ProContact getProContact()
  {
    return this.proContact;
  }

  public void setProContact(ProContact proContact)
  {
    this.proContact = proContact;
  }

  public ProInsured getProAppliMan()
  {
    for (Iterator iterator = this.proInsureds.iterator(); iterator.hasNext(); ) {
      ProInsured proInsured = (ProInsured)iterator.next();
      if ("01".equals(proInsured.getInsuredType()))
        return proInsured;
    }
    return null;
  }

  public List<ProInsured> getProInsureMan()
  {
    List proInsureMans = new ArrayList(0);
    for (Iterator iterator = this.proInsureds.iterator(); iterator.hasNext(); ) {
      ProInsured proInsured = (ProInsured)iterator.next();
      if ("02".equals(proInsured.getInsuredType()))
        proInsureMans.add(proInsured);
    }
    return proInsureMans;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProOrder
 * JD-Core Version:    0.6.0
 */