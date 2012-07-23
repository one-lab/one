
package com.sinosoft.ebusiness.rms.client.cxf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for webServiceDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="webServiceDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busPowers" type="{http://facade.webService.service.rms.ebusiness.sinosoft.com/}busPower" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="employe" type="{http://facade.webService.service.rms.ebusiness.sinosoft.com/}employe" minOccurs="0"/>
 *         &lt;element name="loginComCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serverMassege" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tasks" type="{http://facade.webService.service.rms.ebusiness.sinosoft.com/}task" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "webServiceDTO", propOrder = {
    "busPowers",
    "employe",
    "loginComCode",
    "serverMassege",
    "tasks"
})
public class WebServiceDTO {

    @XmlElement(nillable = true)
    protected List<BusPower> busPowers;
    protected Employe employe;
    protected String loginComCode;
    protected String serverMassege;
    @XmlElement(nillable = true)
    protected List<Task> tasks;

    /**
     * Gets the value of the busPowers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the busPowers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusPowers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusPower }
     * 
     * 
     */
    public List<BusPower> getBusPowers() {
        if (busPowers == null) {
            busPowers = new ArrayList<BusPower>();
        }
        return this.busPowers;
    }

    /**
     * Gets the value of the employe property.
     * 
     * @return
     *     possible object is
     *     {@link Employe }
     *     
     */
    public Employe getEmploye() {
        return employe;
    }

    /**
     * Sets the value of the employe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Employe }
     *     
     */
    public void setEmploye(Employe value) {
        this.employe = value;
    }

    /**
     * Gets the value of the loginComCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginComCode() {
        return loginComCode;
    }

    /**
     * Sets the value of the loginComCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginComCode(String value) {
        this.loginComCode = value;
    }

    /**
     * Gets the value of the serverMassege property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerMassege() {
        return serverMassege;
    }

    /**
     * Sets the value of the serverMassege property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerMassege(String value) {
        this.serverMassege = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tasks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTasks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Task }
     * 
     * 
     */
    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<Task>();
        }
        return this.tasks;
    }

}
