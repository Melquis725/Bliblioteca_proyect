/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melquis
 */
public class prestCntrol {
    
    private Connection conn;
    
    public prestCntrol(Connection conn){
        
      this.conn= conn;
    }
    
    public Prestamo getRegistros(int _Id){
        Prestamo p= null;
        try {
        PreparedStatement stmt;
        stmt = this.conn.prepareStatement("SELECT * FROM prestamo WHERE idPrestamo= ?");
        stmt.setInt(1, _Id);
        ResultSet rs= stmt.executeQuery();
            
        while(rs.next()){
                
            int idPrestamo = rs.getInt("idPrestamo");
            int idLector = rs.getInt("idLector");
            int idLibro = rs.getInt("idLibro");
            String FechaPrestamo = rs.getString("FechaPrestamo");
            String FechaDevolucion = rs.getString("FechaDevolucion");
            String Devuelto = rs.getString("Devuelto");
                
            p= new Prestamo(idPrestamo, idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto);
            System.out.printf("ID del Prestamo %s, ID del Lector %s, ID del Libro %s, Fecha del prestamo %s, Fecha Devolucion %s, Devuelto %s"
                    , p.getIdPrestamo(), p.getIdLector(), p.getIdLibro(), p.getFechaPrestamo(), p.getFechaDevolucion(), p.getDevuelto() );
        }
        }catch (SQLException ex) {
            Logger.getLogger(prestCntrol.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }
    
        public List<Prestamo> getListReg(){
            
        List<Prestamo> buffer = new ArrayList();
            
        try {
        PreparedStatement stmt;
        stmt = this.conn.prepareStatement("SELECT * FROM prestamo");
        ResultSet rs= stmt.executeQuery();
            
        while(rs.next()){
                
            int idPrestamo = rs.getInt("idPrestamo");
            int idLector = rs.getInt("idLector");
            int idLibro = rs.getInt("idLibro");
            String FechaPrestamo = rs.getString("FechaPrestamo");
            String FechaDevolucion = rs.getString("FechaDevolucion");
            String Devuelto = rs.getString("Devuelto");
                
            Prestamo p= new Prestamo(idPrestamo, idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto);
            
            buffer.add(p);
        }
        }catch (SQLException ex) {
            Logger.getLogger(prestCntrol.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return buffer;
        }
    
        public void CrearReg(int idLector, int idLibro, String FechaDevolucion, String Devuelto) {
        String q = "INSERT INTO prestamo(idLector, idLibro, FechaDevolucion, Devuelto) VALUES(?, ?, ?, ?)";
       
        try {
        PreparedStatement stmt;
        stmt = conn.prepareStatement(q);
        stmt.setInt(1, idLector);
        stmt.setInt(2, idLibro);
        stmt.setString(3, FechaDevolucion);
        stmt.setString(4, Devuelto);
        stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(prestCntrol.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        public void borrarReg(int _id){
            
        String q = "DELETE FROM prestamo WHERE idPrestamo= ?";
        try {
            PreparedStatement stmt;
            stmt= conn.prepareStatement(q);
            stmt.setInt(1, _id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(prestCntrol.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}
