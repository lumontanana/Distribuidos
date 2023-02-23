/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ClienteTCP;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Ejemplo implements Serializable{ 
    int x; 
    Ejemplo p1; 
    Ejemplo[] p2;
    Boolean visitado;
    
    Ejemplo(){
    }
    
    public void Recorrido(){
        //Mostramos la variable x
        System.out.println("La variable x = " + this.x);
        
       
    }

}
