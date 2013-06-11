package Services;

import Controller.AppointmentAdministrator;
import Entity.Appointment;
import Entity.AppointmentType;
import Entity.Doctor;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author USER
 */
public class AppointmentServices {

    public boolean checkAvailability(Doctor doctor, Date date, Time time) {
        AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();
        return appointmentAdministrator.isAvailable(doctor, date, time);
    }

    public boolean createAppointment(Doctor doctor, Date date, Time time, Integer idPerson, String cost, AppointmentType type) {
        
        AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();

        if (appointmentAdministrator.isAvailable(doctor, date, time)) {
            Appointment appointment = new Appointment(idPerson, date, time, cost, type);
            appointmentAdministrator.setAppointmentTo(doctor, appointment);
            return true;
        } else {
            return false;
        }
    }

    public void cancelAppointment(Appointment appointment) {
        AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();
        appointmentAdministrator.cancelAppointment(appointment);
    }

    public void cancelAppointment(Appointment appointment, String notes) {
        AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();
        appointmentAdministrator.cancelAppointment(appointment, notes);
    }

    public void completeAppointment(Appointment appointment) {
        AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();
        appointmentAdministrator.appointmentCompleted(appointment);
    }

    public void completeAppointment(Appointment appointment, String notes) {
        AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();
        appointmentAdministrator.appointmentCompleted(appointment, notes);
    }
}
