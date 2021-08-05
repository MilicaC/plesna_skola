/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milica
 */
public class Polaznik extends OpstiDomenskiObjekat{
    
    int sifraPolaznika;
    String ime;
    String prezime;
    String brTelefona;
    String email;
    Date datumRodjenja;
    List<Kurs> listaKurseva;

    public Polaznik() {
    }

    public Polaznik(int sifraPolaznika, String ime, String prezime, String brTelefona, String email, Date datumRodjenja) {
        this.sifraPolaznika = sifraPolaznika;
        this.ime = ime;
        this.prezime = prezime;
        this.brTelefona = brTelefona;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
    }

    public Polaznik(int sifraPolaznika, String ime, String prezime, String brTelefona, String email, Date datumRodjenja, List<Kurs> listaKurseva) {
        this.sifraPolaznika = sifraPolaznika;
        this.ime = ime;
        this.prezime = prezime;
        this.brTelefona = brTelefona;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.listaKurseva = listaKurseva;
    }

    Polaznik(Integer polaznikID) {
        sifraPolaznika = polaznikID;
    }

    public void setListaKurseva(List<Kurs> listaKurseva) {
        this.listaKurseva = listaKurseva;
    }

    public List<Kurs> getListaKurseva() {
        return listaKurseva;
    }
    

    public int getSifraPolaznika() {
        return sifraPolaznika;
    }

    public void setSifraPolaznika(int sifraPolaznika) {
        this.sifraPolaznika = sifraPolaznika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(String brTelefona) {
        this.brTelefona = brTelefona;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    

    

   
  
   

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getNazivTabele() {
        return "polaznik";
    }

    @Override
    public String getParametre() {
         return String.format("%s, '%s', '%s', '%s', '%s', '%s'", sifraPolaznika, ime, prezime, brTelefona, email, datumRodjenja);
    }

    @Override
    public String getNaziveParametara() {
         return "sifraPolaznika, ime, prezime, brTelefona, email, datumRodjenja";
    }

    @Override
    public Integer getVrednostPrimarnogKljuca() {
        return sifraPolaznika;
    }

    @Override
    public String getNazivPrimarnogKljuca() {
        return "sifraPolaznika";
    }

    @Override
    public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> polaznici = new ArrayList<>();
        try {
            while(rs.next()){
                Integer id = rs.getInt("sifraPolaznika");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String brTelefona = rs.getString("brTelefona");
                String imejl = rs.getString("email");
                java.sql.Date datumRodj = rs.getDate("datumRodjenja");
                
                Polaznik polaznik = new Polaznik(id, ime, prezime, brTelefona,imejl, datumRodj);
                polaznici.add(polaznik);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return polaznici;
    }

    @Override
    public String getUpdateUpit() {
         return "ime='"+ime+ "',prezime='"+prezime+
                "', brTelefona='"+brTelefona+"', email = '"+email + "', datumRodjenja = '"+datumRodjenja;
    }

    @Override
    public String getSlozeniPrimarniKljuc() {
        return null;
    }
    
    
    
    
}
