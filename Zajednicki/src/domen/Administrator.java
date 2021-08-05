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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Milica
 */
public class Administrator extends OpstiDomenskiObjekat {
    int sifraAdministratora;
    String username;
    String password;
    String ime;
    String prezime;
    
    
    public Administrator() {
    }

    public Administrator(int sifraAdministratora, String username, String password, String ime, String prezime) {
        this.sifraAdministratora = sifraAdministratora;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
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

    

   

    Administrator(Integer adminID) {
        sifraAdministratora = adminID;
    }

    public int getSifraAdministratora() {
        return sifraAdministratora;
    }

    public void setSifraAdministratora(int sifraAdministratora) {
        this.sifraAdministratora = sifraAdministratora;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    

    @Override
    public String toString() {
        return username;
    }

      @Override
    public String getNazivTabele() {
        return "administrator";
    }

    @Override
    public String getParametre() {
        return String.format("%s, '%s', '%s',, '%s', '%s'", sifraAdministratora, username, password, ime, prezime);
    }

    @Override
    public String getNaziveParametara() {
        return "sifraAdministratora, username, password, ime, prezime";
    }

    @Override
    public String getNazivPrimarnogKljuca() {
        return "sifraAdministratora";
    }

    @Override
    public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> admini = new ArrayList<>();
        try {
            while(rs.next()){
                Integer adminID = rs.getInt("sifraAdministratora");
                String korIme = rs.getString("korisnickoIme");
                String loz = rs.getString("lozinka");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                
                Administrator admin = new Administrator(adminID, korIme, loz, ime, prezime);
                admini.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admini;
    }

    @Override
    public String getUpdateUpit() {
        return "korisnickoIme='"+username+"', lozinka = '"+password+ "', ime = '"+ime+ "', prezime = '"+prezime+ " '";
    }

    @Override
    public String getSlozeniPrimarniKljuc() {
        return null;
    }

    @Override
    public Integer getVrednostPrimarnogKljuca() {
        return sifraAdministratora;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrator other = (Administrator) obj;
        if (this.sifraAdministratora != other.sifraAdministratora) {
            return false;
        }
        return true;
    }



   

    
    
    
    
    
    
    
}
