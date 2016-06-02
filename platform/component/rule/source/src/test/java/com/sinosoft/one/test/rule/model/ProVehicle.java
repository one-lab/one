package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

  private boolean result;

    public String getOrderNo()
    {
        return this.orderNo;
    }
    private BigDecimal replacementValue;

  private BigDecimal actualvalue;

  public void setOrderNo(String orderNo)
  {
    this.orderNo = orderNo;
  }

  public ProOrder getProOrder()
  {
    return this.proOrder;
  }

  public void setProOrder(ProOrder proOrder)
  {
    this.proOrder = proOrder;
  }

  public String getVehicleOwnerName()
  {
    return this.vehicleOwnerName;
  }

  public void setVehicleOwnerName(String vehicleOwnerName)
  {
    this.vehicleOwnerName = vehicleOwnerName;
  }

  public String getIdentifyType()
  {
    return this.identifyType;
  }

  public void setIdentifyType(String identifyType)
  {
    this.identifyType = identifyType;
  }

  public String getIdentifyNumber()
  {
    return this.identifyNumber;
  }

  public void setIdentifyNumber(String identifyNumber)
  {
    this.identifyNumber = identifyNumber;
  }

  public String getModelName()
  {
    return this.modelName;
  }

  public void setModelName(String modelName)
  {
    this.modelName = modelName;
  }

  public String getModelCode()
  {
    return this.modelCode;
  }

  public void setModelCode(String modelCode)
  {
    this.modelCode = modelCode;
  }

  public String getVehicleKind()
  {
    return this.vehicleKind;
  }

  public void setVehicleKind(String vehicleKind)
  {
    this.vehicleKind = vehicleKind;
  }

  public String getVehicleAttribute()
  {
    return this.vehicleAttribute;
  }

  public void setVehicleAttribute(String vehicleAttribute)
  {
    this.vehicleAttribute = vehicleAttribute;
  }

  public String getVehicleType()
  {
    return this.vehicleType;
  }

  public void setVehicleType(String vehicleType)
  {
    this.vehicleType = vehicleType;
  }

  public String getLicensePlateType()
  {
    return this.licensePlateType;
  }

  public void setLicensePlateType(String licensePlateType)
  {
    this.licensePlateType = licensePlateType;
  }

  public String getIsNewVehicle()
  {
    return this.isNewVehicle;
  }

  public void setIsNewVehicle(String isNewVehicle)
  {
    this.isNewVehicle = isNewVehicle;
  }

  public String getLicensePlateNo()
  {
    return this.licensePlateNo;
  }

  public void setLicensePlateNo(String licensePlateNo)
  {
    this.licensePlateNo = licensePlateNo;
  }

  public String getVin()
  {
    return this.vin;
  }

  public void setVin(String vin)
  {
    this.vin = vin;
  }

  public String getEngineNo()
  {
    return this.engineNo;
  }

  public void setEngineNo(String engineNo)
  {
    this.engineNo = engineNo;
  }

  public String getUseNatureCode()
  {
    return this.useNatureCode;
  }

  public void setUseNatureCode(String useNatureCode)
  {
    this.useNatureCode = useNatureCode;
  }

  public Date getFirstRegisterDate()
  {
    return this.firstRegisterDate;
  }

  public void setFirstRegisterDate(Date firstRegisterDate)
  {
    this.firstRegisterDate = firstRegisterDate;
  }

  public String getLicenseColorCode()
  {
    return this.licenseColorCode;
  }

  public void setLicenseColorCode(String licenseColorCode)
  {
    this.licenseColorCode = licenseColorCode;
  }

  public String getColorCode()
  {
    return this.colorCode;
  }

  public void setColorCode(String colorCode)
  {
    this.colorCode = colorCode;
  }

  public BigDecimal getTonnage()
  {
    return this.tonnage;
  }

  public void setTonnage(BigDecimal tonnage)
  {
    this.tonnage = tonnage;
  }

  public Short getSeatCount()
  {
    return this.seatCount;
  }

  public void setSeatCount(Short seatCount)
  {
    this.seatCount = seatCount;
  }

  public BigDecimal getWholeWeight()
  {
    return this.wholeWeight;
  }

  public void setWholeWeight(BigDecimal wholeWeight)
  {
    this.wholeWeight = wholeWeight;
  }

  public Long getDisplacementa()
  {
    return this.displacementa;
  }

  public void setDisplacementa(Long displacementa)
  {
    this.displacementa = displacementa;
  }

  public String getRunMiles()
  {
    return this.runMiles;
  }

  public void setRunMiles(String runMiles)
  {
    this.runMiles = runMiles;
  }

  public String getGlassType()
  {
    return this.glassType;
  }

  public void setGlassType(String glassType)
  {
    this.glassType = glassType;
  }

  public String getPmQueryNo()
  {
    return this.pmQueryNo;
  }

  public void setPmQueryNo(String pmQueryNo)
  {
    this.pmQueryNo = pmQueryNo;
  }

  public String getPower()
  {
    return this.power;
  }

  public void setPower(String power)
  {
    this.power = power;
  }

  public String getModifyFlag()
  {
    return this.modifyFlag;
  }

  public void setModifyFlag(String modifyFlag)
  {
    this.modifyFlag = modifyFlag;
  }

  public String getPowerType()
  {
    return this.powerType;
  }

  public void setPowerType(String powerType)
  {
    this.powerType = powerType;
  }

  public String getVehicleAgeLevel()
  {
    return this.vehicleAgeLevel;
  }

  public void setVehicleAgeLevel(String vehicleAgeLevel)
  {
    this.vehicleAgeLevel = vehicleAgeLevel;
  }

  public Byte getLastYearReparationCount()
  {
    return this.lastYearReparationCount;
  }

  public void setLastYearReparationCount(Byte lastYearReparationCount)
  {
    this.lastYearReparationCount = lastYearReparationCount;
  }

  public BigDecimal getReplacementValue()
  {
    return this.replacementValue;
  }

  public void setReplacementValue(BigDecimal replacementValue)
  {
    this.replacementValue = replacementValue;
  }

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