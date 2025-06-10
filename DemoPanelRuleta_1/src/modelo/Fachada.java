/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author agus
 */
public class Fachada extends Observable{
    private static Fachada instancia = new Fachada();

    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaRuleta sRuleta = new SistemaRuleta();
    
    
    //public enum eventos{};
    
    public enum eventos{cambioListaMesas};
    
    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }
    
    public void agregarCrupier(String nom, String pass, String nc) {
        sAcceso.agregarUsarioCrupier(nom, pass, nc);
    }

    public Crupier loginCrupier(String nom, String pass) throws MesaException {
        return sAcceso.loginCrupier(nom, pass);
    }

    public void agregarJugador(String nom, String pass, String nc,int saldo) {
        sAcceso.agregarJugador(nom, pass, nc,saldo);
    }

    public Jugador loginJugador(String nom, String pass) throws MesaException {
        return sAcceso.loginJugador(nom, pass);
    }

    
    public ArrayList<Efecto> getEfectos() {
        return sRuleta.getEfectos();
    }

    public void agregarEfecto(Efecto e) {
        sRuleta.agregarEfecto(e);
    }
    
    public ArrayList<TipoApuesta> getTiposApuesta() {
        return sRuleta.getTiposApuesta();
    }

    public void agregarTipoApuesta(TipoApuesta ta) {
        sRuleta.agregarTipoApuesta(ta);
    }

    public Mesa agregarMesa(Crupier crupier) {
        return sRuleta.agregarMesa(crupier);
    }
    public ArrayList<Mesa> getMesas() {
        return sRuleta.getMesas();
    }
   
    public void removerMesa(Mesa m){
        sRuleta.removerMesa( m);
    }
    
}
 /*
    
    */