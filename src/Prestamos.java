public class Prestamos {
    private Cliente [] cliente;
    private Inventario inventario;

    public void configurarPrestamo(Cliente[] cl,Inventario inv){
        this.cliente=cl;
        this.inventario=inv;
    }
    public void generarPrestamo(int idLibro, String idCliente){
        for(int i=0; i<cliente.length;i++){
            if(cliente[i].getId().equals(idCliente)){
                for(int l=0;l<inventario.getLibros().size();l++) {
                    if(inventario.getLibros().get(l).getIdLibro() ==idLibro) {
                        if (inventario.getLibros().get(l).getEstado().equals("Disponible")) {
                            inventario.getLibros().get(l).setEstado("No disponible");
                            cliente[i].setLibroPedido(true);
                            System.out.println("Se genero el prestamo");
                        }
                        System.out.println("el libro no esta disponible");
                    }
                    System.out.println("no se encontro el libro");
                }
            }
            System.out.println("No se encontro el cliente");
        }
    }

    public void devolverLibro(int idLibro,String idCliente){
        for (int i=0; i<cliente.length;i++){
            if (cliente[i].getId().equals(idCliente)){
                for (int h=0;h<inventario.getLibros().size();h++){
                    if (inventario.getLibros().get(h).getIdLibro()==idLibro){
                        if (inventario.getLibros().get(h).getEstado().equals("No disponible")){
                            inventario.getLibros().get(h).setEstado("Disponible");
                            cliente[i].setLibroPedido(false);
                            System.out.println("Libro devuelto con exito");
                        }
                        System.out.println("El libro ya estaba disponible");
                    }
                }
            }
            System.out.println("El cliente no se encuentra");
        }
    }
}
