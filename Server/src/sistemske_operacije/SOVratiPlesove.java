/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.Administrator;
import domen.Kurs;
import domen.OpstiDomenskiObjekat;
import domen.Ples;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Milica
 */
public class SOVratiPlesove extends OpstaSO{
    
   List<OpstiDomenskiObjekat> plesovi;

    public List<OpstiDomenskiObjekat> getPlesovi() {
        return plesovi;
    }
    
    public void izvrsiSpecificnuOperaciju() throws Exception {
      plesovi = DBBroker.getInstanca().getAllOpstiDomenskiObjekats(new Ples());

    }
}
