package negocio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Reservas {
    private final RepositorioCitas repositorio;
    private final List<ObservadorReserva> observadores = new ArrayList<>();

   
    public Reservas(RepositorioCitas repositorio) {
        this.repositorio = repositorio;
    }

    public void suscribir(ObservadorReserva observador) {
        observadores.add(observador);
    }

    public List<String> especialidades() {
        return List.of("Odontología", "Pediatría", "Medicina general");
    }

    public List<String> medicosDe(String especialidad) {
        switch (especialidad) {
            case "Odontología": return List.of("Dra. Rojas", "Dr. Vargas");
            case "Pediatría": return List.of("Dra. Molina", "Dr. Flores");
            case "Medicina general": return List.of("Dr. Quispe", "Dra. Salazar");
            default: throw new IllegalArgumentException("Especialidad inválida.");
        }
    }

    public void reservar(String paciente, String especialidad, String medico, String hora) {
        if (!medicosDe(especialidad).contains(medico)) {
            throw new IllegalArgumentException("El médico no pertenece a la especialidad.");
        }
        Cita cita = new Cita.Builder(paciente)
                .especialidad(especialidad)
                .medico(medico)
                .hora(LocalTime.parse(hora.strip()))
                .construir();

        repositorio.guardar(cita);

        for (ObservadorReserva observador : observadores) {
            observador.citaRegistrada(cita);
        }
    }
}
