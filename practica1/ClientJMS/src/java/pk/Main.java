/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import static java.time.Clock.system;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author usuario
 */
public class Main {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Context c;
        QueueConnectionFactory f;
        QueueSession qs = null;
        Queue q;
        QueueSender s= null;
        Mensaje m;
        ObjectMessage om;
        QueueConnection cc = null;
        int code, number, counter;
        Scanner lectura = new Scanner(System.in);
        // Paso 1: Crear el contexto
        try {
            c = new InitialContext();
            f = (QueueConnectionFactory) c.lookup("factoriaConexiones");
            cc = f.createQueueConnection();
            q = (Queue) c.lookup("cola");
            qs = cc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            cc.start();
            s = qs.createSender((javax.jms.Queue) q);
        } catch (NamingException | JMSException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error Initializing context", ex);
            System.exit(1);
        }
        // Paso 2: Envía mensajes
        counter=0;
        do {
            // ESCANEAMOS EL CÓDIGO DE OP
            do{
                System.out.println("La cuenta es: " + counter);
                System.out.println("Introduce un código: 0,1,2");
                code = lectura.nextInt();
            }while(code<0 || code>2);
            
            System.out.println("Introduce un número: ");
            number =  lectura.nextInt();
            counter+=number;
            m = new Mensaje(code, number);
            try {
                om = qs.createObjectMessage(m);
                s.send(om);
            } catch (JMSException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error sending message", ex);
                break;
            }
           
            
        } while (code != 0 && counter<=100);
        // Paso 3: Cerrar la conexión
        try {
            cc.close();
        } catch (JMSException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error closing conection", ex);
        }
        
    }
    
}
