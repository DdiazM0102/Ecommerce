package ecommerce;

public class DevolucionReal implements Devolucion {
    private String estado;

    public DevolucionReal() {
        this.estado = "Pendiente";
    }

    @Override
    public void procesarDevolucion() {
        // Lógica para procesar la devolución
        this.estado = "Procesada";
    }

    @Override
    public String obtenerEstado() {
        return estado;
    }
}
