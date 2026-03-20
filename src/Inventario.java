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

    public void buscarLibros(String valor) {
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(valor.toLowerCase()) ||
                    libro.getAutor().toLowerCase().contains(valor.toLowerCase()) ||
                    libro.getCategoria().toLowerCase().contains(valor.toLowerCase())) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No existen libros.");
        }
    }

    public void mostrarMasPrestados() {
        libros.sort((a, b) -> b.getTotalPrestamo() - a.getTotalPrestamo());
        int limite = Math.min(3, libros.size());
        System.out.println("Libros más prestados:");
        for (int i = 0; i < limite; i++) {
            System.out.println(libros.get(i));
        }
    }
}