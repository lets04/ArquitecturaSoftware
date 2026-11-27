package presentacion;

import datos.RepositorioCitasEnMemoria;
import negocio.Reservas;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/** Presentación: lee los datos y muestra el resultado. */
public class Main {
    public static void main(String[] args) {
        Reservas reservas = new Reservas(new RepositorioCitasEnMemoria());
        // Observer: la consola se suscribe a la confirmación.
        reservas.suscribir(cita -> System.out.printf(
                "%s, tu cita de %s con %s quedó reservada para las %s.%n",
                cita.getPaciente(), cita.getEspecialidad(),
                cita.getMedico(), cita.getHora()));

        try (Scanner consola = new Scanner(System.in)) {
            System.out.print("Paciente: ");
            String paciente = consola.nextLine();
            List<String> especialidades = reservas.especialidades();
            String especialidad = elegir(consola, "Especialidades", especialidades);
            String medico = elegir(consola, "Médicos disponibles",
                    reservas.medicosDe(especialidad));
            System.out.print("Hora (HH:mm): ");
            reservas.reservar(paciente, especialidad, medico, consola.nextLine());
        } catch (DateTimeParseException error) {
            System.out.println("Escribe una hora válida, por ejemplo 09:30.");
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

    /** Repite el menú hasta recibir un número válido. */
    private static String elegir(Scanner consola, String titulo, List<String> opciones) {
        System.out.println(titulo);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, opciones.get(i));
        }
        while (true) {
            System.out.print("Elige un número: ");
            if (!consola.hasNextLine()) {
                throw new IllegalArgumentException("Selección cancelada.");
            }
            try {
                int opcion = Integer.parseInt(consola.nextLine().strip());
                if (opcion >= 1 && opcion <= opciones.size()) {
                    return opciones.get(opcion - 1);
                }
            } catch (NumberFormatException error) {
                // La entrada se trata igual que un número fuera de rango.
            }
            System.out.println("Opción inválida. Intenta otra vez.");
        }
    }
}
