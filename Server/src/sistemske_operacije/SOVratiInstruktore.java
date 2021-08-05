/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.Instruktor;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author Milica
 */
public class SOVratiInstruktore extends OpstaSO{
    
    
     List<OpstiDomenskiObjekat> instruktori;

    public List<OpstiDomenskiObjekat> getInstruktori() {
        return instruktori;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        instruktori = DBBroker.getInstanca().getAllOpstiDomenskiObjekat(new Instruktor());
    }
    
    
}
