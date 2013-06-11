
package Extras;

import Dao.AppointmentDAO;
import Dao.DoctorDAO;

public class LimpiarBase {
    
    public LimpiarBase() {
    }
    
    public void limpiar() {
        DoctorDAO doctorDao = new DoctorDAO();
        AppointmentDAO appointmentDao = new AppointmentDAO();   
        
        doctorDao.clear();
        appointmentDao.clear();
    }
}
