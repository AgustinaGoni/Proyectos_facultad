/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;
import observador.Observable;

/**
 *
 * @author agus
 */
public class Ronda {
    //private int numeroRonda=1;
    private Efecto efecto;
    private ArrayList<Casillero> casilleros=new ArrayList();
    private ArrayList<Apuesta> apuestas= new ArrayList();
    private int numeroGanador=0;
    private int balance=0;
    private int montoTotalApostado;
    private int recoleccion;
    private int liquidacion;
    private int balancePosterior;
    private boolean estadoAbierto;
    private Mesa mesa;
    private Apuesta ultimaApuesta=null;
    private int numeroRonda;
    //private ArrayList<Integer> lanzamientos= new ArrayList();

    public int getRecoleccion() {
        return recoleccion;
    }

    public int getLiquidacion() {
        return liquidacion;
    }

    public int getBalance() {
        return balance;
    }
    
    
    
    
    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }
    public void setUltimaApuesta(Apuesta ultimaApuesta) {
        this.ultimaApuesta = ultimaApuesta;
    }

    
    

    public void setCasilleros(ArrayList<Casillero> casilleros) {
        this.casilleros = casilleros;
    }

    public int getNumeroGanador() {
        return numeroGanador;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public Ronda(Mesa m,int nroRonda) {
        this.numeroRonda = nroRonda;
        //contadorNumeros++;
        this.mesa=m;
    }
    
    public void agregarCasilleros(ArrayList<Casillero> nuevosCasilleros) {
        this.casilleros.addAll(nuevosCasilleros);
    }
    
    public int getCantidadApuestas(){
        if(apuestas!=null){
            return apuestas.size();
        }else
            return 0;
        
    }
    
    public int getMontoTotalApostado(){
        int total=0;
        if(apuestas!=null){
            for(Apuesta a: apuestas){
                total+=a.getValor();
            }
        }
        
        return total;
    }

    public void lanzarBola(Efecto efecto, Mesa mesa) {
        int valor= new Random().nextInt(37);
        this.efecto=efecto;
        do{
            valor=new Random().nextInt(37);
        }while(!efecto.esNumeroValido(valor, mesa));
        numeroGanador=valor;
        mesa.agregarUltimosLanzamientos(numeroGanador);
        mesa.avisar(Mesa.eventos.lanzamientoNumero);
    }

    
    
    public void agregarApuesta(int ucc, int valor, Jugador j) throws MesaException {
        Casillero c= null;
        for(Casillero cas :casilleros){
            if(cas.getUcc()==ucc){
                c=cas;
            }
        }
        
        Apuesta a= new Apuesta(valor,j,c);
        if(a.validar(this.mesa)){
            this.setUltimaApuesta(a);
            j.restarSaldo(valor);
            apuestas.add(a);
            mesa.avisar(Mesa.eventos.cambioApuestas);
            
        }else{
            throw new MesaException("Apuesta no válida");
        }
        
    }
    
    public int getValorUltimaApuesta(){
        if(ultimaApuesta!=null){
            return this.ultimaApuesta.getValor();
        }
        return 0;
    }
    public int getUccUltimaApuesta(){
        if(ultimaApuesta!=null){
            return this.ultimaApuesta.getUccCasillero();
        }
        return 0;
        
    }
    
    ArrayList<Integer> obtenerNumerosApostadosDirectamente() {
        ArrayList<Integer> numerosApostadosDirectamente = new ArrayList<>();
        if(!apuestas.isEmpty()){
            for (Apuesta ap:apuestas){
                if(ap.getUccCasillero()<37){
                    numerosApostadosDirectamente.add(ap.getUccCasillero());
                }
            }
        }
        return numerosApostadosDirectamente;
    }

    public int recolectarApuestas() {
        int total=0;
        for(Apuesta a: apuestas){
            total+=a.getValor();
        }
        mesa.guardarBalanceAnt();
        mesa.aumentarBalance(total);
        recoleccion(total);
        return total;
    }

    public int pagarApuestas() {
        int totalPagado = 0;
        for (Apuesta apuesta : apuestas) {
            if (apuesta.esGanadora(numeroGanador)) {
                int montoGanado = apuesta.getValor() * apuesta.getCasillero().getTipoApuesta().getFactorPago();
                apuesta.incrementarSaldoJugador(montoGanado); 
                totalPagado += montoGanado;
                mesa.guardarBalanceAnt();
                mesa.decrementarBalance(montoGanado);
                liquidacion(montoGanado);
            }
        }
        
        return totalPagado;
    }
    
    
    
    public void recoleccion(int total){
        recoleccion=  total;
        balance = balance+total;
    }
    
    public void liquidacion(int total){
        liquidacion = total;
        balance=balance-total;
    }
    /*public void balancePosterior(int rec, int liq){
        balancePosterior= recoleccion-liquidacion;
    }*/
    /*public int balancePosterior(int rec, int liq){
        //balancePosterior= recoleccion-liquidacion;
        return balancePosterior;
    }*/
    
    public int montoTotalApostadoPorJugador(Jugador j){
        int total=0;
        for(Apuesta a: apuestas){
            if(a.getJugador().equals(j)){
                total+=a.getValor();
            }
        }
        return total;
    }
    
    
    public int obtenerApuestasGanadasPorJugador(Jugador j){
        int totalPagado = 0;
        for (Apuesta apuesta : apuestas) {
            if (apuesta.getJugador().equals(j) && apuesta.esGanadora(numeroGanador)) {
                int montoGanado = apuesta.getValor() * apuesta.getCasillero().getTipoApuesta().getFactorPago(); 
                totalPagado += montoGanado;
            }
        }
        return totalPagado;
    }
    
    public int obtenerBalancePorJugador(Jugador j){
        return montoTotalApostadoPorJugador(j)-obtenerApuestasGanadasPorJugador(j);
    }
    
    public int obtenerTotalPerdido(Jugador j){
        return montoTotalApostadoPorJugador(j);
    }
    
    
    public void pagarYDistribuir() {
        recolectarApuestas();
        pagarApuestas();
        mesa.avisar(Mesa.eventos.pago);
    }
    
    
    public void aumentarBalance(int total) {
        balance+=total;
    }

    public void decrementarBalance(int montoGanado) {
        this.balance-=montoGanado;
    }
    
//hastaAhora
    public int getCantidadApuestaColor(Jugador j,int ucc) {
        int total=0;
        for(Apuesta a: apuestas){
            if(a.getUccCasillero() == ucc && j.equals(a.getJugador())){
                total+=a.getValor();
            }
        }
        return total;
    }

    public boolean apostoRojoNegro(Jugador j) {
        boolean rojo=false;
        boolean negro=false;
        for(Apuesta a: apuestas){
            if(j.equals(a.getJugador())){
                if(a.getUccCasillero() == 43){
                    rojo=true;
                }else if (a.getUccCasillero() == 44){
                negro=true;
                }
            }
            
        }
        return rojo && negro;
    }

    public int apuestasPerdidasColor(Jugador j, int uccCasillero) {
        int total=0;
        for(Apuesta a :apuestas){
            if(j.equals(a.getJugador())){
                if(uccCasillero==a.getUccCasillero()){
                    if(!a.getCasillero().contieneNumeroVinculado(numeroGanador)){
                        total+=a.getValor();
                    }
                }
            }
        }
        return total;
    }
}
