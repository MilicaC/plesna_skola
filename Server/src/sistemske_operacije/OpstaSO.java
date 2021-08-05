/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;

/**
 *
 * @author Milica
 */
public abstract class OpstaSO {
    
     public final void izvrsiOperaciju() throws Exception {
        try {
            DBBroker.getInstanca().poveziSeNaBazu();
            izvrsiSpecificnuOperaciju();
            DBBroker.getInstanca().commit();
           // DBBroker.getInstanca().zatvoriKonekciju();
        } catch (Exception e) {
            DBBroker.getInstanca().rollback();
            DBBroker.getInstanca().zatvoriKonekciju();
        }
    }

    protected abstract void izvrsiSpecificnuOperaciju() throws Exception;
    
}
