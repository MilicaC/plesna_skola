/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.Instruktor;
import domen.Kurs;
import domen.OpstiDomenskiObjekat;
import domen.Polaznik;
import domen.Upis;
import domen.Veza;
import java.util.List;

/**
 *
 * @author Milica
 */
public class SODodajPolaznika extends OpstaSO{
    
     private OpstiDomenskiObjekat polaznik;
    private boolean uspesno = false;
    boolean unetPolaznik = false;
    boolean unetiUpisi = false;
    Polaznik p;
    
    private List<Kurs> listaUpisa;
    
    public boolean isUspesno(){
        return uspesno;
    }

    public SODodajPolaznika(OpstiDomenskiObjekat polaznik) {
        this.polaznik = polaznik;
        this.p = (Polaznik) polaznik;
        this.listaUpisa= p.getListaKurseva();
    }

    public void izvrsiSpecificnuOperaciju() throws Exception {
        unetPolaznik= DBBroker.getInstanca().saveOpstiDomenskiObjekat(polaznik);
        List<Kurs> listaK = p.getListaKurseva();
        for(Kurs k: listaK){
            Upis u = new Upis(p, k,null, null);
            unetiUpisi = DBBroker.getInstanca().saveOpstiDomenskiObjekat(u);
        }
       if(unetPolaznik && unetiUpisi){
           uspesno = true;
       }
    }

}
