/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorIniciarMesa;
import controlador.VistaIniciarMesa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import modelo.Crupier;
import modelo.TipoApuesta;


public class IniciarMesa extends javax.swing.JDialog implements VistaIniciarMesa {

    private ControladorIniciarMesa controlador;
    private ArrayList<TipoApuesta> resultado= new ArrayList();
    /**
     * Creates new form IniciarMesa
     */
    public IniciarMesa(java.awt.Frame parent, boolean modal, Crupier c) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorIniciarMesa(this, c);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listTiposApuesta = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        bIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setViewportView(listTiposApuesta);

        jLabel1.setText("Tipo de apuestas");

        bIniciar.setText("Iniciar");
        bIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(bIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarActionPerformed
       
        
        ArrayList<TipoApuesta> t = (ArrayList<TipoApuesta>)listTiposApuesta.getSelectedValuesList();
        if(t!=null && !t.isEmpty()){
            inicializarMesa(controlador.getCrupier(),t);
            dispose();
            //controlador.agregarTiposApuesta(t);
            new OperarMesa(null,false,controlador.getCrupier(),t).setVisible(true);
        }
        //new OperarMesa(null,false,controlador.getCrupier(),t).setVisible(true);
    }//GEN-LAST:event_bIniciarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controlador.cerrarSesion();
    }//GEN-LAST:event_formWindowClosed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listTiposApuesta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTiposApuesta(ArrayList<TipoApuesta> tiposApuesta) {
        listTiposApuesta.setListData(tiposApuesta.toArray());
        ListSelectionModel selectionModel = listTiposApuesta.getSelectionModel();
        int indice = buscarIndice(tiposApuesta, "Apuesta Directa");
        // Configurar un ListSelectionListener para manejar los cambios de selección
        listTiposApuesta.addListSelectionListener((ListSelectionEvent e) -> {
            // Verificar si la apuesta "Directa" está seleccionada y si es así, mantenerla seleccionada

            if (indice != -1) {
                if (!selectionModel.isSelectedIndex(indice)) {
                    selectionModel.addSelectionInterval(indice, indice);
                }
            }
        });

        //Si "Directa" está en la lista, selecciónala por defecto
        if (indice != -1) {
            selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            selectionModel.setSelectionInterval(indice, indice);
            selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }

    }

    private int buscarIndice(List<TipoApuesta> tipoApuestas, String nombre) {
        for (int i = 0; i < tipoApuestas.size(); i++) {
            if (nombre.equals(tipoApuestas.get(i).getNombre())) {
                return i;
            }
        }
        return -1;
    }

    private void inicializarMesa(Crupier crupier,ArrayList<TipoApuesta> tiposApuesta) {
        controlador.inicializarMesa(crupier,tiposApuesta);
    }

    @Override
    public void error(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
