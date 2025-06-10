/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLoginJugador;
import java.awt.Frame;
import modelo.Jugador;

/**
 *
 * @author agus
 */
public class LoginJugador extends Login {

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal, "Aplicación para jugadores");
        setControlador(new ControladorLoginJugador(this));
    }
    
    @Override
    public void proximoCasoUso(Object o) {
         dispose();
        new UnirseAMesa(null, false, (Jugador)o).setVisible(true);
    }
    
}
