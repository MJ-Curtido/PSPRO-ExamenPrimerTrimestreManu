/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import clases.Equipo;
import clases.Jugador;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import servicio.DAOEquipoJugador;

/**
 *
 * @author Dam
 */
public class PanelInicio extends javax.swing.JPanel {
    private ArrayList<Equipo> listaEquipos;
    private ArrayList<Jugador> listaJugadores;
    private Boolean editar;
    private Equipo equipo;
    
    /**
     * Creates new form PanelInicio
     */
    public PanelInicio(VentanaExamen miVentana) {
        initComponents();
        
        cargarTablaEquipos();
        editar = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        btnAnyadir = new javax.swing.JButton();
        btnPresupuesto = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        tbCiudad = new javax.swing.JTextField();
        tbPresupuesto = new javax.swing.JTextField();
        tbNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnJugadores = new javax.swing.JButton();

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dorsal", "Nombre", "Salario", "Nombre Equipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaJugadores);

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Ciudad", "Presupuesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaEquipos);

        btnAnyadir.setText("Añadir");
        btnAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnyadirActionPerformed(evt);
            }
        });

        btnPresupuesto.setText("Presupuesto");
        btnPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresupuestoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Ciudad");

        jLabel3.setText("Presupuesto");

        btnJugadores.setText("Jugadores");
        btnJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tbPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnPresupuesto)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(btnAnyadir)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(btnJugadores)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tbPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnyadir)
                            .addComponent(btnEliminar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPresupuesto)
                            .addComponent(btnModificar))
                        .addGap(18, 18, 18)
                        .addComponent(btnJugadores)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnyadirActionPerformed
        if (editar) {
            DAOEquipoJugador.getInstance().editarEquipo(equipo, tbNombre.getText().toString(), tbCiudad.getText().toString(), Integer.parseInt(tbPresupuesto.getText().toString()));
            
            JOptionPane.showMessageDialog(null, "Equipo editado correctamente.");
            cargarTablaEquipos();

            btnAnyadir.setText("Añadir");
            editar = false;
        }
        else {
            if (tbPresupuesto.getText().equals("") || tbNombre.getText().equals("") || tbCiudad.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debes introducir todos los valores para poder registrar un equipo.");
            }
            else {
                equipo = new Equipo(tbNombre.getText().toString(), tbCiudad.getText().toString(), Integer.parseInt(tbPresupuesto.getText().toString()));
                if (!DAOEquipoJugador.getInstance().insertarEquipo(equipo)) {
                    JOptionPane.showMessageDialog(null, "No se pueden introducir 2 equipos con el mismo nombre.");
                }
                
                cargarTablaEquipos();
            }
        }
        
        this.updateUI();
    }//GEN-LAST:event_btnAnyadirActionPerformed

    private void btnJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugadoresActionPerformed
        if(tablaEquipos.getSelectedRowCount() == 1) {
            int[] filas = tablaEquipos.getSelectedRows();
            
            equipo = listaEquipos.get(filas[0]);
            cargarTablaJugadores();
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar solo un equipo.");
        }
    }//GEN-LAST:event_btnJugadoresActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaEquipos.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar mínimo un usuario para poder eliminarlo.");
        }
        else {
            int[] filas = tablaEquipos.getSelectedRows();
            ArrayList<Equipo> equipos = new ArrayList<Equipo>();
            
            for (int i = 0; i < filas.length; i++) {
                equipos.add(listaEquipos.get(filas[i]));
            }
            
            if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar los equipos?", "CUIDADO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                for (int i = 0; i < equipos.size(); i++) {
                    DAOEquipoJugador.getInstance().eliminarJugadores(equipos.get(i));
                }
                DAOEquipoJugador.getInstance().eliminarEquipos(equipos);
            }
            
            cargarTablaEquipos();
        }
        
        this.updateUI();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (!editar) {
            if (tablaEquipos.getSelectedRowCount() == 1) {
                equipo = listaEquipos.get(tablaEquipos.getSelectedRow());

                tbNombre.setText(tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 0).toString());
                tbCiudad.setText(tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 1).toString());
                tbPresupuesto.setText(tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 2).toString());

                btnAnyadir.setText("Editar");
                btnModificar.setText("Cancelar");
                editar = true;
            }
            else if (tablaEquipos.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar mínimo un usuario para poder editarlo.");
            }
            else {
                JOptionPane.showMessageDialog(null, "No puedes editar más de un usuario a la vez.");
            }
        }
        else {
            editar = false;
            
            btnAnyadir.setText("Registrar");
            btnModificar.setText("Leer");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresupuestoActionPerformed
        String cadena = "";
        
        JOptionPane.showMessageDialog(null, cadena);
    }//GEN-LAST:event_btnPresupuestoActionPerformed
    
    public void cargarTablaEquipos() {
        listaEquipos = DAOEquipoJugador.getInstance().getEquipos();
        
        DAOEquipoJugador.getInstance().fillTable(tablaEquipos, "SELECT * FROM equipo");
    }
    
    public void cargarTablaJugadores() {
        if (tablaEquipos.getSelectedRowCount() == 1) {
            listaJugadores = DAOEquipoJugador.getInstance().getJugadores(equipo);
        
            DAOEquipoJugador.getInstance().fillTable(tablaJugadores, "SELECT * FROM jugador WHERE NOM_EQUIPO = " + equipo.getNombre());
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnyadir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnJugadores;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPresupuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTable tablaJugadores;
    private javax.swing.JTextField tbCiudad;
    private javax.swing.JTextField tbNombre;
    private javax.swing.JTextField tbPresupuesto;
    // End of variables declaration//GEN-END:variables
}