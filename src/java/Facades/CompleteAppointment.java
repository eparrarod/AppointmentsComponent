/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Appointment;
import Entity.AppointmentType;
import Entity.Doctor;
import Services.AppointmentServices;
import java.util.Calendar;
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

    public void completeAppointment(Appointment appointment) {
        new AppointmentServices().completeAppointment(appointment);
    }

    public void completeAppointment(Appointment appointment, String notes) {
        new AppointmentServices().completeAppointment(appointment, notes);
    }
}
