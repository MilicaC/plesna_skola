/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Administrator;
import domen.Instruktor;
import domen.Kurs;
import domen.OpstiDomenskiObjekat;
import domen.Polaznik;
import domen.Upis;
import java.util.List;
import niti.PokreniServer;
import sistemske_operacije.SODodajInstruktora;
import sistemske_operacije.SODodajKurs;
import sistemske_operacije.SODodajPolaznika;
import sistemske_operacije.SODodajUpis;
import sistemske_operacije.SOIzmeniPolaznika;
import sistemske_operacije.SONadjiAdmina;
import sistemske_operacije.SOObrisiPolaznika;
import sistemske_operacije.SOPretraziInstruktore;
import sistemske_operacije.SOPretraziKurseve;
import sistemske_operacije.SOPretraziPolaznike;
import sistemske_operacije.SOVratiInstruktore;
import sistemske_operacije.SOVratiKurseve;
import sistemske_operacije.SOVratiPlesove;
import sistemske_operacije.SOVratiPolaznike;



/**
 *
 * @author Milica
 */
public class Kontroler {
    
    
    PokreniServer ss;
    private static Kontroler instanca;
    
    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(instanca == null){
            instanca = new Kontroler();
        }
        return instanca;
    }
    
    public void startServer(int port) {
                
        ss = new PokreniServer(port);
        ss.start();
        
        
    }

    public void stopServer() {
        ss.zatvoriServerSocket();
    }

    public OpstiDomenskiObjekat nadjiAdministratora(Administrator administrator) throws Exception{
         SONadjiAdmina so = new SONadjiAdmina(administrator);
         so.izvrsiOperaciju();
        return so.getUlogovaniLogoped();
       
    }

    public List<OpstiDomenskiObjekat> getInstruktore() throws Exception {
        SOVratiInstruktore so = new SOVratiInstruktore();
        so.izvrsiOperaciju();
        return so.getInstruktori(); 
    }

    public List<OpstiDomenskiObjekat> getPolaznike() throws Exception {
        SOVratiPolaznike so = new SOVratiPolaznike();
        so.izvrsiOperaciju();
        return so.getPolaznici(); 
    }

    public List<OpstiDomenskiObjekat> pretraziPolaznike(String string) throws Exception{
        SOPretraziPolaznike so = new SOPretraziPolaznike(string);
        so.izvrsiSpecificnuOperaciju();
        return so.getPolaznici(); 
    }

    public boolean obrisiPolaznika(Polaznik polaznik) throws Exception{
        SOObrisiPolaznika so = new SOObrisiPolaznika(polaznik);
        so.izvrsiSpecificnuOperaciju();
        return so.isUspesno();
    }

    public boolean dodajPolaznika(Polaznik polaznik) throws Exception {
         SODodajPolaznika so = new SODodajPolaznika(polaznik);
        so.izvrsiSpecificnuOperaciju();
        return so.isUspesno();  
    }

    public boolean izmeniPolaznika(Polaznik polaznik) throws Exception{
         SOIzmeniPolaznika so = new SOIzmeniPolaznika(polaznik);
        so.izvrsiSpecificnuOperaciju();
        return so.isUspesno(); 
    }

    public List<OpstiDomenskiObjekat> getKurseve() throws Exception {
        SOVratiKurseve so = new SOVratiKurseve();
        so.izvrsiOperaciju();
        return so.getKursevi();
    }

    public List<OpstiDomenskiObjekat> pretraziInstruktore(String string)throws Exception{
        SOPretraziInstruktore so = new SOPretraziInstruktore(string);
        so.izvrsiSpecificnuOperaciju();
        return so.getInstruktori(); 
    }

    public List<OpstiDomenskiObjekat> pretraziKurseve(String string) throws Exception{
        SOPretraziKurseve so = new SOPretraziKurseve(string);
        so.izvrsiSpecificnuOperaciju();
        return so.getKursevi();
    }

   

    public List<OpstiDomenskiObjekat> getPlesove() throws Exception{
        SOVratiPlesove so = new SOVratiPlesove();
        so.izvrsiOperaciju();
        return so.getPlesovi();
    }

    public boolean dodajInstruktora(Instruktor instruktor) throws Exception {
        SODodajInstruktora so = new SODodajInstruktora(instruktor);
        so.izvrsiSpecificnuOperaciju();
        return so.isUspesno();   
    }

    public boolean dodajKurs(Kurs kurs) throws Exception{
        SODodajKurs so = new SODodajKurs(kurs);
        so.izvrsiSpecificnuOperaciju();
        return so.isUspesno();
    }

    public boolean dodajUpis(Upis upis)throws Exception {
        System.out.println("uslo u SOVratiUpis");
        SODodajUpis so = new SODodajUpis(upis);
        so.izvrsiSpecificnuOperaciju();
        return so.isUspesno(); 
    }
    
    
    
    
    
}
