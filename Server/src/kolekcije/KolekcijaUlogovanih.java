/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekcije;

import domen.Administrator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milica
 */
public class KolekcijaUlogovanih {
    
     private static KolekcijaUlogovanih instanca;
    List<Administrator> listaUlogovanih;

    private KolekcijaUlogovanih() {
        listaUlogovanih = new ArrayList<>();
    }

    public static KolekcijaUlogovanih getInstanca() {
        if(instanca == null){
            instanca = new KolekcijaUlogovanih();
        }
        return instanca;
    }

    public List<Administrator> getListaUlogovanih() {
        return listaUlogovanih;
    }
    
    public void dodaj(Administrator a){
        listaUlogovanih.add(a);
    }
    
     public void obrisi(Administrator a) {
        for (int i = 0; i < listaUlogovanih.size(); i++) {
            if (listaUlogovanih.get(i).equals(a)) {
                listaUlogovanih.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String string = "";
        for (Administrator admin : listaUlogovanih) {
            string+=admin.toString();
        }
        return string;
    }

}
