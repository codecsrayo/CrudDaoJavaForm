package crud1.daoapp;

import crud.daoapp.conexion.Conectar;
import crud.daoapp.controller.FuncionarioController;

import crud.daoapp.dominio.Ciudad;
import crud.daoapp.dominio.EstadoCivil;
import crud.daoapp.dominio.Funcionario;
import crud.daoapp.dominio.Sexo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewFuncionario extends javax.swing.JFrame {
    DefaultTableModel modelo;

    public ViewFuncionario() throws SQLException {
        initComponents();

        setSize(1150, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        String[] titulos = { "Cedula", "Nombres", "Apellidos", "Celular", "Estado", "Sexo", "Fecha", "Direccion",
                "Ciudad" };
        modelo = new DefaultTableModel(null, titulos);
        tblfuncionarios.setModel(modelo);

        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = fecha.format(new Date());
        try {
            jDateFN.setDate(fecha.parse(fechaActual));
        } catch (ParseException ex) {
            Logger.getLogger(ViewFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        mostrarDatosTabla();
        llenarEstadoCivil();
        llenarSexo();
        llenarCiudad();
        limpiar();
        txtidestadocivil.setVisible(false);
        txtidsexo.setVisible(false);
        txtidciudad.setVisible(false);
        txtfechanacimiento.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneComponentes = new javax.swing.JScrollPane();
        tblfuncionarios = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        txtidsexo = new javax.swing.JTextField();
        txtidestadocivil = new javax.swing.JTextField();
        txtidciudad = new javax.swing.JTextField();
        lbltitulo = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        jPanelCampos = new javax.swing.JPanel();
        txtidfuncionario = new javax.swing.JTextField();
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxestadocivil = new javax.swing.JComboBox<>();
        cbxsexo = new javax.swing.JComboBox<>();
        cbxciudad = new javax.swing.JComboBox<>();
        lblvalidarid = new javax.swing.JLabel();
        lblvalidarciudad = new javax.swing.JLabel();
        lblvalidarnombre = new javax.swing.JLabel();
        lblvalidarapellido = new javax.swing.JLabel();
        lblvalidarcelular = new javax.swing.JLabel();
        lblvalidarestadocivil = new javax.swing.JLabel();
        lblvalidarsexo = new javax.swing.JLabel();
        lblvalidarfechanacimiento = new javax.swing.JLabel();
        lblvalidardireccion = new javax.swing.JLabel();
        jDateFN = new com.toedter.calendar.JDateChooser();
        txtfechanacimiento = new javax.swing.JTextField();

        setTitle("INFORMACIÓN DE FUNCIONARIO");
        setName("framePpal"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblfuncionarios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        tblfuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblfuncionariosMouseClicked(evt);
            }
        });
        jScrollPaneComponentes.setViewportView(tblfuncionarios);

        getContentPane().add(jScrollPaneComponentes,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 472, 1350, 200));

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, -1, -1));

        btnsalir.setText("Salir");
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnsalirMousePressed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, -1, -1));

        btnborrar.setText("Borrar");
        btnborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnborrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, -1, -1));
        getContentPane().add(txtidsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, -1));
        getContentPane().add(txtidestadocivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, -1, -1));
        getContentPane().add(txtidciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 72, -1));

        lbltitulo.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        getContentPane().add(lbltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, 55));
        lbltitulo.getAccessibleContext().setAccessibleName("lbltitulo");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, -1, -1));

        jPanelCampos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelCampos.add(txtidfuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 165, -1));
        jPanelCampos.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 368, -1));
        jPanelCampos.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 382, -1));
        jPanelCampos.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 155, -1));
        jPanelCampos.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 368, -1));

        jLabel1.setText("Identificación");
        jPanelCampos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel2.setText("Nombres");
        jPanelCampos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jLabel3.setText("Apellidos");
        jPanelCampos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, -1));

        jLabel4.setText("Celular");
        jPanelCampos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        jLabel5.setText("Sexo");
        jPanelCampos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        jLabel6.setText("Estado Civil");
        jPanelCampos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        jLabel7.setText("Dirección");
        jPanelCampos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        jLabel8.setText("Fecha Nacimiento");
        jPanelCampos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, -1, -1));

        jLabel9.setText("Ciudad");
        jPanelCampos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jPanelCampos.add(cbxestadocivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 152, -1));

        jPanelCampos.add(cbxsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 160, -1));

        jPanelCampos.add(cbxciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 155, -1));

        lblvalidarid.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidarid.setText("Campo Requerido");
        jPanelCampos.add(lblvalidarid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 159, -1));

        lblvalidarciudad.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidarciudad.setText("Campo Requerido");
        jPanelCampos.add(lblvalidarciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 155, -1));

        lblvalidarnombre.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidarnombre.setText("Campo Requerido");
        jPanelCampos.add(lblvalidarnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 368, -1));

        lblvalidarapellido.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidarapellido.setText("Campo Requerido");
        jPanelCampos.add(lblvalidarapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 382, -1));

        lblvalidarcelular.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidarcelular.setText("Campo Requerido");
        jPanelCampos.add(lblvalidarcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 155, -1));

        lblvalidarestadocivil.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidarestadocivil.setText("Campo Requerido");
        jPanelCampos.add(lblvalidarestadocivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 152, -1));

        lblvalidarsexo.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidarsexo.setText("Campo Requerido");
        jPanelCampos.add(lblvalidarsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 160, -1));

        lblvalidarfechanacimiento.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidarfechanacimiento.setText("Campo Requerido");
        jPanelCampos.add(lblvalidarfechanacimiento,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 159, -1));

        lblvalidardireccion.setForeground(new java.awt.Color(255, 0, 51));
        lblvalidardireccion.setText("Campo Requerido");
        jPanelCampos.add(lblvalidardireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 368, -1));

        jDateFN.setDateFormatString("yyyy-MM-dd");
        jDateFN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jDateFNMousePressed(evt);
            }
        });
        jDateFN.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jDateFNInputMethodTextChanged(evt);
            }
        });
        jPanelCampos.add(jDateFN, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 160, -1));

        getContentPane().add(jPanelCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 900, 300));
        getContentPane().add(txtfechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 80, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnagregarActionPerformed
        try {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0)
                agregarFuncionario();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Funcionario no se pudo Agregar");
            Logger.getLogger(ViewFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_btnagregarActionPerformed

    private void btnborrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnborrarActionPerformed
        try {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0)
                borrarFuncionario();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Funcionario no se pudo eliminar");
            Logger.getLogger(ViewFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_btnborrarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnactualizarActionPerformed
        try {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0)
                actualizarFuncionario();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Funcionario no se pudo actualizar");
            Logger.getLogger(ViewFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_btnactualizarActionPerformed

    private void tblfuncionariosMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblfuncionariosMouseClicked

        try {
            if (evt.getClickCount() == 1) {

                JTable receptor = (JTable) evt.getSource();

                txtidfuncionario.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
                txtnombres.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
                txtapellidos.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
                txtcelular.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
                txtidestadocivil.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
                txtidsexo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());
                txtfechanacimiento.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString());
                txtdireccion.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
                txtidciudad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString());

                cbxestadocivil.setSelectedIndex(Integer.parseInt(txtidestadocivil.getText()));
                cbxsexo.setSelectedIndex(Integer.parseInt(txtidsexo.getText()));
                cbxciudad.setSelectedIndex(Integer.parseInt(txtidciudad.getText()));

                SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                jDateFN.setDate(fecha.parse(txtfechanacimiento.getText()));

                btnborrar.setEnabled(true);
                btnactualizar.setEnabled(true);
                txtidfuncionario.setEnabled(false);

            }
        } catch (NumberFormatException e) {
            System.out.println("Error : " + e);
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }// GEN-LAST:event_tblfuncionariosMouseClicked

    private void btnsalirMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnsalirMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0)
                System.exit(0);
        }
    }// GEN-LAST:event_btnsalirMousePressed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }// GEN-LAST:event_btncancelarActionPerformed

    private void jDateFNMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jDateFNMousePressed
        // TODO add your handling code here:
        System.out.println("Fecha = " + jDateFN.getDate());
        System.out.println("Fecha2 = " + jDateFN.getDate().getTime());
    }// GEN-LAST:event_jDateFNMousePressed

    private void jDateFNInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {// GEN-FIRST:event_jDateFNInputMethodTextChanged
        // TODO add your handling code here:
        System.out.println("Fecha = " + jDateFN.getDate());
        System.out.println("Fecha2 = " + jDateFN.getDate().getTime());
    }// GEN-LAST:event_jDateFNInputMethodTextChanged

    public ArrayList<Sexo> getSexo() throws SQLException {

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = Conectar.getConnection();
            ArrayList<Sexo> listasexo = new ArrayList<>();

            // modificar le nombre de la base de datos [DAO]

            String strSentenciaSQL = "SELECT * FROM [DAO].dbo.sexo";
            pstm = connection.prepareStatement(strSentenciaSQL);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {

                Sexo sex = new Sexo();

                sex.setIdsexo(resultado.getInt("idsexo"));
                sex.setSexo(resultado.getString("sexo"));
                listasexo.add(sex);
            }
            return listasexo;

        } catch (SQLException e) {
            System.out.println("Error " + e);
            return null;
        } finally {
            int CLOSE_CURSORS_AT_COMMIT = ResultSet.CLOSE_CURSORS_AT_COMMIT;
            System.out.println("ResultSet cerrado " + CLOSE_CURSORS_AT_COMMIT);
            int CLOSE_ALL_RESULTS = PreparedStatement.CLOSE_ALL_RESULTS;
            System.out.println("PreparedStatement cerrado " + CLOSE_ALL_RESULTS);
            connection.close();
            System.out.println("Conexion BD cerrada en Recuperar Sexo");
        }
    }

    private void llenarSexo() {
        try {
            ArrayList<Sexo> listasexo;
            cbxsexo.removeAllItems();
            listasexo = getSexo();

            for (int i = 0; i < listasexo.size(); i++) {

                cbxsexo.addItem(new Sexo(listasexo.get(i).getIdsexo(), listasexo.get(i).getSexo()));
            }

        } catch (SQLException e) {
            System.out.println("Error :" + e);
        }

    }

    public ArrayList<EstadoCivil> getEstadoCivil() throws SQLException {

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = Conectar.getConnection();
            ArrayList<EstadoCivil> listaestadocivil = new ArrayList<>();

            String strSentenciaSQL = "SELECT * FROM [DAO].dbo.estadocivil";
            pstm = connection.prepareStatement(strSentenciaSQL);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {

                EstadoCivil EC = new EstadoCivil();

                EC.setIdestadocivil(resultado.getInt("idestadocivil"));
                EC.setEstadocivil(resultado.getString("estadocivil"));
                listaestadocivil.add(EC);
            }
            return listaestadocivil;

        } catch (SQLException e) {
            System.out.println("Error " + e);
            return null;
        } finally {
            int CLOSE_CURSORS_AT_COMMIT = ResultSet.CLOSE_CURSORS_AT_COMMIT;
            System.out.println("ResultSet cerrado " + CLOSE_CURSORS_AT_COMMIT);
            int CLOSE_ALL_RESULTS = PreparedStatement.CLOSE_ALL_RESULTS;
            System.out.println("PreparedStatement cerrado " + CLOSE_ALL_RESULTS);
            connection.close();
            System.out.println("Conexion a BD Cerrada en recuperar Estado Civil");

        }

    }

    private void llenarEstadoCivil() {
        try {
            ArrayList<EstadoCivil> listaestadocivil;

            listaestadocivil = getEstadoCivil();
            cbxestadocivil.removeAllItems();

            for (int i = 0; i < listaestadocivil.size(); i++) {

                cbxestadocivil.addItem(new EstadoCivil(listaestadocivil.get(i).getIdestadocivil(),
                        listaestadocivil.get(i).getEstadocivil()));
            }

        } catch (SQLException e) {
            System.out.println("Error :" + e);
        }

    }

    public ArrayList<Ciudad> getCiudad() throws SQLException {

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = Conectar.getConnection();
            ArrayList<Ciudad> listaciudad = new ArrayList<>();

            String strSentenciaSQL = "SELECT * FROM [DAO].dbo.ciudad";
            pstm = connection.prepareStatement(strSentenciaSQL);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {

                Ciudad Ciu = new Ciudad();

                Ciu.setIdciudad(resultado.getInt("idciudad"));
                Ciu.setCiudad(resultado.getString("ciudad"));
                listaciudad.add(Ciu);
            }
            return listaciudad;

        } catch (SQLException e) {
            System.out.println("Error " + e);
            return null;
        } finally {
            int CLOSE_CURSORS_AT_COMMIT = ResultSet.CLOSE_CURSORS_AT_COMMIT;
            System.out.println("ResultSet cerrado " + CLOSE_CURSORS_AT_COMMIT);
            int CLOSE_ALL_RESULTS = PreparedStatement.CLOSE_ALL_RESULTS;
            System.out.println("PreparedStatement cerrado " + CLOSE_ALL_RESULTS);
            connection.close();
            System.out.println("Conexion a BD Cerrada en recuperar Ciudad");
        }
    }

    private void llenarCiudad() {
        try {
            ArrayList<Ciudad> listaciudad;

            listaciudad = getCiudad();
            cbxciudad.removeAllItems();

            for (int i = 0; i < listaciudad.size(); i++) {

                cbxciudad.addItem(new Ciudad(listaciudad.get(i).getIdciudad(), listaciudad.get(i).getCiudad()));
            }

        } catch (Exception e) {
            System.out.println("Error :" + e);
        }

    }

    private void limpiar() {

        String texto = "";
        txtidfuncionario.setText(texto);
        txtnombres.setText(texto);
        txtapellidos.setText(texto);
        txtcelular.setText(texto);
        txtidestadocivil.setText(texto);
        cbxestadocivil.setSelectedIndex(0);
        cbxsexo.setSelectedIndex(0);
        cbxciudad.setSelectedIndex(0);
        txtidsexo.setText(texto);
        txtfechanacimiento.setText(texto);
        txtdireccion.setText(texto);
        txtidciudad.setText(texto);

        btnagregar.setEnabled(true);
        btnactualizar.setEnabled(false);
        btnborrar.setEnabled(false);
        btnsalir.setEnabled(true);
        txtidfuncionario.setEnabled(true);
        lblvalidarid.setVisible(false);
        lblvalidarciudad.setVisible(false);
        lblvalidarnombre.setVisible(false);
        lblvalidarapellido.setVisible(false);
        lblvalidarcelular.setVisible(false);
        lblvalidarestadocivil.setVisible(false);
        lblvalidarsexo.setVisible(false);
        lblvalidarfechanacimiento.setVisible(false);
        lblvalidardireccion.setVisible(false);

        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = fecha.format(new Date());
        try {
            jDateFN.setDate(fecha.parse(fechaActual));
        } catch (ParseException ex) {
            Logger.getLogger(ViewFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Funcionario recuperarFuncionario() {

        Funcionario objfuncionario = new Funcionario();

        boolean valido = true;

        objfuncionario.setIdfuncionario(txtidfuncionario.getText());
        if (txtidfuncionario.getText().isBlank()) {
            valido = false;
            lblvalidarid.setVisible(true);

        } else {
            lblvalidarid.setVisible(false);
        }
        objfuncionario.setNombres(txtnombres.getText());
        if (txtnombres.getText().isBlank()) {
            valido = false;
            lblvalidarnombre.setVisible(true);

        } else {
            lblvalidarnombre.setVisible(false);
        }
        objfuncionario.setApellidos(txtapellidos.getText());
        if (txtapellidos.getText().isBlank()) {
            valido = false;
            lblvalidarapellido.setVisible(true);

        } else {
            lblvalidarapellido.setVisible(false);
        }
        objfuncionario.setCelular(txtcelular.getText());
        if (txtcelular.getText().isBlank()) {
            valido = false;
            lblvalidarcelular.setVisible(true);

        } else {
            lblvalidarcelular.setVisible(false);
        }
        objfuncionario.setIdestadocivil(cbxestadocivil.getItemAt(cbxestadocivil.getSelectedIndex()).getIdestadocivil());
        if (objfuncionario.getIdestadocivil() == 0) {
            valido = false;
            lblvalidarestadocivil.setVisible(true);

        } else {
            lblvalidarestadocivil.setVisible(false);
        }
        objfuncionario.setIdsexo(cbxsexo.getItemAt(cbxsexo.getSelectedIndex()).getIdsexo());
        if (objfuncionario.getIdsexo() == 0) {
            valido = false;
            lblvalidarsexo.setVisible(true);

        } else {
            lblvalidarsexo.setVisible(false);
        }
        objfuncionario.setIdciudad(cbxciudad.getItemAt(cbxciudad.getSelectedIndex()).getIdciudad());
        if (objfuncionario.getIdciudad() == 0) {
            valido = false;
            lblvalidarciudad.setVisible(true);

        } else {
            lblvalidarciudad.setVisible(false);
        }

        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Fecha Recuperada" + String.valueOf(fecha.format(jDateFN.getDate())));
        txtfechanacimiento.setText(String.valueOf(fecha.format(jDateFN.getDate())));
        objfuncionario.setFechanacimiento(txtfechanacimiento.getText());
        if (txtfechanacimiento.getText().isBlank()) {
            valido = false;
            lblvalidarfechanacimiento.setVisible(true);

        } else {
            lblvalidarfechanacimiento.setVisible(false);
        }
        objfuncionario.setDireccion(txtdireccion.getText());
        if (txtdireccion.getText().isBlank()) {
            valido = false;
            lblvalidardireccion.setVisible(true);

        } else {
            lblvalidardireccion.setVisible(false);
        }
        if (valido == true) {

            return objfuncionario;
        } else {

            return null;
        }
    }

    private void mostrarDatosTabla() throws SQLException {
        FuncionarioController funcionarioController = new FuncionarioController();
        List<Funcionario> listafuncionarios = new ArrayList<>();
        Connection connection = null;
        connection = Conectar.getConnection();
        System.out.println("Conexión a la BD establecida en Mostrar datos ");

        try {
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            listafuncionarios = funcionarioController.obtenerFuncionarios();

            listafuncionarios.forEach(funcionario -> {
                Object[] objfuncionario = { funcionario.getIdfuncionario(), funcionario.getNombres(),
                        funcionario.getApellidos(), funcionario.getCelular(), funcionario.getIdestadocivil(),
                        funcionario.getIdsexo(), funcionario.getFechanacimiento(), funcionario.getDireccion(),
                        funcionario.getIdciudad() };
                modelo.addRow(objfuncionario);
            });
        } catch (SQLException e) {
            System.out.println("Error " + e);
        } finally {
            int CLOSE_CURSORS_AT_COMMIT = ResultSet.CLOSE_CURSORS_AT_COMMIT;
            System.out.println("ResultSet cerrado " + CLOSE_CURSORS_AT_COMMIT);
            int CLOSE_ALL_RESULTS = PreparedStatement.CLOSE_ALL_RESULTS;
            System.out.println("PreparedStatement cerrado " + CLOSE_ALL_RESULTS);
            connection.close();
            System.out.println("Conexion a BD Cerrada en Mostrar datos en tabla");
        }
    }

    public void agregarFuncionario() throws SQLException {
        FuncionarioController funcionarioController = new FuncionarioController();
        Connection connection = null;
        connection = Conectar.getConnection();
        System.out.println("Conexión a la BD establecida en Agregar Funcionario ");
        try {
            Funcionario funcionario = recuperarFuncionario();
            if (funcionario == null) {
                JOptionPane.showMessageDialog(null, "No se pudo crear el funcionario faltan campos requeridos");
            } else {
                String id = funcionario.getIdfuncionario();
                Funcionario encontrarFuncionario = funcionarioController.obtenerFuncionario(id);
                if (encontrarFuncionario == null) {

                    funcionarioController.crearFuncionario(funcionario);
                    this.mostrarDatosTabla();
                    JOptionPane.showMessageDialog(null, "Funcionario agregado correctamente");
                    this.limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionario ya existe");
                }
            }
        } catch (HeadlessException e) {
            System.out.println("Funcionario no fue Agregado " + e);
        } catch (NumberFormatException NF) {
            System.out.println("Campos incorrectos " + NF);
        } catch (SQLException ex) {
            Logger.getLogger(ViewFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            int CLOSE_CURSORS_AT_COMMIT = ResultSet.CLOSE_CURSORS_AT_COMMIT;
            System.out.println("ResultSet cerrado " + CLOSE_CURSORS_AT_COMMIT);
            int CLOSE_ALL_RESULTS = PreparedStatement.CLOSE_ALL_RESULTS;
            System.out.println("PreparedStatement cerrado " + CLOSE_ALL_RESULTS);
            connection.close();
            System.out.println("Conexion a BD Cerrada en Agegar Funcionario");
        }
    }

    public void borrarFuncionario() throws SQLException {
        FuncionarioController funcionarioController = new FuncionarioController();
        Connection connection = null;
        connection = Conectar.getConnection();
        System.out.println("Conexión a la BD establecida en Borrar Funcionario ");
        try {
            Funcionario objfuncionario = recuperarFuncionario();
            String id = objfuncionario.getIdfuncionario();
            funcionarioController.eliminarFuncionario(id);
            this.mostrarDatosTabla();
            this.limpiar();
            JOptionPane.showMessageDialog(null, "Funcionario eliminado correctamente");
        } catch (HeadlessException e) {
            System.out.println("Error al borar registro " + e);
        } catch (SQLException ex) {
            Logger.getLogger(ViewFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            int CLOSE_CURSORS_AT_COMMIT = ResultSet.CLOSE_CURSORS_AT_COMMIT;
            System.out.println("ResultSet cerrado " + CLOSE_CURSORS_AT_COMMIT);
            int CLOSE_ALL_RESULTS = PreparedStatement.CLOSE_ALL_RESULTS;
            System.out.println("PreparedStatement cerrado " + CLOSE_ALL_RESULTS);
            connection.close();
            System.out.println("Conexion a BD Cerrada en Borrar Funcionario");
        }
    }

    public void actualizarFuncionario() throws SQLException {
        FuncionarioController funcionarioController = new FuncionarioController();
        Connection connection = null;
        connection = Conectar.getConnection();
        System.out.println("Conexión a la BD establecida en Actualizar ");
        try {
            Funcionario objfuncionario = recuperarFuncionario();
            String id = objfuncionario.getIdfuncionario();
            funcionarioController.actualizarFuncionario(id, objfuncionario);
            this.mostrarDatosTabla();
            JOptionPane.showMessageDialog(null, "Funcionario actualizado correctamente");
            this.limpiar();
        } catch (HeadlessException e) {
            System.out.println("Funcionario no fue Agregado " + e);
        } catch (NumberFormatException NF) {
            System.out.println("Campos incorrectos " + NF);
        } finally {
            int CLOSE_CURSORS_AT_COMMIT = ResultSet.CLOSE_CURSORS_AT_COMMIT;
            System.out.println("ResultSet cerrado " + CLOSE_CURSORS_AT_COMMIT);
            int CLOSE_ALL_RESULTS = PreparedStatement.CLOSE_ALL_RESULTS;
            System.out.println("PreparedStatement cerrado " + CLOSE_ALL_RESULTS);
            connection.close();
            System.out.println("Conexion a BD Cerrada en Actualizar Funcionario");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ViewFuncionario().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ViewFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<Ciudad> cbxciudad;
    private javax.swing.JComboBox<EstadoCivil> cbxestadocivil;
    private javax.swing.JComboBox<Sexo> cbxsexo;
    private com.toedter.calendar.JDateChooser jDateFN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JScrollPane jScrollPaneComponentes;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lblvalidarapellido;
    private javax.swing.JLabel lblvalidarcelular;
    private javax.swing.JLabel lblvalidarciudad;
    private javax.swing.JLabel lblvalidardireccion;
    private javax.swing.JLabel lblvalidarestadocivil;
    private javax.swing.JLabel lblvalidarfechanacimiento;
    private javax.swing.JLabel lblvalidarid;
    private javax.swing.JLabel lblvalidarnombre;
    private javax.swing.JLabel lblvalidarsexo;
    private javax.swing.JTable tblfuncionarios;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtfechanacimiento;
    private javax.swing.JTextField txtidciudad;
    private javax.swing.JTextField txtidestadocivil;
    private javax.swing.JTextField txtidfuncionario;
    private javax.swing.JTextField txtidsexo;
    private javax.swing.JTextField txtnombres;
    // End of variables declaration//GEN-END:variables
}
