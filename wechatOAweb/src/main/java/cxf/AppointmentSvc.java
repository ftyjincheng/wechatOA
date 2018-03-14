package cxf;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-11-16T15:33:13.442+08:00
 * Generated source version: 2.7.18
 * 
 */
@WebServiceClient(name = "AppointmentSvc", 
                  wsdlLocation = "http://162.16.160.50/webservice/Real/AppointmentSvc.asmx?wsdl",
                  targetNamespace = "") 
public class AppointmentSvc extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("", "AppointmentSvc");
    public final static QName AppointmentSvcSoap12 = new QName("", "AppointmentSvcSoap12");
    public final static QName AppointmentSvcSoap = new QName("", "AppointmentSvcSoap");
    public final static QName AppointmentSvcHttpPost = new QName("", "AppointmentSvcHttpPost");
    public final static QName AppointmentSvcHttpGet = new QName("", "AppointmentSvcHttpGet");
    static {
        URL url = null;
        try {
            url = new URL("http://162.16.160.50/webservice/Real/AppointmentSvc.asmx?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AppointmentSvc.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://162.16.160.50/webservice/Real/AppointmentSvc.asmx?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AppointmentSvc(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AppointmentSvc(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AppointmentSvc() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
//    public AppointmentSvc(WebServiceFeature ... features) {
//        super(WSDL_LOCATION, SERVICE, features);
//    }
//
//    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
//    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
//    //compliant code instead.
//    public AppointmentSvc(URL wsdlLocation, WebServiceFeature ... features) {
//        super(wsdlLocation, SERVICE, features);
//    }
//
//    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
//    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
//    //compliant code instead.
//    public AppointmentSvc(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
//        super(wsdlLocation, serviceName, features);
//    }

    /**
     *
     * @return
     *     returns AppointmentSvcSoap
     */
    @WebEndpoint(name = "AppointmentSvcSoap12")
    public AppointmentSvcSoap getAppointmentSvcSoap12() {
        return super.getPort(AppointmentSvcSoap12, AppointmentSvcSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AppointmentSvcSoap
     */
    @WebEndpoint(name = "AppointmentSvcSoap12")
    public AppointmentSvcSoap getAppointmentSvcSoap12(WebServiceFeature... features) {
        return super.getPort(AppointmentSvcSoap12, AppointmentSvcSoap.class, features);
    }
    /**
     *
     * @return
     *     returns AppointmentSvcSoap
     */
    @WebEndpoint(name = "AppointmentSvcSoap")
    public AppointmentSvcSoap getAppointmentSvcSoap() {
        return super.getPort(AppointmentSvcSoap, AppointmentSvcSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AppointmentSvcSoap
     */
    @WebEndpoint(name = "AppointmentSvcSoap")
    public AppointmentSvcSoap getAppointmentSvcSoap(WebServiceFeature... features) {
        return super.getPort(AppointmentSvcSoap, AppointmentSvcSoap.class, features);
    }
    /**
     *
     * @return
     *     returns AppointmentSvcHttpPost
     */
    @WebEndpoint(name = "AppointmentSvcHttpPost")
    public AppointmentSvcHttpPost getAppointmentSvcHttpPost() {
        return super.getPort(AppointmentSvcHttpPost, AppointmentSvcHttpPost.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AppointmentSvcHttpPost
     */
    @WebEndpoint(name = "AppointmentSvcHttpPost")
    public AppointmentSvcHttpPost getAppointmentSvcHttpPost(WebServiceFeature... features) {
        return super.getPort(AppointmentSvcHttpPost, AppointmentSvcHttpPost.class, features);
    }
    /**
     *
     * @return
     *     returns AppointmentSvcHttpGet
     */
    @WebEndpoint(name = "AppointmentSvcHttpGet")
    public AppointmentSvcHttpGet getAppointmentSvcHttpGet() {
        return super.getPort(AppointmentSvcHttpGet, AppointmentSvcHttpGet.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AppointmentSvcHttpGet
     */
    @WebEndpoint(name = "AppointmentSvcHttpGet")
    public AppointmentSvcHttpGet getAppointmentSvcHttpGet(WebServiceFeature... features) {
        return super.getPort(AppointmentSvcHttpGet, AppointmentSvcHttpGet.class, features);
    }

}