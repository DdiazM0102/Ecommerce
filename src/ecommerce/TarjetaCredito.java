package ecommerce;

public class TarjetaCredito implements Pago {
    @Override
    public void procesarPago(Usuario usuario, Producto producto) {
        System.out.println("Pago procesado con tarjeta de crédito por el producto " + producto.getNombre());
    }
}
