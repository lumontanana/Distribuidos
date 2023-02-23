/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;




import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ServidorTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int serverPort = 6789; //El puerto de servicio. 
        ServerSocket listenSocket; //El socket de escucha de peticiones. 
        Socket clientSocket; //Socket para la comunicacion. 
        ObjectInputStream in;
        Ejemplo e;
        
        try{ 
            listenSocket = new ServerSocket(serverPort);
          
            //Comportamiento normal de un servidor,buclea tendiendo 
            //laspeticionesdelosclientes: 
            System.out.println("Servidor en marcha");
            clientSocket=listenSocket.accept(); //Espera una peticion 
            //y obtiene un socket de comunicacion. 
            in = new ObjectInputStream(clientSocket.getInputStream());         
            e = (Ejemplo)in.readObject();
            
      
            
            
            e.Recorrido();
            
            System.out.println("Cierro conexion");
            listenSocket.close();
        
        }catch(IOException ex){ 
            System.out.println("Error en socket:"+ ex.getMessage()); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
} 
        
        
        
        
        
   
    
