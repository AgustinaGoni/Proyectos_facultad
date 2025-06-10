/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import modelo.Completo;
import modelo.Directo;
import modelo.Docena;
import modelo.Fachada;
import modelo.Parcial;
import modelo.RojoNegro;
import modelo.Simulador;

/**
 *
 * @author agus
 */
public class DatosPrueba {
    public static void cargar(){
        
        Fachada logica = Fachada.getInstancia();
        
        //CRUPIERES
        logica.agregarCrupier("101", "aaa", "Antonio");
        logica.agregarCrupier("102", "bbb", "Bianca");
        logica.agregarCrupier("103", "ccc", "Camila");
        logica.agregarCrupier("111", "a", "Alberto");
        logica.agregarCrupier("c", "c", "Crupier");
        
        //JUGADORES
        logica.agregarJugador("201", "aaa", "Ana",1000);
        logica.agregarJugador("202", "bbb", "Bernardo",500);
        logica.agregarJugador("203", "ccc", "Carlos",100);
        logica.agregarJugador("204", "ddd", "Damian",50);
        logica.agregarJugador("205", "eee", "Esther",10);
        logica.agregarJugador("222", "a", "Juan",1500);
        logica.agregarJugador("j", "j", "Jugador",2000);
        
        //EFECTOS
        logica.agregarEfecto(new Simulador("Modo simulador"));
        logica.agregarEfecto(new Parcial("Modo aleatorio parcial"));
        logica.agregarEfecto(new Completo("Modo aleatorio completo"));
        
        //TIPOS APUESTA
        //int factorPago, boolean obligatorio, boolean esDirecta, String nombre
        logica.agregarTipoApuesta(new RojoNegro(2,false,false,"Apuesta Colores"));
        logica.agregarTipoApuesta(new Docena(3,false,false,"Apuesta de Docena"));
        logica.agregarTipoApuesta(new Directo(36,true,true,"Apuesta Directa"));

        
        
    }
}
