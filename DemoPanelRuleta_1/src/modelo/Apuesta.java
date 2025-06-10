/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author agus
 */
public class Apuesta {
    
    private int valor;
    private Jugador jugador;
    private Casillero casillero;

    public int getValor() {
        return valor;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Casillero getCasillero() {
        return casillero;
    }
    public int getUccCasillero() {
        return casillero.getUcc();
    }
    public Apuesta(int valor, Jugador jugador, Casillero c) {
        this.valor = valor;
        this.jugador = jugador;
        this.casillero= c;
        
    }

    public boolean validar(Mesa m) {
        return !this.casillero.getTipoApuesta().aplicarRestriccion(this, m);
    }

    public boolean esGanadora(int numeroGanador) {
        return casillero.contieneNumeroVinculado(numeroGanador);
    }

    public void incrementarSaldoJugador(int montoGanado) {
        jugador.agregarSaldo(montoGanado);
    }
    
    
    
}
