public class Cliente {
    private String id;
    private String nombre;
    private String numero;
    private String residencia;
    private boolean libroPedido;
    private double multa;

    public Cliente(String id,String nombre, String numero, String residencia,boolean libroPedido){
    this.id=id;
    this.nombre=nombre;
    this.numero=numero;
    this.residencia=residencia;
    this.libroPedido=libroPedido;
    this.multa=0;
    }
    public String getId() {
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getNumero(){
        return numero;
    }
    public String getResidencia(){
        return residencia;
    }
    public boolean getLibroPedido(){
        return libroPedido;
    }

    public void setLibroPedido(boolean libroPedido) {
        this.libroPedido = libroPedido;
    }

    public void mostrarInfor(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Numero: "+ numero);
        System.out.println("Residencia: "+ residencia);
    }
    public double getMulta(){
        return multa;
    }

    public void agregarMulta(double valor) {
        multa+= valor;
    }
}