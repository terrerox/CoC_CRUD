package view;

import config.Database;
import java.util.Date;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import model.Evento;
//import model.War;

/**
 *
 * @author Admin
 */
public class CrudViewTesting extends javax.swing.JFrame {

    private Database database = new Database();
    private SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    private DefaultTableModel model;
    private int id;
    private String filtro = "ID";
    private String valorComboBox;

    public CrudViewTesting() {
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla("");
        formatearSpinners();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        lugarTxt = new javax.swing.JTextField();
        fechaCalendar = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        horaInicioTxt = new javax.swing.JSpinner(sm);
        SpinnerDateModel sm2 =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        horaFinalTxt = new javax.swing.JSpinner(sm2);
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        loadBtn = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        searchComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));
        jPanel1.setToolTipText("Datos");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setText("Lugar:");

        nombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTxtActionPerformed(evt);
            }
        });

        lugarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lugarTxtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setText("Fecha del evento:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setText("Hora Inicio:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel6.setText("Hora Final:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel7.setText("Detalles:");

        JSpinner.DateEditor de = new JSpinner.DateEditor(horaInicioTxt, "HH:mm:ss");
        horaInicioTxt.setEditor(de);

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(horaFinalTxt, "HH:mm:ss");
        horaFinalTxt.setEditor(de2);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lugarTxt)
                            .addComponent(horaInicioTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreTxt)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(horaFinalTxt)
                            .addComponent(fechaCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(fechaCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(horaInicioTxt)
                    .addComponent(horaFinalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lugarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-plus-+-50.png"))); // NOI18N
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/pencil.png"))); // NOI18N
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/wasteTrash.png"))); // NOI18N
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        loadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/reload.png"))); // NOI18N
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por", "Fecha", "Nombre", "Detalles" }));
        searchComboBox.setToolTipText("SELECT");
        searchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Table"));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Fecha", "Lugar", "Hora inicio", "Hora final", "Detalles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Formulario de datos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        int row = dataTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro");
            return;
        }
        
        id = Integer.parseInt((String) dataTable.getValueAt(row, 0).toString());
        String nombre = (String) dataTable.getValueAt(row, 1);
        Date fecha = (Date) dataTable.getValueAt(row, 2);
        String lugar = (String) dataTable.getValueAt(row, 3);
        Time horaInicio = (Time) dataTable.getValueAt(row, 4);
        Time horaFinal = (Time) dataTable.getValueAt(row, 5);
        String detalles = (String) dataTable.getValueAt(row, 6);
        
        nombreTxt.setText(nombre);
        lugarTxt.setText(lugar);
        horaFinalTxt.setValue(horaFinal);
        horaInicioTxt.setValue(horaInicio);
        jTextArea1.setText(detalles);
        fechaCalendar.setDate(fecha);    
    }//GEN-LAST:event_dataTableMouseClicked

    private void searchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboBoxActionPerformed
        valorComboBox = searchComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_searchComboBoxActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        cargarTabla(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        recargar();
        limpiarTextbox();
    }//GEN-LAST:event_loadBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        eliminar();
        cargarTabla("");
 
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        update();
        cargarTabla("");
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        insertar();
        cargarTabla("");
    }//GEN-LAST:event_addBtnActionPerformed

    private void lugarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lugarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lugarTxtActionPerformed

    private void nombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudViewTesting().setVisible(true);
            }
        });
    }

  private void cargarTabla(String valor) {
        limpiarTabla();
        filtro = asignarValorParaFiltrar();
        try {
            Object[] evento = new Object[7];
            model = (DefaultTableModel) dataTable.getModel();
            List<Evento> eventos = database.getEventos(filtro, valor);
            for (Evento n : eventos) {
                evento[0] = n.getId();
                evento[1] = n.getNombreEvento();
                evento[2] = n.getFecha();
                evento[3] = n.getLugar();
                evento[4] = n.getHoraInicio();
                evento[5] = n.getHoraFinal();
                evento[6] = n.getDetalles();
                model.addRow(evento);
            }
            dataTable.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private String asignarValorParaFiltrar() {
        if (valorComboBox == "Fecha") {
            return "FECHA";
        }

        if (valorComboBox == "Nombre") {
            return "NOMBRE";
        }

        if (valorComboBox == "Detalles") {
            return "DETALLES";
        }
        return "ID";
    }

    private void insertar() {

        String horaInicio = formater.format(horaInicioTxt.getValue());
        String horaFinal = formater.format(horaFinalTxt.getValue());
        String nombre = nombreTxt.getText();
        String lugar = lugarTxt.getText();
        String detalles = jTextArea1.getText();
        Date date = fechaCalendar.getDate();

        if (nombre.equals("") || lugar.equals("") || horaFinal.equals("") || date == null
                || horaInicio.equals("") || detalles.equals("")) {

            JOptionPane.showMessageDialog(null, "Favor de llenar los campos");
        } 
        else  {
            java.sql.Date fecha = new java.sql.Date(date.getTime());

            if (validarHora(Time.valueOf(horaInicio), Time.valueOf(horaFinal))) {

                Evento nuevoEvento = new Evento(
                        nombre,
                        Time.valueOf(horaInicio),
                        Time.valueOf(horaFinal),
                        lugar,
                        fecha,
                        detalles
                );

                if (database.insertarEvento(nuevoEvento)) {
                    JOptionPane.showMessageDialog(null, "Se insertó exitosamente");
                    limpiarTextbox();
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al insertar los registros.");
                }
            }
        }
         limpiarTabla();
    }

    private void update() {
        
        String nombre = nombreTxt.getText();
        String lugar = lugarTxt.getText();
        String horaInicio = formater.format(horaInicioTxt.getValue());        
        String horaFinal = formater.format(horaFinalTxt.getValue());
        String detalles = jTextArea1.getText();
        Date date = fechaCalendar.getDate();
        
        int row = dataTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro");
        }

       else if (nombre.equals("") || lugar.equals("") || horaFinal.equals("") || date == null
                || horaInicio.equals("") || detalles.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Favor de llenar los campos");
        }
       
        else if (validarHora(Time.valueOf(horaInicio), Time.valueOf(horaFinal))) {

            java.sql.Date fecha = new java.sql.Date(date.getTime());
            Evento eventoActualizado = new Evento(
                    id,
                    nombre,
                    Time.valueOf(horaInicio),
                    Time.valueOf(horaFinal),
                    lugar,
                    fecha,
                    detalles
            );
            
            if (database.actualizarEvento(eventoActualizado)){
                JOptionPane.showMessageDialog(null, "Evento actualizado");
                limpiarTextbox();
            }
            else{
                JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el evento");
            }
        }
         limpiarTabla();
    }

    private void eliminar() {
        int selectedRow = dataTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro");
        }
        
        else if ( JOptionPane.showConfirmDialog(null, "Esta seguro de que desea eliminar este registro?") == 0) {
                database.eliminarEvento(id);
                JOptionPane.showMessageDialog(null, "Eliminado");
                limpiarTextbox();
            }
        limpiarTabla();
    }

    private void limpiarTabla() {
        dataTable.setModel(new DefaultTableModel(null, new String[]{"ID", "Nombre", "Fecha", "Lugar", "Hora inicio", "Hora final", "Detalles"}));
    }

    private void limpiarTextbox() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        nombreTxt.setText("");
        lugarTxt.setText("");
        horaFinalTxt.setValue(Time.valueOf(time.format(formatter)));
        horaInicioTxt.setValue(Time.valueOf(time.format(formatter)));
        jTextArea1.setText("");
        fechaCalendar.setDate(null);
        
        formatearSpinners();
    }

    private void recargar() {
        limpiarTabla();
        cargarTabla("");
    }
    
    private void formatearSpinners(){
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        SpinnerDateModel sm2 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        horaInicioTxt.setModel(sm);
        horaFinalTxt.setModel(sm2);
        JSpinner.DateEditor de = new JSpinner.DateEditor(horaInicioTxt, "HH:mm:ss");
        JSpinner.DateEditor de2 = new JSpinner.DateEditor(horaFinalTxt, "HH:mm:ss");
        horaInicioTxt.setEditor(de);
        horaFinalTxt.setEditor(de2);
        ((JSpinner.DefaultEditor) horaInicioTxt.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) horaFinalTxt.getEditor()).getTextField().setEditable(false);
    }
    
    private boolean validarHora(Time h1, Time h2){
        
        if (h1.before(h2)){
            return true;
        }
        else{
             JOptionPane.showMessageDialog(null, "La hora de inicio debe de ser anterior a la hora final");
            return false;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton deleteBtn;
    private com.toedter.calendar.JDateChooser fechaCalendar;
    private javax.swing.JSpinner horaFinalTxt;
    private javax.swing.JSpinner horaInicioTxt;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton loadBtn;
    private javax.swing.JTextField lugarTxt;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JComboBox<String> searchComboBox;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
