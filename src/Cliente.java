public class Cliente {
    private String id;
    private String nombre;
    private String numero;
    private String residencia;
    private int libroPedido;

    public Cliente(String id,String nombre, String numero, String residencia,int libroPedido){
    this.id=id;
    this.nombre=nombre;
    this.numero=numero;
    this.residencia=residencia;
    this.libroPedido=libroPedido;
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
    public int getLibroPedido(){
        return libroPedido;
    }
    public void mostrarInfor(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Numero: "+ numero);
        System.out.println("Residencia: "+ residencia);
    }

}
