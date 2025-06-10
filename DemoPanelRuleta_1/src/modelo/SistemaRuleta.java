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
public class SistemaRuleta {
    
    private ArrayList<Efecto> efectos = new ArrayList();
    private ArrayList<TipoApuesta> tiposApuesta = new ArrayList();
    private ArrayList<Mesa> mesas= new ArrayList();

    
    public ArrayList<Efecto> getEfectos() {
        return efectos;
    }

    public void agregarEfecto(Efecto e){
        efectos.add(e);
    }
    
    public ArrayList<TipoApuesta> getTiposApuesta() {
        return tiposApuesta;
    }

    public void agregarTipoApuesta(TipoApuesta ta) {
        tiposApuesta.add(ta);
    }
//TODO VALIDAR
    public Mesa agregarMesa(Crupier crupier) {
        for (Mesa mesa : mesas) {
            if (mesa.getCrupier().equals(crupier)) {
                return mesa;
            }
        }
        Mesa nuevaMesa = new Mesa(crupier);
        crupier.setMesa(nuevaMesa);
        mesas.add(nuevaMesa);
        Fachada.getInstancia().avisar(Fachada.eventos.cambioListaMesas);
        return nuevaMesa;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
   public void removerMesa(Mesa m){
        mesas.remove(m);
        Fachada.getInstancia().avisar(Fachada.eventos.cambioListaMesas);
    }
}






 /*
    */