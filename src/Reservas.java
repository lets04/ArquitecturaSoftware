import java.time.LocalTime;

// Facade: una llamada arma la cita y la registra en la agenda.
class Reservas {
    private final Agenda agenda = new Agenda();

    void alReservar(Observador observador) {
        agenda.suscribir(observador);
    }

    void reservar(String paciente, String especialidad, String hora) {
        Cita cita = new Cita.Builder(paciente).especialidad(especialidad)
                .hora(LocalTime.parse(hora.strip())).construir();
        agenda.guardar(cita);
    }
}
