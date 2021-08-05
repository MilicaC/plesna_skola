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
import java.util.List;

/**
 *
 * @author Milica
 */
public class SOVratiKurseve extends OpstaSO{

    List<OpstiDomenskiObjekat> kursevi;

    public List<OpstiDomenskiObjekat> getKursevi() {
        return kursevi;
    }
    
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        kursevi = DBBroker.getInstanca().getAllOpstiDomenskiObjekat(new Kurs());
        for (OpstiDomenskiObjekat odo : kursevi) {
            Kurs k = (Kurs) odo;
          Administrator a =  (Administrator) DBBroker.getInstanca().getOpstiDomenskiObjekatByPrimaryKey(new Administrator(), k.getAdministrator().getSifraAdministratora());
           
        
        }
    }
    
}
