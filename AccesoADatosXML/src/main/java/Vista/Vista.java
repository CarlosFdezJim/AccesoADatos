/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CrearEquipoXml;
import Controlador.CrearJugadorXml;
import Controlador.CrearLigaXml;
import Controlador.Equipos_Controlador;
import Controlador.Jugador_Controlador;
import Controlador.Liga_Controlador;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Fernández
 */
public class Vista extends javax.swing.JFrame {    

    public Vista() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelLigas = new javax.swing.JPanel();
        txtNumEquipos_Ligas = new javax.swing.JTextField();
        jButtonEliminar_Ligas = new javax.swing.JButton();
        txtNumLigas_Ligas = new javax.swing.JTextField();
        txtFederacion_Ligas = new javax.swing.JTextField();
        jButtonAceptar_Ligas = new javax.swing.JButton();
        jButtonCancelar_Ligas = new javax.swing.JButton();
        txtNombre_Ligas = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableLigas = new javax.swing.JTable();
        txtID_Ligas = new javax.swing.JTextField();
        jButtonInsertar_Ligas = new javax.swing.JButton();
        jButtonModificar_Ligas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanelEquipo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableEquipos = new javax.swing.JTable();
        txtID_Equipos = new javax.swing.JTextField();
        txtLiga_Equipos = new javax.swing.JTextField();
        txtNumJugadores_Equipos = new javax.swing.JTextField();
        txtPresupuesto_Equipos = new javax.swing.JTextField();
        txtNombre_Equipos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxEquipos = new javax.swing.JComboBox<>();
        jButtonInsertar_Equipos = new javax.swing.JButton();
        jButtonEliminar_Equipos = new javax.swing.JButton();
        jButtonModificar_Equipos = new javax.swing.JButton();
        jButtonAceptar_Equipos = new javax.swing.JButton();
        jButtonCancelar_Equipos = new javax.swing.JButton();
        jPanelJugadores = new javax.swing.JPanel();
        txtNombre_Jugadores = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableJugadores = new javax.swing.JTable();
        txtDNI_Jugadores = new javax.swing.JTextField();
        txtClub_Jugadores = new javax.swing.JTextField();
        txtPosicion_Jugadores = new javax.swing.JTextField();
        txtDorsal_Jugadores = new javax.swing.JTextField();
        jButtonInsertar_Jugador = new javax.swing.JButton();
        jButtonEliminar_Jugador = new javax.swing.JButton();
        jButtonModificar_Jugador = new javax.swing.JButton();
        jButtonAceptar_Jugador = new javax.swing.JButton();
        jButtonCancelar_Jugador = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxJugador = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtNumEquipos_Ligas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumEquipos_LigasActionPerformed(evt);
            }
        });

        jButtonEliminar_Ligas.setText("Eliminar");

        txtNumLigas_Ligas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumLigas_LigasActionPerformed(evt);
            }
        });

        txtFederacion_Ligas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFederacion_LigasActionPerformed(evt);
            }
        });

        jButtonAceptar_Ligas.setText("Aceptar");

        jButtonCancelar_Ligas.setText("Cancelar");

        txtNombre_Ligas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_LigasActionPerformed(evt);
            }
        });

        jTableLigas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Nº Equipos", "Nº Ligas", "Federación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLigas.setRowHeight(25);
        jTableLigas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLigasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableLigas);
        if (jTableLigas.getColumnModel().getColumnCount() > 0) {
            jTableLigas.getColumnModel().getColumn(0).setResizable(false);
            jTableLigas.getColumnModel().getColumn(1).setResizable(false);
            jTableLigas.getColumnModel().getColumn(2).setResizable(false);
            jTableLigas.getColumnModel().getColumn(3).setResizable(false);
            jTableLigas.getColumnModel().getColumn(4).setResizable(false);
        }

        txtID_Ligas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtID_LigasActionPerformed(evt);
            }
        });

        jButtonInsertar_Ligas.setText("Insertar");
        jButtonInsertar_Ligas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertar_LigasActionPerformed(evt);
            }
        });

        jButtonModificar_Ligas.setText("Modificar");
        jButtonModificar_Ligas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar_LigasActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Equipo");

        jLabel2.setText("Nombre equipo");

        jLabel3.setText("Número de Equipos");

        jLabel4.setText("Número de Ligas");

        jLabel5.setText("Federación");

        javax.swing.GroupLayout jPanelLigasLayout = new javax.swing.GroupLayout(jPanelLigas);
        jPanelLigas.setLayout(jPanelLigasLayout);
        jPanelLigasLayout.setHorizontalGroup(
            jPanelLigasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLigasLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanelLigasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLigasLayout.createSequentialGroup()
                        .addComponent(jButtonInsertar_Ligas)
                        .addGap(221, 221, 221)
                        .addComponent(jButtonEliminar_Ligas)
                        .addGap(210, 210, 210)
                        .addComponent(jButtonModificar_Ligas))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131)
                .addGroup(jPanelLigasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(jPanelLigasLayout.createSequentialGroup()
                        .addComponent(jButtonAceptar_Ligas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar_Ligas))
                    .addComponent(txtID_Ligas)
                    .addComponent(txtNombre_Ligas)
                    .addComponent(txtNumEquipos_Ligas)
                    .addComponent(txtNumLigas_Ligas)
                    .addComponent(txtFederacion_Ligas))
                .addGap(95, 95, 95))
        );
        jPanelLigasLayout.setVerticalGroup(
            jPanelLigasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLigasLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanelLigasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLigasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID_Ligas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre_Ligas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumEquipos_Ligas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumLigas_Ligas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtFederacion_Ligas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanelLigasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar_Ligas)
                    .addComponent(jButtonAceptar_Ligas)
                    .addComponent(jButtonModificar_Ligas)
                    .addComponent(jButtonEliminar_Ligas)
                    .addComponent(jButtonInsertar_Ligas))
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("Ligas", jPanelLigas);

        jPanelEquipo.setEnabled(false);

        jTableEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Liga", "Nº Jugadores", "Presupuesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEquipos.setEditingColumn(0);
        jTableEquipos.setEditingRow(0);
        jTableEquipos.setRowHeight(25);
        jTableEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEquiposMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableEquipos);
        if (jTableEquipos.getColumnModel().getColumnCount() > 0) {
            jTableEquipos.getColumnModel().getColumn(0).setResizable(false);
            jTableEquipos.getColumnModel().getColumn(1).setResizable(false);
            jTableEquipos.getColumnModel().getColumn(2).setResizable(false);
            jTableEquipos.getColumnModel().getColumn(3).setResizable(false);
            jTableEquipos.getColumnModel().getColumn(4).setResizable(false);
        }

        txtID_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtID_EquiposActionPerformed(evt);
            }
        });

        txtLiga_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLiga_EquiposActionPerformed(evt);
            }
        });

        txtNumJugadores_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumJugadores_EquiposActionPerformed(evt);
            }
        });

        txtPresupuesto_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPresupuesto_EquiposActionPerformed(evt);
            }
        });

        txtNombre_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_EquiposActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Equipo");

        jLabel8.setText("Nombre Equipo");

        jLabel9.setText("Liga");

        jLabel10.setText("Nº Jugadores");

        jLabel11.setText("Presupuesto");

        jComboBoxEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquiposActionPerformed(evt);
            }
        });

        jButtonInsertar_Equipos.setText("Insertar");
        jButtonInsertar_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertar_EquiposActionPerformed(evt);
            }
        });

        jButtonEliminar_Equipos.setText("Eliminar");
        jButtonEliminar_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar_EquiposActionPerformed(evt);
            }
        });

        jButtonModificar_Equipos.setText("Modificar");
        jButtonModificar_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar_EquiposActionPerformed(evt);
            }
        });

        jButtonAceptar_Equipos.setText("Aceptar");

        jButtonCancelar_Equipos.setText("Cancelar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonInsertar_Equipos)
                        .addGap(162, 162, 162)
                        .addComponent(jButtonEliminar_Equipos)
                        .addGap(222, 222, 222)
                        .addComponent(jButtonModificar_Equipos))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxEquipos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jButtonAceptar_Equipos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar_Equipos))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addGap(0, 222, Short.MAX_VALUE))
                        .addComponent(txtNumJugadores_Equipos)
                        .addComponent(txtLiga_Equipos)
                        .addComponent(txtNombre_Equipos)
                        .addComponent(txtID_Equipos)
                        .addComponent(txtPresupuesto_Equipos)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID_Equipos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre_Equipos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLiga_Equipos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumJugadores_Equipos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPresupuesto_Equipos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsertar_Equipos)
                    .addComponent(jButtonEliminar_Equipos)
                    .addComponent(jButtonModificar_Equipos)
                    .addComponent(jButtonAceptar_Equipos)
                    .addComponent(jButtonCancelar_Equipos))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout jPanelEquipoLayout = new javax.swing.GroupLayout(jPanelEquipo);
        jPanelEquipo.setLayout(jPanelEquipoLayout);
        jPanelEquipoLayout.setHorizontalGroup(
            jPanelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipoLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanelEquipoLayout.setVerticalGroup(
            jPanelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Equipos", jPanelEquipo);

        txtNombre_Jugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_JugadoresActionPerformed(evt);
            }
        });

        jTableJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Club", "Posición", "Dorsal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableJugadores.setRowHeight(25);
        jTableJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableJugadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableJugadores);
        if (jTableJugadores.getColumnModel().getColumnCount() > 0) {
            jTableJugadores.getColumnModel().getColumn(0).setResizable(false);
            jTableJugadores.getColumnModel().getColumn(1).setResizable(false);
            jTableJugadores.getColumnModel().getColumn(2).setResizable(false);
            jTableJugadores.getColumnModel().getColumn(3).setResizable(false);
            jTableJugadores.getColumnModel().getColumn(4).setResizable(false);
        }

        txtDNI_Jugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNI_JugadoresActionPerformed(evt);
            }
        });

        txtClub_Jugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClub_JugadoresActionPerformed(evt);
            }
        });

        txtPosicion_Jugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosicion_JugadoresActionPerformed(evt);
            }
        });

        txtDorsal_Jugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDorsal_JugadoresActionPerformed(evt);
            }
        });

        jButtonInsertar_Jugador.setText("Insertar");

        jButtonEliminar_Jugador.setText("Eliminar");

        jButtonModificar_Jugador.setText("Modificar");

        jButtonAceptar_Jugador.setText("Aceptar");

        jButtonCancelar_Jugador.setText("Cancelar");

        jLabel12.setText("DNI Jugador");

        jLabel13.setText("Nombre Jugador");

        jLabel14.setText("Club");

        jLabel15.setText("Posición");

        jLabel16.setText("Dorsal");

        jComboBoxJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelJugadoresLayout = new javax.swing.GroupLayout(jPanelJugadores);
        jPanelJugadores.setLayout(jPanelJugadoresLayout);
        jPanelJugadoresLayout.setHorizontalGroup(
            jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                        .addComponent(jButtonInsertar_Jugador)
                        .addGap(161, 161, 161)
                        .addComponent(jButtonEliminar_Jugador)
                        .addGap(206, 206, 206)
                        .addComponent(jButtonModificar_Jugador))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                        .addComponent(jButtonAceptar_Jugador)
                        .addGap(7, 7, 7)
                        .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxJugador, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jButtonCancelar_Jugador))))
                    .addComponent(txtClub_Jugadores)
                    .addComponent(txtNombre_Jugadores)
                    .addComponent(txtDNI_Jugadores, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPosicion_Jugadores)
                    .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                        .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDorsal_Jugadores))
                .addGap(130, 130, 130))
        );
        jPanelJugadoresLayout.setVerticalGroup(
            jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtDNI_Jugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre_Jugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtClub_Jugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPosicion_Jugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDorsal_Jugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jComboBoxJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelJugadoresLayout.createSequentialGroup()
                        .addContainerGap(59, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonModificar_Jugador)
                        .addComponent(jButtonAceptar_Jugador)
                        .addComponent(jButtonCancelar_Jugador))
                    .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonInsertar_Jugador)
                        .addComponent(jButtonEliminar_Jugador)))
                .addGap(74, 74, 74))
        );

        jTabbedPane1.addTab("Jugadores", jPanelJugadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDorsal_JugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDorsal_JugadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDorsal_JugadoresActionPerformed

    private void txtPosicion_JugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosicion_JugadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPosicion_JugadoresActionPerformed

    private void txtClub_JugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClub_JugadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClub_JugadoresActionPerformed

    private void txtDNI_JugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNI_JugadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNI_JugadoresActionPerformed

    private void txtNombre_JugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_JugadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_JugadoresActionPerformed

    private void jButtonInsertar_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertar_EquiposActionPerformed

    }//GEN-LAST:event_jButtonInsertar_EquiposActionPerformed

    private void jButtonEliminar_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar_EquiposActionPerformed


    }//GEN-LAST:event_jButtonEliminar_EquiposActionPerformed

    private void jButtonModificar_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar_EquiposActionPerformed

    }//GEN-LAST:event_jButtonModificar_EquiposActionPerformed

    private void txtNombre_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_EquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_EquiposActionPerformed

    private void txtPresupuesto_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresupuesto_EquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresupuesto_EquiposActionPerformed

    private void txtNumJugadores_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumJugadores_EquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumJugadores_EquiposActionPerformed

    private void txtLiga_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLiga_EquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLiga_EquiposActionPerformed

    private void txtID_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID_EquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID_EquiposActionPerformed

    private void jTableEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEquiposMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel)jTableEquipos.getModel();        
        
