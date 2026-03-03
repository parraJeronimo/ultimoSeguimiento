import java.util.ArrayList;

public class Biblioteca {
    private String name;
    private Inventario inventario;
    private ArrayList<Cliente> clientes;

    public Biblioteca(String name) {
        this.name = name;
        this.inventario = new Inventario();
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

}

