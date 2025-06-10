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
public class RojoNegro extends TipoApuesta{

    public RojoNegro(int factorPago, boolean obligatorio, boolean esDirecta, String nombre) {
        super(factorPago, obligatorio, esDirecta, nombre);
    }
    //TODO
    @Override
    public boolean aplicarRestriccion(Apuesta a, Mesa m) {
       if(m.getRondaAnterior()== null){
           return false;
       }
       boolean respuesta= false;
       Jugador j= a.getJugador();
       int cantidadApuestaColorHastaAhora=m.getRondaActual().getCantidadApuestaColor(j,a.getUccCasillero());
       boolean aposto2colores=m.getRondaAnterior().apostoRojoNegro(j);
       int ultimoLanzamiento=m.getRondaAnterior().getNumeroGanador();
       
       int sumaApuestasPerdidasEnRondaAnteriorColor = m.getRondaAnterior().apuestasPerdidasColor(j,a.getUccCasillero());
       
       if(aposto2colores && (ultimoLanzamiento!=0)){
           return false;
       }
       if(cantidadApuestaColorHastaAhora+a.getValor()>sumaApuestasPerdidasEnRondaAnteriorColor){
           return true;
       }
       /*
       if((!(ultimoLanzamiento!=0)&& aposto2colores) && (sumaApuestasPerdidasEnRondaAnteriorColor <cantidadApuestaColorHastaAhora)){
           respuesta = true;
       }
       */
       return respuesta;
    }
    
    

    @Override
    public ArrayList<Casillero> crearCasilleros() {
        ArrayList<Casillero> casilleros = new ArrayList<>();
    
        casilleros.add(new Casillero(43, this, Arrays.asList(1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,36)));
        casilleros.add(new Casillero(44, this, Arrays.asList(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35)));
        
        return casilleros;
    }
    
}
