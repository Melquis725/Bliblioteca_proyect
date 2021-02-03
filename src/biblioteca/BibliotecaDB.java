
package biblioteca;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BibliotecaDB {

    private String connString =  "jdbc:mysql://localhost:3306/biblioteca";
    private String User = "root";
    private String passwrd = "";
    
    private Connection conn;
    
    public Connection getConnection(){
        return conn;
    }
    
    public BibliotecaDB(){
        try {
            this.conn = DriverManager.getConnection(this.connString, this.User, this.passwrd);
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
