package ecommerce;

class Mensajero implements Observer {

    private String nombre;

    public Mensajero(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para Mensajero " + nombre + ": " + mensaje);
    }
}
