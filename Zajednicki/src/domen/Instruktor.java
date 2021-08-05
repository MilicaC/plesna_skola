/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Milica
 */
public class Instruktor extends  OpstiDomenskiObjekat{
    int sifraInstruktora;
    String ime;
    String prezime;
    String imejl;
    String brTelefona;
    List<Kurs> listaKurseva;

    public Instruktor() {
    }

    public Instruktor(int sifraInstruktora, String ime, String prezime, String imejl, String brTelefona) {
        this.sifraInstruktora = sifraInstruktora;
        this.ime = ime;
        this.prezime = prezime;
        this.imejl = imejl;
        this.brTelefona = brTelefona;
        
    }

    public Instruktor(int sifraInstruktora, String ime, String prezime, String imejl, String brTelefona, List<Kurs> listaKurseva) {
        this.sifraInstruktora = sifraInstruktora;
        this.ime = ime;
        this.prezime = prezime;
        this.imejl = imejl;
        this.brTelefona = brTelefona;
        this.listaKurseva = listaKurseva;
    }

    Instruktor(Integer instrukID) {
        sifraInstruktora = instrukID;
    }
    
    
    

    public int getSifraInstruktora() {
        return sifraInstruktora;
    }

    public void setSifraInstruktora(int sifraInstruktora) {
        this.sifraInstruktora = sifraInstruktora;
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

    public String getImejl() {
        return imejl;
    }

    public void setImejl(String imejl) {
        this.imejl = imejl;
    }

    public String getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(String brTelefona) {
        this.brTelefona = brTelefona;
    }

    public List<Kurs> getListaKurseva() {
        return listaKurseva;
    }

    public void setListaKurseva(List<Kurs> listaKurseva) {
        this.listaKurseva = listaKurseva;
    }

    

    @Override
    public String toString() {
        return ime +" "+prezime;
    }

    @Override
    public String getNazivTabele() {
        return "instruktor";
    }

    @Override
    public String getParametre() {
         return String.format("%s, '%s', '%s', '%s', '%s'", sifraInstruktora, ime, prezime, imejl, brTelefona);
    }

    @Override
    public String getNaziveParametara() {
       return "idInstruktora, ime, prezime, email, brTelefona";

    }

    @Override
    public Integer getVrednostPrimarnogKljuca() {
        return sifraInstruktora;
    }

    @Override
    public String getNazivPrimarnogKljuca() {
        return "sifraInstruktora";
    }

    @Override
    public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> instruktori = new ArrayList<>();
        try {
            while(rs.next()){
                Integer instruktorID = rs.getInt("idInstruktora");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String email = rs.getString("email");
                String brTel = rs.getString("brTelefona");
                
                
                Instruktor instruktor = new Instruktor(instruktorID, ime, prezime, email, brTel);
                instruktori.add(instruktor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instruktori;
    }

    @Override 
    public String getUpdateUpit() {
        return "idInstruktora='"+sifraInstruktora+"', ime = '"+ime+ "', prezime='"+ prezime+ "', email='"+imejl+ "', brTelefona='"+brTelefona;

    }

    @Override
    public String getSlozeniPrimarniKljuc() {
        return null;
    }
    
    
    
    
    
    
    
}
