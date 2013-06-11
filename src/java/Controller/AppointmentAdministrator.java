package Controller;

import Entity.Appointment;
import Entity.AppointmentStatus;
import Entity.AppointmentType;
import Entity.Doctor;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Esteban
 */
public class AppointmentAdministrator {

    public boolean isAvailable(Doctor doctor, Date date, Time time) {
        for (Appointment appointment : doctor.getAppointments()) {
            if ((appointment.getStatus() == AppointmentStatus.ASSIGNED) && (appointment.getDate().equals(date)) && (appointment.getTime().equals(time))) {
                return false;
            }
        }
        return true;
    }

    public void setAppointmentTo(Doctor doctor, Appointment appointment) {
        doctor.assignAppointment(appointment);
    }

    public void appointmentCompleted(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.COMPLETED);
    }

    public void appointmentCompleted(Appointment appointment, String notes) {
        appointmentCompleted(appointment);
        appointment.setNotes(notes);
    }

    public void cancelAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.CANCELLED);
    }

    public void cancelAppointment(Appointment appointment, String notes) {
        cancelAppointment(appointment);
        appointment.setNotes(notes);
    }
}
