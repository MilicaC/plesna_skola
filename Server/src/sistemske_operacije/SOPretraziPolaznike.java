/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Polaznik;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Milica
 */
public class SOPretraziPolaznike {
    
    
    private List<OpstiDomenskiObjekat> polaznici;
    private String kriterijumPretrage;
    

    public SOPretraziPolaznike(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public void izvrsiSpecificnuOperaciju() throws Exception {
        List<OpstiDomenskiObjekat> sviPolaznici = DBBroker.getInstanca().getAllOpstiDomenskiObjekat(new Polaznik());
        System.out.println("sviPolaynici size: " + sviPolaznici.size());
        polaznici = new LinkedList<>();

        for (OpstiDomenskiObjekat odo : sviPolaznici) {
            Polaznik p = (Polaznik) odo;
            if (findStringMatches(p)) {
                System.out.println("Usao u uslov");
                polaznici.add(p);
                System.out.println("Nasao polaznika: "+p.toString());
            }
        }
    }

    

    public List<OpstiDomenskiObjekat> getPolaznici() {
        return polaznici;
    }

    private boolean findStringMatches(Polaznik p) {
          System.out.println();
        String[] trazeniKriterijumi = kriterijumPretrage.split(" ");
        for (String kriterijum : trazeniKriterijumi) {
            if (p.getIme().toLowerCase().matches("(.*)" + kriterijum.toLowerCase() + "(.*)") || p.getPrezime().toLowerCase().matches("(.*)" + kriterijum.toLowerCase() + "(.*)" )) {
                 //   || p.getImeRoditeljaPacijena().toLowerCase().matches("(.*)" + kriterijum.toLowerCase() + "(.*)" )) {
                return true;
            }
        }
        return false;
    }
    
}
