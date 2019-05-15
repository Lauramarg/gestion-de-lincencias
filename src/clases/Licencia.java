package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Licencia {

    protected final String email;
    protected final LocalDate fechaCreacion;
    protected final String codigo;
    protected ArrayList<Transaccion> transacciones;
    protected Integer tRealizadas;
    protected boolean revocada;
    protected final String servicio;

    public Licencia(String email, String servicio) {
        this.email = email;
        this.servicio = servicio;
        fechaCreacion = LocalDate.now();
        codigo = UUID.randomUUID().toString();
        transacciones = new ArrayList<Transaccion>();
        tRealizadas = 0;
        revocada = false;
    }

    public boolean revocar() {
        return revocada = true;
    }

    protected abstract boolean aplicable();

    public Transaccion obtenerAutorizacion() {
        if (!revocada && aplicable()) {
            transacciones.add(new Transaccion((this)));
            tRealizadas++;
            return transacciones.get(tRealizadas - 1);
        }
        return null;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Licencia{" + "email=" + email + ", fechaCreacion=" + fechaCreacion + ", codigo=" + codigo + ", transacciones=" + transacciones + ", tRealizadas=" + tRealizadas + ", revocada=" + revocada + ", servicio=" + servicio + '}';
    }

}
