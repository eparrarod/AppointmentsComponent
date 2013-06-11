
package Dao;

import Entity.Doctor;
import com.google.code.morphia.query.Query;
import java.util.List;


public class DoctorDAO extends AbstractDAO{
    
    public DoctorDAO() {
        super();
    }
    
    public DoctorDAO(String dbName) {
        super(dbName);
    }
    
    public void create(Doctor doctor) {
        ds.save(doctor);
    }

    public List<Doctor> findAll() {
        Query<Doctor> q = ds.createQuery(Doctor.class);
        return q.asList();
    }       
    
    public List<Doctor> findAllBySpecialty(int specialty) {
        Query<Doctor> q = ds.createQuery(Doctor.class).filter("specialty ==", specialty);
        return q.asList();
    }  
   
    public Doctor findById(int id) {
        Query<Doctor> q = ds.createQuery(Doctor.class).filter("idDoctor ==", id);
        return q.get();
    }
    
    public void removeById(int id) {
        Query<Doctor> q = ds.createQuery(Doctor.class).filter("idDoctor ==", id);
        ds.delete(q);
    }
    
    public void update(Doctor doctor) {
        ds.merge(doctor);
    }
    
    public void clear() {
        Query<Doctor> q = ds.createQuery(Doctor.class);
        ds.delete(q);
    }        
}
