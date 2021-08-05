/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Administrator;
import domen.Instruktor;
import domen.Kurs;
import domen.Ples;
import domen.Polaznik;
import domen.Upis;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Konstante;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milica
 */
public class Kontroler {
    
    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(instanca == null){
            instanca = new Kontroler();
        }
        return instanca;
    }
    
    
    public Administrator nadjiAdmina(Administrator admin) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_ADMINA);
        kz.setParametar(admin);
        
        try{
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            System.out.println(so.getPoruka());
            if(so.isUspesnost() == false){
            }
                  
            if(so.isUspesnost() == true && so.getPodaci() != null){
                return (Administrator) so.getPodaci();
            }
            if (so.isUspesnost() == true && so.getPodaci()== null) {
                 throw new Exception("Administrator je vec ulogovan.");
            }else{
                 throw new Exception("Administrator ne postoji u bazi !!!");
            }
        } catch (IOException ex) {
            closeProgramOnSocketException();
            return null;
        }
            
            
       
            
        }
        
    private void closeProgramOnSocketException() {
         JOptionPane.showMessageDialog(null, "Сервер је затворио конекцију!\n Програм ће се угасити!", "Грешка!", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    public boolean obrisiInstruktora(Instruktor izabraniInstruktor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean obrisiPolaznika(Polaznik izabraniPolaynik) throws Exception {
         try {        
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Konstante.OBRISI_POLAZNIKA);
            kz.setParametar(izabraniPolaynik);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            if (so.isUspesnost()==true) {
                return true;
            }else{
            throw new Exception("Greska prilikom brisanja pacijenta!");
            }
           } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    

    public boolean dodajPolaznika(Polaznik p) throws IOException, ClassNotFoundException, Exception{
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(p);
        kz.setOperacija(Konstante.KREIRAJ_POLAZNIKA);
        System.out.println("ispred try bloka");
        System.out.println(p.getIme());
        try {
            
            Komunikacija.getInstance().posaljiZahtev(kz);
            System.out.println("posle komunikacije");
            if(kz != null){
                System.out.println(p.getListaKurseva() + " ovo su rursevi");
            }
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor(); // ovde je greska
            System.out.println("posel komunikacije 222222");
            if (so.isUspesnost()== true) {
                return true;
            } else {
          // throw new Exception("Greska prilikom ubacivanja novog polaznika!");
               System.out.println("greska prilikom ubacivanja");
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
        return false;
    }

    public boolean izmeniPolaznika(Polaznik p) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(p);
        kz.setOperacija(Konstante.IZMENI_POLAZNIKA);
        try {
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            if (so.isUspesnost()== true) {
                return true;
            } else {
            throw new Exception("Greska prilikom izmene polaznika!");
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public Administrator izlogujSe(Administrator ulogovan) throws Exception {
        
        try {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(ulogovan);
        kz.setOperacija(Konstante.IZLOGUJ_SE);
        
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        //ulogovan = (Logoped) so.getPodaci();
            if (so.isUspesnost() == true) {
                System.out.println("Uspesno izlogovan.");
            } else {
                throw new Exception("Greska prilikom izglovanja!");
            }
            return ulogovan;
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Kurs> vratiSveKurseve() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_KURSEVE);
        try {
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            if (so.isUspesnost()== true) {
                return (List<Kurs>) so.getPodaci();
            } else {
                Exception ex = so.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Ples> vratiSvePlesove() throws Exception {
         KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_PLESOVE);
        try {
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            if (so.isUspesnost()== true) {
                return (List<Ples>) so.getPodaci();
            } else {
                Exception ex = so.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Instruktor> vratiSveInstruktore() throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_INSTRUKTORE);
        try {
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            if (so.isUspesnost()== true) {
                return (List<Instruktor>) so.getPodaci();
            } else {
                Exception ex = so.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public boolean dodajInstruktora(Instruktor instruktor) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(instruktor);
        kz.setOperacija(Konstante.KREIRAJ_INSTRUKTORA);
        try {
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            if (so.isUspesnost()== true) {
                return true;
            } else {
            throw new Exception("Greška prilikom dodavanja novog instruktora!");
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        } 
    }

    public boolean dodajKurs(Kurs kurs)throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(kurs);
        kz.setOperacija(Konstante.KREIRAJ_KURS);
        try {
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            if (so.isUspesnost()== true) {
                return true;
            } else {
            throw new Exception("Greska prilikom ubacivanja novog kursa!");
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        } 
    }

    public List<Polaznik> vratiSvePolaznike() throws  Exception{
         KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_POLAZNIKE);
        try {
           Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            if (so.isUspesnost()== true) {
                return (List<Polaznik>) so.getPodaci();
            } else {
                Exception ex = so.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    

    public boolean dodajUpis(Upis upis) throws Exception{
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(upis);
        kz.setOperacija(Konstante.KREIRAJ_UPIS);
        try {
            System.out.println(upis);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor(); // ovde je greska
            if (so.isUspesnost()== true) {
                return true;
            } else {
            throw new Exception("Greska prilikom dodavanja novog upisa!");
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }
                
        
}
        
    
    
