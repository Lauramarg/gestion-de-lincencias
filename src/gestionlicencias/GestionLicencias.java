package gestionlicencias;

import clases.Licencia;
import clases.LicenciaLimiteDiario;
import clases.LicenciaTemporal;
import clases.LicenciaTransaccionesLimitadas;
import clases.Transaccion;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestionLicencias {

    public static void main(String[] args) {
        String servicio = "http://api.um.es/disco/v1/";
        String email1 = "juan@um.es";
        String email2 = "pepe@um.es";
        String email3 = "paco@um.es";

        LicenciaTemporal lT = new LicenciaTemporal(email1, servicio, LocalDate.of(2019, 6, 9));
        LicenciaTransaccionesLimitadas lTL = new LicenciaTransaccionesLimitadas(email2, servicio, 3);
        LicenciaLimiteDiario lLD = new LicenciaLimiteDiario(email3, servicio, 4, 1);

        ArrayList<Licencia> licencias = new ArrayList<Licencia>();
        licencias.add(lT);
        licencias.add(lTL);
        licencias.add(lLD);

        for (Licencia l : licencias) {
            System.out.println(l.toString());
            if (l.equals(lLD)) {
                System.out.println("Transacciones restantes para hoy = " + lLD.getTransaccionesRestantesHoy());
            }
        }

        lT.revocar();

        for (Licencia l : licencias) {
            for (int i = 0; i < 4; i++) {
                Transaccion t = l.obtenerAutorizacion();
                if (t != null) {
                    System.out.println(t.toString());
                } else {
                    System.out.println("No autorizada");
                }

            }
        }

        for (Licencia l : licencias) {
            System.out.println(l.toString());

        }
    }

}
