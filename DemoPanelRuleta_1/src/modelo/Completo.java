/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author agus
 */
public class Completo extends Efecto {
    
    public Completo(String nombre) {
        super(nombre);
    }
    @Override
    public boolean esNumeroValido(int n, Mesa mesa) {
        return true;
    }
    
}
