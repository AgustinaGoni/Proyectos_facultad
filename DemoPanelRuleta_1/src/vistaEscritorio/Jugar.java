/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistaEscritorio;

import componente.PanelRuleta;
import componente.PanelRuleta.Escuchador;
import controlador.ControladorJugar;
import controlador.VistaJugar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Jugador;
import modelo.Mesa;
import modelo.MesaException;
import modelo.TipoApuesta;
/**
 *
 * @author agus
 */

public class Jugar extends javax.swing.JFrame implements VistaJugar{
    
   
    private boolean apuestasPendientes=false;
    
    private ControladorJugar controlador;
    public Jugar(java.awt.Frame parent, boolean modal, Jugador j,Mesa m) {
        initComponents();
        setLocationRelativeTo(parent);
        controlador = new ControladorJugar(this,j,m);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        r = new componente.PanelRuleta();
        f1 = new javax.swing.JRadioButton();
        f5 = new javax.swing.JRadioButton();
        f10 = new javax.swing.JRadioButton();
        f50 = new javax.swing.JRadioButton();
        f100 = new javax.swing.JRadioButton();
        lNumeroSorteado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lSaldo = new javax.swing.JLabel();
        lRuleta = new javax.swing.JLabel();
        lRonda = new javax.swing.JLabel();
        lNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tRondas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tValor = new javax.swing.JTable();
        bAbandonar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        f1.setText("1");
        f1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1ActionPerformed(evt);
            }
        });

        f5.setText("5");
        f5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f5ActionPerformed(evt);
            }
        });

        f10.setText("10");
        f10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f10ActionPerformed(evt);
            }
        });

        f50.setText("50");
        f50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f50ActionPerformed(evt);
            }
        });

        f100.setText("100");
        f100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f100ActionPerformed(evt);
            }
        });

        lNumeroSorteado.setText("Numero sorteado: ");

        jScrollPane1.setViewportView(tRondas);

        jScrollPane2.setViewportView(tValor);

        bAbandonar.setText("Abandonar");
        bAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAbandonarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(f1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(f5)
                .addGap(18, 18, 18)
                .addComponent(f10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f50)
                .addGap(18, 18, 18)
                .addComponent(f100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(lNumeroSorteado)
                .addGap(167, 167, 167))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(198, 198, 198)
                            .addComponent(lRuleta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(lRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bAbandonar))
                        .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addComponent(lRuleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f1)
                            .addComponent(f5)
                            .addComponent(f10)
                            .addComponent(f50)
                            .addComponent(f100)
                            .addComponent(lNumeroSorteado))
                        .addGap(18, 18, 18)
                        .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(bAbandonar))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbandonarActionPerformed
        if(!apuestasPendientes){
            controlador.abandonarMesa();
            dispose();
        }else{
            error("No puede abandonar hasta completar la ronda");
        }
    }//GEN-LAST:event_bAbandonarActionPerformed

    private void f5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f5ActionPerformed
        apostarFicha(f5,5);
    }//GEN-LAST:event_f5ActionPerformed

    public void apostarFicha(javax.swing.JRadioButton f,int valor){
        if (f.isSelected()) {
            r.agregar(new PanelRuleta.Escuchador() {
                @Override
                public void celdaSeleccionada(int universalCellCode) {
                   try{
                       controlador.realizarApuestaMesa(universalCellCode, valor);
                       int apuesta = r.getApuesta(universalCellCode)+ valor;
                       r.setApuesta(universalCellCode, apuesta);
                       apuestasPendientes=true;
                   }catch( MesaException ex){
                       error(ex.getMessage());
                   }
                    
                }
            });
        } else {
            r.eliminarEscuchadores();
        }
    }
    
    
    private void f1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f1ActionPerformed
        apostarFicha(f1,1);
    }//GEN-LAST:event_f1ActionPerformed

    
    
    private void f10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f10ActionPerformed
       apostarFicha(f10,10);
    }//GEN-LAST:event_f10ActionPerformed

    private void f50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f50ActionPerformed
        apostarFicha(f50,50);
    }//GEN-LAST:event_f50ActionPerformed

    private void f100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f100ActionPerformed
        apostarFicha(f100,100);
    }//GEN-LAST:event_f100ActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbandonar;
    private javax.swing.JRadioButton f1;
    private javax.swing.JRadioButton f10;
    private javax.swing.JRadioButton f100;
    private javax.swing.JRadioButton f5;
    private javax.swing.JRadioButton f50;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lNumeroSorteado;
    private javax.swing.JLabel lRonda;
    private javax.swing.JLabel lRuleta;
    private javax.swing.JLabel lSaldo;
    private componente.PanelRuleta r;
    private javax.swing.JTable tRondas;
    private javax.swing.JTable tValor;
    // End of variables declaration//GEN-END:variables

    
    
    
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
        System.out.print("aaa");
        System.out.print(tApuesta);
        for(TipoApuesta ta: tApuesta){
            System.out.print(ta);
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
    public void mostrarSaldo(int s) {
        lSaldo.setText("Saldo $"+ s);
    }

    @Override
    public void mostrarRuleta(int numeroDeRonda) {
        lRuleta.setText("Ruleta #"+ numeroDeRonda);
    }

    @Override
    public void mostrarRonda(int numeroRonda) {
        lRonda.setText("Ronda #" + numeroRonda);
    }

    @Override
    public void error(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void mostrarNombreJugador(String nombre) {
        lNombre.setText(nombre);
    }

    
    
    @Override
    public void mostrarUltimoNumeroSorteado(int nro) {
        lNumeroSorteado.setText("Número soretado"+ nro);
    }

    @Override
    public void mostrarTablaRonda(int ronda, int totalApostado, int ganado, int perdido, int balance) {
        DefaultTableModel datos = (DefaultTableModel) tRondas.getModel();
        if (datos.getColumnCount() == 0) {
            datos.addColumn("Ronda");
            datos.addColumn("Total apostado");
            datos.addColumn("Ganado");
            datos.addColumn("Perdido");
            datos.addColumn("Balance");
        }

        int numeroRonda = ronda;
        int tApostado = totalApostado;
        int tGanado = ganado;
        int tPerdido = perdido;
        int balanceRonda = balance;
        

        datos.addRow(new Object[]{numeroRonda, tApostado, tGanado, tPerdido, balanceRonda});
    }

    @Override
    public void mostrarTablaValor(int[] numeros, double[] ocurrencias) {
        DefaultTableModel datos = (DefaultTableModel) tValor.getModel();
        datos.setRowCount(0); 

        if (datos.getColumnCount() == 0) {
            datos.addColumn("Número");
            datos.addColumn("Ocurrencias");
        }
        for (int i = 0; i < numeros.length; i++) {
            datos.addRow(new Object[]{numeros[i], ocurrencias[i]});
        }
    }

    @Override
    public void bloquearPanel() {
        r.pausar();
    }

    @Override
    public void reanudarPanel() {
        r.reanudar();
        r.limpiar();
        apuestasPendientes=false;
    }

    @Override
    public void expulsarJugadores() {
            JOptionPane.showMessageDialog(this, "Se cerro la mesa");
            dispose();
        }
    }
    
    
    
        
    
        
    

