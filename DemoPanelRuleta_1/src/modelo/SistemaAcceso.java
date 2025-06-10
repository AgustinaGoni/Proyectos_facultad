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
public class SistemaAcceso {

    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Crupier> crupieres = new ArrayList();
    
    private ArrayList<Jugador> jugadoresConectados = new ArrayList();
    private ArrayList<Crupier> crupieresConectados = new ArrayList();
    
    
    public void agregarUsarioCrupier(String ced, String pass, String nc) {
        crupieres.add(new Crupier(ced,pass,nc));
    }
    
    public void agregarJugador(String ced, String pass, String nc, int saldo) {
        jugadores.add(new Jugador(ced,pass,nc,saldo));
    }
    
    
    public Crupier loginCrupier(String ced, String pass) throws MesaException {
       Usuario u = buscarUsuario(ced,pass,crupieres);
       if (u==null) throw new MesaException("Credenciales incorrectas.");
       return (Crupier)u;
    }

    

    public Jugador loginJugador(String ced, String pass) throws MesaException {
       Usuario u = buscarUsuario(ced,pass,jugadores);
       if (u==null) throw new MesaException("Credenciales incorrectas.");
       return (Jugador)u;
    }
    
    
    private Usuario buscarUsuario(String ced, String pass, ArrayList lista){
        Usuario u;
        for(Object o:lista){
            u = (Usuario)o;
            if(u.getCedula().equals(ced) && u.getPassword().equals(pass)){
                return u;
            }
        }
        return null;
    }
    
    //TODO 
    public boolean agregarUsarioCrupierConectado(Crupier c) {
        if(buscarUsuario(c.getCedula(),c.getPassword(),crupieresConectados)==null){
            crupieresConectados.add(c);
            return true;
        }else{
            return false;
        }
    }
    
    /*
    public void agregarJugadorConectado(Jugador j) {
        jugadores.add(new Jugador(ced,pass,nc,saldo));
    }
    */
}
