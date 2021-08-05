/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.Instruktor;
import domen.OpstiDomenskiObjekat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Milica
 */
public class SOPretraziInstruktore extends OpstaSO{
    
    private List<OpstiDomenskiObjekat> instruktori;
    private String kriterijumPretrage;

    
    
    public SOPretraziInstruktore(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }
           
    @Override
    public void izvrsiSpecificnuOperaciju() throws Exception {
    List<OpstiDomenskiObjekat> sviInstruktori = DBBroker.getInstanca().getAllOpstiDomenskiObjekat(new Instruktor());
        System.out.println("sviInstruktori size: " + sviInstruktori.size());
        instruktori = new LinkedList<>();

        for (OpstiDomenskiObjekat odo : sviInstruktori) {
            Instruktor i = (Instruktor) odo;
            if (findStringMatches(i)) {
                System.out.println("Usao u uslov");
                instruktori.add(i);
                System.out.println("Nasao logopeda: "+i.toString());
            }
        }
    }

    private boolean findStringMatches(Instruktor i) {
        System.out.println(i);
        String[] trazeniKriterijumi = kriterijumPretrage.split(" ");
        for (String kriterijum : trazeniKriterijumi) {
            if (i.getIme().toLowerCase().matches("(.*)" + kriterijum.toLowerCase() + "(.*)") || 
                    i.getPrezime().toLowerCase().matches("(.*)" + kriterijum.toLowerCase() + "(.*)") ) {
                return true;
            }
        }
        return false;
    }

    public List<OpstiDomenskiObjekat> getInstruktori() {
        return instruktori;
    }
    
    
}
