/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author agus
 */
public class Casillero {
    private int ucc;
    private TipoApuesta tipoApuesta;
    private List<Integer> numerosVinculados;

    
    public int getUcc() {
        return ucc;
    }

    public Casillero(int ucc,TipoApuesta tipoApuesta, List<Integer> numerosVinculados) {
        this.ucc = ucc;
        this.tipoApuesta= tipoApuesta;
        this.numerosVinculados = numerosVinculados;
    }

    public TipoApuesta getTipoApuesta() {
        return tipoApuesta;
    }

    public List<Integer> getNumerosVinculados() {
        return numerosVinculados;
    }
    
    public boolean contieneNumeroVinculado(int numero){
        return numerosVinculados.contains(numero);
    }
    
    
}
