# Ejemplo de la Actividad 10
## Reserva de una cita médica

Usa Java 11 y se ejecuta en consola con una cita por ejecución. La agenda se guarda en memoria.

## Ejecutar

Con el JDK 11 o superior, abre una terminal en la carpeta que contiene `src/`:

```bash
javac -encoding UTF-8 -d out -sourcepath src src/Main.java
java -cp out Main
```

Ingresa `Luciana`, `Odontología` y `09:30`. La consola muestra «Ana, tu cita de Odontología quedó reservada para las 09:30».

## Patrones

- **Builder** reúne los datos y construye la cita.
- **Facade** coordina la creación de la cita y su registro en la agenda.
- **Observer** muestra el aviso cuando la agenda termina de guardar la cita.

## Estructura del proyecto

- `src/Main.java` lee los datos e imprime la confirmación.
- `src/Cita.java` contiene la cita y su Builder.
- `src/Reservas.java` contiene la fachada.
- `src/Agenda.java` guarda las citas y avisa a los observadores.
- `src/Observador.java` define el método de aviso.
