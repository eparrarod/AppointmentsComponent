
package Dao;

import Entity.Appointment;
import com.google.code.morphia.query.Query;
import java.util.List;


public class AppointmentDAO extends AbstractDAO{

    public AppointmentDAO() {
        super();
    }
    
    public AppointmentDAO(String dbName) {
        super(dbName);
    }    
    
    public void create(Appointment appointment) {
        ds.save(appointment);
    }

    public List<Appointment> findAll() {
        Query<Appointment> q = ds.createQuery(Appointment.class);
        return q.asList();
    }
    
    public Appointment findById(int id) {
        Query<Appointment> q = ds.createQuery(Appointment.class).filter("idAppointment ==", id);
        return q.get();
    }
    
    public void removeById(int id) {
        Query<Appointment> q = ds.createQuery(Appointment.class).filter("idAppointment ==", id);
        ds.delete(q);
    }
    
    public void update(Appointment appointment) {
        ds.merge(appointment);
    }
    
    public void clear() {
        Query<Appointment> q = ds.createQuery(Appointment.class);
        ds.delete(q);
    }    
    
}
