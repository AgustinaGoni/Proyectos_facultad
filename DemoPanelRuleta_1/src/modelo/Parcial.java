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
public class Parcial extends Efecto{
    
    public Parcial(String nombre) {
        super(nombre);
    }
    @Override
    public boolean esNumeroValido(int n, Mesa mesa) {
        ArrayList<Integer> ultimosNumeros = mesa.obtenerUltimosNumerosGanadores();
        return !ultimosNumeros.contains(n);
    }
    
}
    
