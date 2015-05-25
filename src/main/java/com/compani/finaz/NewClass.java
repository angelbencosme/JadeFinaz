/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz;

/**
 *
 * @author AngelBencosme
 */
public class NewClass {
    
    
    public double montoInteres(int monto,int interes,int numeroCuotas){
        
        double montoInteres;
        double r;
        double interesCapitalizado;
        
        interesCapitalizado = (interes/100)/numeroCuotas;
        
        r = 1 - Math.pow(interesCapitalizado, numeroCuotas);
        
        montoInteres = monto / r;
              
        
    return montoInteres;
    }
   
    public static void main(String[] args){
        NewClass n = new NewClass();
        double monto = n.montoInteres(50000,16,12);
        System.out.println("Monto:"+ monto);
      
        
    }
  
    
}
