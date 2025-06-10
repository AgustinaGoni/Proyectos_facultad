/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Crupier;
import modelo.Efecto;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Mesa;
import modelo.Ronda;
import modelo.TipoApuesta;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author agus
 */
public class ControladorOperarMesa implements Observador{
    private VistaOperarMesa vista;
    private Crupier crupier;
    private Mesa mesa;
    private ArrayList<TipoApuesta> tApuesta;
    private Ronda ronda;

    public ArrayList<TipoApuesta> gettApuesta() {
        return tApuesta;
    }

    public ControladorOperarMesa(VistaOperarMesa vista, Crupier crupier, ArrayList<TipoApuesta> tApuesta) {
        this.vista = vista;
        this.crupier = crupier;
        this.mesa = crupier.getMesa();
        //mesa.setTiposApuesta(tApuesta);
        this.tApuesta=tApuesta;
        //Ronda r= new Ronda();
        //mesa.agregarRonda(r);
        
        //preguntar
        //this.ronda=mesa.getRondaActual();
        this.mesa.agregarObservador(this);
        ocultarBotones();
        
        mostrarBalance();
        mostrarNumeroRonda();
        mostrarNumeroRuleta();
        mostrarListaEfectos();
        mostrarCantidadTotalApuestas();
        mosotrarMontoTotalApostado();
        mostrarListaJugadoresYSaldo();
    }
    
    public void mostrarBalance(){
        vista.mostrarBalance(mesa.getBalance());//TODO fijarse
    }

    private void ocultarBotones() {
       vista.ocultarBotones(tApuesta);
    }

    private void mostrarNumeroRuleta() {
        vista.mostrarNumeroRuleta(crupier.getNumero());
    }
    
    private void mostrarListaEfectos() {
        vista.mostrarListaEfectos(Fachada.getInstancia().getEfectos());
    }

    private void mostrarNumeroRonda() {
        vista.mostrarNumeroRonda(mesa.getNumeroDeRonda());
    }

    private void mostrarCantidadTotalApuestas() {
        vista.mostrarCantidadTotalApuestas(mesa.getRondaActual().getCantidadApuestas());
    }

    private void mosotrarMontoTotalApostado() {
        vista.mostrarMontoTotalApostado(mesa.getRondaActual().getMontoTotalApostado());
    }

    /*public void lanzarBola(Efecto efecto) {
        ronda.lanzarBola(efecto,mesa);
    }*/
    
    private void mostrarUltimosLanzamientos(){
        vista.mostrarListaUltimosLanzamientos(mesa.obtenerUltimosNumerosGanadores());
    }

    public void lanzarBola(Efecto efecto) {
        mostrarApuestas();
        ronda=mesa.getRondaActual();
        ronda.lanzarBola(efecto,mesa);
        mostrarNumeroGanado();
        mostrarUltimosLanzamientos();
    }
    
    private void mostrarNumeroGanado(){
        vista.mostrarUltimoSorteado(ronda.getNumeroGanador());
    }

    private void mostrarListaRonda(){
        vista.mostrarListaRondasEfectuadas(rondaAnterior(), balanceAnterior(),montoTotalApuestas(),recoleccion(),liquidacion(),balancePosterior());
    }
    
    private int rondaAnterior() {
        return mesa.getNumeroDeRondaAnterior();
    }
    private int balanceAnterior() {
        return mesa.getBalanceAnt();
    }
    private int montoTotalApuestas() {
        return mesa.getRondaAnterior().getMontoTotalApostado();
    }
    private int recoleccion() {
        return mesa.getRondaAnterior().getRecoleccion();
    }
    private int liquidacion() {
        return mesa.getRondaAnterior().getLiquidacion();
    }
    private int balancePosterior() {
        return mesa.getBalance();
    }
    
    
    private void mostrarListaJugadoresYSaldo(){
        vista.mostrarListaJugadoresYSaldo(mesa.getJugadores());
    }
    
    
    
    public void pagar() {
        mesa.getRondaActual().pagarYDistribuir();
        mesa.iniciarNuevaRonda();
        mostrarNumeroRonda();
        mostrarListaRonda();
        mostrarListaJugadoresYSaldo();
        //mostrarUltimosLanzamientos();
        //mostrarCantidadTotalApuestas();
        //mosotrarMontoTotalApostado();
    }

    public void mostrarApuestas(){
        vista.mostrarApuestasJugadores(mesa.getRondaActual().getValorUltimaApuesta(), mesa.getRondaActual().getUccUltimaApuesta());
    }

    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Mesa.eventos.cambioApuestas)){
          mostrarApuestas();
          mostrarCantidadTotalApuestas();
          mosotrarMontoTotalApostado();
        }else if(evento.equals(Mesa.eventos.cambioListaJugadores)){
            mostrarListaJugadoresYSaldo();
        }else if(evento.equals(Mesa.eventos.pago)){
            mostrarCantidadTotalApuestas();
            mosotrarMontoTotalApostado();
            limpiarApuestas();
            mostrarBalance();
        }
    }

    private void limpiarApuestas() {
        vista.limpiarApuestas();
    }

    

    public void cerrarSesion() {
        mesa.cerrarSesionOperarMesa();
        Fachada.getInstancia().removerMesa(crupier.getMesa());
        crupier.cerrarSesion();
    }
    
}
