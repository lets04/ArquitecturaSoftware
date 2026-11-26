import java.time.LocalTime;

class Cita {
    final String paciente;
    final String especialidad;
    final LocalTime hora;

    private Cita(Builder datos) {
        paciente = datos.paciente;
        especialidad = datos.especialidad;
        hora = datos.hora;
    }

    // Builder: reúne los datos antes de construir la cita.
    static class Builder {
        private final String paciente;
        private String especialidad;
        private LocalTime hora;

        Builder(String paciente) {
            this.paciente = paciente.strip();
        }

        Builder especialidad(String especialidad) {
            this.especialidad = especialidad.strip();
            return this;
        }

        Builder hora(LocalTime hora) {
            this.hora = hora;
            return this;
        }

        Cita construir() {
            if (paciente.isEmpty() || especialidad == null
                    || especialidad.isEmpty() || hora == null) {
                throw new IllegalArgumentException("Completa los datos de la cita.");
            }
            return new Cita(this);
        }
    }
}
