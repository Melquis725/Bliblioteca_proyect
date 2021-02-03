
package biblioteca;

import java.sql.*;


public class Biblioteca {

   
    public static void main(String[] args) {
        
        BibliotecaDB db= new BibliotecaDB();
        Connection conn= db.getConnection();
        
        
        // Ingresar Estudiante 
        Estudiante e= new Estudiante(conn);
        /*
        e.NewEstudiante("Winston Javier", "Informatica", 82726252);
        
        System.out.println("Estudiante Agregado !");*/
        
        
        
        
        // Ingresar Libro
        Libro b= new Libro(conn);
        /*
        b.NewLibro("Teorema de Firulais", "Algebra");
        
        System.out.println("Libro Agreagado !");*/
        
        
        
        
        // Gestion Registros
        prestCntrol p= new prestCntrol(conn);
        
        //p.CrearReg(2, 3, "2021-03-05", "No");
        
       p.getRegistros(3);
        
        //p.borrarReg(4);
        
        //System.out.println("Registro Creado !");
        
        
        
        // ArryList 
        /*for(Prestamo pres: p.getListReg()){
            
            System.out.println(pres.getIdPrestamo());
            System.out.println(pres.getIdLector());
            System.out.println(pres.getIdLibro());
            
        }*/

    }
}
