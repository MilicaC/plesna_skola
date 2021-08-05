/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import domen.Ples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import konfig.Konfiguracija;

/**
 *
 * @author Milica
 */
public class DBBroker {
    
     private static DBBroker instanca;
    Connection konekcija;

    private DBBroker() {
    }

    public static DBBroker getInstanca() {
        if(instanca == null){
            instanca = new DBBroker();
        }
        return instanca;
    }
    
     public boolean poveziSeNaBazu() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drajver ucitan");
            String url = Konfiguracija.getInstanca().getUrl();
            String user = Konfiguracija.getInstanca().getUsername();
            String pass = Konfiguracija.getInstanca().getPassword();
            konekcija = DriverManager.getConnection(url, user, pass);
            konekcija.setAutoCommit(false);
            System.out.println("Konektovanje na bazu uspesno!");
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Drajver nije nadjen");
            return false;
        } catch (SQLException ex) {
            System.out.println("Neuspesno konektovanje na bazu!");
            return false;
        }
    }

    public void zatvoriKonekciju(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            System.out.println("Greska! Konekcija ne moze da se zatvori.");
            ex.printStackTrace();
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            System.out.println("Greska! Commit ne moze da se izvrsi.");
            ex.printStackTrace();
        }
    }
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            System.out.println("Greska! Rollback ne moze da se izvrsi.");
            ex.printStackTrace();
        }
    }

    public List<OpstiDomenskiObjekat> getAllOpstiDomenskiObjekat(OpstiDomenskiObjekat o) throws SQLException {
        try {
            String query = "SELECT * FROM " + o.getNazivTabele();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(query);
            List<OpstiDomenskiObjekat> list = o.konvertujRSUListu(rs);
            //s.close();
            System.out.println("ResultSet uspesno postavljen!");
            return list;
        } catch (SQLException ex) {
            System.out.println("Greska u postavljanju ResultSet-a na klasu " + o.getNazivTabele());
            ex.printStackTrace();
            throw ex;
        }
        
        
    }

    public boolean deleteOpstiDomenskiObjekat(OpstiDomenskiObjekat o) throws SQLException {
        try {
            String query;
            
            if (o.getSlozeniPrimarniKljuc() == null) {
                query = "DELETE FROM " + o.getNazivTabele() + " WHERE " + o.getNazivPrimarnogKljuca() + "=" + o.getVrednostPrimarnogKljuca();
            } else {
                query = "DELETE FROM " + o.getNazivTabele() + " WHERE " + o.getSlozeniPrimarniKljuc();
            }
            System.out.println(query);
            Statement s = (Statement) konekcija.createStatement();
            s.executeUpdate(query);
            commit();
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Ne moze da se obrise objekat: " + o.getNazivTabele());
            throw ex;
        }
    }

    public synchronized boolean saveOpstiDomenskiObjekat(OpstiDomenskiObjekat o) throws SQLException {
         try {
            String query = "";
            query = "INSERT INTO " + o.getNazivTabele() + "(" + o.getNaziveParametara() + ")" + " VALUES (" + o.getParametre() + ")";
            System.out.println(query);
            //Statement s = konekcija.createStatement();
            PreparedStatement s = konekcija.prepareStatement(query);
            System.out.println("Statement kreiran");
            int i = s.executeUpdate(query);
            System.out.println("Upit izvrsen");
            commit();
            s.close();
            System.out.println("Statement zatvoren");
            return true;
        } catch (SQLException ex) {
            System.out.println("Ne moze da se sacuva objekat: " + o.getNazivTabele());
            throw ex;
        }
    }

    public boolean updateOpstiDomenskiObjekat(OpstiDomenskiObjekat o) throws SQLException {
        try {
            String query = "";
            if (o.getSlozeniPrimarniKljuc() == null) {
                query = "UPDATE " + o.getNazivTabele() + " SET " + o.getUpdateUpit() + " WHERE " + o.getNazivPrimarnogKljuca() + "=" + o.getVrednostPrimarnogKljuca();
            } else {
                query = "UPDATE " + o.getNazivTabele() + " SET " + o.getUpdateUpit() + " WHERE " + o.getSlozeniPrimarniKljuc();
            }
            System.out.println(query);
            Statement s = (Statement) konekcija.createStatement();
            int i = s.executeUpdate(query);
            commit();
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Ne moze da se azurira objekat: " + o.getNazivTabele());
            throw ex;
        }
    }

   
public synchronized OpstiDomenskiObjekat getOpstiDomenskiObjekatByPrimaryKey(OpstiDomenskiObjekat o, int id) throws SQLException {
        String query;

        if (o.getSlozeniPrimarniKljuc() == null) {
            query = "SELECT * FROM " + o.getNazivTabele() + " WHERE " + o.getNazivPrimarnogKljuca() + "=" + id;
        } else {
            query = "SELECT * FROM " + o.getNazivTabele() + " WHERE " + o.getSlozeniPrimarniKljuc();
        }
        Statement s = (Statement) konekcija.createStatement();
        System.out.println(query);
        ResultSet rs = s.executeQuery(query);
        List<OpstiDomenskiObjekat> list = o.konvertujRSUListu(rs);
       // s.close();
        return list.get(0);
    }

    public List<OpstiDomenskiObjekat> getAllOpstiDomenskiObjekats(OpstiDomenskiObjekat o) throws SQLException {
        try {
            String query = "SELECT * FROM " + o.getNazivTabele();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(query);
            List<OpstiDomenskiObjekat> list = o.konvertujRSUListu(rs);
            s.close();
            System.out.println("ResultSet uspesno postavljen!");
            return list;
        } catch (SQLException ex) {
            System.out.println("Greska u postavljanju ResultSet-a na klasu " + o.getNazivTabele());
            ex.printStackTrace();
            throw ex;
        }
    }
   

    }
    
    

