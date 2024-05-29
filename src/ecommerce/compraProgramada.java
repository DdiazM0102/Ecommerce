package ecommerce;

class CompraProgramada {

    private Producto producto;
    private String fecha;

    public CompraProgramada(Producto producto, String fecha) {
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
