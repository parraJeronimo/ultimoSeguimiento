import java.util.ArrayList;

public class Biblioteca {
    private String name;
    private Inventario inventario;
    private ArrayList<Cliente> clientes;
    public Biblioteca(String name){
        this.name=name;
        this.inventario= new Inventario();
        this.clientes= new ArrayList<>();
    }
}
