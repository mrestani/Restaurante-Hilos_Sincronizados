
package tareahilossync;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Camareros implements Runnable {

    private final RestInterface plato;

    public Camareros(RestInterface plato) {
        this.plato = plato;
    }

    @Override
    public void run() {
        
        
        while(Utils.mesa<=5){
            
            try {
                plato.getPlato();
                Thread.sleep((int)(Math.random()*2000+6000));
                Utils.mesa=Utils.platos-1;
                if(Utils.mesa==5 && plato.getPlato()==0){
                    System.out.println("Camarero esperando orden.");
                } else {
                    plato.ActualizarMesa();
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Camareros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
