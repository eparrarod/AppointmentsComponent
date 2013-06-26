package Entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

@Entity
public class Doctor {

    @Id
    private int idDoctor;
    private int idHospital;
    private String name;
    private String lastname;
    private Specialty specialty;
    @Reference
    private List<Appointment> appointments;

    public Doctor() {
        
    }
    
    public Doctor(int idDoctor, int idHospital ,String name, Specialty specialty) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.specialty = specialty;
        this.appointments = new ArrayList<Appointment>();
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void assignAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
