package Entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import java.util.Calendar;
import org.bson.types.ObjectId;

@Entity
public class Appointment {
    
    @Id
    private ObjectId id; 
    private int idAppointment;
    private int idPerson;
    private Calendar time;
    private String cost;
    private String notes;
    private AppointmentType type;
    private AppointmentStatus status;    

    public Appointment() {
    }

    public Appointment(int idPerson, Calendar time, String cost, AppointmentType type) {
        this.idPerson = idPerson;
        this.time = time;
        this.cost = cost;
        this.type = type;
        this.status = AppointmentStatus.ASSIGNED;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }
    
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }   
}
