/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Doctor;
import Services.AppointmentServices;
import java.sql.Time;
import java.util.Date;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author USER
 */
@WebService(serviceName = "CheckAvailability")
@Stateless()
public class CheckAvailability {
    public boolean checkAvailability(int idDoctor, Date date, Time time) {
        return new AppointmentServices().checkAvailability(idDoctor, date, time);
    }
}
