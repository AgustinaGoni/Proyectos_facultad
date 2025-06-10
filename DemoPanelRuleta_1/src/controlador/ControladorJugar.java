/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Apuesta;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Mesa;
import modelo.MesaException;
import modelo.Ronda;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author agus
 */
public class ControladorJugar implements Observador {
    
    private VistaJugar vista;
    private Jugador jugador;
    private Mesa mesa;
    private Ronda ronda;
    private Apuesta apuesta;
    private Casillero casillero;
    
    public ControladorJugar(VistaJugar vista, Jugador jugador, Mesa m) {
        this.vista = vista;
        this.jugador=jugador;
        this.mesa=m;
        this.jugador.agregarObservador(this);
        this.mesa.agregarObservador(this);
        ocultarBotones();
        mostrarSaldo();
        mostrarRonda();
        mostrarRuleta();
        mostrarNombre();
        mostrarOcurrenciaTabla();
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Jugador.eventos.cambioSaldo)){
            mostrarSaldo();
        }else if(evento.equals(Mesa.eventos.lanzamientoNumero)){
            mostrarNumeroSorteado(); 
            //mostrarRondaTabla();
            bloquearPanel();
        }else if(evento.equals(Mesa.eventos.pago)){
            reanudarPanelYlimpiarApuestas();
            mostrarOcurrenciaTabla();
            mostrarRondaTabla();
        }else if(evento.equals(Mesa.eventos.cambioRonda)){
            mostrarRonda();
        }else if(evento.equals(Mesa.eventos.expulsarJugadores)){
            expulsarJugadores();
        }
    }

    private void ocultarBotones() {
        vista.ocultarBotones(mesa.getTipoApuestas());
    }
    
    
    public void realizarApuestaMesa(int universalCellCode, int valor)throws MesaException {
        mostrarSaldo();
        ronda= mesa.getRondaActual();
        ronda.agregarApuesta(universalCellCode, valor ,jugador);
    }

    private void mostrarSaldo() {
        vista.mostrarSaldo(jugador.getSaldo());
    }
    
    private void mostrarRonda() {
        vista.mostrarRonda(mesa.getRondaActual().getNumeroRonda());
    }
    
    private void mostrarRuleta() {
        vista.mostrarRuleta(mesa.getCrupier().getNumero());
    }
    
    private void mostrarNombre(){
        vista.mostrarNombreJugador(jugador.getNombreCompleto());
    }
    
    private void mostrarNumeroSorteado(){
        vista.mostrarUltimoNumeroSorteado(mesa.getRondaActual().getNumeroGanador());
    }
    
    private void mostrarRondaTabla(){
        vista.mostrarTablaRonda(mesa.getRondaActual().getNumeroRonda(), mesa.getRondaActual().montoTotalApostadoPorJugador(jugador),
                mesa.getRondaActual().obtenerApuestasGanadasPorJugador(jugador), mesa.getRondaActual().obtenerTotalPerdido(jugador),
                mesa.getRondaActual().obtenerBalancePorJugador(jugador));
        
    }
    
    private void mostrarOcurrenciaTabla(){
        int[] numeros = new int[37]; 
        double[] ocurrencias = new double[37]; 
        for (int i = 0; i < 37; i++) {
            numeros[i] = i;
            ocurrencias[i] = mesa.getOcurrenciasDelNumero(i);
        }
        vista.mostrarTablaValor(numeros, ocurrencias);
    }

    private void bloquearPanel() {
        vista.bloquearPanel();
    }
     private void reanudarPanelYlimpiarApuestas(){
         vista.reanudarPanel();
     }

    public void abandonarMesa() {
        mesa.abandonarMesa(jugador);
    }

    private void expulsarJugadores() {
        vista.expulsarJugadores();
    }
}
