/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ClienteTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ClienteTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Socket s = null; 
        int serverPort = 6789; //Puertodelservidor. 
        DataInputStream in; //Para lecturas sobre el stream 
        DataOutputStream out; //Paralasescriturassobreelstream 
        String data;//Paraobtenerlarespuestadelservidor
        //Variables que creamos nosotros
        Ejemplo e,e1,e2;
        
        try{ 
            //CreaSocketlocalyseconectaalservidor: 
            s = new Socket(args[1],serverPort);//Alconectarsecreaelsocketdeservicioenelservidor. 
            //Peticiondeservicio: 
            in = new DataInputStream(s.getInputStream()); 
            out = new DataOutputStream(s.getOutputStream()); //Enviaelmensaje: 
            out.writeUTF(args[0]); 
            //Obtienelarespuestadelservidor: 
            data=in.readUTF(); 
            System.out.println("Datosrecibidos:"+data); 
            
            
            e = new Ejemplo();
            e1 = new Ejemplo();
            e2 = new Ejemplo();
        
            e.x = 50;
            e1.x = 100;
            e2.x = 200;

            //e2
            e2.p1 = e1;
            e2.p2=null;

            out.writeObject(e2);

            //e1
            e1.p1=e2; 
            e1.p2= new Ejemplo[2]; 
            e1.p2[0]=e1; 
            e1.p2[1]=e2; 

            //e
            e.p1=e1; 
            e.p2=null;

        }catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }
    
}
