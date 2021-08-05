/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Instruktor;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelTabeleInstruktori extends AbstractTableModel implements TableModelListener{
    
    ModelTabeleInstruktori mti;
    List<Instruktor> instruktori;
    String[] kolone ={"Šifra","Ime","Prezime","Email","Br. telefona", "Kursevi"};
    
    
 public ModelTabeleInstruktori(List<Instruktor> instr){
     this.instruktori = instr;
     mti = new ModelTabeleInstruktori();
 }

    public ModelTabeleInstruktori() {
        instruktori = new LinkedList<>();
    }
   

    @Override
    public int getRowCount() {
        return instruktori.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Instruktor i = instruktori.get(rowIndex);
        switch(columnIndex){
            case 0: return i.getSifraInstruktora();
            case 1: return i.getIme();
            case 2: return i.getPrezime();
            case 3: return i.getImejl();
            case 4: return i.getBrTelefona();
           case 5: return i.getListaKurseva();
            
            default : return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    

 

    public Instruktor vratiIzabranogInstruktora(int red) {
        return instruktori.get(red);
                
    }

    public List<Instruktor> getInstruktori() {
        return instruktori;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
         mti = (ModelTabeleInstruktori) e.getSource();
        String columnName = mti.getColumnName(column);
        Object data = mti.getValueAt(row, column);
        fireTableDataChanged();
        // Do something with the data...
    }

    public void dodajRed(Instruktor red) {
        instruktori.add(red);
    }
    
}
