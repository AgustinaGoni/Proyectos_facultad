/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Jugador;
import modelo.Fachada;
import modelo.MesaException;

/**
 *
 * @author agus
 */
public class ControladorLoginJugador extends ControladorLogin{

    public ControladorLoginJugador(VistaLogin vista) {
        super(vista);
    }
    
    @Override
    public Object llamarLoginModelo(String ced, String pwd) {
        try{
            Jugador jugador= Fachada.getInstancia().loginJugador(ced, pwd);
            jugador.tieneSesionActiva();
            jugador.setSesionActiva(true);
            return jugador;
        }catch(MesaException ex){
            vista.error(ex.getMessage());
            return null;
        }
    }
    
}
