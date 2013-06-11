/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author USER
 */
@Singleton
@LocalBean
public class SOATClient {

   // @WebServiceRef(wsdlLocation = "META-INF/wsdl/192.168.0.102_8080/caculadoraPrueba/CaculadoraWS.wsdl")
    private String service;
       
    public boolean ensurance(int id){
        
     // return service.method(id); 
      return true;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
