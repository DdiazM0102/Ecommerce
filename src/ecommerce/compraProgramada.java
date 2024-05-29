package ecommerce;

class compraProgramada {

    private Producto producto;
    private String fecha;

    public compraProgramada(Producto producto, String fecha) {
        this.producto = producto;
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public String getFecha() {
        return fecha;
    }
}
