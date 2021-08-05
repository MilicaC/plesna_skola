/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milica
 */
public class Kurs extends OpstiDomenskiObjekat{
    
    
    int sifraKursa;
    String nazivKursa;
    double cena;
    String opis;
    Administrator administrator;
    List<Ples> listaPlesova;

    public Kurs() {
    }

    public Kurs(int sifraKursa, String nazivKursa, double cena, String opis, Administrator administrator, List<Ples> listaPlesova) {
        this.sifraKursa = sifraKursa;
        this.nazivKursa = nazivKursa;
        this.cena = cena;
        this.opis = opis;
        this.administrator = administrator;
        this.listaPlesova = listaPlesova;
    }
    
    
    

    public Kurs(int sifraKursa, String nazivKursa, double cena, String opis, Administrator administrator) {
        this.sifraKursa = sifraKursa;
        this.nazivKursa = nazivKursa;
        this.cena = cena;
        this.opis = opis;
        this.administrator = administrator;
    }
    
    
    

    Kurs(Integer kursID) {
        sifraKursa = kursID;
    }

    public int getSifraKursa() {
        return sifraKursa;
    }

    public void setSifraKursa(int sifraKursa) {
        this.sifraKursa = sifraKursa;
    }
    
    public List<Ples> getListaPlesova() {
        return listaPlesova;
    }

    public void setListaPlesova(List<Ples> listaPlesova) {
        this.listaPlesova = listaPlesova;
    }
    
    

    public String getNazivKursa() {
        return nazivKursa;
    }

    public void setNazivKursa(String nazivKursa) {
        this.nazivKursa = nazivKursa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    
    
    
    
    

    @Override
    public String getNazivTabele() {
        return "kurs";
    }

    @Override
    public String getParametre() {
        return String.format("%s, '%s', '%s', '%s', '%s'", sifraKursa, nazivKursa, cena ,opis, administrator.getSifraAdministratora());
    }

    @Override
    public String getNaziveParametara() {
        return "idKursa, naziv, cena, opis, sifraAdministratora";
    }

    @Override
    public Integer getVrednostPrimarnogKljuca() {
        return sifraKursa;
    }

    @Override
    public String getNazivPrimarnogKljuca() {
        return "sifraKursa";
    }

    @Override
    public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
         List<OpstiDomenskiObjekat> kursevi = new ArrayList<>();
        try {
            while(rs.next()){
                Integer kursID = rs.getInt("idKursa");
                String nazivKursa = rs.getString("naziv");
                double cenaKursa = rs.getInt("cena");
                String opisKursa = rs.getString("opis");
                Integer adminID = rs.getInt("sifraAdministratora");
                
                Kurs k = new Kurs(kursID, nazivKursa, cenaKursa,opisKursa, new Administrator(adminID));
                kursevi.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kursevi;
    }

    @Override
    public String getUpdateUpit() {
      return "idKursa='"+sifraKursa+"', naziv = '"+nazivKursa+ "', cena='"+ cena+ "', opis='"+opis+ "',sifraAdministratora='"+ administrator.getSifraAdministratora();

    }
    

    @Override
    public String getSlozeniPrimarniKljuc() {
        return null;
    }

    
    
    public void dodajPles(Ples ples) {
    ples.setKurs(this);
    listaPlesova.add(ples);
    } 

    @Override
    public String toString() {
        return nazivKursa;
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
        final Kurs other = (Kurs) obj;
        if (this.sifraKursa != other.sifraKursa) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
