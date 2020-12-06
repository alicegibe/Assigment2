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
        int numgelati=0;
        MenuItem icecreamlessprice=null;
       
        
       

        if (items == null) {
            throw new TakeAwayBillException("La lista è vuota");
        }

        if (items.contains(null)) {
            throw new TakeAwayBillException("Nella lista è presente un elemento vuoto");
        }

       

        //costo totale
        for(MenuItem i: items) {
        tot +=i.getPrice();
        if (i.getItem() == MenuItem.type.Gelato) { //conto gelati
            numgelati++;
           
            if ((icecreamlessprice == null) || (icecreamlessprice.getPrice() > i.getPrice())) { //assegno gelato costo minimo
                icecreamlessprice = i;
            }
        }
        
        } 
        if (numgelati > 5) {
            tot -= icecreamlessprice.getPrice() * 0.5;
        }
        
       

        return tot;

      
    }



}