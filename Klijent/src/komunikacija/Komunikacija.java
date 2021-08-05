/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milica
 */
public class Komunikacija {
    
    private Socket soket;
    private static Komunikacija instanca;

    
    // kod tamare je drugacije, ne radi ovo u konstruktoru
    public Komunikacija() {
        try {
            soket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Komunikacija getInstance() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }
    
    public void setSocket(Socket soket) throws IOException {
        this.soket = soket;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) throws SocketException, IOException {

        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        out.writeObject(kz);
    }

    public ServerskiOdgovor primiOdgovor() throws SocketException, ClassNotFoundException, IOException {
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerskiOdgovor so = (ServerskiOdgovor) in.readObject();
        if(so != null){
            System.out.println("so NIJE NULL");   
        }
        return so;
        
        
    }
    

    
}

