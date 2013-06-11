/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Appointment;
import Services.AppointmentServices;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author USER
 */
@WebService(serviceName = "CompleteAppointment")
@Stateless()
public class CompleteAppointment {
    
    public void completeAppointment(int idAppointment) {
        new AppointmentServices().completeAppointment(idAppointment);
    }
    /*
    public void completeAppointment(int idAppointment, String notes) {
        new AppointmentServices().completeAppointment(idAppointment, notes);
    }*/
}
