import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamos {

    private Cliente[] cliente;
    private Inventario inventario;

    private ArrayList<Prestamo> prestamosLista = new ArrayList<>();

    public void configurarPrestamo(Cliente[] cl, Inventario inv) {
        this.cliente = cl;
        this.inventario = inv;
    }

    public void generarPrestamo(int idLibro, String idCliente) {

        boolean clienteEncontrado = false;
        boolean libroEncontrado = false;

        for (int i = 0; i < cliente.length; i++) {

            if (cliente[i].getId().equals(idCliente)) {

                clienteEncontrado = true;

                for (int l = 0; l < inventario.getLibros().size(); l++) {

                    if (inventario.getLibros().get(l).getIdLibro() == idLibro) {

                        libroEncontrado = true;

                        if (inventario.getLibros().get(l).getEstado().equals("Disponible")) {
                            inventario.getLibros().get(l).setEstado("No disponible");

                            inventario.getLibros().get(l).setTotalPrestamo(
                                    inventario.getLibros().get(l).getTotalPrestamo() + 1
                            );

                            cliente[i].setLibroPedido(true);

                            Prestamo nuevo = new Prestamo(idLibro, idCliente);
                            prestamosLista.add(nuevo);

                            System.out.println("Se genero el prestamo");
                            System.out.println("Fecha limite: " + nuevo.getFechaLimite());

                            return;

                        } else {
                            System.out.println("El libro no esta disponible");
                            return;
                        }
                    }
                }

                if (!libroEncontrado) {
                    System.out.println("No se encontro el libro");
                }

                return;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("No se encontro el cliente");
        }
    }

    public void devolverLibro(int idLibro, String idCliente) {

        boolean clienteEncontrado = false;
        boolean libroEncontrado = false;

        for (int i = 0; i < cliente.length; i++) {

            if (cliente[i].getId().equals(idCliente)) {

                clienteEncontrado = true;

                for (int h = 0; h < inventario.getLibros().size(); h++) {

                    if (inventario.getLibros().get(h).getIdLibro() == idLibro) {

                        libroEncontrado = true;

                        if (inventario.getLibros().get(h).getEstado().equals("No disponible")) {

                            for (int p = 0; p < prestamosLista.size(); p++) {

                                if (prestamosLista.get(p).getIdLibro() == idLibro &&
                                        prestamosLista.get(p).getIdCliente().equals(idCliente)) {

                                    LocalDate hoy = LocalDate.now();

                                    if (hoy.isAfter(prestamosLista.get(p).getFechaLimite())) {

                                        long dias = ChronoUnit.DAYS.between(
                                                prestamosLista.get(p).getFechaLimite(), hoy
                                        );

                                        double multa = dias * 1000;

                                        cliente[i].agregarMulta(multa);

                                        System.out.println("Multa generada: $" + multa);
                                    }

                                    prestamosLista.remove(p);
                                    break;
                                }
                            }

                            inventario.getLibros().get(h).setEstado("Disponible");
                            cliente[i].setLibroPedido(false);

                            System.out.println("Libro devuelto con exito");
                            return;

                        } else {
                            System.out.println("El libro ya estaba disponible");
                            return;
                        }
                    }
                }

                if (!libroEncontrado) {
                    System.out.println("No se encontro el libro");
                }

                return;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("El cliente no se encuentra");
        }
    }
    public ArrayList<Prestamo> getPrestamosLista() {
        return prestamosLista;
    }
}