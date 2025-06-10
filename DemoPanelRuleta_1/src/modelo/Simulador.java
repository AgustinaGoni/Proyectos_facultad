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
public class Simulador extends Efecto {

    
    public Simulador(String nombre) {
        super(nombre);
    }
    
    @Override
    public boolean esNumeroValido(int n, Mesa mesa) {
        Ronda r= mesa.getRondaActual();
        ArrayList<Integer> numerosApuestaDirecta = r.obtenerNumerosApostadosDirectamente();
        return ((numerosApuestaDirecta.contains(n))|| (n==0));
    }
    
    
    
}
