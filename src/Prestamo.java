import java.time.LocalDate;

public class Prestamo {

    private int idLibro;
    private String idCliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;

    public Prestamo(int idLibro, String idCliente) {
        this.idLibro = idLibro;
        this.idCliente = idCliente;
        this.fechaPrestamo = LocalDate.now();
        this.fechaLimite = fechaPrestamo.plusDays(7);
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
}