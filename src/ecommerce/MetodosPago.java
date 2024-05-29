package ecommerce;

class MetodosPago {

    public void pagarConTransferenciaElectronica(Usuario usuario, Producto producto) {
        System.out.println("Usuario " + usuario.getNombre() + " pagó con transferencia electrónica por el producto " + producto.getNombre());
    }

    public void pagarConTarjeta(Usuario usuario, Producto producto) {
        System.out.println("Usuario " + usuario.getNombre() + " pagó con tarjeta por el producto " + producto.getNombre());
    }

    public void pagarConEfectivo(Usuario usuario, Producto producto) {
        System.out.println("Usuario " + usuario.getNombre() + " pagó con efectivo por el producto " + producto.getNombre());
    }
}
