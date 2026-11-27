package negocio;

import java.time.LocalTime;

/** Representa una cita médica. */
public class Cita {
    private final String paciente;
    private final String especialidad;
    private final String medico;
    private final LocalTime hora;

    private Cita(Builder datos) {
        paciente = datos.paciente;
        especialidad = datos.especialidad;
        medico = datos.medico;
        hora = datos.hora;
    }

    public String getPaciente() { return paciente; }

    public String getEspecialidad() { return especialidad; }

    public String getMedico() { return medico; }

    public LocalTime getHora() { return hora; }

    /** Builder: reúne y valida los datos antes de crear la cita. */
    public static class Builder {
        private final String paciente;
        private String especialidad = "";
        private String medico = "";
        private LocalTime hora;

        public Builder(String paciente) {
            this.paciente = paciente.strip();
        }

        public Builder especialidad(String especialidad) {
            this.especialidad = especialidad.strip();
            return this;
        }

        public Builder medico(String medico) {
            this.medico = medico.strip();
            return this;
        }

        public Builder hora(LocalTime hora) {
            this.hora = hora;
            return this;
        }

        public Cita construir() {
            if (paciente.isEmpty() || especialidad.isEmpty()
                    || medico.isEmpty() || hora == null) {
                throw new IllegalArgumentException("Completa los datos de la cita.");
            }
            return new Cita(this);
        }
    }
}
