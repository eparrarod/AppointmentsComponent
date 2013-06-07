package Services;

import Controller.AppointmentAdministrator;
import Entity.Appointment;
import Entity.AppointmentType;
import Entity.Doctor;
import java.util.Calendar;

/**
 *
 * @author USER
 */
public class AppointmentServices {

    public boolean checkAvailability(Doctor doctor, Calendar time) {
        AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();
        return appointmentAdministrator.isAvailable(doctor, time);
    }

    public boolean createAppointment(Doctor doctor, Calendar time, Integer idPerson, String cost, AppointmentType type) {
        AppointmentAdministrator appointmentAdministrator = new AppointmentAdministrator();

        if (appointmentAdministrator.isAvailable(doctor, time)) {
            Appointment appointment = new Appointment(idPerson, time, cost, type);
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
