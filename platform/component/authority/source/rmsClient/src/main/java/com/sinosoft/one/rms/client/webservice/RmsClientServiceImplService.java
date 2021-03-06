
package com.sinosoft.one.rms.client.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "RmsClientServiceImplService", targetNamespace = "http://facade.rms.one.sinosoft.com/", wsdlLocation = "http://localhost:8080/mis/services/RmsLoginService?wsdl")
public class RmsClientServiceImplService
    extends Service
{

    private final static URL RMSCLIENTSERVICEIMPLSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/mis/services/RmsLoginService?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        RMSCLIENTSERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public RmsClientServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RmsClientServiceImplService() {
        super(RMSCLIENTSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://facade.rms.one.sinosoft.com/", "RmsClientServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns RmsClientService
     */
    @WebEndpoint(name = "RmsClientServiceImplPort")
    public RmsClientService getRmsClientServiceImplPort() {
        return (RmsClientService)super.getPort(new QName("http://facade.rms.one.sinosoft.com/", "RmsClientServiceImplPort"), RmsClientService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RmsClientService
     */
    @WebEndpoint(name = "RmsClientServiceImplPort")
    public RmsClientService getRmsClientServiceImplPort(WebServiceFeature... features) {
        return (RmsClientService)super.getPort(new QName("http://facade.rms.one.sinosoft.com/", "RmsClientServiceImplPort"), RmsClientService.class, features);
    }

}
