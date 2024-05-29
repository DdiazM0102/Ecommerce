package ecommerce;

import java.util.ArrayList;
import java.util.List;

class Programa {

    private List<Usuario> usuarios;
    private List<Producto> productos;

    public Programa() {
        this.usuarios = new ArrayList<>();
        this.productos = new ArrayList<>();
        agregarProductosAutomaticos();
    }

    private void agregarProductosAutomaticos() {
        for (int i = 1; i <= 10; i++) {
            productos.add(new Producto(i, "Producto " + i, 10.0 * i));
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Usuario getUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Producto getProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
    }
}
