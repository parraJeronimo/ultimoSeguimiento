import java.io.*;
import java.util.ArrayList;

public class Persistencias {

    // ================= LIBROS =================
    public static void guardarLibros(ArrayList<Libro> libros) {

        try (PrintWriter pw = new PrintWriter(new FileWriter("libros.txt"))) {

            for (Libro l : libros) {
                pw.println(
                        l.getIdLibro() + "," +
                                l.getTitulo() + "," +
                                l.getAutor() + "," +
                                l.getCategoria() + "," +
                                l.getEstado() + "," +
                                l.getTotalPrestamo()
                );
            }

        } catch (IOException e) {
            System.out.println("Error guardando libros");
        }
    }

    public static ArrayList<Libro> cargarLibros() {

        ArrayList<Libro> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/libros.txt"))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                Libro l = new Libro(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        "", "",
                        datos[3]
                );

                l.setEstado(datos[4]);
                l.setTotalPrestamo(Integer.parseInt(datos[5]));

                lista.add(l);
            }

        } catch (IOException e) {
            System.out.println("No hay archivo de libros aún.");
        }

        return lista;
    }

    // ================= CLIENTES =================
    public static void guardarClientes(ArrayList<Cliente> clientes) {

        try (PrintWriter pw = new PrintWriter(new FileWriter("clientes.txt"))) {

            for (Cliente c : clientes) {
                pw.println(
                        c.getId() + "," +
                                c.getNombre() + "," +
                                c.getNumero() + "," +
                                c.getResidencia() + "," +
                                c.getMulta()
                );
            }

        } catch (IOException e) {
            System.out.println("Error guardando clientes");
        }
    }

    public static ArrayList<Cliente> cargarClientes() {

        ArrayList<Cliente> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/clientes.txt"))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] d = linea.split(",");

                Cliente c = new Cliente(d[0], d[1], d[2], d[3], false);
                c.agregarMulta(Double.parseDouble(d[4]));

                lista.add(c);
            }

        } catch (IOException e) {
            System.out.println("No hay archivo de clientes aún.");
        }

        return lista;
    }

    // ================= PRESTAMOS =================
    public static void guardarPrestamos(ArrayList<Prestamo> prestamos) {

        try (PrintWriter pw = new PrintWriter(new FileWriter("prestamos.txt"))) {

            for (Prestamo p : prestamos) {
                pw.println(
                        p.getIdLibro() + "," +
                                p.getIdCliente() + "," +
                                p.getFechaLimite()
                );
            }

        } catch (IOException e) {
            System.out.println("Error guardando prestamos");
        }
    }

    public static ArrayList<Prestamo> cargarPrestamos() {

        ArrayList<Prestamo> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/prestamos.txt"))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] d = linea.split(",");

                Prestamo p = new Prestamo(
                        Integer.parseInt(d[0]),
                        d[1]
                );

                lista.add(p);
            }

        } catch (IOException e) {
            System.out.println("No hay archivo de prestamos aún.");
        }

        return lista;
    }
}