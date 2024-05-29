package ecommerce;

public class Efectivo implements Pago {
    @Override
    public void procesarPago(Usuario usuario, Producto producto) {
        System.out.println("Pago procesado en efectivo por el producto " + producto.getNombre());
    }
}
