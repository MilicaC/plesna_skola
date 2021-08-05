/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemske_operacije;

import db.DBBroker;
import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milica
 */
public class SONadjiAdmina extends OpstaSO{
    
     private OpstiDomenskiObjekat admin;
    public OpstiDomenskiObjekat ulogovaniAdmin;

   public SONadjiAdmina(OpstiDomenskiObjekat admin) {
        this.admin = admin;
        ulogovaniAdmin= null;
    }

    

    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
         try {
            List<OpstiDomenskiObjekat> admini = DBBroker.getInstanca().getAllOpstiDomenskiObjekat(admin);
             Administrator uneti = (Administrator) admin;
            for (OpstiDomenskiObjekat odo : admini) {
                Administrator admin = (Administrator) odo;
                if (admin.getUsername().equals(uneti.getUsername())&& admin.getPassword().equals(uneti.getPassword())) {
                    this.ulogovaniAdmin= admin;
                    return;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(SONadjiAdmina.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public OpstiDomenskiObjekat getUlogovaniLogoped() {
        return ulogovaniAdmin;
    }

    
    
    }
    
    
    
    
    

