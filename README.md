# Reserva de citas médicas

**Actividad 10**  
**Estudiante:** Leticia Brenda Loredo Salazar  

## Descripción

Desarrollé un programa en Java que permite reservar una cita médica desde la consola. El usuario escribe su nombre, la especialidad y la hora. Si los datos son válidos, la cita se guarda en memoria y el programa muestra una confirmación.

El programa registra una cita por ejecución. La información se conserva mientras el programa está abierto.

## Patrones de diseño

| Patrón | Categoría | Cómo lo usé |
| --- | --- | --- |
| Builder | Creacional | En `Cita.java`, `Cita.Builder` reúne los datos. Los métodos `especialidad()` y `hora()` completan la información y `construir()` la valida antes de crear la cita. |
| Facade | Estructural | En `Reservas.java`, el método `reservar()` construye la cita y la envía a la agenda. Desde `Main` puedo completar la reserva con una sola llamada. |
| Observer | De comportamiento | En `Agenda.java`, después de guardar la cita se llama a `citaRegistrada()`. El observador que configuré en `Main` muestra el mensaje de confirmación. |

## Estructura del proyecto

| Archivo | Responsabilidad |
| --- | --- |
| `src/Main.java` | Lee los datos y muestra el resultado en consola. |
| `src/Cita.java` | Representa la cita y contiene el Builder. |
| `src/Reservas.java` | Coordina la reserva. |
| `src/Agenda.java` | Guarda la cita y avisa a los observadores. |
| `src/Observador.java` | Define el método `citaRegistrada()`. |

## Cómo ejecutar

Necesitas **JDK 11 o superior**. Abre la terminal en la carpeta que contiene `src/` y ejecuta:

```bash
javac -encoding UTF-8 -d out -sourcepath src src/Main.java
java -cp out Main
```

## Ejemplo de ejecución

```text
Paciente: Luciana
Especialidad: Odontología
Hora (HH:mm): 09:30
Luciana, tu cita de Odontología quedó reservada para las 09:30.
```