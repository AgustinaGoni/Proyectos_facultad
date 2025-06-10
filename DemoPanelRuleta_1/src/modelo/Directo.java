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
public class Directo extends TipoApuesta{

    
    public Directo(int factorPago, boolean obligatorio, boolean esDirecta, String nombre) {
        super(factorPago, obligatorio, esDirecta, nombre);
    }
    
    
    @Override
    public boolean aplicarRestriccion(Apuesta a, Mesa m) {
        return false;
    }

    @Override
    public ArrayList<Casillero> crearCasilleros() {
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i <= 36; i++) {
            ArrayList<Integer> numerosVinculados = new ArrayList<>();
            numerosVinculados.add(i); 
            casilleros.add(new Casillero(i, this, numerosVinculados));
        }
        return casilleros;
    }
    
}
