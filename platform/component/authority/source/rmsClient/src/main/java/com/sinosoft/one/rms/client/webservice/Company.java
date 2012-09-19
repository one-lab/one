
package com.sinosoft.one.rms.client.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for company complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="company">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acntUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressCName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressEName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="articleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comCName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comEName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="faxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insurerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isinSured" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="manager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newComCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upperComCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "company", propOrder = {
    "accountant",
    "acntUnit",
    "addressCName",
    "addressEName",
    "articleCode",
    "comCName",
    "comCode",
    "comEName",
    "comType",
    "faxNumber",
    "flag",
    "insurerName",
    "isinSured",
    "manager",
    "newComCode",
    "phoneNumber",
    "postCode",
    "remark",
    "upperComCode",
    "validStatus"
})
public class Company {

    protected String accountant;
    protected String acntUnit;
    protected String addressCName;
    protected String addressEName;
    protected String articleCode;
    protected String comCName;
    protected String comCode;
    protected String comEName;
    protected String comType;
    protected String faxNumber;
    protected String flag;
    protected String insurerName;
    protected String isinSured;
    protected String manager;
    protected String newComCode;
    protected String phoneNumber;
    protected String postCode;
    protected String remark;
    protected String upperComCode;
    protected String validStatus;

    /**
     * Gets the value of the accountant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountant() {
        return accountant;
    }

    /**
     * Sets the value of the accountant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountant(String value) {
        this.accountant = value;
    }

    /**
     * Gets the value of the acntUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcntUnit() {
        return acntUnit;
    }

    /**
     * Sets the value of the acntUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcntUnit(String value) {
        this.acntUnit = value;
    }

    /**
     * Gets the value of the addressCName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressCName() {
        return addressCName;
    }

    /**
     * Sets the value of the addressCName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressCName(String value) {
        this.addressCName = value;
    }

    /**
     * Gets the value of the addressEName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressEName() {
        return addressEName;
    }

    /**
     * Sets the value of the addressEName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressEName(String value) {
        this.addressEName = value;
    }

    /**
     * Gets the value of the articleCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleCode() {
        return articleCode;
    }

    /**
     * Sets the value of the articleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleCode(String value) {
        this.articleCode = value;
    }

    /**
     * Gets the value of the comCName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComCName() {
        return comCName;
    }

    /**
     * Sets the value of the comCName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComCName(String value) {
        this.comCName = value;
    }

    /**
     * Gets the value of the comCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComCode() {
        return comCode;
    }

    /**
     * Sets the value of the comCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComCode(String value) {
        this.comCode = value;
    }

    /**
     * Gets the value of the comEName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComEName() {
        return comEName;
    }

    /**
     * Sets the value of the comEName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComEName(String value) {
        this.comEName = value;
    }

    /**
     * Gets the value of the comType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComType() {
        return comType;
    }

    /**
     * Sets the value of the comType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComType(String value) {
        this.comType = value;
    }

    /**
     * Gets the value of the faxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the value of the faxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNumber(String value) {
        this.faxNumber = value;
    }

    /**
     * Gets the value of the flag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * Gets the value of the insurerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsurerName() {
        return insurerName;
    }

    /**
     * Sets the value of the insurerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsurerName(String value) {
        this.insurerName = value;
    }

    /**
     * Gets the value of the isinSured property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsinSured() {
        return isinSured;
    }

    /**
     * Sets the value of the isinSured property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsinSured(String value) {
        this.isinSured = value;
    }

    /**
     * Gets the value of the manager property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManager() {
        return manager;
    }

    /**
     * Sets the value of the manager property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManager(String value) {
        this.manager = value;
    }

    /**
     * Gets the value of the newComCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewComCode() {
        return newComCode;
    }

    /**
     * Sets the value of the newComCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewComCode(String value) {
        this.newComCode = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the upperComCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpperComCode() {
        return upperComCode;
    }

    /**
     * Sets the value of the upperComCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpperComCode(String value) {
        this.upperComCode = value;
    }

    /**
     * Gets the value of the validStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidStatus() {
        return validStatus;
    }

    /**
     * Sets the value of the validStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidStatus(String value) {
        this.validStatus = value;
    }

}
