
package com.sinosoft.one.rms.client.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busDataInfos" type="{http://facade.rms.one.sinosoft.com/}busDataInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataRuleID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="des" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isValidate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataRule", propOrder = {
    "busDataInfos",
    "dataRuleID",
    "des",
    "isValidate",
    "rule"
})
public class DataRule {

    @XmlElement(nillable = true)
    protected List<BusDataInfo> busDataInfos;
    protected String dataRuleID;
    protected String des;
    protected String isValidate;
    protected String rule;

    /**
     * Gets the value of the busDataInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the busDataInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusDataInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusDataInfo }
     * 
     * 
     */
    public List<BusDataInfo> getBusDataInfos() {
        if (busDataInfos == null) {
            busDataInfos = new ArrayList<BusDataInfo>();
        }
        return this.busDataInfos;
    }

    /**
     * Gets the value of the dataRuleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRuleID() {
        return dataRuleID;
    }

    /**
     * Sets the value of the dataRuleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRuleID(String value) {
        this.dataRuleID = value;
    }

    /**
     * Gets the value of the des property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDes() {
        return des;
    }

    /**
     * Sets the value of the des property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDes(String value) {
        this.des = value;
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
     * Gets the value of the rule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRule() {
        return rule;
    }

    /**
     * Sets the value of the rule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRule(String value) {
        this.rule = value;
    }

}
