/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author Raul Molina Cordones
 */

import controller.IMCController;
import view.VentanaCalculadora;

public class Main {

    public static void main(String[] args) {
        VentanaCalculadora vista = new VentanaCalculadora();
        new IMCController(vista);
        vista.setVisible(true);
    }
}
