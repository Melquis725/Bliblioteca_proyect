
package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Estudiante {
            
    private int idLector;
    private String Nombre;
    private String Carrera;
    private int Telefono;
    
    public Connection conn;
    public Estudiante(Connection conn){
        this.conn= conn;
    }

    
    public Estudiante(int idLector, String Nombre, String Carrera, int Telefono) {
        this.idLector = idLector;
        this.Nombre = Nombre;
        this.Carrera = Carrera;
        this.Telefono = Telefono;
        
    }

    public int getId() {
        return idLector;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCarrera() {
        return Carrera;
    }

    public int getTelefono() {
        return Telefono;
    }
   
    public void NewEstudiante(String Nombre, String Carrera, int Telefono){
        
    String q= ("INSERT INTO estudiante(Nombre, Carrera, Telefono) VALUES (?, ?, ?)");
    try{
    PreparedStatement stmt;
    stmt= conn.prepareStatement(q);
    stmt.setString(1, Nombre);
    stmt.setString(2, Carrera);
    stmt.setInt(3,Telefono);
    stmt.execute();
    }catch(SQLException ex){
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
            
}
