/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Polaznik;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logika.Kontroler;

/**
 *
 * @author Milica
 */
public class FrmIzmeniPolaznika extends javax.swing.JFrame {
    
    Polaznik p;
    FrmGlavna glavna;

    /**
     * Creates new form FrmIzmeniPolaznika
     */
    
    
   

    public FrmIzmeniPolaznika() {
        initComponents();
    }
/*  public FrmIzmeniPolaznika(java.awt.Frame parent, boolean modal) {
       // super(parent, modal);
        glavna = (FrmGlavna) parent;
        initComponents();
        setLocationRelativeTo(null);
    }*/

    FrmIzmeniPolaznika(java.awt.Frame parent, boolean b) {
        super();
         glavna = (FrmGlavna) parent;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jj = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSifra = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtBrTelefona = new javax.swing.JTextField();
        txtDatumRodj = new com.toedter.calendar.JDateChooser();
        btnIzmeni = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Izmena polaznika");

        jj.setText("Šifra:");

        jLabel3.setText("Ime:");

        jLabel4.setText("Prezime:");

        jLabel5.setText("Email:");

        jLabel6.setText("Broj telefona:");

        jLabel7.setText("Datum rođenja:");

        txtIme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImeActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(161, 161, 161)
                        .addComponent(txtIme))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jj)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnIzmeni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOdustani))
                            .addComponent(txtSifra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDatumRodj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(txtBrTelefona, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jj)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBrTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDatumRodj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdustani)
                    .addComponent(btnIzmeni))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtImeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImeActionPerformed

     private void btnIzmenibtnGroupMouseEntered(java.awt.event.MouseEvent evt) {                                                

        if (evt.getSource() == btnIzmeni) {
            btnIzmeni.setContentAreaFilled(true);
            btnIzmeni.setBackground(new Color(233, 136, 0));
        }
        
    }                                               

    private void btnIzmenibtnGroupMouseExited(java.awt.event.MouseEvent evt) {                                               

        if (evt.getSource() == btnIzmeni) {
            btnIzmeni.setContentAreaFilled(true);
            btnIzmeni.setBackground(new Color(243, 189, 0));
      
        }
    } 
   
    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
         if(ispravno()){
            int sifra = Integer.parseInt(txtSifra.getText());
            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            String email = txtEmail.getText();
            String brTelefona = txtBrTelefona.getText();
             Timestamp datumRodj = (Timestamp) txtDatumRodj.getDate();
            
            p = new Polaznik(sifra, ime, prezime, brTelefona, email, datumRodj);
            
            if(izmeniPolaznika(p) == true){
                this.dispose();
               // glavna.srediPanelPacijenti();
            }
        }
        //premesti poruku ovde
        
        
        
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
         int odgovor = JOptionPane.showConfirmDialog(this, "Да ли сте сигурни да желите одустанете?", "Упозорење!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (odgovor == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_btnOdustaniActionPerformed

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
            java.util.logging.Logger.getLogger(FrmIzmeniPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIzmeniPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIzmeniPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIzmeniPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIzmeniPolaznika().setVisible(true);
            }
        });
    }

    void postaviVrednosti(Polaznik izabraniPolaznik) {
        txtIme.setText(izabraniPolaznik.getIme());
        txtPrezime.setText(izabraniPolaznik.getPrezime());
        txtBrTelefona.setText(izabraniPolaznik.getBrTelefona());
        txtEmail.setText(izabraniPolaznik.getEmail());
        txtSifra.setText(String.valueOf(izabraniPolaznik.getSifraPolaznika()));
     //   txtDatumRodj.setText(""); kako se setuje na DATUM
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jj;
    private javax.swing.JTextField txtBrTelefona;
    private com.toedter.calendar.JDateChooser txtDatumRodj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtSifra;
    // End of variables declaration//GEN-END:variables

    private boolean ispravno() {
        if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtEmail.getText().isEmpty() ||
                txtBrTelefona.getText().isEmpty() || txtDatumRodj.getDate() == null){
            return false;
        }else{
            return true;
        }
    }

    private boolean izmeniPolaznika(Polaznik p) {
        try {
            boolean izmenjen = Kontroler.getInstanca().izmeniPolaznika(p);
            if (izmenjen == true) {
             JOptionPane.showMessageDialog(this, "Sistem je izmenio podatke o polazniku.", "Uspesno!",JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da izmeni podatke o polazniku.", "Greska!",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmIzmeniPolaznika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
