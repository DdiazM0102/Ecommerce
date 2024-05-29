package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Programa implements Subject {

    private List<Usuario> usuarios;
    private List<Producto> productos;
    private List<Observer> observers;

    public Programa() {
        this.usuarios = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.observers = new ArrayList<>();
        agregarProductosAutomaticos();
    }

    private void agregarProductosAutomaticos() {
        for (int i = 1; i <= 10; i++) {
            productos.add(new Producto(i, "Producto " + i, 10.0 * i));
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        registrarObserver(usuario);
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        notificarObservers("Nuevo producto agregado: " + producto.getNombre() + " con precio " + producto.getPrecio());
    }

    public void cambiarPrecioProducto(int idProducto, double nuevoPrecio) {
        Producto producto = getProductoPorId(idProducto);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            notificarObservers("El precio del producto " + producto.getNombre() + " ha cambiado a " + nuevoPrecio);
        }
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

    @Override
    public void registrarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void eliminarObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(String mensaje) {
        for (Observer observer : observers) {
            observer.actualizar(mensaje);
        }
    }
}
