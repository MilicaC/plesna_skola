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
public class SOIzmeniPolaznika extends OpstaSO{
    
     private OpstiDomenskiObjekat polaznik;
    private boolean uspesno = false;
    
    public boolean isUspesno(){
        return uspesno;
    }

    public SOIzmeniPolaznika(OpstiDomenskiObjekat polaznik) {
        this.polaznik= polaznik;
    }

    public void izvrsiSpecificnuOperaciju() throws Exception {
        uspesno = DBBroker.getInstanca().updateOpstiDomenskiObjekat(polaznik);
    }
    
}
