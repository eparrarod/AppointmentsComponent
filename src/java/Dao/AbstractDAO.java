
package Dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import java.net.UnknownHostException;


public abstract class AbstractDAO {
    
    protected Mongo mongo = null;
    protected Morphia morphia = null;
    protected Datastore ds = null;  
    
    public AbstractDAO() {
        //se crea la conexion
        mongo = null;
        try {
            mongo = new Mongo("localhost", 27017);
        } catch(UnknownHostException e){}
        //se crea una instancia de morphia y se mapean las clases que necesitamos
        morphia = new Morphia();
        //morphia.map(Student.class).map(Parents.class).map(Mother.class).map(Father.class);
        morphia.mapPackage("Entity");
        //se le asigna a un datastore la coneccion a una base de datos en particular
        ds = morphia.createDatastore(mongo, "baseHospital");          
    }
    
    public AbstractDAO(String dbName) {
        //se crea la conexion
        mongo = null;
        try {
            mongo = new Mongo("localhost", 27017);
        } catch(UnknownHostException e){}
        //se crea una instancia de morphia y se mapean las clases que necesitamos
        morphia = new Morphia();
        //morphia.map(Student.class).map(Parents.class).map(Mother.class).map(Father.class);
        morphia.mapPackage("Entity");
        //se le asigna a un datastore la coneccion a una base de datos en particular
        ds = morphia.createDatastore(mongo, dbName);          
    }   
    
    
}
