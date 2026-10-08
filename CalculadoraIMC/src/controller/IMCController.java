/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import model.CalculadoraIMC;
import view.VentanaCalculadora;
import java.awt.event.ActionListener;

/**
 *
 * @author Raul Molina Cordones
 */
public class IMCController implements ActionListener {
    
    private final CalculadoraIMC calculadora = new CalculadoraIMC();
    private final VentanaCalculadora vista;

    public IMCController(VentanaCalculadora vista) {
        this.vista = vista;
        this.vista.getBtnCalcular().addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getBtnCalcular()){
            calcular(vista.getTxtPeso(),vista.getTxtAltura());
        }

    }
    
    public void calcular(int peso, int altura){
        double imc = calculadora.calcular(peso, altura);
        
        vista.setResultado(String.valueOf(imc));
        vista.setClasificacion(calculadora.clasificar(imc));
        
        
        
        
    }
    

    
    
    
}
