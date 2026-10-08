/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Raul Molina Cordones
 */
public class CalculadoraIMC {
    
    public double calcular(double peso, double altura){
        return peso / (altura * altura);
    }
    
    public String clasificar(double imc){

        if(imc < 18.5){
            return "Bajo Peso";
        }else if(imc < 24.9){
            return "Peso Normal";
        }else if(imc < 29.9){
            return "Sobrepeso";
        }else{
            return "Obesidad";
        } 
    }

}
