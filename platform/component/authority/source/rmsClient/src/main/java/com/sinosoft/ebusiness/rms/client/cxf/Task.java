
package com.sinosoft.ebusiness.rms.client.cxf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for task complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="task">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="children" type="{http://facade.webService.service.rms.ebusiness.sinosoft.com/}task" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="des" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isValidate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="menuName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="menuURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sysFalg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "task", propOrder = {
    "children",
    "des",
    "flag",
    "isValidate",
    "menuName",
    "menuURL",
    "name",
    "sysFalg",
    "taskID"
})
public class Task {

    @XmlElement(nillable = true)
    protected List<Task> children;
    protected String des;
    protected String flag;
    protected String isValidate;
    protected String menuName;
    protected String menuURL;
    protected String name;
    protected String sysFalg;
    protected String taskID;

    /**
     * Gets the value of the children property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the children property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildren().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Task }
     * 
     * 
     */
    public List<Task> getChildren() {
        if (children == null) {
            children = new ArrayList<Task>();
        }
        return this.children;
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
     * Gets the value of the menuName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Sets the value of the menuName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenuName(String value) {
        this.menuName = value;
    }

    /**
     * Gets the value of the menuURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenuURL() {
        return menuURL;
    }

    /**
     * Sets the value of the menuURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenuURL(String value) {
        this.menuURL = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the sysFalg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysFalg() {
        return sysFalg;
    }

    /**
     * Sets the value of the sysFalg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysFalg(String value) {
        this.sysFalg = value;
    }

    /**
     * Gets the value of the taskID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskID() {
        return taskID;
    }

    /**
     * Sets the value of the taskID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskID(String value) {
        this.taskID = value;
    }

}
