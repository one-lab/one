
package com.sinosoft.ebusiness.rms.client.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for busPower complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="busPower">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busPowerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataRule" type="{http://facade.webService.service.rms.ebusiness.sinosoft.com/}dataRule" minOccurs="0"/>
 *         &lt;element name="dataRuleParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isValidate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="task" type="{http://facade.webService.service.rms.ebusiness.sinosoft.com/}task" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "busPower", propOrder = {
    "busPowerID",
    "dataRule",
    "dataRuleParam",
    "isValidate",
    "task"
})
public class BusPower {

    protected String busPowerID;
    protected DataRule dataRule;
    protected String dataRuleParam;
    protected String isValidate;
    protected Task task;

    /**
     * Gets the value of the busPowerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusPowerID() {
        return busPowerID;
    }

    /**
     * Sets the value of the busPowerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusPowerID(String value) {
        this.busPowerID = value;
    }

    /**
     * Gets the value of the dataRule property.
     * 
     * @return
     *     possible object is
     *     {@link DataRule }
     *     
     */
    public DataRule getDataRule() {
        return dataRule;
    }

    /**
     * Sets the value of the dataRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRule }
     *     
     */
    public void setDataRule(DataRule value) {
        this.dataRule = value;
    }

    /**
     * Gets the value of the dataRuleParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRuleParam() {
        return dataRuleParam;
    }

    /**
     * Sets the value of the dataRuleParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRuleParam(String value) {
        this.dataRuleParam = value;
    }

    /**
     * Gets the value of the isValidate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsValidate() {
        return isValidate;
    }

    /**
     * Sets the value of the isValidate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsValidate(String value) {
        this.isValidate = value;
    }

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link Task }
     *     
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link Task }
     *     
     */
    public void setTask(Task value) {
        this.task = value;
    }

}
