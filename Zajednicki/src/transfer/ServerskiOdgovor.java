/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Milica
 */
public class ServerskiOdgovor implements Serializable{
    
    private Object podaci;
    private boolean uspesnost;
    private Exception exception;
    private String poruka;
    
    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object podaci, boolean uspesnost, Exception exception, String poruka) {
        this.podaci = podaci;
        this.uspesnost = uspesnost;
        this.exception = exception;
        this.poruka = poruka;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public boolean isUspesnost() {
        return uspesnost;
    }

    public void setUspesnost(boolean uspesnost) {
        this.uspesnost = uspesnost;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    
    
}
