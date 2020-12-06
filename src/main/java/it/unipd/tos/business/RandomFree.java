////////////////////////////////////////////////////////////////////
// alice gibellato 1197756
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import java.time.LocalTime;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class RandomFree {

    private List < MenuItem > list;
    private User utente;
    private LocalTime tempo;
    private double prezzo;

    public RandomFree(List < MenuItem > list, User user, LocalTime time, double price) {
        this.list = list;
        this.utente = user;
        this.tempo = time;
        this.prezzo = price;
    }

    public List < MenuItem > getList() {
        return list;
    }

    public User getUser() {
        return utente;
    }

    public int getTime() {
        return ((tempo.getHour() * 60 * 60) + (tempo.getMinute() * 60) + tempo.getSecond());
    }


    public double getPrice() {
        return prezzo;
    }

    public void changePrice(double p) {
        prezzo = p;
    }

}