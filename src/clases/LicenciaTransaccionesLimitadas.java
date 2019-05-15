package clases;

public class LicenciaTransaccionesLimitadas extends Licencia {

    protected final Integer lTransacciones;
    protected Integer tRestantes;

    public LicenciaTransaccionesLimitadas(String email, String servicio, int lTransacciones) {
        super(email, servicio);
        this.lTransacciones = lTransacciones;
        tRestantes = lTransacciones;
    }

    public int getTRestantes() {
        return tRestantes = lTransacciones - tRealizadas;
    }

    @Override
    protected boolean aplicable() {
        if (getTRestantes() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " LicenciaTransaccionesLimitadas{" + "lTransacciones=" + lTransacciones + ", tRestantes=" + tRestantes + '}';
    }

}
