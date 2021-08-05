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
public class SODodajUpis extends OpstaSO{
    
     private OpstiDomenskiObjekat upis;
    private boolean uspesno = false;
    boolean unetUpis = false;
  //  boolean uneteVeze = false;
    Upis u;
    
  //  private List<Kurs> listaVeza;
    
    public boolean isUspesno(){
        return uspesno;
    }

    public SODodajUpis(OpstiDomenskiObjekat upis) {
        this.upis = upis;
        this.u = (Upis) upis;
      //  this.listaVeza= u.getListaKurseva();
    }

    public void izvrsiSpecificnuOperaciju() throws Exception {
        unetUpis= DBBroker.getInstanca().saveOpstiDomenskiObjekat(upis);
       
       if(unetUpis){
           uspesno = true;
       }
    }
}
