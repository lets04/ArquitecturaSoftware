# Reserva de citas médicas con arquitectura de tres capas

**Actividad 11**  
**Estudiante:** Leticia Brenda Loredo Salazar  

## Descripción

Para esta actividad retomé el sistema de reservas médicas de la Actividad 10. Agregué un menú numerado para seleccionar la especialidad y un segundo menú que muestra los médicos de esa especialidad. Después, el usuario ingresa la hora y el sistema confirma la cita.

Si el usuario escribe una letra o un número fuera del rango del menú, el programa le pide que elija otra vez. Las citas se guardan en memoria durante la ejecución.

## Arquitectura del proyecto

| Capa | Archivos | Responsabilidad |
| --- | --- | --- |
| Presentación | `src/presentacion/Main.java` | Muestra los menús, lee las opciones y presenta la confirmación o el mensaje de error. |
| Negocio | `src/negocio/Cita.java`, `Reservas.java`, `RepositorioCitas.java` y `ObservadorReserva.java` | Verifica que el médico pertenezca a la especialidad, construye la cita y coordina el guardado y la confirmación. |
| Datos | `src/datos/RepositorioCitasEnMemoria.java` | Implementa el guardado de citas en una lista. |

`Main` conecta el repositorio en memoria con `Reservas`. Para guardar una cita, `Reservas` usa la interfaz `RepositorioCitas`.

## Patrones de diseño

- **Builder (creacional).** Uso `Cita.Builder` para reunir los datos del paciente, la especialidad, el médico y la hora. El método `construir()` comprueba que estén completos.
- **Facade (estructural).** `Reservas` ofrece `especialidades()`, `medicosDe()` y `reservar()`. Desde la consola puedo consultar las opciones y solicitar una reserva a través de esa clase.
- **Observer (de comportamiento).** `Main` registra la acción de confirmación con `suscribir()`. Cuando termina el guardado, `Reservas` llama a `citaRegistrada()` y se muestra el mensaje.

## Principios SOLID

| Principio | Aplicación en el proyecto |
| --- | --- |
| Responsabilidad única | La consola, las reglas de reserva y el almacenamiento tienen responsabilidades separadas. |
| Abierto/cerrado | Puedo agregar otro aviso mediante `suscribir()` sin editar `reservar()`. |
| Sustitución de Liskov | `Reservas` puede trabajar con otra implementación de `RepositorioCitas` si esta cumple el contrato de `guardar()`. |
| Segregación de interfaces | `RepositorioCitas` define el guardado y `ObservadorReserva` define el aviso. Cada interfaz tiene una operación concreta. |
| Inversión de dependencias | `Reservas` recibe la interfaz `RepositorioCitas` en su constructor. `Main` elige la implementación en memoria. |

## Cómo ejecutar

Necesitas **JDK 11 o superior**. Abre la terminal en la carpeta que contiene `src/` y ejecuta:

```bash
javac -encoding UTF-8 -d out -sourcepath src src/presentacion/Main.java
java -cp out presentacion.Main
```

## Ejemplo de ejecución

```text
Paciente: Luciana
Especialidades
1. Odontología
2. Pediatría
3. Medicina general
Elige un número: 1
Médicos disponibles
1. Dra. Rojas
2. Dr. Vargas
Elige un número: 1
Hora (HH:mm): 09:30
Ana, tu cita de Odontología con Dra. Rojas quedó reservada para las 09:30.
```

Para probar la validación del menú, ingresa `9` en la lista de especialidades. El programa debe mostrar «Opción inválida. Intenta otra vez.» y volver a pedir el número.