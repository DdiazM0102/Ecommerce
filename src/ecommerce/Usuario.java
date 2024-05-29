package ecommerce;

import java.util.ArrayList;
import java.util.List;

class Usuario {

    private int id;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private List<Producto> productosApartados;
    private List<compraProgramada> comprasProgramadas;

    public Usuario(int id, String nombre, String email, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.productosApartados = new ArrayList<>();
        this.comprasProgramadas = new ArrayList<>();
    }

    public void comprarProducto(Producto producto) {
        System.out.println("Usuario " + nombre + " compró el producto " + producto.getNombre());
    }

    public void apartarProducto(Producto producto) {
        productosApartados.add(producto);
        System.out.println("Usuario " + nombre + " apartó el producto " + producto.getNombre());
    }

    public void devolverProducto(Producto producto) {
        System.out.println("Usuario " + nombre + " devolvió el producto " + producto.getNombre());
    }

    public void programarCompra(Producto producto, String fecha) {
        comprasProgramadas.add(new compraProgramada(producto, fecha));
        System.out.println("Usuario " + nombre + " ha programado la compra del producto " + producto.getNombre() + " para la fecha " + fecha);
    }

    public void mostrarProductosApartados() {
        if (productosApartados.isEmpty()) {
            System.out.println("No hay productos apartados.");
        } else {
            for (Producto producto : productosApartados) {
                System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
