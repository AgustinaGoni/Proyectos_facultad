/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Crupier;
import modelo.Efecto;
import modelo.Jugador;
import modelo.TipoApuesta;

/**
 *
 * @author agus
 */
public interface VistaOperarMesa {
    
    public void mostrarBalance(int balance);

    public void mostrarNumeroRonda(int nroRonda);

    public void mostrarNumeroRuleta(int numero);
    
    public void mostrarListaEfectos(ArrayList<Efecto> efectos);
    
    public void mostrarCantidadTotalApuestas(int cantidad);
    
    public void mostrarMontoTotalApostado(int monto);
    
    public void mostrarMesaDistribuciónApuesta();
    
    public void mostrarListaUltimosLanzamientos(List<Integer> lanzamientos);
    
    public void mostrarListaRondasEfectuadas(int nroRonda, int balanceA, int apuestas, int rec, int liq, int balanceP);
    
    public void mostrarListaJugadoresYSaldo(ArrayList<Jugador> jugadores);
            
    public void error(String message);

    public void ocultarBotones(ArrayList<TipoApuesta> tApuesta);
    
    public void mostrarUltimoSorteado(int numero);

    public void mostrarApuestasJugadores(int valor, int ucc);
    
    public void limpiarApuestas();
}
