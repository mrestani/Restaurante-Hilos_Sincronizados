
package tareahilossync;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Cajero implements Runnable {
    
    private final RestInterface plato;

    public Cajero(RestInterface plato) {
        this.plato = plato;
    }
    

    @Override
    public void run() {
        
        try {
            plato.getPlato();
            Thread.sleep((int)(Math.random()*1000));

        } catch (InterruptedException ex) {
            Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
