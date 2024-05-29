package ecommerce;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Programa programa = new Programa();
    private static final MetodosPago metodosPago = new MetodosPago();

    public static void main(String[] args) {
        // Crear y registrar observadores adicionales
        Mensajero mensajero = new Mensajero("Carlos");
        programa.registrarObserver(mensajero);

        
        
        int opcion;
        
        System.out.println("Iniciando la aplicacion...");
        
        RegistroActividad.getInstancia().registrarActividad("Inicio de la aplicacion");
        
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    menuCompra();
                    break;
                case 3:
                    apartarProducto();
                    break;
                case 4:
                    hacerDevolucion();
                    break;
                case 5:
                    cambiarPrecioProducto();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú ===");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Comprar producto");
        System.out.println("3. Apartar producto");
        System.out.println("4. Hacer devolución del producto");
        System.out.println("5. Cambiar precio de producto");
        System.out.println("6. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void registrarUsuario() {
        System.out.print("Ingrese ID del usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese email del usuario: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese dirección del usuario: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese teléfono del usuario: ");
        String telefono = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombre, email, direccion, telefono);
        programa.agregarUsuario(usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    private static void menuCompra() {
        int opcionCompra;
        do {
            mostrarMenuCompra();
            opcionCompra = scanner.nextInt();
            scanner.nextLine();

            switch (opcionCompra) {
                case 1:
                    comprarProducto();
                    break;
                case 2:
                    comprarProductoApartado();
                    break;
                case 3:
                    compraProgramada();
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionCompra != 4);
    }

    private static void mostrarMenuCompra() {
        System.out.println("\n=== Menú de Compra ===");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Comprar producto");
        System.out.println("2. Comprar producto apartado");
        System.out.println("3. Compra programada");
        System.out.println("4. Regresar al menú principal");
        System.out.print("Ingrese su opción: ");
    }

    private static void comprarProducto() {
        System.out.println("Productos disponibles:");
        programa.mostrarProductos();

        System.out.print("Ingrese ID del producto a comprar: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine();
        Producto producto = programa.getProductoPorId(idProducto);

        if (producto != null) {
            System.out.print("Ingrese ID del usuario: ");
            int idUsuario = scanner.nextInt();
            scanner.nextLine();
            Usuario usuario = programa.getUsuarioPorId(idUsuario);

            if (usuario != null) {
                usuario.comprarProducto(producto);
                seleccionarMetodoPago(usuario, producto);
                System.out.println("Producto comprado con éxito.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void comprarProductoApartado() {
        System.out.print("Ingrese ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();
        Usuario usuario = programa.getUsuarioPorId(idUsuario);

        if (usuario != null) {
            System.out.println("Productos apartados por el usuario:");
            usuario.mostrarProductosApartados();

            System.out.print("Ingrese ID del producto apartado a comprar: ");
            int idProducto = scanner.nextInt();
            scanner.nextLine();
            Producto producto = programa.getProductoPorId(idProducto);

            if (producto != null) {
                usuario.comprarProducto(producto);
                seleccionarMetodoPago(usuario, producto);
                System.out.println("Producto apartado comprado con éxito.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void compraProgramada() {
        System.out.print("Ingrese ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();
        Usuario usuario = programa.getUsuarioPorId(idUsuario);

        if (usuario != null) {
            System.out.println("Productos disponibles:");
            programa.mostrarProductos();

            System.out.print("Ingrese ID del producto a comprar: ");
            int idProducto = scanner.nextInt();
            scanner.nextLine();
            Producto producto = programa.getProductoPorId(idProducto);

            if (producto != null) {
                System.out.print("Ingrese fecha para realizar la compra (formato AAAA-MM-DD): ");
                String fecha = scanner.nextLine();
                usuario.programarCompra(producto, fecha);
                seleccionarMetodoPago(usuario, producto);
                System.out.println("Compra programada con éxito para la fecha " + fecha);
            } else {
                System.out.println("Producto no encontrado.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void apartarProducto() {
        Usuario usuario = solicitarUsuario();
        if (usuario == null) {
            return;
        }

        System.out.println("Productos disponibles:");
        programa.mostrarProductos();

        System.out.print("Ingrese ID del producto a apartar: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine();
        Producto producto = programa.getProductoPorId(idProducto);

        if (producto != null) {
            usuario.apartarProducto(producto);
            System.out.println("Producto apartado con éxito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void hacerDevolucion() {
    Usuario usuario = solicitarUsuario();
    if (usuario == null) {
        return;
    }

    // Crear una devolución a través del proxy
    Devolucion devolucion = new ProxyDevolucion();

    // Procesar la devolución
    devolucion.procesarDevolucion();

    System.out.println("Estado de la devolución: " + devolucion.obtenerEstado());
}


    private static Usuario solicitarUsuario() {
        System.out.print("Ingrese ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();
        Usuario usuario = programa.getUsuarioPorId(idUsuario);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
        }

        return usuario;
    }

    private static void seleccionarMetodoPago(Usuario usuario, Producto producto) {
    System.out.println("Seleccione el método de pago:");
    System.out.println("1. Transferencia electrónica");
    System.out.println("2. Tarjeta");
    System.out.println("3. Efectivo");
    System.out.print("Ingrese su opción: ");
    int opcionPago = scanner.nextInt();
    scanner.nextLine();

    Pago metodoPago;

    switch (opcionPago) {
        case 1:
            metodoPago = new ValidadorPago(new TransferenciaElectronica());
            break;
        case 2:
            metodoPago = new ValidadorPago(new TarjetaCredito());
            break;
        case 3:
            metodoPago = new ValidadorPago(new Efectivo());
            break;
        default:
            System.out.println("Opción no válida.");
            return;
    }

    metodoPago.procesarPago(usuario, producto);
}


    private static void cambiarPrecioProducto() {
        System.out.print("Ingrese ID del producto: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo precio del producto: ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine();

        programa.cambiarPrecioProducto(idProducto, nuevoPrecio);
    }
}
