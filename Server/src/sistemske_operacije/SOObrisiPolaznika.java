/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Milica
 */
public class SOObrisiPolaznika extends OpstaSO{
    
     private OpstiDomenskiObjekat polaznik;
    private boolean uspesno = false;
    
    public boolean isUspesno(){
        return uspesno;
    }

    public SOObrisiPolaznika(OpstiDomenskiObjekat polaznik) {
        this.polaznik = polaznik;
    }
    
    public void izvrsiSpecificnuOperaciju() throws Exception {
        uspesno = DBBroker.getInstanca().deleteOpstiDomenskiObjekat(polaznik);
    }
    
}
