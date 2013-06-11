
package Extras;

import Dao.AppointmentDAO;
import Dao.DoctorDAO;
import Entity.Appointment;
import Entity.Doctor;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class InicializarBase {   

    public InicializarBase() {
    }
    
  
    public void inicializar() throws ParseException {
        
        DoctorDAO doctorDao = new DoctorDAO();
        AppointmentDAO appointmentDao = new AppointmentDAO(); 
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");     
         
        Appointment cita1 = new Appointment();
        cita1.setIdPerson(1);
        cita1.setIdAppointment(10);
        cita1.setCost("$15000");
        cita1.setNotes("asdf");
        cita1.setDate(df.parse("29/12/2001"));
        cita1.setTime(new Time(12,30,45));
        
        Appointment cita2 = new Appointment();
        cita2.setIdPerson(2);
        cita2.setIdAppointment(11);
        cita2.setCost("$9300");
        cita2.setNotes("jklñ"); 
        cita2.setDate(df.parse("29/12/2001"));
        cita2.setTime(new Time(12,30,45));

        
        Appointment cita3 = new Appointment();
        cita3.setIdPerson(2);
        cita3.setIdAppointment(12);
        cita3.setCost("$9300");
        cita3.setNotes("qwer");    
        cita3.setDate(df.parse("29/12/2001"));
        cita3.setTime(new Time(12,30,45));
        
        List<Appointment> listaCitas = new ArrayList();
        listaCitas.add(cita1);
        listaCitas.add(cita2);
        listaCitas.add(cita3);
        
        Doctor doctor1 = new Doctor();
        doctor1.setName("uiop");
        doctor1.setIdDoctor(20);
        doctor1.setAppointments(listaCitas);
        
        appointmentDao.create(cita1);
        appointmentDao.create(cita2);
        appointmentDao.create(cita3);
        System.out.println(appointmentDao.findById(11).getNotes() + appointmentDao.findById(11).getDate());
        doctorDao.create(doctor1);        
    } 

}
