/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Administrator;
import domen.Instruktor;
import domen.Kurs;
import domen.Ples;
import domen.Polaznik;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import komunikacija.Komunikacija;
import konstante.Konstante;
import logika.Kontroler;
import modeli.ModelTabeleInstruktori;
import modeli.ModelTabeleKursevi;
import modeli.ModelTabelePolaznici;
import sesija.Sesija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milica
 */
public class FrmGlavna extends javax.swing.JFrame {
    
    String aktivanPanel;
    Administrator administrator;

    /**
     * Creates new form FrmGlavna
     */
    public FrmGlavna(Administrator administrator) {
        initComponents();
        this.administrator = administrator;
        
        lblNaslov.setBackground(new Color(140, 144, 145));
        setSize(760, 640);
        btnUpis.setVisible(false);
        setLocationRelativeTo(null);
        srediPocetnu();
        pripremiFormu();
         this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    Exit();
            }

         
            
        
        
        });
    }
    
       private void Exit() {
          int odgovor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da se odjavite?", "Upozorenje!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (odgovor == JOptionPane.YES_OPTION){

            try {
                Administrator ulogovan = (Administrator) Sesija.getInstanca().getMapa().get("admin");

                Kontroler.getInstanca().izlogujSe(ulogovan);
                Sesija.getInstanca().getMapa().remove("admin", ulogovan);
                System.exit(0);
               /* this.setVisible(false);
                this.dispose();
                FrmLogin fl = new FrmLogin();
                fl.setVisible(true);*/
            } catch (Exception ex) {
                Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInstruktori = new javax.swing.JLabel();
        lblKursevi = new javax.swing.JLabel();
        lblPolaznici = new javax.swing.JLabel();
        lblPocetna = new javax.swing.JLabel();
        lblOdjaviSe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUlogovani = new javax.swing.JLabel();
        btnPretrazi = new javax.swing.JButton();
        txtPretrazi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnUpis = new javax.swing.JButton();
        lblNaslov = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOpisKursa = new javax.swing.JTextArea();
        lblOpis = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plesna škola - administracija");
        setSize(new java.awt.Dimension(680, 400));
        getContentPane().setLayout(null);

        lblInstruktori.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        lblInstruktori.setForeground(new java.awt.Color(255, 0, 0));
        lblInstruktori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstruktori.setText("Instruktori");
        lblInstruktori.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblInstruktori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInstruktoriMouseClicked(evt);
            }
        });
        getContentPane().add(lblInstruktori);
        lblInstruktori.setBounds(20, 168, 120, 36);

        lblKursevi.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        lblKursevi.setForeground(new java.awt.Color(255, 0, 0));
        lblKursevi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKursevi.setText("Kursevi");
        lblKursevi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblKursevi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKurseviMouseClicked(evt);
            }
        });
        getContentPane().add(lblKursevi);
        lblKursevi.setBounds(20, 222, 120, 36);

        lblPolaznici.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        lblPolaznici.setForeground(new java.awt.Color(255, 0, 0));
        lblPolaznici.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPolaznici.setText("Polaznici");
        lblPolaznici.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPolaznici.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPolazniciMouseClicked(evt);
            }
        });
        getContentPane().add(lblPolaznici);
        lblPolaznici.setBounds(20, 276, 120, 36);

        lblPocetna.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        lblPocetna.setForeground(new java.awt.Color(255, 0, 0));
        lblPocetna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPocetna.setText("Pocetna");
        lblPocetna.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPocetna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPocetnaMouseClicked(evt);
            }
        });
        getContentPane().add(lblPocetna);
        lblPocetna.setBounds(20, 460, 120, 36);

        lblOdjaviSe.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        lblOdjaviSe.setForeground(new java.awt.Color(255, 0, 0));
        lblOdjaviSe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOdjaviSe.setText("Odjavi se");
        lblOdjaviSe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOdjaviSe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOdjaviSeMouseClicked(evt);
            }
        });
        getContentPane().add(lblOdjaviSe);
        lblOdjaviSe.setBounds(20, 520, 120, 35);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ulogovani administrator:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 25, 140, 15);

        lblUlogovani.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUlogovani.setForeground(new java.awt.Color(255, 255, 255));
        lblUlogovani.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUlogovani.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblUlogovani);
        lblUlogovani.setBounds(20, 51, 160, 20);

        btnPretrazi.setBackground(new java.awt.Color(239, 16, 40));
        btnPretrazi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPretrazi.setForeground(new java.awt.Color(255, 255, 255));
        btnPretrazi.setText("Pretrazi");
        btnPretrazi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });
        getContentPane().add(btnPretrazi);
        btnPretrazi.setBounds(625, 102, 78, 28);
        getContentPane().add(txtPretrazi);
        txtPretrazi.setBounds(263, 102, 344, 28);

        tabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.setAlignmentX(2.0F);
        tabela.setAlignmentY(2.0F);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(263, 168, 440, 130);

        btnObrisi.setBackground(new java.awt.Color(239, 16, 40));
        btnObrisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnObrisi.setForeground(new java.awt.Color(255, 255, 255));
        btnObrisi.setText("Obrisi");
        btnObrisi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(btnObrisi);
        btnObrisi.setBounds(627, 351, 76, 28);

        btnIzmeni.setBackground(new java.awt.Color(239, 16, 40));
        btnIzmeni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnIzmeni.setForeground(new java.awt.Color(255, 255, 255));
        btnIzmeni.setText("Izmeni");
        btnIzmeni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });
        getContentPane().add(btnIzmeni);
        btnIzmeni.setBounds(533, 351, 76, 28);

        btnDodaj.setBackground(new java.awt.Color(239, 16, 40));
        btnDodaj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(255, 255, 255));
        btnDodaj.setText("Dodaj");
        btnDodaj.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });
        getContentPane().add(btnDodaj);
        btnDodaj.setBounds(430, 351, 76, 28);

        btnUpis.setBackground(new java.awt.Color(239, 16, 40));
        btnUpis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpis.setForeground(new java.awt.Color(255, 255, 255));
        btnUpis.setText("UPIS");
        btnUpis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnUpis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpisActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpis);
        btnUpis.setBounds(170, 520, 120, 40);

        lblNaslov.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        lblNaslov.setForeground(new java.awt.Color(255, 255, 255));
        lblNaslov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblNaslov);
        lblNaslov.setBounds(230, 20, 480, 50);

        txtOpisKursa.setColumns(20);
        txtOpisKursa.setLineWrap(true);
        txtOpisKursa.setRows(5);
        jScrollPane2.setViewportView(txtOpisKursa);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(430, 440, 190, 70);

        lblOpis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblOpis.setForeground(new java.awt.Color(255, 255, 255));
        lblOpis.setText("Opis kursa:");
        lblOpis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblOpis);
        lblOpis.setBounds(430, 410, 70, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/pozadina ples 2.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 750, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
         if(aktivanPanel == "instruktori"){
            FrmDodajInstruktora dijalog = new FrmDodajInstruktora(this, true);
            dijalog.setVisible(true);
            dijalog.pack(); // novo
            dijalog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
        }
        
        if(aktivanPanel == "polaznici"){
            FrmDodajPolaznika dijalog = new FrmDodajPolaznika(this, true);
            dijalog.setVisible(true);
            dijalog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
        if(aktivanPanel == "kursevi"){
            FrmDodajKurs dijalog = new FrmDodajKurs(this, true, administrator);
            dijalog.setVisible(true);
            dijalog.pack();
            dijalog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
         if(aktivanPanel == "instruktori"){
            try {
            if (btnPretrazi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti kriterijum pretrage.", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
            }
            
            String pretraga = txtPretrazi.getText();
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Konstante.PRETRAZI_INSTRUKTORE);
            kz.setParametar(pretraga);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            List<Instruktor> listanadjenih = (List<Instruktor>) so.getPodaci();
            if(listanadjenih.isEmpty()){
                JOptionPane.showMessageDialog(this, "Sistem ne može da pronađe instruktora po zadatoj vrednosti.", "Upozorenje", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Sistem je našao instruktore po zadatoj vrednosti.", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
                ModelTabeleInstruktori mti = new ModelTabeleInstruktori(listanadjenih);
                tabela.setModel(mti);            
            }
            
            
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }

        
        if(aktivanPanel == "polaznici"){
           try {
            if (txtPretrazi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti kriterijum pretrage.", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
            }
            
            String pretraga = txtPretrazi.getText();
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Konstante.PRETRAZI_POLAZNIKE);
            kz.setParametar(pretraga);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            List<Polaznik> listanadjenih = (List<Polaznik>) so.getPodaci();
            if(listanadjenih.isEmpty()){
                JOptionPane.showMessageDialog(this, "Sistem ne može da nađe polaznike po zadatoj vrednosti.", "Upozorenje", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Sistem je našao polaznike po zadatoj vrednosti.", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
                ModelTabelePolaznici mtp = new ModelTabelePolaznici(listanadjenih);
                tabela.setModel(mtp);            
            }
            
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
        
        if(aktivanPanel == "kursevi"){
          try {
            if (txtPretrazi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti kriterijum pretrage.", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            String pretraga = txtPretrazi.getText();
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Konstante.PRETRAZI_KURSEVE);
            kz.setParametar(pretraga);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor(); // ovde je greska
            List<Kurs> listanadjenih = (List<Kurs>) so.getPodaci();
            if(listanadjenih.isEmpty()){
                JOptionPane.showMessageDialog(this, "Sistem ne može da nađe kurseve po zadatoj vrednosti.", "Upozorenje", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Sistem je našao kurseve po zadatoj vrednosti.", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
                ModelTabeleKursevi mtk = new ModelTabeleKursevi(listanadjenih);
                tabela.setModel(mtk);           
            }
            
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        } 
        } 
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void lblOdjaviSeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOdjaviSeMouseClicked
        int odgovor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da se odjavite?", "Upozorenje!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (odgovor == JOptionPane.YES_OPTION){

            try {
                Administrator ulogovan = (Administrator) Sesija.getInstanca().getMapa().get("admin");

                Kontroler.getInstanca().izlogujSe(ulogovan);
                Sesija.getInstanca().getMapa().remove("admin", ulogovan);

                this.setVisible(false);
                this.dispose();
                FrmLogin fl = new FrmLogin();
                fl.setVisible(true);
                
            } catch (Exception ex) {
                Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lblOdjaviSeMouseClicked

    private void lblPocetnaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPocetnaMouseClicked
        srediPocetnu();
    }//GEN-LAST:event_lblPocetnaMouseClicked

    private void lblPolazniciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPolazniciMouseClicked
        srediPanelPolaznici();
    }//GEN-LAST:event_lblPolazniciMouseClicked

    private void lblKurseviMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKurseviMouseClicked
        srediPanelKursevi();
    }//GEN-LAST:event_lblKurseviMouseClicked

    private void lblInstruktoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInstruktoriMouseClicked
        srediPanelInstruktori();
    }//GEN-LAST:event_lblInstruktoriMouseClicked

    private void btnUpisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpisActionPerformed
        FrmNoviUpis forma = new FrmNoviUpis(this, true,administrator);
        forma.setVisible(true);
        forma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }//GEN-LAST:event_btnUpisActionPerformed

    private void tabelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseEntered

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if(aktivanPanel == "kursevi"){
            jScrollPane2.setVisible(true);
            lblOpis.setVisible(true);
            int i = tabela.getSelectedRow();
            ModelTabeleKursevi mtk = (ModelTabeleKursevi) tabela.getModel();
            List<Kurs> listaKurseva = vratiKurseve();
            Kurs k = listaKurseva.get(i);
            txtOpisKursa.setText(k.getOpis());
            
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
         if(aktivanPanel == "instruktori"){
           
            ModelTabeleInstruktori mti = (ModelTabeleInstruktori) tabela.getModel();
            int red = tabela.getSelectedRow();
            
            if(red == -1){
                JOptionPane.showMessageDialog(this, "Морате изабрати ред који желите да измените!", "Упозорење", JOptionPane.ERROR_MESSAGE);
            }else{
                Instruktor izabraniInstruktor = mti.vratiIzabranogInstruktora(red);
                FrmIzmeniInstruktora frmizmena = new FrmIzmeniInstruktora(this, true);
                frmizmena.postaviVrednosti(izabraniInstruktor);
                frmizmena.setVisible(true);
            }
        }
        
     /*   if(aktivanPanel == "Polaznici"){
            ModelTabelePacijenti mtp = (ModelTabelePacijenti) tabela.getModel();
            int red = tabela.getSelectedRow();
            
            if(red == -1){
                JOptionPane.showMessageDialog(this, "Морате изабрати ред који желите да измените!", "Упозорење", JOptionPane.ERROR_MESSAGE);
            }else{
                Pacijent izabraniPacijent = mtp.vratiIzabranogPacijenta(red);
                DijalogIzmeniPacijenta dijalog = new DijalogIzmeniPacijenta(this, true);
                dijalog.postaviVrednosti(izabraniPacijent);
                dijalog.setVisible(true);
            }
        }*/
        
        if(aktivanPanel == "kursevi"){
             ModelTabeleKursevi mtk = (ModelTabeleKursevi) tabela.getModel();
            int red = tabela.getSelectedRow();
            
            if(red == -1){
                JOptionPane.showMessageDialog(this, "Морате изабрати ред који желите да измените!", "Упозорење", JOptionPane.ERROR_MESSAGE);
            }else{
                Kurs izabraniKurs = mtk.vratiIzabraniKurs(red);
                FrmIzmeniKurs frmizmeni = new FrmIzmeniKurs(this, true);
                frmizmeni.postaviVrednosti(izabraniKurs); 
                frmizmeni.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

   private void btnPretrazibtnGroupMouseEntered(java.awt.event.MouseEvent evt) {                                                 
       if (evt.getSource() == btnPretrazi) {
            btnPretrazi.setContentAreaFilled(true);
            btnPretrazi.setBackground(new Color(233, 136, 0));
        }
    }  
    
      private void btnPretrazibtnGroupMouseExited(java.awt.event.MouseEvent evt) {                                                
        if (evt.getSource() == btnPretrazi) {
            btnPretrazi.setContentAreaFilled(true);
            btnPretrazi.setBackground(new Color(243, 189, 0));
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
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //   new FrmGlavna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnUpis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInstruktori;
    private javax.swing.JLabel lblKursevi;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JLabel lblOdjaviSe;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblPocetna;
    private javax.swing.JLabel lblPolaznici;
    private javax.swing.JLabel lblUlogovani;
    private static javax.swing.JTable tabela;
    private javax.swing.JTextArea txtOpisKursa;
    private javax.swing.JTextField txtPretrazi;
    // End of variables declaration//GEN-END:variables

    private void srediPocetnu() {
         srediBojePanela();
         lblNaslov.setText("");
        aktivanPanel = "pocetna";
        
        lblUlogovani.setText(administrator.getIme() + " "+ administrator.getPrezime());
        lblNaslov.setVisible(false);
        txtPretrazi.setVisible(false);
        btnDodaj.setVisible(false);
        btnIzmeni.setVisible(false);
        btnObrisi.setVisible(false);
        jScrollPane1.setVisible(false);
        btnPretrazi.setVisible(false);
        btnUpis.setVisible(true);
        lblOpis.setVisible(false);
        txtOpisKursa.setVisible(false);
        jScrollPane2.setVisible(false);
    
    }

    private void pripremiFormu() {
         URL slika = ClassLoader.getSystemResource("image/ples2.png");
        ImageIcon ikonica = new ImageIcon(slika);
        setIconImage(ikonica.getImage());
    }

    private void srediBojePanela() {
     /*    panelLogopedi.setBackground(new Color(28,107,100));
        panelPacijenti.setBackground(new Color(28,107,100));
        panelTretmani.setBackground(new Color(28,107,100));  */
    }

     private void srediPanelInstruktori() {
        srediBojePanela();
        lblNaslov.setVisible(true);
        lblNaslov.setText("Rad sa instruktorima");
        aktivanPanel = "instruktori";
        
      
        jScrollPane1.setVisible(true);
        btnPretrazi.setVisible(true);
        txtPretrazi.setVisible(true);
        
       List<Instruktor> instruktori = vratiInstruktore();
        ModelTabeleInstruktori mti = new ModelTabeleInstruktori(instruktori);
        tabela.setModel(mti);
           JComboBox cbKursevi = new JComboBox(vratiKurseve().toArray());
         TableColumn tcKursevi = tabela.getColumnModel().getColumn(5);
         tcKursevi.setCellEditor(new DefaultCellEditor(cbKursevi));
        
        
         resizeColumnWidth(tabela);
        
        
        
      tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setBackground(new Color(239, 16, 40));
        
        
       
       
        btnDodaj.setVisible(true);
        btnIzmeni.setVisible(true);
        btnObrisi.setVisible(true);
        btnUpis.setVisible(true);
        
        jScrollPane2.setVisible(false);
        txtOpisKursa.setVisible(false);
        lblOpis.setVisible(false);
       
       
        
}
        
        

    private List<Instruktor> vratiInstruktore() {
           
         List<Instruktor> instruktori = new LinkedList<>();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Konstante.VRATI_INSTRUKTORE);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            instruktori = (List<Instruktor>) so.getPodaci();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return instruktori;

    }

    

   

    private void srediPanelPolaznici() {
        srediBojePanela();
        lblNaslov.setVisible(true);
       lblNaslov.setText("Rad sa polaznicima");
       aktivanPanel = "polaznici";
       
      
       btnDodaj.setVisible(true);
       btnIzmeni.setVisible(true);
       btnObrisi.setVisible(true);
       btnUpis.setVisible(true);
    
       jScrollPane1.setVisible(true);
       btnPretrazi.setVisible(true);
       txtPretrazi.setVisible(true);
       lblOpis.setVisible(false);
       txtOpisKursa.setVisible(false);
       jScrollPane2.setVisible(false);
      
       List<Polaznik> polaznici = vratiPolaznike();
       ModelTabelePolaznici mtp = new ModelTabelePolaznici(polaznici);
       tabela.setModel(mtp);
        resizeColumnWidth(tabela);
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setBackground(new Color(239, 16, 40));
       
       
    }

    private List<Polaznik> vratiPolaznike() {
        List<Polaznik> polaznici = new LinkedList<>();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Konstante.VRATI_POLAZNIKE);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            polaznici = (List<Polaznik>) so.getPodaci();
           
        } catch (ClassNotFoundException | IOException ex) {
           Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
  
        }
        
        System.out.println(polaznici.size());
        return polaznici;
    }

    private void srediPanelKursevi() {
        aktivanPanel = "kursevi";
        srediBojePanela();
        lblNaslov.setVisible(true);
       lblNaslov.setText("Rad sa kursevima");
       

       
       btnDodaj.setVisible(true);
       btnIzmeni.setVisible(true);
       btnObrisi.setVisible(true);
       btnUpis.setVisible(true);
    
       jScrollPane1.setVisible(true);
       btnPretrazi.setVisible(true);
       txtPretrazi.setVisible(true);
      // lblOpis.setVisible(true);
      // jScrollPane2.setVisible(true);
       
       List<Kurs> kursevi = vratiKurseve();
       ModelTabeleKursevi mtKursevi = new ModelTabeleKursevi(kursevi);
       tabela.setModel(mtKursevi);
        resizeColumnWidth(tabela);
                
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setBackground(new Color(239, 16, 40));
       
       
    }

    private List<Kurs> vratiKurseve() {
         List<Kurs> kursevi = new LinkedList<>();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Konstante.VRATI_KURSEVE);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            kursevi = (List<Kurs>) so.getPodaci();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kursevi;
    }

   
    public static void dodajRedUTabeluI(Instruktor red){
        ModelTabeleInstruktori model =  new ModelTabeleInstruktori();
        model = (ModelTabeleInstruktori) tabela.getModel();
        model.dodajRed(red);
        model.fireTableDataChanged();
    }
    
    public static void dodajRedUTabeluK(Kurs red){
        ModelTabeleKursevi model =  new ModelTabeleKursevi();
        model = (ModelTabeleKursevi) tabela.getModel();
        model.dodajRed(red);
        model.fireTableDataChanged();
    }
    
    
    public void resizeColumnWidth(JTable table) {
    
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 40; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            
            Component comp = table.prepareRenderer(renderer, row, column);
           
            width = Math.max(comp.getPreferredSize().width +10 , width);
        }
        if(width > 300)
            width=300;
        columnModel.getColumn(column).setPreferredWidth(width);
    }
    
}
   
}
