/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import iuGrafica.Menu;

/**
 *
 * @author agus
 */
public class Inicio {
    public static void main(String[] args) {
        // TODO code application logic here
        DatosPrueba.cargar();
        new Menu().setVisible(true);
    }
}
