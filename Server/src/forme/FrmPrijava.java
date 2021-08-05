/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import db.DBBroker;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import konfig.Konfiguracija;
import kontroler.Kontroler;

/**
 *
 * @author Milica
 */
public class FrmPrijava extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrijava
     */
    public FrmPrijava() {
        initComponents();
        setLocationRelativeTo(null);
        pripremiFormu();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    Exit();
            }
            
        
        
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    void Exit(){
        int odgovor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da odustanete?", "Upozorenje!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (odgovor == JOptionPane.YES_OPTION){
            try{
            Kontroler.getInstanca().stopServer();
            System.out.println("Server stopiran.\n");
            dispose();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Serverski soket ne moze da se zatvori!");
            }
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPovezivanje = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        lblVreme = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pokretanje sistema");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/server nova.PNG"))); // NOI18N

        jLabel1.setText("Vreme pokretanja:");

        btnPovezivanje.setText("POVEŽI SE");
        btnPovezivanje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPovezivanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPovezivanjeActionPerformed(evt);
            }
        });

        btnOdustani.setText("ODUSTANI");
        btnOdustani.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnOdustani.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblVreme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPovezivanje, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnPovezivanje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblVreme))
                .addGap(21, 21, 21))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPovezivanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPovezivanjeActionPerformed
        Konfiguracija.getInstanca().setPort("9000");
        Konfiguracija.getInstanca().setUrl("jdbc:mysql://localhost/plesna_skola");
        Konfiguracija.getInstanca().setUsername("root");
        Konfiguracija.getInstanca().setPassword("");
        if (DBBroker.getInstanca().poveziSeNaBazu()) {
                Kontroler.getInstanca().startServer(Integer.parseInt(Konfiguracija.getInstanca().getPort()));
                System.out.println("Server pokrenut, osluskivanje na portu " + Konfiguracija.getInstanca().getPort() + "\n");
                btnPovezivanje.setEnabled(false);
                btnOdustani.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Konekcija nije moguca", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        
        lblVreme.setText(""+ sdf.format(date));
    }//GEN-LAST:event_btnPovezivanjeActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
         int odgovor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da odustanete?", "Upozorenje!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (odgovor == JOptionPane.YES_OPTION){
            try{
            Kontroler.getInstanca().stopServer();
            System.out.println("Server stopiran.\n");
            btnPovezivanje.setEnabled(true);
            btnOdustani.setEnabled(false);
            lblVreme.setText("");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Serverski soket ne moze da se zatvori!");
            }
        }
        
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
         
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(FrmPrijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrijava().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPovezivanje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblVreme;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() {
        URL slika = ClassLoader.getSystemResource("img/ples2.png");
        ImageIcon ikonica = new ImageIcon(slika);
        setIconImage(ikonica.getImage());
    }
}
