package negocio;

/** Observer: recibe el aviso de que se guardó una cita. */
public interface ObservadorReserva {
    void citaRegistrada(Cita cita);
}
