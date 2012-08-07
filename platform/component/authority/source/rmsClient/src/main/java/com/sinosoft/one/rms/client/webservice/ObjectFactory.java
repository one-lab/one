
package com.sinosoft.one.rms.client.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sinosoft.ebusiness.rms.client.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindCompanysByUserCodeAndPasswordResponse_QNAME = new QName("http://facade.clientService.rms.ebusiness.sinosoft.com/", "findCompanysByUserCodeAndPasswordResponse");
    private final static QName _FindCompanysByUserCodeAndPassword_QNAME = new QName("http://facade.clientService.rms.ebusiness.sinosoft.com/", "findCompanysByUserCodeAndPassword");
    private final static QName _LoginResponse_QNAME = new QName("http://facade.clientService.rms.ebusiness.sinosoft.com/", "loginResponse");
    private final static QName _Login_QNAME = new QName("http://facade.clientService.rms.ebusiness.sinosoft.com/", "login");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sinosoft.ebusiness.rms.client.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link FindCompanysByUserCodeAndPassword }
     * 
     */
    public FindCompanysByUserCodeAndPassword createFindCompanysByUserCodeAndPassword() {
        return new FindCompanysByUserCodeAndPassword();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link FindCompanysByUserCodeAndPasswordResponse }
     * 
     */
    public FindCompanysByUserCodeAndPasswordResponse createFindCompanysByUserCodeAndPasswordResponse() {
        return new FindCompanysByUserCodeAndPasswordResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCompanysByUserCodeAndPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.clientService.rms.ebusiness.sinosoft.com/", name = "findCompanysByUserCodeAndPasswordResponse")
    public JAXBElement<FindCompanysByUserCodeAndPasswordResponse> createFindCompanysByUserCodeAndPasswordResponse(FindCompanysByUserCodeAndPasswordResponse value) {
        return new JAXBElement<FindCompanysByUserCodeAndPasswordResponse>(_FindCompanysByUserCodeAndPasswordResponse_QNAME, FindCompanysByUserCodeAndPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCompanysByUserCodeAndPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.clientService.rms.ebusiness.sinosoft.com/", name = "findCompanysByUserCodeAndPassword")
    public JAXBElement<FindCompanysByUserCodeAndPassword> createFindCompanysByUserCodeAndPassword(FindCompanysByUserCodeAndPassword value) {
        return new JAXBElement<FindCompanysByUserCodeAndPassword>(_FindCompanysByUserCodeAndPassword_QNAME, FindCompanysByUserCodeAndPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.clientService.rms.ebusiness.sinosoft.com/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.clientService.rms.ebusiness.sinosoft.com/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

}
