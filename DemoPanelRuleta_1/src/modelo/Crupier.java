/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author agus
 */
public class Crupier extends Usuario{
    
    private Mesa mesa = new Mesa();
    private boolean sesionActiva = false;

    private static int contadorNumeros = 1; 
    private int numero;

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    

    public int getNumero() {
        return numero;
    }
    
    public Crupier(String cedula, String password, String nombreCompleto) {
        super(cedula, password, nombreCompleto);
        this.numero = contadorNumeros;
        contadorNumeros++;
    }

    public Mesa getMesa() {
        return mesa;
    }
    
    public void tieneSesionActiva() throws MesaException {
        if(sesionActiva){
            throw new MesaException("Acceso denegado. El usuario ya tiene una sesión activa.");
        }
        

    }

    public void setSesionActiva(boolean sesionActiva) {
        this.sesionActiva = sesionActiva;
    }
    
    public void cerrarSesion(){
        setSesionActiva(false);
        setMesa(null);
    }
    
}
