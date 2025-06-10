/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Casillero;
import modelo.Crupier;
import modelo.Fachada;
import modelo.Mesa;
import modelo.Ronda;
import modelo.TipoApuesta;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author agus
 */
public class ControladorIniciarMesa  /*implements Observador*/{

    private VistaIniciarMesa vista;
    private Crupier crupier;
    //private Mesa mesa;

    public ControladorIniciarMesa(VistaIniciarMesa vista, Crupier c) {
       this.vista = vista;
       this.crupier = c;
       //this.mesa= crupier.getMesa();
       mostrarTiposApuesta();
    }

    private void mostrarTiposApuesta() {
        vista.mostrarTiposApuesta(Fachada.getInstancia().getTiposApuesta());
    }

    public VistaIniciarMesa getVista() {
        return vista;
    }

    public Crupier getCrupier() {
        return crupier;
    }
 
    public void inicializarMesa(Crupier crupier, ArrayList<TipoApuesta> tiposApuesta) {
        Mesa m = Fachada.getInstancia().agregarMesa(crupier);
        m.iniciarMesa(tiposApuesta);
    }

    public void cerrarSesion() {
        crupier.setSesionActiva(false);
        //Fachada.getInstancia().removerMesa(crupier.getMesa());
    }

   
    
    
    
    
    
    
   

    
    
}
