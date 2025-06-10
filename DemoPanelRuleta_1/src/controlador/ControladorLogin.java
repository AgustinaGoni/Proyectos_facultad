/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import modelo.Fachada;

/**
 *
 * @author PC
 */
public abstract class ControladorLogin {
    
    public VistaLogin vista;
    
    
    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
    
    public void login(String ced,String pwd){
        Object o = llamarLoginModelo(ced,pwd);
        if(o!=null){
            vista.proximoCasoUso(o);
        } 
    }

    public abstract Object llamarLoginModelo(String ced, String pwd);
        
    /*    private VistaLogin vista;
    
    
    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
    
    public void login(String ced,String pwd){
        Object o = llamarLoginModelo(ced,pwd);
        if(o==null){
            vista.error("Login incorrecto");
        }else vista.proximoCasoUso(o);
    }

    public abstract Object llamarLoginModelo(String ced, String pwd);*/
    
    
    
}
