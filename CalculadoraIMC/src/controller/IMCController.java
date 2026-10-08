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
        verificacionDatos();

    }
    
    public void verificacionDatos(){


    if (vista.getTxtAltura().trim().isEmpty() || vista.getTxtPeso().trim().isEmpty()) {
        vista.faltanCampos();
    } else{
        try{
        float peso = Float.parseFloat(vista.getTxtPeso().trim().replace(',', '.'));
        float altura = Float.parseFloat(vista.getTxtAltura().trim().replace(',', '.'));

        if (altura > 3) {
            altura = altura / 100;
        }

        calcular(altura,peso);
        
        }catch (NumberFormatException e){
            vista.camposErroneos();
        }
    }
}

    public void calcular(float altura, float peso){
        
        float imc = (float)(calculadora.calcular(peso, altura));
        String clasificacion = calculadora.clasificar(imc);

        vista.monstrarResultados(imc, clasificacion);
        
    }

    }
    
    


    
    
    

