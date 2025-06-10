/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import observador.Observable;

/**
 *
 * @author agus
 */
public class Jugador extends Usuario{
    private int saldo = 0;
    private boolean sesionActiva=false;

    

    

    public enum eventos{cambioSaldo};
    
    public Jugador(String cedula, String password, String nombreCompleto, int saldo) {
        super(cedula, password, nombreCompleto);
        this.saldo=saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void agregarSaldo(int montoGanado) {
        int saldoActual= getSaldo();
        this.saldo=saldoActual+montoGanado;
        avisar(Jugador.eventos.cambioSaldo);
    }
    
    public void restarSaldo(int valor) throws MesaException {
        int saldoActual=getSaldo();
        if(saldoActual-valor<0)throw new MesaException("Saldo insuficiente");
            
        this.saldo = saldoActual-valor;
        avisar(Jugador.eventos.cambioSaldo);
    }
    
    
    @Override
    public boolean equals(Object o){
        Jugador j = (Jugador)o;
        return this.getCedula().equals(j.getCedula()) &&
               this.getNombreCompleto().equalsIgnoreCase(j.getNombreCompleto());
    }
    
    public void tieneSesionActiva() throws MesaException {
        if(sesionActiva){
            throw new MesaException("Acceso denegado. El usuario ya tiene una sesión activa.");
        }
    }

    public void cerrarSesion() {
        setSesionActiva(false);
    }
    
    public void setSesionActiva(boolean sesionActiva) {
        this.sesionActiva = sesionActiva;
    }
}
