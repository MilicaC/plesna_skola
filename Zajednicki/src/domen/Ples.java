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
public class Ples extends OpstiDomenskiObjekat{
    int sifraPlesa;
    Kurs kurs;
    String naziv;

    public Ples() {
    }

    public Ples(int sifraPlesa, Kurs kurs, String naziv) {
        this.sifraPlesa = sifraPlesa;
        this.kurs = kurs;
        this.naziv = naziv;
    }

    Ples(int idPlesa) {
        sifraPlesa = idPlesa;
    }

    public int getSifraPlesa() {
        return sifraPlesa;
    }

    public void setSifraPlesa(int sifraPlesa) {
        this.sifraPlesa = sifraPlesa;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

   

    @Override
    public String getNazivTabele() {
        return "ples";
    }

    @Override
    public String getParametre() {
      return String.format("%s, %s, '%s'", sifraPlesa, kurs.getSifraKursa(), naziv);

    }

    @Override
    public String getNaziveParametara() {
        return "sifraPlesa, sifraKursa, naziv";
    }

    @Override
    public Integer getVrednostPrimarnogKljuca() {
        return null;
    }

    @Override
    public String getNazivPrimarnogKljuca() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> plesovi = new ArrayList<>();
        try {
            while(rs.next()){
                Integer plesID = rs.getInt("sifraPlesa");
                Integer kursID = rs.getInt("sifraKursa");
                String nazivPlesa = rs.getString("naziv");
                
                
                Ples p = new Ples(plesID, new Kurs(kursID), nazivPlesa);
                plesovi.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ples.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plesovi;
    }

    @Override
    public String getUpdateUpit() {
         return "sifraPlesa = "+sifraPlesa+", sifraKursa = "+kurs.getSifraKursa()+", naziv = "+naziv;
    }

    @Override
    public String getSlozeniPrimarniKljuc() {
        return "WHERE sifraPlesa="+sifraPlesa+"AND sifraKursa="+kurs.getSifraKursa();

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
        final Ples other = (Ples) obj;
        if (this.sifraPlesa != other.sifraPlesa) {
            return false;
        }
        return true;
    }
    
    
    

   
}