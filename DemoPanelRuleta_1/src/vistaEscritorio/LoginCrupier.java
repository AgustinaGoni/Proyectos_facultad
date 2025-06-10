/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLoginCrupier;
import java.awt.Frame;
import modelo.Crupier;

/**
 *
 * @author agus
 */
public class LoginCrupier extends Login {

    public LoginCrupier(Frame parent, boolean modal) {
        super(parent, modal, "Aplicación para crupiers");
        setControlador(new ControladorLoginCrupier(this));
    }

    
    @Override
    public void proximoCasoUso(Object o) {
        dispose();
        new IniciarMesa(null, false, (Crupier)o).setVisible(true);
    }
    
}
