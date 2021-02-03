/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melquis
 */
public class Libro {
    
    int idLibro;
    String Titulo;
    String Area;
    
    public Connection conn;
    public Libro(Connection conn){
        this.conn= conn;
    }
    
    public Libro(int idLibro, String Titulo, String Area){
        this.idLibro= idLibro;
        this.Titulo= Titulo;
        this.Area= Area;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getArea() {
        return Area;
    }
    
    public void NewLibro(String Titulo, String Area) {
        String q = "INSERT INTO libro(Titulo, Area) VALUES(?, ?)";
       
        try {
        PreparedStatement stmt;
        stmt = conn.prepareStatement(q);
        stmt.setString(1, Titulo);
        stmt.setString(2, Area);
        stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
