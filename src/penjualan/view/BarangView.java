package penjualan.view;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import penjualan.entity.Barang;
import penjualan.implement.BarangImplement;
import penjualan.interfc.BarangInterfc;

public class BarangView extends javax.swing.JFrame {
    List<Barang> record = new ArrayList<Barang>();
    BarangInterfc brgServis;
    int row;
    JTable tabelBarang = new JTable();
    
    public BarangView() {
        initComponents();
        
        tabelBarang = new JTable() {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        tabelBarang.getTableHeader().setReorderingAllowed(false);
        
        brgServis = new BarangImplement();
        tabelBarang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = tabelBarang.getSelectedRow();
                if(row != -1){
                    isiText();
                    txtidbarang.setEnabled(false);
                    btnTambah.setEnabled(false);
                    btnUbah.setEnabled(true);
                    btnHapus.setEnabled(true);
                }
            }
        });
        this.statusAwal();
    }
    
    void loadData(){
        try{
            record = brgServis.getAll();
        } catch(Exception ex){
            Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel(){
        Object data[][] = new Object[record.size()][4];
        int x = 0;
        for(Barang brg:record){
            data[x][0] = brg.getIdBarang();
            data[x][1] = brg.getNamaBarang();
            data[x][2] = brg.getJumlah();
            data[x][3] = brg.getHarga();
            x++;
        }
        String judul[] = {"ID barang", "Nama barang", "Jumlah", "Harga"};
        tabelBarang.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabelBarang);
    }
    
    void isiText(){
        Barang brg = record.get(row);
        txtidbarang.setText(brg.getIdBarang());
        txtnamabarang.setText(brg.getNamaBarang());
        txtjumlahbarang.setText(brg.getJumlah() + " ");
        txthargabarang.setText(brg.getHarga() + " ");
    }
    
    void kosongkanText(){
        txtidbarang.setText("");
        txtnamabarang.setText("");
        txtjumlahbarang.setText("");
        txthargabarang.setText("");
        txtidbarang.setEnabled(true);
        btnTambah.setEnabled(true);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        tabelBarang.getSelectionModel().clearSelection();
    }
    private void statusAwal() {
        kosongkanText();
        record.clear();
        loadData();
        isiTabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtidbarang = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtjumlahbarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txthargabarang = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(500, 400));

        jLabel1.setText("Kode Barang");

        txtnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarangActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Barang");

        txtjumlahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahbarangActionPerformed(evt);
            }
        });

        jLabel3.setText("Jumlah");

        jLabel4.setText("Harga");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jumlah", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabel);

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Menu Barang");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbah)
                                .addGap(101, 101, 101))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnReset)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnamabarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtidbarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txthargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtjumlahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus)))
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtjumlahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txthargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnReset)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabarangActionPerformed

    private void txtjumlahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahbarangActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        Barang brg = new Barang();
        String idBarang = txtidbarang.getText();
        try{
            brgServis.delete(idBarang);
        }catch(Exception ex){
            Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
        this.statusAwal();
        JOptionPane.showMessageDialog(this, "data berhasil dihapus");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try{
            Barang brg = new Barang();
            brg.setIdBarang(txtidbarang.getText());
            brg.setNamaBarang(txtnamabarang.getText());
            brg.setJumlah(Integer.parseInt(txtjumlahbarang.getText().trim()));
            brg.setHarga(Integer.parseInt(txthargabarang.getText().trim()));
            brgServis.insert(brg);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data tersimpan");
        }catch(Exception ex){
            Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(this, ex);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try{
            Barang brg = new Barang();
            brg.setIdBarang(txtidbarang.getText());
            brg.setNamaBarang(txtnamabarang.getText());
            brg.setJumlah(Integer.parseInt(txtjumlahbarang.getText().trim()));
            brg.setHarga(Integer.parseInt(txthargabarang.getText().trim()));
            brgServis.update(brg);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil diubah");
        }catch(Exception ex){
            Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(this, ex);   
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        kosongkanText();
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txthargabarang;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtjumlahbarang;
    private javax.swing.JTextField txtnamabarang;
    // End of variables declaration//GEN-END:variables

    
}
