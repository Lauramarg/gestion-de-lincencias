package clases;

import java.util.HashMap;
import java.util.Map;

public class LicenciaLimiteDiario extends LicenciaTransaccionesLimitadas {

    private final Integer lDiario;
    private Integer tDiarias;
    private Map<Integer, Integer> tDia;
    private Integer dia;

    public LicenciaLimiteDiario(String email, String servicio, int lTransacciones, int lDiario) {
        super(email, servicio, lTransacciones);
        this.lDiario = lDiario;
        tDiarias = 0;
        tDia = new HashMap<Integer, Integer>();
        dia = 1;
    }

    @Override
    public Transaccion obtenerAutorizacion() {
        if (!revocada && aplicable()) {
            transacciones.add(new Transaccion((this)));
            tRealizadas++;
            tDiarias++;
            tDia.put(dia, tRealizadas);
            return transacciones.get(tRealizadas - 1);
        }
        return null;
    }

    @Override
    public boolean aplicable() {
        if (getTRestantes() > 0 && tDiarias < lDiario) {
            return true;
        }
        return false;
    }

    public void aumentarDia() {
        tDiarias = 0;
        dia++;
    }

    public Integer getTransaccionesRestantesHoy() {
        return lDiario - tDiarias;
    }

    public Integer getTransaccionesDia(Integer dia) {
        return tDia.get(dia);
    }

    @Override
    public String toString() {
        return super.toString() + " LicenciaLimiteDiario{" + "lDiario=" + lDiario + ", tDiarias=" + tDiarias + ", tDia=" + tDia + ", dia=" + dia + '}';
    }

}
