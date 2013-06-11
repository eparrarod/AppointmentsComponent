/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Services.AppointmentServices;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "GetAppointments")
@Stateless()
public class GetAppointments {
    
    @WebMethod(operationName = "getAppointmentsByPerson")
    public List getAppointmentsByPerson(int personId){
    return new AppointmentServices().getAppointmentsByPatient(personId);
    }
    
    @WebMethod(operationName = "getDoctorsBySpecialty")
    public List getDoctorsBySpecialty(int specialty){
        return new AppointmentServices().getDoctorsBySpecialty(specialty);
    }
}
