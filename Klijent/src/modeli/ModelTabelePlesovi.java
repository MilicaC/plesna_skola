/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Kurs;
import domen.Ples;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelTabelePlesovi extends AbstractTableModel{
    
    Kurs kurs;
    List<Ples> listaPlesova;
    String[] imenaKolona = new String[] {"Sifra plesa", "Sifra kursa","Naziv plesa"};
    
    
    public ModelTabelePlesovi(){
        listaPlesova = new LinkedList<>();
      
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

  /*  public Kurs getKurs() {
        return kurs;
    }*/

    public List<Ples> getListaPlesova() {
        return listaPlesova;
    }
    
    // vrati izabranu stavku
    
    
    
    

    @Override
    public int getRowCount() {
        return listaPlesova.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ples p = listaPlesova.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getSifraPlesa();
            case 1: return p.getKurs().getSifraKursa();
            case 2: return p.getNaziv();
         
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return imenaKolona[column];
    }

    public void dodajPles(Ples novi) {
        listaPlesova.add(novi);
    }

    public Ples vratiIzabraniPles(int red) {
        return listaPlesova.get(red);
    }

    public Kurs getKurs() {
        return kurs;
    }
    
    
    
    
    
}
