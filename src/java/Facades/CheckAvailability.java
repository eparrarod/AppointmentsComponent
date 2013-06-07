/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

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
@WebService(serviceName = "CheckAvailability")
@Stateless()
public class CheckAvailability {
    
    public boolean chackAvailability(Doctor doctor, Calendar time) {
        return new AppointmentServices().checkAvailability(doctor, time);
    }
}
