////////////////////////////////////////////////////////////////////
// alice gibellato 1197756
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import it.unipd.tos.business.exception.TakeAwayBillException;

public class Calculator implements TakeAwayBill {
    public double getOrderPrice(List < MenuItem > items, User user) throws TakeAwayBillException {
        double tot = 0.0;        
       

        if (items == null) {
            throw new TakeAwayBillException("La lista è vuota");
        }

        if (items.contains(null)) {
            throw new TakeAwayBillException("Nella lista è presente un elemento vuoto");
        }

       

        //costo totale
        for (MenuItem i: items) { 
            tot += i.getPrice();
            
        }

       

        return tot;

      
    }



}