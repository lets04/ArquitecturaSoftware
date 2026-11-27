package datos;

import negocio.Cita;
import negocio.RepositorioCitas;
import java.util.ArrayList;
import java.util.List;

/** guarda la cita en memoria durante la ejecución*/
public class RepositorioCitasEnMemoria implements RepositorioCitas {
    private final List<Cita> citas = new ArrayList<>();

    @Override
    public void guardar(Cita cita) {
        citas.add(cita);
    }
}
