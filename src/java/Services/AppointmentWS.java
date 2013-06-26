/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controller.AppointmentAdministrator;
import Dao.DoctorDAO;
import Entity.Appointment;
import Entity.AppointmentType;
import Entity.Doctor;
import Entity.Specialty;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author Camilo
 */
@WebService(serviceName = "AppointmentWS")
@Stateless()
public class AppointmentWS {
    @EJB
    private SOATClient sOATClient;

    AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();

    public boolean checkAvailability(int idDoctor, Date date, Time time) {
        return appointmentAdministrator.isAvailable(idDoctor, date, time);
    }

    public boolean createAppointment(int idDoctor, Date date, Time time, Integer idPerson, String cost, AppointmentType type) {
       
        if (appointmentAdministrator.isAvailable(idDoctor, date, time)) {
            Appointment appointment = new Appointment(idPerson, date, time, cost, type);
            appointmentAdministrator.setAppointmentTo(idDoctor, appointment.getIdAppointment());
            return true;
        } else {
            return false;
        }
    }

    public void cancelAppointment(int idAppointment) {
        appointmentAdministrator.cancelAppointment(idAppointment);
    }

    public void completeAppointment(int idAppointment) {
        appointmentAdministrator.appointmentCompleted(idAppointment);
    }
    
    public List getDoctorsBySpecialty(int specialty){
        DoctorDAO dd = new DoctorDAO();
        return dd.findAllBySpecialty(specialty);
    }
    
    public List getAppointmentsByPatient(int personId){
        return appointmentAdministrator.getAppointmentsByPersonId(personId);
        }
    
    public boolean createEmergency(int idDoctor, Date date, Time time, Integer idPerson, String cost){
        
        if(sOATClient.validateSOAT(idPerson.toString()).isSuccess()){
            return createAppointment(idDoctor, date, time, idPerson, cost, AppointmentType.EMERGENCY);
        }
    
    public List<String> getSpecialties() {
        return appointmentAdministrator.getSpecialties();
    }
    
    public void createDoctor(int idDoctor, int idHospital, String name, Specialty specialty) {
       appointmentAdministrator.createDoctor(idDoctor, idHospital, name, specialty);
    }
    
    public List<Doctor> getListDoctor() {
        return appointmentAdministrator.getListDoctor();
    }
    
    public List<Doctor> getDoctorsByHospitalId(int id) {
        return appointmentAdministrator.getDoctorsByHospitalId(id);
    }
    
    public void deleteDoctor(int idDoctor) {
        appointmentAdministrator.deleteDoctor(idDoctor);
    }
    
    public void updateDoctor(Doctor doctor) {
        appointmentAdministrator.updateDoctor(doctor);
    }
    
    public Doctor getDoctor(int idDoctor) {
        return appointmentAdministrator.getDoctor(idDoctor);
    }
}
