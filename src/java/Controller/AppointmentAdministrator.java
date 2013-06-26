package Controller;

import Dao.AppointmentDAO;
import Dao.DoctorDAO;
import Entity.Appointment;
import Entity.AppointmentStatus;
import Entity.AppointmentType;
import Entity.Doctor;
import Entity.Specialty;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Esteban
 * 
 * Return Doctors list--names
 */
public class AppointmentAdministrator {

    private DoctorDAO dd = new DoctorDAO();
    private AppointmentDAO ad = new AppointmentDAO();
    
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
    
    public List<String> getSpecialties() {
        List<String> types = new ArrayList<String>();
        
        types.add(Specialty.GENERAL.toString().toUpperCase());
        types.add(Specialty.ODONTOLOGIA.toString().toUpperCase());
        types.add(Specialty.ORTODONCIA.toString().toUpperCase());
        types.add(Specialty.OPTOMETRIA.toString().toUpperCase());
        types.add(Specialty.PEDIATRIA.toString().toUpperCase());
        types.add(Specialty.CARDIOLOGIA.toString().toUpperCase());
        
        return types;
    }
    
    public void createDoctor(int idDoctor, int idHospital, String name, Specialty specialty) {
        dd.create(new Doctor(idDoctor, idHospital, name, specialty));
    }
    
    public void deleteDoctor(int idDoctor) {
        dd.removeById(idDoctor);
    }
    
    public void updateDoctor(Doctor doctor) {
        dd.update(doctor);
    }
    
    public List<Doctor> getListDoctor() {
        return dd.findAll();
    }
    
    public Doctor getDoctor(int idDoctor) {
        List<Doctor> list = getListDoctor();
        
        for(Doctor d : list) {
            if(d.getIdDoctor() == idDoctor) {
                return d;
            }
        }
        
        return null;
    }
    
    public List<Doctor> getDoctorsByHospitalId(int id) {
        List<Doctor> list = getListDoctor();
        List<Doctor> listDoctor = new ArrayList<Doctor>();
        
        for(Doctor d : list) {
            if(d.getIdHospital() == id) {
                listDoctor.add(d);
            }
        }
        
        return listDoctor;
    }
}
