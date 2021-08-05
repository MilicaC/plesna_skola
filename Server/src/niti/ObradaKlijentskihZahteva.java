/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Administrator;
import domen.Instruktor;
import domen.Kurs;
import domen.OpstiDomenskiObjekat;
import domen.Polaznik;
import domen.Upis;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kolekcije.KolekcijaUlogovanih;
import konstante.Konstante;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milica
 */
public class ObradaKlijentskihZahteva extends Thread{
    
     private Socket soket;

    public ObradaKlijentskihZahteva(Socket soket) {
        this.soket = soket;
    }

    public Socket getSoket() {
        return soket;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {
       
        KlijentskiZahtev kz = null;
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        while(!soket.isClosed()){
            try {
                kz = primiZahtev();
            boolean uspesno = false;
            switch(kz.getOperacija()){
                case Konstante.VRATI_ADMINA:
                    OpstiDomenskiObjekat ulogovaniAdmin = Kontroler.getInstanca().nadjiAdministratora((Administrator) kz.getParametar());
                    
                   if(ulogovaniAdmin!= null){
                        if(!KolekcijaUlogovanih.getInstanca().getListaUlogovanih().contains((Administrator)ulogovaniAdmin)){
                          KolekcijaUlogovanih.getInstanca().dodaj((Administrator) ulogovaniAdmin);
                            System.out.print("Administrator u kolekciji" +KolekcijaUlogovanih.getInstanca().getListaUlogovanih().toString());
                            so.setUspesnost(true);
                            so.setPodaci(ulogovaniAdmin);
                            so.setPoruka("Administrator je uspesno ulogovan!");
                        }else{
                            System.out.println("Administrator je vec ulogovan!");
                            so.setUspesnost(true);
                            so.setPodaci(null);
                          //  so.setPoruka("Logoped je vec ulogovan!");
                        }
                    }else{
                            System.out.println("Administartor ne postoji u bazi!");
                            so.setUspesnost(false);
                            so.setPodaci(null);
                           // so.setPoruka("Logoped ne postoji u bazi!");
                    }
                    break;
                    
                case Konstante.VRATI_INSTRUKTORE:
                    List<OpstiDomenskiObjekat> instruktori = Kontroler.getInstanca().getInstruktore();
                            so.setUspesnost(true);
                            so.setPodaci(instruktori);                     
                            break;
                 case Konstante.VRATI_POLAZNIKE:
                            List<OpstiDomenskiObjekat> polaznici = Kontroler.getInstanca().getPolaznike();
                            so.setUspesnost(true);
                            so.setPodaci(polaznici);                     
                            break;
                 case Konstante.PRETRAZI_POLAZNIKE:
                     List<OpstiDomenskiObjekat> polazniciPretraga = Kontroler.getInstanca().pretraziPolaznike((String) kz.getParametar());
                        so.setUspesnost(true);
                        so.setPodaci(polazniciPretraga);
                        break;
                  case Konstante.PRETRAZI_INSTRUKTORE:
                        List<OpstiDomenskiObjekat> instruktoriPretraga = Kontroler.getInstanca().pretraziInstruktore((String)kz.getParametar());
                        so.setUspesnost(true);
                        so.setPodaci(instruktoriPretraga);
                        break;
                  case Konstante.PRETRAZI_KURSEVE:
                          System.out.println("uslo u kejs preetrazi kurseve");
                        List<OpstiDomenskiObjekat> kurseviPretraga = Kontroler.getInstanca().pretraziKurseve((String) kz.getParametar());
                        so.setUspesnost(true);
                        so.setPodaci(kurseviPretraga);
                        break;
                  case Konstante.OBRISI_POLAZNIKA:
                  uspesno = Kontroler.getInstanca().obrisiPolaznika((Polaznik) kz.getParametar());
                            if (uspesno) {
                                so.setUspesnost(true);
                            } else {
                                so.setUspesnost(false);
                            }
                        break;
                  case Konstante.KREIRAJ_POLAZNIKA:
                      System.out.println("poceo case da se izvrsava");
                   uspesno = Kontroler.getInstanca().dodajPolaznika((Polaznik) kz.getParametar());
                            if (uspesno) {
                                so.setUspesnost(true);
                            } else {
                                so.setUspesnost(false);
                            }
                    break;
                  case Konstante.IZMENI_POLAZNIKA:
                    uspesno = Kontroler.getInstanca().izmeniPolaznika((Polaznik) kz.getParametar());
                            if (uspesno) {
                                so.setUspesnost(true);
                            } else {
                                so.setUspesnost(false);
                            }
                    break;
                  case Konstante.VRATI_KURSEVE:
                            List<OpstiDomenskiObjekat> kursevi = Kontroler.getInstanca().getKurseve();
                            so.setUspesnost(true);
                            so.setPodaci(kursevi);                     
                            break;
                   case Konstante.VRATI_PLESOVE:
                           List<OpstiDomenskiObjekat> plesovi = Kontroler.getInstanca().getPlesove();
                            so.setUspesnost(true);
                            so.setPodaci(plesovi);
                       
                        break;
                   case Konstante.KREIRAJ_INSTRUKTORA:
                            uspesno = Kontroler.getInstanca().dodajInstruktora((Instruktor) kz.getParametar());
                            if (uspesno) {
                                so.setUspesnost(true);
                            } else {
                                so.setUspesnost(false);
                            }
                    break;
                  case Konstante.IZLOGUJ_SE:
                        OpstiDomenskiObjekat ulogovaniLog = (Administrator) kz.getParametar();
                        if (ulogovaniLog != null) {
                            KolekcijaUlogovanih.getInstanca().obrisi((Administrator)ulogovaniLog);
                            so.setUspesnost(true);
                        }else{
                            so.setUspesnost(false);
                        }
                        break;
                 case Konstante.KREIRAJ_KURS:
                    uspesno = Kontroler.getInstanca().dodajKurs((Kurs) kz.getParametar());
                            if (uspesno) {
                                so.setUspesnost(true);
                            } else {
                                so.setUspesnost(false);
                            }
                    break;
                case Konstante.KREIRAJ_UPIS:
                            uspesno = Kontroler.getInstanca().dodajUpis((Upis) kz.getParametar());
                            if (uspesno) {
                                so.setUspesnost(true);
                            } else {
                                so.setUspesnost(false);
                            }
                    break;
    }
            posaljiOdgovor(so);
            }
            catch (IOException ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }

    private void posaljiOdgovor(ServerskiOdgovor so) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        out.writeObject(so);
        out.flush();
    }
    
    
     public KlijentskiZahtev primiZahtev() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        return (KlijentskiZahtev) in.readObject();
    }

   public  Socket getSocket() {
        return soket;
    }
    
    
            
    
}
