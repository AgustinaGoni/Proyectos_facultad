/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author agus
 */
public abstract class TipoApuesta {
    private int factorPago;
    private boolean obligatorio;
    private boolean esDirecta;
    private String nombre;
    private ArrayList<Casillero> casilleros = new ArrayList();
 
    //private ArrayList<Casillero> casilleros;
    
    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }
    /*
    public void agregarCasilleros(ArrayList<Casillero> nuevosCasilleros) {
        this.casilleros.addAll(nuevosCasilleros);
    }*/
    /*
    public Casillero getCasillero(int ucc){
        for(Casillero c: casilleros){
            if(c.getUcc() == ucc){
                return c;
            }
        }
        return null;
    }
    */
    public TipoApuesta(int factorPago, boolean obligatorio, boolean esDirecta, String nombre) {
        this.factorPago = factorPago;
        this.obligatorio = obligatorio;
        this.esDirecta = esDirecta;
        this.nombre = nombre;
    }

    public int getFactorPago() {
        return factorPago;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public boolean isEsDirecta() {
        return esDirecta;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString(){
        return nombre;
    }
    @Override
    public boolean equals(Object o){
        TipoApuesta t = (TipoApuesta)o;
        return t.getNombre().equalsIgnoreCase(getNombre());
    }
    
    
    public abstract boolean aplicarRestriccion(Apuesta a, Mesa m);
    public abstract ArrayList<Casillero> crearCasilleros();

    
}
