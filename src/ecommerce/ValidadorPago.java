package ecommerce;

public class ValidadorPago implements Pago {
    private Pago pago;

    public ValidadorPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public void procesarPago(Usuario usuario, Producto producto) {
        if (validarPago(usuario, producto)) {
            pago.procesarPago(usuario, producto);
        } else {
            System.out.println("El pago no pudo ser procesado. Método de pago no válido.");
        }
    }

    private boolean validarPago(Usuario usuario, Producto producto) {
        // Lógica de validación de pago
        return true; // Por simplicidad, siempre devuelve true en este ejemplo
    }
}
