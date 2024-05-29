package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class RegistroActividad {
    private static RegistroActividad instancia;
    private List<String> registro;

    private RegistroActividad() {
        registro = new ArrayList<>();
    }

    public static RegistroActividad getInstancia() {
        if (instancia == null) {
            instancia = new RegistroActividad();
        }
        return instancia;
    }

    public void registrarActividad(String actividad) {
        registro.add(actividad);
        System.out.println("Actividad registrada: " + actividad);
    }

    public void mostrarRegistro() {
        System.out.println("=== Registro de Actividad ===");
        for (String actividad : registro) {
            System.out.println(actividad);
        }
        System.out.println("=============================");
    }
}
