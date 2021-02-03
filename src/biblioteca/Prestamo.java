

package biblioteca;


public class Prestamo {
    
    private int idPrestamo;
    private int idLector;
    private int idLibro;
    private String FechaPrestamo;
    private String FechaDevolucion;
    private String Devuelto;

    public Prestamo(int idPrestamo, int idLector, int idLibro, String FechaPrestamo, String FechaDevolucion, String Devuelto) {
        this.idPrestamo = idPrestamo;
        this.idLector = idLector;
        this.idLibro = idLibro;
        this.FechaPrestamo = FechaPrestamo;
        this.FechaDevolucion = FechaDevolucion;
        this.Devuelto = Devuelto;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public int getIdLector() {
        return idLector;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getFechaPrestamo() {
        return FechaPrestamo;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public String getDevuelto() {
        return Devuelto;
    }
    
    
}
