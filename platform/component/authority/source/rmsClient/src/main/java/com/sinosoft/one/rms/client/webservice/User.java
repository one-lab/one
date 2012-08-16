
package com.sinosoft.one.rms.client.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for user complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="user">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataPowers" type="{http://facade.clientService.rms.one.sinosoft.com/}dataPower" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loginComCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginComName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="menuList" type="{http://facade.clientService.rms.one.sinosoft.com/}menu" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="passWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleIdList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taskIdList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "dataPowers",
    "loginComCode",
    "loginComName",
    "menuList",
    "passWord",
    "roleIdList",
    "taskIdList",
    "userCode",
    "userName"
})
public class User {

    @XmlElement(nillable = true)
    protected List<DataPower> dataPowers;
    protected String loginComCode;
    protected String loginComName;
    @XmlElement(nillable = true)
    protected List<Menu> menuList;
    protected String passWord;
    @XmlElement(nillable = true)
    protected List<String> roleIdList;
    @XmlElement(nillable = true)
    protected List<String> taskIdList;
    protected String userCode;
    protected String userName;

    /**
     * Gets the value of the dataPowers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataPowers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataPowers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataPower }
     * 
     * 
     */
    public List<DataPower> getDataPowers() {
        if (dataPowers == null) {
            dataPowers = new ArrayList<DataPower>();
        }
        return this.dataPowers;
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
    	if(this.loginComCode==null){
    		this.loginComCode = value;
    	}
    }

    /**
     * Gets the value of the loginComName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginComName() {
        return loginComName;
    }

    /**
     * Sets the value of the loginComName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginComName(String value) {
    	if(this.loginComName==null){
    		this.loginComName = value;
    	}
    }

    /**
     * Gets the value of the menuList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the menuList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMenuList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Menu }
     * 
     * 
     */
    public List<Menu> getMenuList() {
        if (menuList == null) {
            menuList = new ArrayList<Menu>();
        }
        return this.menuList;
    }

    /**
     * Gets the value of the passWord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * Sets the value of the passWord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassWord(String value) {
    	if( this.passWord ==null){
    		this.passWord = value;
    	}
    }

    /**
     * Gets the value of the roleIdList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleIdList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleIdList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRoleIdList() {
        if (roleIdList == null) {
            roleIdList = new ArrayList<String>();
        }
        return this.roleIdList;
    }

    /**
     * Gets the value of the taskIdList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskIdList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskIdList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTaskIdList() {
        if (taskIdList == null) {
            taskIdList = new ArrayList<String>();
        }
        return this.taskIdList;
    }

    /**
     * Gets the value of the userCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * Sets the value of the userCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserCode(String value) {
    	if(this.userCode==null){
    		this.userCode = value;
    	}
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
    	if(this.userName==null){
    		 this.userName = value;
    	}
    }

}
