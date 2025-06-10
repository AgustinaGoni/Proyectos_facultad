/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import modelo.Jugador;
import modelo.Mesa;
import modelo.MesaException;

import observador.Observable;
import observador.Observador;

/**
 *
 * @author agus
 */
public class ControladorUnirseAMesa implements Observador{
    
    private VistaUnirseAMesa vista;
    private Jugador jugador;
    

    public Jugador getJugador() {
        return jugador;
    }
    
    public ControladorUnirseAMesa(VistaUnirseAMesa vista, Jugador j) {
       this.vista = vista;
       this.jugador = j;
       
       mostrarMesas();
       Fachada.getInstancia().agregarObservador(this);
    }

    private void mostrarMesas() {
        vista.mostrarMesas(Fachada.getInstancia().getMesas());
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Fachada.eventos.cambioListaMesas)){
            mostrarMesas();
        }
    }

    public void unirseAMesa(Mesa mesaSeleccionada) throws MesaException {
        mesaSeleccionada.agregarJugador(jugador);
    }

    public void cerrarSesion() {
        jugador.cerrarSesion();
    }
    
}
