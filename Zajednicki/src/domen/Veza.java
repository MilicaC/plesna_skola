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
public class Veza extends OpstiDomenskiObjekat{
    
    Instruktor instruktor;
    Kurs kurs;

    public Veza() {
    }

    public Veza(Instruktor instruktor, Kurs kurs) {
        this.instruktor = instruktor;
        this.kurs = kurs;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
    
    
    
    
    
    
    

    @Override
    public String getNazivTabele() {
        return "veza";
    }

    @Override
    public String getParametre() {
              return String.format("%s, %s", kurs.getSifraKursa(), instruktor.getSifraInstruktora());

    }

    @Override
    public String getNaziveParametara() {
        return "idKursa, idInstruktora";
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
        List<OpstiDomenskiObjekat> veze = new ArrayList<>();
        try {
            while(rs.next()){
                Integer kursID = rs.getInt("idKursa");
                Integer instrukID = rs.getInt("idInstruktora");
                
                
                
                Veza v = new Veza(new Instruktor(instrukID), new Kurs(kursID));
                veze.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ples.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veze;
    }

    @Override
    public String getUpdateUpit() {
        return "idKursa = "+kurs.getSifraKursa()+", idInstruktora = "+instruktor.getSifraInstruktora();

    }

    @Override
    public String getSlozeniPrimarniKljuc() {
        return "WHERE idKursa="+kurs.getSifraKursa()+"AND idInstruktora="+instruktor.getSifraInstruktora();

    }
    
}
