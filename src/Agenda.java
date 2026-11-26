import java.util.ArrayList;
import java.util.List;

// Observer: la agenda avisa a sus suscriptores después de guardar.
class Agenda {
    private final List<Cita> citas = new ArrayList<>();
    private final List<Observador> observadores = new ArrayList<>();

    void suscribir(Observador observador) {
        observadores.add(observador);
    }

    void guardar(Cita cita) {
        citas.add(cita);
        for (Observador observador : observadores) {
            observador.citaRegistrada(cita);
        }
    }
}
