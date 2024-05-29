package ecommerce;

import java.util.List;

public interface Subject {
    
    void registrarObserver(Observer observer);
    void eliminarObserver(Observer observer);
    void notificarObservers(String mensaje);
}
