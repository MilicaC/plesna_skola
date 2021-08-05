/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Ples;
import domen.Polaznik;
import java.util.List;

/**
 *
 * @author Milica
 */
public class SOVratiPolaznike extends OpstaSO{
    List<OpstiDomenskiObjekat> polaznici;

    public List<OpstiDomenskiObjekat> getPolaznici() {
        return polaznici;
    }

    

    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        polaznici = DBBroker.getInstanca().getAllOpstiDomenskiObjekat(new Polaznik());
    }
    
}
