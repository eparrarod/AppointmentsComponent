/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Controller.AppointmentAdministrator;
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
@WebService(serviceName = "CreateAppointment")
@Stateless()
public class CreateAppointment {

    public boolean createAppointment(Doctor doctor, Calendar time, Integer idPerson, String cost, AppointmentType type) {
        return new AppointmentServices().createAppointment(doctor, time, idPerson, cost, type);
    }
}
