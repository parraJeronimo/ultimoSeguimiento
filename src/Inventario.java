import java.util.ArrayList;

public class Inventario {

    private ArrayList<Libro> libros;

    public Inventario() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(int idLibro, String titulo, String autor, String editorial, String fechaPublicacion, String categoria) {

        Libro nuevo = new Libro(idLibro, titulo, autor, editorial, fechaPublicacion, categoria);

        libros.add(nuevo);
    }

    public Libro buscarPorId(int id) {

        for (Libro libro : libros) {
            if (libro.getIdLibro() == id) {
                return libro;
            }
        }

        return null;
    }

    public void listarDisponibles() {

        boolean hay = false;

        for (Libro libro : libros) {
            if (libro.getEstado().equals("Disponible")) {
                System.out.println(libro);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay libros disponibles.");
        }
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}