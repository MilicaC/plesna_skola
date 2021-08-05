/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konfig;

/**
 *
 * @author Milica
 */
public class Konfiguracija {
    
     private static Konfiguracija instanca;
    private String username;
    private String password;
    private String url;
    private String port;
   // private String driver;
    
    private Konfiguracija() {
    }

    public static Konfiguracija getInstanca() {
       if(instanca == null){
           instanca = new Konfiguracija();
       }
        return instanca;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
  /*  public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }*/

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    
}
