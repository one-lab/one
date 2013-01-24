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
@Table(name="GE_PRO_VEHICLE")
public class ProVehicle
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String orderNo;
  private ProOrder proOrder;
  private String vehicleOwnerName;
  private String identifyType;
  private String identifyNumber;
  private String modelName;
  private String modelCode;
  private String vehicleKind;
  private String vehicleAttribute;
  private String vehicleType;
  private String licensePlateType;
  private String isNewVehicle;
  private String licensePlateNo;
  private String vin;
  private String engineNo;
  private String useNatureCode;
  private Date firstRegisterDate;
  private String licenseColorCode;
  private String colorCode;
  private BigDecimal tonnage;
  private Short seatCount;
  private BigDecimal wholeWeight;
  private Long displacementa;
  private String runMiles;
  private String glassType;
  private String pmQueryNo;
  private String power;
  private String modifyFlag;
  private String powerType;
  private String vehicleAgeLevel;
  private Byte lastYearReparationCount;
  private BigDecimal replacementValue;
  private BigDecimal actualvalue;

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

  @Column(name="VEHICLEOWNERNAME")
  public String getVehicleOwnerName()
  {
    return this.vehicleOwnerName;
  }

  public void setVehicleOwnerName(String vehicleOwnerName)
  {
    this.vehicleOwnerName = vehicleOwnerName;
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

  @Column(name="MODELNAME")
  public String getModelName()
  {
    return this.modelName;
  }

  public void setModelName(String modelName)
  {
    this.modelName = modelName;
  }

  @Column(name="MODELCODE")
  public String getModelCode()
  {
    return this.modelCode;
  }

  public void setModelCode(String modelCode)
  {
    this.modelCode = modelCode;
  }

  @Column(name="VEHICLEKIND")
  public String getVehicleKind()
  {
    return this.vehicleKind;
  }

  public void setVehicleKind(String vehicleKind)
  {
    this.vehicleKind = vehicleKind;
  }

  @Column(name="VEHICLEATTRIBUTE")
  public String getVehicleAttribute()
  {
    return this.vehicleAttribute;
  }

  public void setVehicleAttribute(String vehicleAttribute)
  {
    this.vehicleAttribute = vehicleAttribute;
  }

  @Column(name="VEHICLETYPE")
  public String getVehicleType()
  {
    return this.vehicleType;
  }

  public void setVehicleType(String vehicleType)
  {
    this.vehicleType = vehicleType;
  }

  @Column(name="LICENSEPLATETYPE")
  public String getLicensePlateType()
  {
    return this.licensePlateType;
  }

  public void setLicensePlateType(String licensePlateType)
  {
    this.licensePlateType = licensePlateType;
  }

  @Column(name="ISNEWVEHICLE")
  public String getIsNewVehicle()
  {
    return this.isNewVehicle;
  }

  public void setIsNewVehicle(String isNewVehicle)
  {
    this.isNewVehicle = isNewVehicle;
  }

  @Column(name="LICENSEPLATENO")
  public String getLicensePlateNo()
  {
    return this.licensePlateNo;
  }

  public void setLicensePlateNo(String licensePlateNo)
  {
    this.licensePlateNo = licensePlateNo;
  }

  @Column(name="VIN")
  public String getVin()
  {
    return this.vin;
  }

  public void setVin(String vin)
  {
    this.vin = vin;
  }

  @Column(name="ENGINENO")
  public String getEngineNo()
  {
    return this.engineNo;
  }

  public void setEngineNo(String engineNo)
  {
    this.engineNo = engineNo;
  }

  @Column(name="USENATURECODE")
  public String getUseNatureCode()
  {
    return this.useNatureCode;
  }

  public void setUseNatureCode(String useNatureCode)
  {
    this.useNatureCode = useNatureCode;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="FIRSTREGISTERDATE")
  public Date getFirstRegisterDate()
  {
    return this.firstRegisterDate;
  }

  public void setFirstRegisterDate(Date firstRegisterDate)
  {
    this.firstRegisterDate = firstRegisterDate;
  }

  @Column(name="LICENSECOLORCODE")
  public String getLicenseColorCode()
  {
    return this.licenseColorCode;
  }

  public void setLicenseColorCode(String licenseColorCode)
  {
    this.licenseColorCode = licenseColorCode;
  }

  @Column(name="COLORCODE")
  public String getColorCode()
  {
    return this.colorCode;
  }

  public void setColorCode(String colorCode)
  {
    this.colorCode = colorCode;
  }

  @Column(name="TONNAGE")
  public BigDecimal getTonnage()
  {
    return this.tonnage;
  }

  public void setTonnage(BigDecimal tonnage)
  {
    this.tonnage = tonnage;
  }

  @Column(name="SEATCOUNT")
  public Short getSeatCount()
  {
    return this.seatCount;
  }

  public void setSeatCount(Short seatCount)
  {
    this.seatCount = seatCount;
  }

  @Column(name="WHOLEWEIGHT")
  public BigDecimal getWholeWeight()
  {
    return this.wholeWeight;
  }

  public void setWholeWeight(BigDecimal wholeWeight)
  {
    this.wholeWeight = wholeWeight;
  }

  @Column(name="DISPLACEMENTA")
  public Long getDisplacementa()
  {
    return this.displacementa;
  }

  public void setDisplacementa(Long displacementa)
  {
    this.displacementa = displacementa;
  }

  @Column(name="RUNMILES")
  public String getRunMiles()
  {
    return this.runMiles;
  }

  public void setRunMiles(String runMiles)
  {
    this.runMiles = runMiles;
  }

  @Column(name="GLASSTYPE")
  public String getGlassType()
  {
    return this.glassType;
  }

  public void setGlassType(String glassType)
  {
    this.glassType = glassType;
  }

  @Column(name="PMQUERYNO")
  public String getPmQueryNo()
  {
    return this.pmQueryNo;
  }

  public void setPmQueryNo(String pmQueryNo)
  {
    this.pmQueryNo = pmQueryNo;
  }

  @Column(name="POWER")
  public String getPower()
  {
    return this.power;
  }

  public void setPower(String power)
  {
    this.power = power;
  }

  @Column(name="MODIFYFLAG")
  public String getModifyFlag()
  {
    return this.modifyFlag;
  }

  public void setModifyFlag(String modifyFlag)
  {
    this.modifyFlag = modifyFlag;
  }

  @Column(name="POWERTYPE")
  public String getPowerType()
  {
    return this.powerType;
  }

  public void setPowerType(String powerType)
  {
    this.powerType = powerType;
  }

  @Column(name="VEHICLEAGELEVEL")
  public String getVehicleAgeLevel()
  {
    return this.vehicleAgeLevel;
  }

  public void setVehicleAgeLevel(String vehicleAgeLevel)
  {
    this.vehicleAgeLevel = vehicleAgeLevel;
  }

  @Column(name="LASTYEARREPARATIONCOUNT")
  public Byte getLastYearReparationCount()
  {
    return this.lastYearReparationCount;
  }

  public void setLastYearReparationCount(Byte lastYearReparationCount)
  {
    this.lastYearReparationCount = lastYearReparationCount;
  }

  @Column(name="REPLACEMENTVALUE")
  public BigDecimal getReplacementValue()
  {
    return this.replacementValue;
  }

  public void setReplacementValue(BigDecimal replacementValue)
  {
    this.replacementValue = replacementValue;
  }

  @Column(name="ACTUALVALUE")
  public BigDecimal getActualvalue()
  {
    return this.actualvalue;
  }

  public void setActualvalue(BigDecimal actualvalue)
  {
    this.actualvalue = actualvalue;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProVehicle
 * JD-Core Version:    0.6.0
 */