package ecommerce;

public class TransferenciaElectronica implements Pago {
    @Override
    public void procesarPago(Usuario usuario, Producto producto) {
        System.out.println("Pago procesado con transferencia electrónica por el producto " + producto.getNombre());
    }
}
