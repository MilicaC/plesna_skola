/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

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
public class Upis extends OpstiDomenskiObjekat{
    
    
    Polaznik polaznik;
    Kurs kurs;
    Date datumUpisa;
    Administrator administrator;

    public Upis() {
    }

    public Upis(Polaznik polaznik, Kurs kurs, Date datumUpisa, Administrator administrator) {
        this.polaznik = polaznik;
        this.kurs = kurs;
        this.datumUpisa = datumUpisa;
        this.administrator = administrator;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Date getDatumUpisa() { //miljani ovde Date
        return datumUpisa;
    }

    public void setDatumUpisa(Date datumUpisa) {
        this.datumUpisa = datumUpisa;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    
    
    
    
    

    @Override
    public String getNazivTabele() {
        return "upis";
    }

    @Override
    public String getParametre() {
       return String.format("%s, %s, %s, '%s'", polaznik.getSifraPolaznika(), kurs.getSifraKursa(), datumUpisa, administrator.getSifraAdministratora());

    }

    @Override
    public String getNaziveParametara() {
           return "sifraPolaznika, sifraKursa, datumUpisa, sifraAdministratora";
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
         List<OpstiDomenskiObjekat> upisi = new ArrayList<>();
        try {
            while(rs.next()){
                Integer polaznikID = rs.getInt("sifraPolaznika");
                Integer kursID = rs.getInt("sifraKursa");
                java.sql.Date datumU = rs.getDate("datumUpisa");
                int adminID = rs.getInt("sifraAdministratora");
                
                Upis u = new Upis(new Polaznik(polaznikID), new Kurs(kursID), datumU, new Administrator(adminID));
                upisi.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ples.class.getName()).log(Level.SEVERE, null, ex);
        }
        return upisi;
    }

    @Override
    public String getUpdateUpit() {
                return "sifraPolaznika='"+polaznik.getSifraPolaznika()+"', sifraKursa = '"+kurs.getSifraKursa()+ "', datumUpisa='"+ datumUpisa+ "', sifraAdministratora='"+administrator.getSifraAdministratora();

        
    }

    @Override
    public String getSlozeniPrimarniKljuc() {
         return "WHERE sifraPolaznika="+polaznik.getSifraPolaznika()+"AND sifraKursa="+kurs.getSifraKursa();

    }

    @Override
    public String toString() {
        return polaznik.getIme() + " " + kurs.getNazivKursa();
    }
    
    
    
    
    
}
