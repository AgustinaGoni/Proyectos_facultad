/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.TipoApuesta;

/**
 *
 * @author agus
 */
public interface VistaIniciarMesa {
    
    public void mostrarTiposApuesta(ArrayList<TipoApuesta> tiposApuesta);
    
    public void error(String msg);
}
