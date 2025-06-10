/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author agus
 */
public class Docena extends TipoApuesta{

    public Docena(int factorPago, boolean obligatorio, boolean esDirecta, String nombre) {
        super(factorPago, obligatorio, esDirecta, nombre);
    }
    @Override
    public boolean aplicarRestriccion(Apuesta a, Mesa m) {
        Ronda r= m.getRondaActual();
        //TODO
        if(r!=null){
            ArrayList<Apuesta> apuestasRonda = r.getApuestas();
            Jugador jActual=a.getJugador();
            for(Apuesta ap: apuestasRonda){
                if(ap.getJugador().equals(jActual) && ap.getUccCasillero()>=40 && ap.getUccCasillero()<=42){
                    int docenaExistente = ap.getUccCasillero();
                    int nuevaDocena = a.getUccCasillero();
                    if(docenaExistente != nuevaDocena){
                        return true;
                    }   
                } 
            }  
        }
        return false;
    }

    
    
    @Override
    public ArrayList<Casillero> crearCasilleros() {
        ArrayList<Casillero> casilleros = new ArrayList<>();
        
        casilleros.add(new Casillero(40, this, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        casilleros.add(new Casillero(41, this, Arrays.asList(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24)));
        casilleros.add(new Casillero(42, this, Arrays.asList(25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36)));
        return casilleros;
    }
    
}
