package Controller;

import Dao.AppointmentDAO;
import Dao.DoctorDAO;
import Entity.Appointment;
import Entity.AppointmentStatus;
import Entity.AppointmentType;
import Entity.Doctor;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Esteban
 * 
 * Return Doctors list--names
 */
public class AppointmentAdministrator {

    DoctorDAO dd = new DoctorDAO();
    AppointmentDAO ad = new AppointmentDAO();
    
    public boolean isAvailable(int idDoctor, Date date, Time time) {
        Doctor doctor = dd.findById(idDoctor);
        for (Appointment appointment : doctor.getAppointments()) {
            if ((appointment.getStatus() == AppointmentStatus.ASSIGNED) && (appointment.getDate().equals(date)) && (appointment.getTime().equals(time))) {
                return false;
            }
        }
        return true;
    }

    public void setAppointmentTo(int idDoctor, int idAppointment) {
        Doctor doctor = dd.findById(idDoctor);        
        Appointment appointment = ad.findById(idAppointment);
        doctor.assignAppointment(appointment);
    }

    public void appointmentCompleted(int idAppointment) {
        Appointment appointment = ad.findById(idAppointment);
        appointment.setStatus(AppointmentStatus.COMPLETED);
    }

    public void appointmentCompleted(int idAppointment, String notes) {
        Appointment appointment = ad.findById(idAppointment);
        appointmentCompleted(idAppointment);
        appointment.setNotes(notes);
    }

    public void cancelAppointment(int idAppointment) {
        Appointment appointment = ad.findById(idAppointment);
        appointment.setStatus(AppointmentStatus.CANCELLED);
    }

    public void cancelAppointment(int idAppointment, String notes) {
        Appointment appointment = ad.findById(idAppointment);
        cancelAppointment(idAppointment);
        appointment.setNotes(notes);
    }
    
    public List getAppointmentsByPersonId(int idPerson){
    return ad.findByPersonId(idPerson);
    }
}
