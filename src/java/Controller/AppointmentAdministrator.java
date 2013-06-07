package Controller;

import Entity.Appointment;
import Entity.AppointmentStatus;
import Entity.AppointmentType;
import Entity.Doctor;
import java.util.Calendar;

/**
 *
 * @author Esteban
 */
public class AppointmentAdministrator {

    public boolean isAvailable(Doctor doctor, Calendar time) {
        for (Appointment appointment : doctor.getAppointments()) {
            if ((appointment.getStatus() == AppointmentStatus.ASSIGNED) && (appointment.getTime().equals(time))) {
                return true;
            }
        }
        return false;
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
