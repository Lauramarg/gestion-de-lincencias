package clases;

import java.time.LocalDate;

public class LicenciaTemporal extends Licencia {

    private LocalDate fechaCaducidad;
    private boolean caducada;

    public LicenciaTemporal(String email, String servicio, LocalDate fechaCaducidad) {
        super(email, servicio);
        this.fechaCaducidad = fechaCaducidad;
        if (fechaCreacion.isAfter(fechaCaducidad)) {
            caducada = true;
        } else {
            caducada = false;
        }
    }

    public LicenciaTemporal(String email, String servicio) {
        super(email, servicio);
        fechaCaducidad = fechaCreacion.plusMonths(3);
        if (fechaCreacion.isAfter(fechaCaducidad)) {
            caducada = true;
        } else {
            caducada = false;
        }
    }

    public void extenderCaducidad(int meses) {
        fechaCaducidad = fechaCaducidad.plusMonths(meses);
        if (fechaCreacion.isAfter(fechaCaducidad)) {
            caducada = true;
        } else {
            caducada = false;
        }
    }

    @Override
    protected boolean aplicable() {
        if (!caducada) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " LicenciaTemporal{" + "fechaCaducidad=" + fechaCaducidad + ", caducada=" + caducada + '}';
    }

}
