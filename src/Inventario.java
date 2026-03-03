import java.util.ArrayList;


public class Inventario {

    private ArrayList<Libro> libros;
    private int idInventario;

    public Inventario() {
        this.libros = new ArrayList<>();

    }

    public void agregarLibro(String titulo, String autor, String editorial, String fechaPublicacion, String categoria) {
        Libro nuevo = new Libro(idInventario, titulo, autor, editorial, fechaPublicacion, categoria);
        libros.add(nuevo);
        idInventario++;
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
            if (libro.getEstado().equals("DISPONIBLE")) {
                System.out.println(libro);
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay libros disponibles.");
    }

    public void listarTodos() {
        if (libros.isEmpty()) {
            System.out.println("El inventario esta vacio.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

}