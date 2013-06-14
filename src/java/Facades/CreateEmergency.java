package Facades;

import Services.AppointmentServices;
import java.sql.Time;
import java.util.Date;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "CreateEmergency")
@Stateless()
public class CreateEmergency {

    public boolean CreateEmergency(int idDoctor, Date date, Time time, Integer idPerson, String cost) {
        return new AppointmentServices().createEmergency(idDoctor, date, time, idPerson, cost);
    }
}
