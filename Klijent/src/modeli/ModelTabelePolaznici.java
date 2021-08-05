/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Polaznik;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelTabelePolaznici extends AbstractTableModel{
    
    List<Polaznik> polaznici;
    String[] kolone = new String[]{"Šifra","Ime","Prezime","Br. telefona", "Email","Datum rodj."};
    
    
   public ModelTabelePolaznici(List<Polaznik> polaznici) {
        this.polaznici = polaznici;
    }
    
    
    @Override
    public int getRowCount() {
        return polaznici.size();
    }
    

    

    

    @Override
    public int getColumnCount() {
        return  kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          Polaznik p = polaznici.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getSifraPolaznika();
            case 1: return p.getIme();
            case 2: return p.getPrezime();
            case 3: return p.getBrTelefona();
            case 4: return p.getEmail();
            case 5: return p.getDatumRodjenja();
            default : return "n/a";        
        }
    }

    public Polaznik vratiIzabranogPolaznika(int red) {
        return polaznici.get(red);
    }

   

    public List<Polaznik> getPolaznici() {
        return polaznici;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
    
}
