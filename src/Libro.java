public class Libro {

    private int idLibro;
    private String titulo;
    private String autor;
    private String editorial;
    private String fechaPublicacion;
    private String categoria;
    private String estado;
    private int totalPrestamo;

    public Libro(int idLibro, String titulo, String autor, String editorial, String fechaPublicacion, String categoria) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.categoria = categoria;
        this.estado = "Disponible";

    }

    public int getTotalPrestamo() {
        return totalPrestamo;
    }

    public void setTotalPrestamo(int totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idLibro + " - " + titulo + " - " + autor + " - " + estado;
    }
}