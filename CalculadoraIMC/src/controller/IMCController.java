/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Color;
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
    
    //Método para verificar que los datos sean correctos
    public void verificacionDatos(){

    //Para ver si estan vacios
    if (vista.getTxtAltura().trim().isEmpty() || vista.getTxtPeso().trim().isEmpty()) {
        vista.faltanCampos();
    } else{ 
        //el try comprueba si es un numero
        try{
        //cambia la , por un . - el usuario puede haberlo introducido asi
        float peso = Float.parseFloat(vista.getTxtPeso().trim().replace(',', '.'));
        float altura = Float.parseFloat(vista.getTxtAltura().trim().replace(',', '.'));

        //Por si el usuario ha introduccido la altura en cm la dividimos entre 100
        //El filtro es de 3metros ya que es practicamente imposible que alguien mida más
        if (altura > 3) {
            altura = altura / 100;
        }
        //Ejecutamos el método calcular(altura, peso)
        calcular(altura,peso);
        
        }catch (NumberFormatException e){
            vista.camposErroneos();
        }
    }
}
    //Metodo para calcular el imc y la clasificacion y se muestran los resultados
    public void calcular(float altura, float peso){
        
        float imc = (float)(calculadora.calcular(peso, altura));
        String clasificacion = calculadora.clasificar(imc);

        vista.monstrarResultados(imc, clasificacion);
        
        //Reto Adicional: cambiar el color del label
        if (clasificacion.equals("Peso Normal")) {
            vista.getLblClasificacion().setForeground(Color.GREEN);
        } else if (clasificacion.equals("Bajo Peso") || clasificacion.equals("Sobrepeso")) {
            vista.getLblClasificacion().setForeground(Color.ORANGE);
        } else if (clasificacion.equals("Obesidad")) {
            vista.getLblClasificacion().setForeground(Color.RED);
        }
        
    }

    }
    
    


    
    
    

