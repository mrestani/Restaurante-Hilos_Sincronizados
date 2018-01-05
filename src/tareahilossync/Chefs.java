
package tareahilossync;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Chefs implements Runnable {

    private RestInterface plato;
    private boolean cocinado = false;

    public Chefs(RestInterface plato) {
        this.plato = plato;
    }

    @Override
    public void run() {
        long coccion=0;
        
        while(Utils.mesa<=5){
            int orden = plato.getPlato();
            if (orden == 1) {
                coccion = 3000;

            } else if (orden == 2) {
                coccion = 5000;
                plato.setOrdenMesa();

            } else if (orden == 3) {
                coccion = 2000;
                plato.setOrdenMesa();

            } else if (orden == 4) {
                coccion = 4000;
                plato.setOrdenMesa();

            } else if (orden == 5) {
                coccion = 6000;
                plato.setOrdenMesa();

            }
            try {
                Thread.sleep(coccion);
                plato.setOrdenMesa();
                System.out.println("Orden lista en mesa");
            } catch (InterruptedException ex) {
                Logger.getLogger(Chefs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Utils.mesa==5){
            plato.ActualizarMesa();
        }

    }
    
    
}
