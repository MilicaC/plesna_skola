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
import domen.Veza;
import java.util.List;

/**
 *
 * @author Milica
 */
public class SODodajInstruktora extends OpstaSO{
    
     private OpstiDomenskiObjekat instruktor;
    private boolean uspesno = false;
    boolean unetInstruktor = false;
    boolean uneteVeze = false;
    Instruktor i;
    
    private List<Kurs> listaVeza;
    
    public boolean isUspesno(){
        return uspesno;
    }

    public SODodajInstruktora(OpstiDomenskiObjekat instruktor) {
        this.instruktor = instruktor;
        this.i = (Instruktor) instruktor;
        this.listaVeza= i.getListaKurseva();
    }

    public void izvrsiSpecificnuOperaciju() throws Exception {
        unetInstruktor= DBBroker.getInstanca().saveOpstiDomenskiObjekat(instruktor);
        List<Kurs> listaK = i.getListaKurseva();
        for(Kurs k: listaK){
          Veza veza = new Veza(i, k);
            uneteVeze = DBBroker.getInstanca().saveOpstiDomenskiObjekat(veza);
        }
       if(unetInstruktor && uneteVeze){
           uspesno = true;
       }
    }

    
}
