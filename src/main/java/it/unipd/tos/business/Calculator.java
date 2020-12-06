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
        double gelatibudini = 0.0;
       
        
       

        if (items == null) {
            throw new TakeAwayBillException("La lista è vuota");
        }

        if (items.contains(null)) {
            throw new TakeAwayBillException("Nella lista è presente un elemento vuoto");
        }
        //issue 4
        if (items.size() > 30) {
            throw new TakeAwayBillException("La lista ha più 30 elementi");
        }

       

        //costo totale
        for(MenuItem i: items) {
        tot +=i.getPrice();
        if (i.getItem() == MenuItem.type.Gelato) { 
            numgelati++;  //conto gelati
            gelatibudini += i.getPrice();  // sommo prezzo gelato
            if ((icecreamlessprice == null) || (icecreamlessprice.getPrice() > i.getPrice())) { //assegno gelato costo minimo
                icecreamlessprice = i;
            }}
            if (i.getItem() == MenuItem.type.Budino) {
                gelatibudini += i.getPrice();   //sommo prezzo budino 
            }
            
            
        } 
   
        
         //issue 2
        if (numgelati > 5) {
            tot -= icecreamlessprice.getPrice() * 0.5;
        } 
        //issue 3
        if (gelatibudini > 50) {
        
        tot = tot*0.9;
        }  
        //issue 5 
        if(tot<10) {
        tot +=0.50;
        }
        
        
        
        
       

        return tot;

      
    }



}
