
package com.sinosoft.ebusiness.rms.client.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sinosoft.ebusiness.rms.client.cxf package. 
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

    private final static QName _WebServiceLogin_QNAME = new QName("http://facade.webService.service.rms.ebusiness.sinosoft.com/", "webServiceLogin");
    private final static QName _WebServiceSelectComResponse_QNAME = new QName("http://facade.webService.service.rms.ebusiness.sinosoft.com/", "webServiceSelectComResponse");
    private final static QName _WebServiceSelectCom_QNAME = new QName("http://facade.webService.service.rms.ebusiness.sinosoft.com/", "webServiceSelectCom");
    private final static QName _WebServiceLoginResponse_QNAME = new QName("http://facade.webService.service.rms.ebusiness.sinosoft.com/", "webServiceLoginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sinosoft.ebusiness.rms.client.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WebServiceLoginResponse }
     * 
     */
    public WebServiceLoginResponse createWebServiceLoginResponse() {
        return new WebServiceLoginResponse();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link Employe }
     * 
     */
    public Employe createEmploye() {
        return new Employe();
    }

    /**
     * Create an instance of {@link WebServiceLogin }
     * 
     */
    public WebServiceLogin createWebServiceLogin() {
        return new WebServiceLogin();
    }

    /**
     * Create an instance of {@link WebServiceSelectComResponse }
     * 
     */
    public WebServiceSelectComResponse createWebServiceSelectComResponse() {
        return new WebServiceSelectComResponse();
    }

    /**
     * Create an instance of {@link DataRule }
     * 
     */
    public DataRule createDataRule() {
        return new DataRule();
    }

    /**
     * Create an instance of {@link BusPower }
     * 
     */
    public BusPower createBusPower() {
        return new BusPower();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link WebServiceDTO }
     * 
     */
    public WebServiceDTO createWebServiceDTO() {
        return new WebServiceDTO();
    }

    /**
     * Create an instance of {@link WebServiceSelectCom }
     * 
     */
    public WebServiceSelectCom createWebServiceSelectCom() {
        return new WebServiceSelectCom();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebServiceLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.webService.service.rms.ebusiness.sinosoft.com/", name = "webServiceLogin")
    public JAXBElement<WebServiceLogin> createWebServiceLogin(WebServiceLogin value) {
        return new JAXBElement<WebServiceLogin>(_WebServiceLogin_QNAME, WebServiceLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebServiceSelectComResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.webService.service.rms.ebusiness.sinosoft.com/", name = "webServiceSelectComResponse")
    public JAXBElement<WebServiceSelectComResponse> createWebServiceSelectComResponse(WebServiceSelectComResponse value) {
        return new JAXBElement<WebServiceSelectComResponse>(_WebServiceSelectComResponse_QNAME, WebServiceSelectComResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebServiceSelectCom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.webService.service.rms.ebusiness.sinosoft.com/", name = "webServiceSelectCom")
    public JAXBElement<WebServiceSelectCom> createWebServiceSelectCom(WebServiceSelectCom value) {
        return new JAXBElement<WebServiceSelectCom>(_WebServiceSelectCom_QNAME, WebServiceSelectCom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebServiceLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.webService.service.rms.ebusiness.sinosoft.com/", name = "webServiceLoginResponse")
    public JAXBElement<WebServiceLoginResponse> createWebServiceLoginResponse(WebServiceLoginResponse value) {
        return new JAXBElement<WebServiceLoginResponse>(_WebServiceLoginResponse_QNAME, WebServiceLoginResponse.class, null, value);
    }

}
