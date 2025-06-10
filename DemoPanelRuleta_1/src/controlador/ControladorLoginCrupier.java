/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Crupier;
import modelo.Fachada;
import modelo.MesaException;

/**
 *
 * @author agus
 */
public class ControladorLoginCrupier extends ControladorLogin{

    public ControladorLoginCrupier(VistaLogin vista) {
        super(vista);
    }
    
    @Override
    public Object llamarLoginModelo(String ced, String pwd) {
        try{
            Crupier crupier= Fachada.getInstancia().loginCrupier(ced, pwd);
            crupier.tieneSesionActiva();
            crupier.setSesionActiva(true);
            return crupier;
        }catch(MesaException ex){
            vista.error(ex.getMessage());
            return null;
        }
    }
    
}
