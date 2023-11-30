/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Output.Supplier;

import Database.DB;
import Output.FormLogin;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milea
 */
public class ListSupplier extends javax.swing.JFrame {

    ArrayList<Integer> listSupplier = new ArrayList<>();
    int userId;
    DB db;

    /**
     * Creates new form ListCustomer
     *
     * @param userId
     */
    public ListSupplier(int userId) {
        initComponents();
        this.userId = userId;
        this.db = new DB(new String[]{"supplier", "supplier_id"});
        this.loadTabel();
    }

    public ListSupplier() {
        new FormLogin().setVisible(true);
        this.setVisible(false);
        dispose();
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
        tableCustomer = new javax.swing.JTable();
        btnAddCustomer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputSearch = new javax.swing.JTextField();
        filterBy = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "Telpon", "Alamat", "Tgl Dibuat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);
        if (tableCustomer.getColumnModel().getColumnCount() > 0) {
            tableCustomer.getColumnModel().getColumn(0).setResizable(false);
            tableCustomer.getColumnModel().getColumn(1).setResizable(false);
            tableCustomer.getColumnModel().getColumn(2).setResizable(false);
            tableCustomer.getColumnModel().getColumn(3).setResizable(false);
            tableCustomer.getColumnModel().getColumn(4).setResizable(false);
        }

        btnAddCustomer.setText("Tambah");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Customer");

        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputSearchKeyTyped(evt);
            }
        });

        filterBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama", "Alamat" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filterBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCustomer)
                    .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        // TODO add your handling code here:
        new FormSupplier(this, userId).setVisible(true);
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void inputSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSearchKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.loadTabel();
        }
    }//GEN-LAST:event_inputSearchKeyTyped

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:
        JTable target = (JTable) evt.getSource();
        int row = target.getSelectedRow();
        int indexId = Integer.parseInt(target.getModel().getValueAt(row, 0).toString());
        System.out.println(indexId);
        int supplierId = listSupplier.get(indexId - 1);
        System.out.println(supplierId);
        
        new FormSupplier(this, supplierId).setVisible(true);
    }//GEN-LAST:event_tableCustomerMouseClicked

    public void loadTabel() {
        String search = inputSearch.getText();
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        model.setRowCount(0);
        try {
            String query = "SELECT * FROM supplier;";
            if (!search.equals("")) {
                query = "SELECT * FROM supplier WHERE supplier_nama LIKE ?;";
                if (filterBy.getSelectedIndex() == 1) {
                    query = "SELECT * FROM supplier WHERE suplier_alamat LIKE ?;";
                }
            }
            PreparedStatement preparedStatement = db.getPrepStatement(query);
            if (!search.equals("")) {
                preparedStatement.setString(1, "%" + search + "%");
            }
            ResultSet result = preparedStatement.executeQuery();

            int i = 1;
            listSupplier.clear();
            while (result.next()) {
                Object[] baris = new Object[4];
                baris[0] = i++;
                listSupplier.add(result.getInt("customer_id"));
                baris[1] = result.getString("customer_fullname");
                baris[2] = result.getString("customer_telepon");
                baris[3] = result.getString("customer_alamat");
                model.addRow(baris);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JComboBox<String> filterBy;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCustomer;
    // End of variables declaration//GEN-END:variables
}
