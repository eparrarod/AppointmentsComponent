package Services;

import Controller.AppointmentAdministrator;
import Dao.DoctorDAO;
import Entity.Appointment;
import Entity.AppointmentType;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class AppointmentServices {
    
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

    public void cancelAppointment(int idAppointment, String notes) {
        appointmentAdministrator.cancelAppointment(idAppointment, notes);
    }

    public void completeAppointment(int idAppointment) {
        appointmentAdministrator.appointmentCompleted(idAppointment);
    }

    public void completeAppointment(int idAppointment, String notes) {
        appointmentAdministrator.appointmentCompleted(idAppointment, notes);
    }
    
    public List getDoctorsBySpecialty(int specialty){
        DoctorDAO dd = new DoctorDAO();
        return dd.findAllBySpecialty(specialty);
    }
    
    public List getAppointmentsByPatient(int personId){
        return appointmentAdministrator.getAppointmentsByPersonId(personId);
        }
}
