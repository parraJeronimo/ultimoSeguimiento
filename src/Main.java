import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("LIBROS");
        Inventario inventario = new Inventario();
        Prestamos prestamos = new Prestamos();

        int opcion;
        do {
            System.out.println("\n===== MENU BIBLIOTECA =====");
            System.out.println("1. Registrar libro");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar libros disponibles");
            System.out.println("4. Registrar cliente");
            System.out.println("5. Generar prestamo");
            System.out.println("6. Devolver libro");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Editorial: ");
                    String editorial = sc.nextLine();

                    System.out.print("Fecha publicacion: ");
                    String fecha = sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    inventario.agregarLibro(titulo, autor, editorial, fecha, categoria);
                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:
                    inventario.listarTodos();
                    break;

                case 3:
                    inventario.listarDisponibles();
                    break;

                case 4:
                    System.out.print("ID Cliente: ");
                    String id = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Numero: ");
                    String numero = sc.nextLine();

                    System.out.print("Residencia: ");
                    String residencia = sc.nextLine();

                    Cliente cliente = new Cliente(id, nombre, numero, residencia, false);
                    biblioteca.registrarCliente(cliente);
                    System.out.println("Cliente registrado.");
                    break;

                case 5:
                    System.out.print("ID Libro: ");
                    int idLibro = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID Cliente: ");
                    String idCliente = sc.nextLine();

                    // Debes pasar los clientes al arreglo antes
                    prestamos.configurarPrestamo(
                            biblioteca.getClientes().toArray(new Cliente[0]),
                            inventario
                    );

                    prestamos.generarPrestamo(idLibro, idCliente);
                    break;

                case 6:
                    System.out.print("ID Libro: ");
                    int idDev = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID Cliente: ");
                    String idCliDev = sc.nextLine();

                    prestamos.devolverLibro(idDev, idCliDev);
                    break;

                case 0:
                    System.out.println("FIN");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}