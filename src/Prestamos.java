public class Prestamos {
    private Cliente cliente;
    private Inventario inventario;
    private String fechaPrestamo;

    public void generarPrestamo(){

    }
    public void actualizarPrestamo(Cliente cl,Inventario inv){
        this.cliente=cl;
        this.inventario=inv;
    }
}
