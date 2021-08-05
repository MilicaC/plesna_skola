/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milica
 */
public class PokreniServer extends Thread{
    
    ServerSocket serverSocket;
    List<ObradaKlijentskihZahteva> klijenti;
    

    public PokreniServer(int port) {
         try {
            serverSocket = new ServerSocket(port);
            System.out.println("ServerSocket je kreiran.");
            klijenti = new ArrayList<>();
        } catch (IOException ex) {
            System.out.println("ServerSocket nije kreiran.");
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        
         while(true){
            System.out.println("Cekanje...");
        try {
            Socket soket = serverSocket.accept();
            ObradaKlijentskihZahteva klijent = new ObradaKlijentskihZahteva(soket);
            klijent.start();
            klijenti.add(klijent);
            System.out.println("Klijent se povezao!");
            int i = klijenti.size();
                System.out.println("Klijent broj " + i + " je konektovan!");
        } catch (SocketException ex) {
                System.out.println("Server je zatvoren!");
                break;
        } catch (IOException ex) {
            System.out.println("Greska! Neuspesno povezivanje klijenta.");
            ex.printStackTrace();
        }
    }
        
    zaustaviObraduKlijentskihZahtevaNit();
    

    }
    
    

    public boolean zatvoriServerSocket() {
        // ovde treba dodati kod za diskonekciju korisnika
        for (ObradaKlijentskihZahteva ct : klijenti) {
            try {
                ct.getSocket().close();
                System.err.println("Klijent je diskonektovan");
                
            } catch (IOException ex) {
                System.out.println("Klijent ne moze da se diskonektuje. " + ct.getSocket().getInetAddress());
                ex.printStackTrace();
            }
        }
        try {
            serverSocket.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void zaustaviObraduKlijentskihZahtevaNit() {
          for (ObradaKlijentskihZahteva klijent : klijenti) {
            try {
                klijent.getSoket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Serverski soket ne moze da se zatvori.");
            ex.printStackTrace();
        }
    }
        
    }
    
    
    
    
    

