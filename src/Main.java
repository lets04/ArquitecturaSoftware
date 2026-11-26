import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reservas reservas = new Reservas();
        reservas.alReservar(cita -> System.out.printf(
                "%s, tu cita de %s quedó reservada para las %s.%n",
                cita.paciente, cita.especialidad, cita.hora));

        try (Scanner consola = new Scanner(System.in)) {
            System.out.print("Paciente: ");
            String paciente = consola.nextLine();
            System.out.print("Especialidad: ");
            String especialidad = consola.nextLine();
            System.out.print("Hora (HH:mm): ");
            reservas.reservar(paciente, especialidad, consola.nextLine());
        } catch (DateTimeParseException error) {
            System.out.println("Escribe una hora válida en formato HH:mm.");
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
