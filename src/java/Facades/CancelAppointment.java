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
@WebService(serviceName = "CancelAppointment")
@Stateless()
public class CancelAppointment {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    public void cancelAppointment(Appointment appointment) {
        new AppointmentServices().cancelAppointment(appointment);
    }

    public void cancelAppointment(Appointment appointment, String notes) {
        new AppointmentServices().cancelAppointment(appointment, notes);
    }
}
