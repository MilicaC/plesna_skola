/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Milica
 */
public class Sesija {
     private static Sesija instanca;
    private Map<String, Object> mapa;
    
    private Sesija(){
        mapa = new HashMap<>();
    }

    public static Sesija getInstanca() {
        if(instanca == null){
            instanca = new Sesija();
        }
        return instanca;
    }
   

    public Map<String, Object> getMapa() {
        return mapa;
    }
    
    public void put(String key, Object value) {
        mapa.put(key, value);
    }

    public Object get(String key) {
        return mapa.get(key);
    }

    public void remove(String key) {
        mapa.remove(key);
    }   

    
    
    
}
