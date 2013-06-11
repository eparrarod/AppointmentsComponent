/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.AppointmentType;
import Extras.InicializarBase;
import Services.AppointmentServices;
import java.sql.Time;
import java.util.Date;
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
     public boolean createAppointment(int idDoctor, Date date, Time time, Integer idPerson, String cost, AppointmentType type){      
        return new AppointmentServices().createAppointment(idDoctor, date, time, idPerson, cost, type);
    }
}
