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
public class ModelTabeleKursevi extends AbstractTableModel{

   List<Kurs> listaKurseva;
   String[] imena = new String[]{"Naziv","Cena"};

    public ModelTabeleKursevi(List<Kurs> kursevi) {
        listaKurseva = kursevi;
    }

    public ModelTabeleKursevi() {
        listaKurseva = new LinkedList<>();
    }

    @Override
    public int getRowCount() {
        return listaKurseva.size();
    }

    @Override
    public int getColumnCount() {
        return imena.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kurs k = listaKurseva.get(rowIndex);
        
        switch(columnIndex){
            case 0: return k.getNazivKursa();
            case 1: return k.getCena();
            
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return imena[column];
    }

    

    public Object getPlesovi() {
        return listaKurseva;
    }
    
    public void dodajKurs(Kurs k){
         if(!listaKurseva.contains(k)){
        listaKurseva.add(k);
        fireTableDataChanged();
        }
    }

    public void izbrisi(int red) {
        listaKurseva.remove(red);
        fireTableDataChanged();
    }

    public List<Kurs> vratiKurseve() {
        return listaKurseva;
    }    

    public void dodajRed(Kurs red) {
        listaKurseva.add(red);
    }

    public Kurs vratiIzabraniKurs(int red) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
