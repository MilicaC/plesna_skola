/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.Kurs;
import domen.OpstiDomenskiObjekat;
import java.util.LinkedList;
import java.util.List;
import kontroler.Kontroler;

/**
 *
 * @author Milica
 */
public class SOPretraziKurseve extends OpstaSO{
    
    
   
    private List<OpstiDomenskiObjekat> kursevi;
    private String kriterijumPretrage;

   public List<OpstiDomenskiObjekat> getKursevi() {
        return kursevi;
    }

    public SOPretraziKurseve(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }
               
    public void izvrsiSpecificnuOperaciju() throws Exception {
    List<OpstiDomenskiObjekat> sviKursevi = DBBroker.getInstanca().getAllOpstiDomenskiObjekat(new Kurs());
        System.out.println("sviKursevi size: " + sviKursevi.size());
        kursevi = new LinkedList<>();

        for (OpstiDomenskiObjekat odo : sviKursevi) {
            Kurs k = (Kurs) odo;
            System.out.println(k);
          
            
           if (findStringMatches(k)) {
                System.out.println("Usao u uslov");
                
               kursevi.add(k);
                System.out.println("Nasao kurs: "+k.toString());
            }
        }
    }

    private boolean findStringMatches(Kurs k) {
       
        String[] trazeniKriterijumi = kriterijumPretrage.split(" ");
        System.out.println("Kriterijum pretrage:"+kriterijumPretrage);
        for (String kriterijum : trazeniKriterijumi) {
            if (k.getNazivKursa().toLowerCase().matches("(.*)" + kriterijum.toLowerCase() + "(.*)") || 
                    k.getOpis().toLowerCase().matches("(.*)" + kriterijum.toLowerCase() + "(.*)" )) {
                return true;
            }
        }
        return false;
    } 
    
}


 