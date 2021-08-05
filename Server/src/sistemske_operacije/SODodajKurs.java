/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.Kurs;
import domen.OpstiDomenskiObjekat;
import domen.Ples;
import java.util.List;

/**
 *
 * @author Milica
 */
public class SODodajKurs extends OpstaSO{
    
    private OpstiDomenskiObjekat kurs;
    private boolean uspesno = false;
    boolean unetKurs = false;
    boolean unetiPlesovi = false;
    private Kurs k;
    private List<Ples> listaPlesova;
    
    public boolean isUspesno(){
        return uspesno;
    }

    public SODodajKurs(OpstiDomenskiObjekat kurs) {
        this.kurs = kurs;
        this.k = (Kurs) kurs;
        this.listaPlesova = k.getListaPlesova();
    }

    public void izvrsiSpecificnuOperaciju() throws Exception {
        unetKurs = DBBroker.getInstanca().saveOpstiDomenskiObjekat(kurs);
        for(Ples pl : listaPlesova){
            unetiPlesovi = DBBroker.getInstanca().saveOpstiDomenskiObjekat(pl);
        }
        if(unetKurs && unetiPlesovi){
            uspesno = true;
        }
    }
    
}
