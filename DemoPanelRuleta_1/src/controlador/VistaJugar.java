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
public interface VistaJugar {
    
    public void ocultarBotones(ArrayList<TipoApuesta> tApuesta);
    
    public void mostrarSaldo(int s);

    public void mostrarRonda(int numeroDeRonda);

    public void mostrarRuleta(int numeroRonda);
    
    public void mostrarNombreJugador(String nombre);
    
    public void mostrarUltimoNumeroSorteado(int nro);
    
    public void mostrarTablaRonda(int ronda, int tApostado, int ganado, int perdido, int balance);
    
    public void mostrarTablaValor(int[] numeros, double[] ocurrencias);
    
    public void bloquearPanel();
    
    public void reanudarPanel();
    
    public void expulsarJugadores();
    
    public void error(String msg);
}
