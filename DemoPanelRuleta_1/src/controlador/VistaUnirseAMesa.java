/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Mesa;

/**
 *
 * @author agus
 */
public interface VistaUnirseAMesa {
    
    public void mostrarMesas(ArrayList<Mesa> mesas);
    public void error(String msg);
}
