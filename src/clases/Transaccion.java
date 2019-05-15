package clases;

import java.time.LocalDate;

public class Transaccion {

    private final Licencia licencia;
    private final LocalDate fecha;

    public Transaccion(Licencia licencia) {
        this.licencia = licencia;
        fecha = LocalDate.now();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Codigo=");
        s.append(licencia.codigo);
        s.append(" Email=");
        s.append(licencia.email);
        s.append(" FechaCreacion=");
        s.append(licencia.fechaCreacion);
        s.append(" Revocada=");
        s.append(licencia.revocada);
        s.append(" Servicio=");
        s.append(licencia.servicio);
        s.append(" TRealizadas=");
        s.append(licencia.tRealizadas);

        return "Transaccion{" + /*"licencia " + s +*/ ",fecha=" + fecha + '}';
    }

}
