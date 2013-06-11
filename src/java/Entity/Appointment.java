package Entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import java.sql.Time;
import java.util.Date;
import org.bson.types.ObjectId;

@Entity
public class Appointment {
    
    @Id
    private ObjectId id; 
    private int idAppointment;
    private int idPerson;
    private Date date;
    private Time time;
    private String cost;
    private String notes;
    private AppointmentType type;
    private AppointmentStatus status;    

    public Appointment() {
    }

    public Appointment(int idPerson, Date date, Time time, String cost, AppointmentType type) {
        this.idPerson = idPerson;
        this.date = date;
        this.time=time;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public AppointmentType getType() {
        return type;
    }

    public void setType(AppointmentType type) {
        this.type = type;
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
