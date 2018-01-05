//Mariana Restani Solís
//Tarea Hilos sincronizados
//Progamación concurrente cliente y servidor

package tareahilossync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TareaHilosSync {

    
    public static void main(String[] args) {
        
        ExecutorService service = Executors.newCachedThreadPool();
        
        RestInterface plato = new RestInterface();
        
        for (int i = 0; i < 1; i++) {
            service.submit(new Cajero(plato));
            
        }
    
        for (int i = 0; i <= 6; i++) {
            service.submit(new Chefs(plato));


        }
        
        for (int i = 0; i <= 10; i++) {
            service.submit(new Camareros(plato));

            
        }
            
        
    }
    
}
