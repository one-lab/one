
package com.sinosoft.one.rms.client.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for busDataInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="busDataInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busDataColumn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="busDataInfoID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="busDataTable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "busDataInfo", propOrder = {
    "busDataColumn",
    "busDataInfoID",
    "busDataTable"
})
public class BusDataInfo {

    protected String busDataColumn;
    protected String busDataInfoID;
    protected String busDataTable;

    /**
     * Gets the value of the busDataColumn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusDataColumn() {
        return busDataColumn;
    }

    /**
     * Sets the value of the busDataColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusDataColumn(String value) {
        this.busDataColumn = value;
    }

    /**
     * Gets the value of the busDataInfoID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusDataInfoID() {
        return busDataInfoID;
    }

    /**
     * Sets the value of the busDataInfoID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusDataInfoID(String value) {
        this.busDataInfoID = value;
    }

    /**
     * Gets the value of the busDataTable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusDataTable() {
        return busDataTable;
    }

    /**
     * Sets the value of the busDataTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusDataTable(String value) {
        this.busDataTable = value;
    }

}
