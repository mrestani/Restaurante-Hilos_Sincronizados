
package tareahilossync;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marianarestani
 */
public class RestInterface {
    
    private boolean cocinado = false;
    
    
    public synchronized int getPlato(){
        String ord = "";
        
            String msj = JOptionPane.showInputDialog("Digite orden del plato: \n1.Hamburguesa \n2.Chalupas \n3.Papas fritas \n4.Perros calientes \n5.Casado \n6.Salir");
            int platos = Integer.parseInt(msj);
            
            switch(platos){
                
                case 1:
                    ord = "Hamburguesa";
                    System.out.println(ord +" en preparación");
                    break;
                case 2:
                    ord = "Chalupas";
                    System.out.println(ord +" en preparación");
                    break;
                case 3:
                    ord = "Papas fritas";
                    System.out.println(ord +" en preparación");
                    break;
                case 4:
                    ord = "Perros calientes";
                    System.out.println(ord +" en preparación");
                    break;
                case 5:
                    ord = "Casados";
                    System.out.println(ord +" en preparación");
                    break;
                default:
                    System.out.println("Fin");
  
        }

        Utils.platos++;
        cocinado = false;
        return Utils.mesa;
    }

    
    
    public synchronized void setOrdenMesa(){
        
        while(cocinado && Utils.platos <= 5){
            try {
                wait();
                System.out.println("Esperando orden de la cocina");
            } catch (InterruptedException ex) {
                Logger.getLogger(RestInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        cocinado = true;
        Utils.mesa = 1 + Utils.platos;
        notify();
        
        if(Utils.mesa==5){
            System.out.println("Mesa llena.");
        }
        
    }
    
    public synchronized void ActualizarMesa(){
        
        while(Utils.mesa==5 && !cocinado){
            try {
                wait();
                System.out.println("Mesa llena.");
            } catch (InterruptedException ex) {
                Logger.getLogger(RestInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Utils.mesa = Utils.platos-1;
        cocinado=false;
        System.out.println("Orden entregado a cliente.");
        notify();
    }
}
