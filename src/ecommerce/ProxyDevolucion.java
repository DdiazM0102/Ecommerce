package ecommerce;

public class ProxyDevolucion implements Devolucion {
    private DevolucionReal devolucionReal;

    public ProxyDevolucion() {
        this.devolucionReal = new DevolucionReal();
    }

    @Override
    public void procesarDevolucion() {
        if (puedeProcesarDevolucion()) {
            devolucionReal.procesarDevolucion();
        } else {
            System.out.println("No se puede procesar la devolución en este estado.");
        }
    }

    @Override
    public String obtenerEstado() {
        return devolucionReal.obtenerEstado();
    }

    private boolean puedeProcesarDevolucion() {
        // Lógica para verificar si la devolución se puede procesar en el estado actual
        return devolucionReal.obtenerEstado().equals("Pendiente");
    }
}