//        jTableEquipos.setEnabled(false);
        
       txtID_Equipos.setText(tblModel.getValueAt(jTableEquipos.getSelectedRow(), 0).toString());
       txtNombre_Equipos.setText(tblModel.getValueAt(jTableEquipos.getSelectedRow(), 1).toString());
       txtLiga_Equipos.setText(tblModel.getValueAt(jTableEquipos.getSelectedRow(), 2).toString());
       txtNumJugadores_Equipos.setText(tblModel.getValueAt(jTableEquipos.getSelectedRow(), 3).toString());
       txtPresupuesto_Equipos.setText(tblModel.getValueAt(jTableEquipos.getSelectedRow(), 4).toString());
       
    }//GEN-LAST:event_jTableEquiposMouseClicked

    private void jTableJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableJugadoresMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel)jTableJugadores.getModel();
        
        //jTableJugadores.setEnabled(false);
        
        String tblDNIJugadores = tblModel.getValueAt(jTableJugadores.getSelectedRow(), 0).toString();
        String tblNombreJugadores = tblModel.getValueAt(jTableJugadores.getSelectedRow(), 1).toString();
        String tblClubJugadores = tblModel.getValueAt(jTableJugadores.getSelectedRow(), 2).toString();
        String tblPosicionJugadores = tblModel.getValueAt(jTableJugadores.getSelectedRow(), 3).toString();
        String tblDorsalJugadores = tblModel.getValueAt(jTableJugadores.getSelectedRow(), 4).toString();
        
       txtDNI_Jugadores.setText(tblDNIJugadores);
       txtNombre_Jugadores.setText(tblNombreJugadores);
       txtClub_Jugadores.setText(tblClubJugadores);
       txtPosicion_Jugadores.setText(tblPosicionJugadores);
       txtDorsal_Jugadores.setText(tblDorsalJugadores);
    }//GEN-LAST:event_jTableJugadoresMouseClicked

    private void jButtonModificar_LigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar_LigasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModificar_LigasActionPerformed

    private void jButtonInsertar_LigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertar_LigasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInsertar_LigasActionPerformed

    private void txtID_LigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID_LigasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID_LigasActionPerformed

    private void jTableLigasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLigasMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel)jTableLigas.getModel();
        
        txtID_Ligas.setText(tblModel.getValueAt(jTableLigas.getSelectedRow(), 0).toString());
        txtNombre_Ligas.setText(tblModel.getValueAt(jTableLigas.getSelectedRow(), 1).toString());
        txtNumEquipos_Ligas.setText(tblModel.getValueAt(jTableLigas.getSelectedRow(), 2).toString());
        txtNumLigas_Ligas.setText(tblModel.getValueAt(jTableLigas.getSelectedRow(), 3).toString());
        txtFederacion_Ligas.setText(tblModel.getValueAt(jTableLigas.getSelectedRow(), 4).toString());
        

    }//GEN-LAST:event_jTableLigasMouseClicked

    private void txtNombre_LigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_LigasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_LigasActionPerformed

    private void txtFederacion_LigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFederacion_LigasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFederacion_LigasActionPerformed

    private void txtNumLigas_LigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumLigas_LigasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumLigas_LigasActionPerformed

    private void txtNumEquipos_LigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumEquipos_LigasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumEquipos_LigasActionPerformed

    private void jComboBoxEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEquiposActionPerformed
        this.txtLiga_Equipos.setText(this.jComboBoxEquipos.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxEquiposActionPerformed

    private void jComboBoxJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxJugadorActionPerformed
        this.txtClub_Jugadores.setText(this.jComboBoxJugador.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxJugadorActionPerformed

    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException{
       Vista v = new Vista();
       
       CrearJugadorXml x = new CrearJugadorXml();
       x.CrearXML();
       CrearEquipoXml z = new CrearEquipoXml();
       z.CrearXML();
       CrearLigaXml y = new CrearLigaXml();
       y.CrearXML();
       
       Jugador_Controlador juga_ctr = new Jugador_Controlador(v);
       juga_ctr.LoadDatabasePlayers();
       Equipos_Controlador equ_ctr = new Equipos_Controlador(v);
       equ_ctr.loadDatabaseTeam();
       Liga_Controlador liga_ctr = new Liga_Controlador(v);
       liga_ctr.LoadDatabaseLeague();
       
       v.setVisible(true);
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAceptar_Equipos;
    public javax.swing.JButton jButtonAceptar_Jugador;
    public javax.swing.JButton jButtonAceptar_Ligas;
    public javax.swing.JButton jButtonCancelar_Equipos;
    public javax.swing.JButton jButtonCancelar_Jugador;
    public javax.swing.JButton jButtonCancelar_Ligas;
    public javax.swing.JButton jButtonEliminar_Equipos;
    public javax.swing.JButton jButtonEliminar_Jugador;
    public javax.swing.JButton jButtonEliminar_Ligas;
    public javax.swing.JButton jButtonInsertar_Equipos;
    public javax.swing.JButton jButtonInsertar_Jugador;
    public javax.swing.JButton jButtonInsertar_Ligas;
    public javax.swing.JButton jButtonModificar_Equipos;
    public javax.swing.JButton jButtonModificar_Jugador;
    public javax.swing.JButton jButtonModificar_Ligas;
    public javax.swing.JComboBox<String> jComboBoxEquipos;
    public javax.swing.JComboBox<String> jComboBoxJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelEquipo;
    private javax.swing.JPanel jPanelJugadores;
    public javax.swing.JPanel jPanelLigas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableEquipos;
    public javax.swing.JTable jTableJugadores;
    public javax.swing.JTable jTableLigas;
    public javax.swing.JTextField txtClub_Jugadores;
    public javax.swing.JTextField txtDNI_Jugadores;
    public javax.swing.JTextField txtDorsal_Jugadores;
    public javax.swing.JTextField txtFederacion_Ligas;
    public javax.swing.JTextField txtID_Equipos;
    public javax.swing.JTextField txtID_Ligas;
    public javax.swing.JTextField txtLiga_Equipos;
    public javax.swing.JTextField txtNombre_Equipos;
    public javax.swing.JTextField txtNombre_Jugadores;
    public javax.swing.JTextField txtNombre_Ligas;
    public javax.swing.JTextField txtNumEquipos_Ligas;
    public javax.swing.JTextField txtNumJugadores_Equipos;
    public javax.swing.JTextField txtNumLigas_Ligas;
    public javax.swing.JTextField txtPosicion_Jugadores;
    public javax.swing.JTextField txtPresupuesto_Equipos;
    // End of variables declaration//GEN-END:variables
}
