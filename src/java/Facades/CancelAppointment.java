/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Appointment;
import Entity.AppointmentType;
import Entity.Doctor;
import Services.AppointmentServices;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author USER
 */
@WebService(serviceName = "CancelAppointment")
@Stateless()
public class CancelAppointment {

    public void cancelAppointment(int idAppointment) {
        new AppointmentServices().cancelAppointment(idAppointment);
    }
/*
    public void cancelAppointment(int idAppointment, String notes) {
        new AppointmentServices().cancelAppointment(idAppointment, notes);
    }*/
}
