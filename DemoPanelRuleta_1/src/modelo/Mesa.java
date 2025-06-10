/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import observador.Observable;

/**
 *
 * @author agus
 */
//cambia balance,cambia lista Jugador, cambiaEfecto,
//como veo las apuestas realizadas
public class Mesa extends Observable{

    private ArrayList<Efecto> efectos=new ArrayList();
    private ArrayList<Jugador> jugadores=new ArrayList();
    private ArrayList<Ronda> rondas=new ArrayList();
    private ArrayList<TipoApuesta> tiposApuesta=new ArrayList();
    private int balance=0;
    private int balanceAnt;
    private boolean habilitada=false;
    private List<Integer> ultimosLanzamientos=new ArrayList();
    private Crupier crupier;

    private int numeroRondaActual;

    public enum eventos{cambioApuestas,cambioListaJugadores,lanzamientoNumero, pago,cambioRonda,expulsarJugadores};
    
    
    
    public int getBalance() {
        return balance;
    }
    
    public int getBalanceAnt(){
        return balanceAnt;
    }

    public void guardarBalanceAnt(){
        balanceAnt = balance;
    }

    public List<Integer> getUltimosLanzamientos() {
        return ultimosLanzamientos;
    }

    public void setUltimosLanzamientos(List<Integer> ultimosLanzamientos) {
        this.ultimosLanzamientos = ultimosLanzamientos;
    }
    public void agregarUltimosLanzamientos(int ultimoLanzamiento) {
        ultimosLanzamientos.add(ultimoLanzamiento) ;
    }
    
    
    public Crupier getCrupier() {
        return crupier;
    }
    public String getNombreCrupier() {
        return crupier.getNombreCompleto();
    }
    public int getNumeroCrupier() {
        return crupier.getNumero();
    }
    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public Mesa() {
    }
    
    public Mesa(Crupier c) {
        this.crupier=c;
        numeroRondaActual = 0;
    }
    

    public ArrayList<Efecto> getEfectos() {
        return efectos;
    }

    public void setEfectos(ArrayList<Efecto> efectos) {
        this.efectos = efectos;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(ArrayList<Ronda> rondas) {
        this.rondas = rondas;
    }

    public ArrayList<TipoApuesta> getTipoApuestas() {
        return tiposApuesta;
    }

    public void setTiposApuesta(ArrayList<TipoApuesta> tiposApuesta) {
        this.tiposApuesta = tiposApuesta;
    }
    
    public double getOcurrenciasDelNumero(int i) {
        int ocurrencias = 0;
        for (Ronda ronda : rondas) {
            if (ronda.getNumeroGanador() == i) {
                ocurrencias++;
            }
        }
        return rondas.size() > 0 ? (double) ocurrencias / rondas.size() * 100 : 0;
    }
    
    
    public Ronda getRondaActual(){
        
        if (!rondas.isEmpty()) {
            Ronda rondaActual = rondas.get(rondas.size() - 1);
            return rondaActual;
        } else {
            return null;
        }
    }
    
    public Ronda getRondaAnterior(){
        
        if (rondas.size()>1 ) {
            Ronda rondaActual = rondas.get(rondas.size() - 2);
            return rondaActual;
        } else {
            return null;
        }
    }
    
    public int getNumeroDeRonda(){
        Ronda rondaActual=getRondaActual();
        if (rondaActual!=null) {
            return rondaActual.getNumeroRonda();
        } else {
            return 0;
        }
    }
    
    public int getNumeroDeRondaAnterior(){
        if(getNumeroDeRonda()!=0){
            return getNumeroDeRonda()-1;
        }else{
            return 0;
        }
    }
    
    public void iniciarMesa(ArrayList<TipoApuesta> tiposApuesta){
        iniciarNuevaRonda();
        this.setTiposApuesta(tiposApuesta);
        Ronda r= this.getRondaActual();
        for(TipoApuesta tipo : tiposApuesta) {
            ArrayList<Casillero> casillerosDelTipo = tipo.crearCasilleros();
            //Agregar a la ronda los casilleros. no a los tipos
            r.agregarCasilleros(casillerosDelTipo);
        }
        
    }
    
    //meter ronda de controlador 
    public void iniciarNuevaRonda() {
        numeroRondaActual++;
        Ronda nuevaRonda = new Ronda(this,numeroRondaActual);
        rondas.add(nuevaRonda);
        for(TipoApuesta tipo : tiposApuesta) {
            ArrayList<Casillero> casillerosDelTipo = tipo.crearCasilleros();
            //Agregar a la ronda los casilleros. no a los tipos
            nuevaRonda.agregarCasilleros(casillerosDelTipo);
        }
        avisar(Mesa.eventos.cambioRonda);
    }
    
    
    
    @Override
    public String toString(){
        return(""+ getNumeroCrupier());
    }
    
    
    public ArrayList<Integer> obtenerUltimosNumerosGanadores() {
        ArrayList<Integer> ultimosNumeros = new ArrayList<>();
        int totalRondas = rondas.size();
        for (int i = totalRondas - 1; i >= Math.max(totalRondas - 4, 0); i--) {
            ultimosNumeros.add(rondas.get(i).getNumeroGanador());
        }
        return ultimosNumeros;
    }
    
   

   
    public void aumentarBalance(int total) {
        this.balance=total+balance;
    }

    public void decrementarBalance(int montoGanado) {
        this.balance-=montoGanado;
    }
    
    public void agregarJugador(Jugador j) throws MesaException{
        if (!jugadores.contains(j)) {
            jugadores.add(j);
            avisar(eventos.cambioListaJugadores);
        }else{
            throw new MesaException("El jugador ya participa de esta mesa");
        }
    }
    
    
    public void abandonarMesa(Jugador j){
        jugadores.remove(j);
        avisar(eventos.cambioListaJugadores);
    }
    
    public void cerrarSesionOperarMesa() {
        getRondaActual().pagarYDistribuir();
        List<Jugador> jugadoresParaRemover = new ArrayList<>(jugadores); // Crear una copia para iterar
        for(Jugador j: jugadoresParaRemover){
            abandonarMesa(j);
        }
        avisar(eventos.expulsarJugadores);
    }
    
}
