/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


package vistaEscritorio;

import componente.PanelRuleta;
import controlador.ControladorOperarMesa;
import controlador.VistaOperarMesa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Crupier;
import modelo.Efecto;
import modelo.Jugador;
import modelo.TipoApuesta;

/**
 *
 * @author agus
 */
public class OperarMesa extends javax.swing.JFrame implements VistaOperarMesa {

    private ControladorOperarMesa controlador;
    private boolean estadoMesaBloqueada=false;
    
    public OperarMesa(java.awt.Frame parent, boolean modal, Crupier c, ArrayList<TipoApuesta> ta) {
        //super(parent, modal);
        initComponents();
        controlador = new ControladorOperarMesa(this,c,ta);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        r = new componente.PanelRuleta();
        lBalance = new javax.swing.JLabel();
        lRonda = new javax.swing.JLabel();
        lRuleta = new javax.swing.JLabel();
        bCerrarMesa = new javax.swing.JButton();
        lApuestas = new javax.swing.JLabel();
        lMonto = new javax.swing.JLabel();
        cEfectos = new javax.swing.JComboBox();
        lUltimoSorteado = new javax.swing.JLabel();
        lUltimosLanzamientos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tRondas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tJugadores = new javax.swing.JTable();
        bPagar = new javax.swing.JButton();
        bLanzar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bCerrarMesa.setText("Cerrar mesa");
        bCerrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarMesaActionPerformed(evt);
            }
        });

        cEfectos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Efecto" }));

        jScrollPane1.setViewportView(tRondas);

        tJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Jugador", "Saldo"
            }
        ));
        jScrollPane2.setViewportView(tJugadores);

        bPagar.setText("Pagar");
        bPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPagarActionPerformed(evt);
            }
        });

        bLanzar.setText("Lanzar");
        bLanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLanzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lUltimosLanzamientos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(223, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192)
                                .addComponent(lRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(lRuleta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lApuestas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(cEfectos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bLanzar)
                            .addComponent(bPagar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, Short.MAX_VALUE)
                                .addComponent(bCerrarMesa)
                                .addContainerGap(218, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lUltimoSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lRuleta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCerrarMesa))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bPagar)
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cEfectos)
                        .addComponent(lApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lUltimoSorteado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bLanzar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lUltimosLanzamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPagarActionPerformed
        controlador.pagar();
        estadoMesaBloqueada=false;
        bPagar.setEnabled(false); 
        bLanzar.setEnabled(true); 
    }//GEN-LAST:event_bPagarActionPerformed

    private void bCerrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarMesaActionPerformed
        if(estadoMesaBloqueada){
            dispose();
            controlador.cerrarSesion();
        }else{
            error("No se puede cerrar la mesa en este momento.");
        }
    }//GEN-LAST:event_bCerrarMesaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void bLanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLanzarActionPerformed
        Object seleccion = cEfectos.getSelectedItem();
        if(seleccion instanceof Efecto){
            controlador.lanzarBola((Efecto)seleccion);
            estadoMesaBloqueada=true;
            bPagar.setEnabled(true); 
            bLanzar.setEnabled(false); 
        }else {
            error("Debe elegir un efecto");
        }
    }//GEN-LAST:event_bLanzarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrarMesa;
    private javax.swing.JButton bLanzar;
    private javax.swing.JButton bPagar;
    private javax.swing.JComboBox cEfectos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lApuestas;
    private javax.swing.JLabel lBalance;
    private javax.swing.JLabel lMonto;
    private javax.swing.JLabel lRonda;
    private javax.swing.JLabel lRuleta;
    private javax.swing.JLabel lUltimoSorteado;
    private javax.swing.JLabel lUltimosLanzamientos;
    private componente.PanelRuleta r;
    private javax.swing.JTable tJugadores;
    private javax.swing.JTable tRondas;
    // End of variables declaration//GEN-END:variables
 
    
    
    @Override
    public void mostrarBalance(int balance) {
        lBalance.setText("Balance "+ balance);
    }
    @Override
    public void mostrarNumeroRonda(int nroRonda) {
        lRonda.setText("Ronda #"+ nroRonda);
    }
    @Override
    public void mostrarNumeroRuleta(int numero) {
        lRuleta.setText("Ruleta #"+ numero);
    }

    @Override
    public void mostrarListaEfectos(ArrayList<Efecto> efectos) {
        for(Efecto f: efectos){
            cEfectos.addItem(f);
        }
    }

    @Override
    public void mostrarCantidadTotalApuestas(int cantidad) {
        lApuestas.setText("Apuestas "+ cantidad );
    }

    @Override
    public void mostrarMontoTotalApostado(int monto) {
        lMonto.setText("Monto $"+ monto);
    }

    @Override
    public void mostrarMesaDistribuciónApuesta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarListaUltimosLanzamientos(List<Integer> lanzamientos) {
        StringBuilder numeros = new StringBuilder();
        for (Integer numero : lanzamientos) {
            numeros.append(numero.toString()).append(", ");
        }

    
        if (numeros.length() > 0) {
            numeros.setLength(numeros.length() - 2);
        }

        lUltimosLanzamientos.setText("Últimos lanzamientos: " + numeros.toString());
    }

    
    @Override
    public void mostrarListaRondasEfectuadas(int nroRonda, int balanceA, int apuestas, int rec, int liq, int balanceP) {
        DefaultTableModel datos = (DefaultTableModel) tRondas.getModel();
        if (datos.getColumnCount() == 0) {
            datos.addColumn("Ronda");
            datos.addColumn("Balance Anterior");
            datos.addColumn("Apuestas");
            datos.addColumn("Recolección");
            datos.addColumn("Liquidación");
            datos.addColumn("Balance Posterior");
        }

        int numeroRonda = nroRonda;
        int balanceAnterior = balanceA;
        int totalApuestas = apuestas;
        int monto = rec;
        int recoleccion = liq;
        int liquidacion = balanceP;

        datos.addRow(new Object[]{numeroRonda, balanceAnterior, totalApuestas, monto, recoleccion, liquidacion});
    }

    @Override
    public void mostrarListaJugadoresYSaldo(ArrayList<Jugador> jugadores) {
        DefaultTableModel datos = (DefaultTableModel) tJugadores.getModel();
        if (datos.getColumnCount() == 0) {
            datos.addColumn("Jugador");
            datos.addColumn("Saldo");
        }
        datos.setRowCount(0);
        for (Jugador j : jugadores) {
            String nombreJugador = j.getNombreCompleto();
            int saldo = j.getSaldo(); 
            datos.addRow(new Object[]{nombreJugador, saldo});
        }
    }

    @Override
    public void error(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    //TODO Pregunta
    @Override
    public void ocultarBotones(ArrayList<TipoApuesta> tApuesta) {
        r.setVisible(PanelRuleta.TERCERA_COLUMNA, false);
        r.setVisible(PanelRuleta.SEGUNDA_COLUMNA, false);
        r.setVisible(PanelRuleta.PRIMERA_COLUMNA, false);
        r.setVisible(PanelRuleta.MENOR, false);
        r.setVisible(PanelRuleta.MAYOR, false);
        r.setVisible(PanelRuleta.PAR, false);
        r.setVisible(PanelRuleta.PRIMO, false);
        r.setVisible(PanelRuleta.IMPAR, false);
        r.setVisible(PanelRuleta.COMPUESTO, false);
        r.setVisible(PanelRuleta.ROJO, false);
        r.setVisible(PanelRuleta.NEGRO, false);
        r.setVisible(PanelRuleta.PRIMERA_DOCENA, false);
        r.setVisible(PanelRuleta.SEGUNDA_DOCENA, false);
        r.setVisible(PanelRuleta.TERCERA_DOCENA, false);
        
        for(TipoApuesta ta: tApuesta){
            if(ta.getNombre().equals("Apuesta Colores")){
                r.setVisible(PanelRuleta.ROJO, true);
                r.setVisible(PanelRuleta.NEGRO, true);
            }else if(ta.getNombre().equals("Apuesta de Docena")){
                r.setVisible(PanelRuleta.PRIMERA_DOCENA, true);
                r.setVisible(PanelRuleta.SEGUNDA_DOCENA, true);
                r.setVisible(PanelRuleta.TERCERA_DOCENA, true);
            }
        }
        
    }

    @Override
    public void mostrarUltimoSorteado(int numero) {
        lUltimoSorteado.setText("Numero sorteado: "+ numero );
    }

    @Override
    public void mostrarApuestasJugadores(int valor, int ucc) {
        int apuestaActual = r.getApuesta(ucc);
        int apuesta = apuestaActual+ valor;
        r.setApuesta(ucc, apuesta);
        
    }

    @Override
    public void limpiarApuestas() {
        r.limpiar();
    }

    

    
}
