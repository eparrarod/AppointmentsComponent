/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Controller.AppointmentAdministrator;
import Entity.Appointment;
import Entity.AppointmentType;
import Entity.Doctor;
import Extras.InicializarBase;
import Services.AppointmentServices;
import java.sql.Time;
import java.text.ParseException;
import java.util.Calendar;
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

    public boolean createAppointment(Doctor doctor, Date date, Time time, Integer idPerson, String cost, AppointmentType type){
        
        /*try{
            InicializarBase init = new InicializarBase();
            init.inicializar();
        }catch(Exception ex){
        }*/
        
        
        return new AppointmentServices().createAppointment(doctor, date, time, idPerson, cost, type);
    }
}
