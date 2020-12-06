package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class CalculatorTest {
	
	Calculator bill;
	User user;
	double tot;
	List<MenuItem> list;
	private static final double Diff = 1e-3;
	
	@Before
	public void setup() {
		bill = new Calculator();
		tot = 0.00;
		list = new ArrayList<MenuItem>();
		user = new User("Alice","Gibellato",21);
	}
	//test lista nulla
		@Test(expected = TakeAwayBillException.class) 
	    public void listNulltTest() throws TakeAwayBillException {
	        list = null;
	        tot = bill.getOrderPrice(list,user);
	    }
		//test oggetto nullo 
		@Test(expected = TakeAwayBillException.class) 
	    public void nullInListTest() throws TakeAwayBillException {
	        list.add(new MenuItem(MenuItem.type.Bevanda,"Fanta",2.50));
	        list.add(new MenuItem(MenuItem.type.Gelato,"Stracciatella",1.50));
			list.add(null);
	        tot = bill.getOrderPrice(list,user);
	    }
		
	//test calcolo totale
	@Test
	public void sumTest() throws TakeAwayBillException {

        list.add(new MenuItem(MenuItem.type.Gelato, "Coppagelato", 7.00));
        list.add(new MenuItem(MenuItem.type.Budino, "Cioccolato", 4.00));
        list.add(new MenuItem(MenuItem.type.Bevanda, "CocaCola", 2.50));

        tot = bill.getOrderPrice(list,user);

        assertEquals(13.50,tot,Diff);
    }  
	//test 5 gelati 
	@Test
	public void discount50Test() throws TakeAwayBillException {
		list.add(new MenuItem(MenuItem.type.Gelato,"Cioccolatomaxi",7.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"Stracciatella",1.50));
		list.add(new MenuItem(MenuItem.type.Gelato,"Cioccolato",2.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"Mirtillomaxi",7.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"Vaniglia",2.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"Caramello",2.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"Fragola",2.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"Limone",2.00));
		tot = bill.getOrderPrice(list, user);
		assertEquals(24.75,tot,Diff);
	} 
	//10% sconto se +€50
	@Test 
	public void discount10Test() throws TakeAwayBillException {
		list.add(new MenuItem(MenuItem.type.Budino,"Cioccolato",8.00));
		list.add(new MenuItem(MenuItem.type.Budino,"Panna",10.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"BananaSplit",15.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"CoppaAmarena",25.00));
		list.add(new MenuItem(MenuItem.type.Bevanda,"Fanta",2.50));
		tot = bill.getOrderPrice(list, user);
		assertEquals(54.45,tot,Diff);
		} 
	//test 30 elementi 
	@Test(expected = TakeAwayBillException.class) 
	public void max30Test() throws TakeAwayBillException {
		for(int i=0; i<40; i++) {
			list.add(new MenuItem(MenuItem.type.Budino,"Cioccolato",8.00));
		}
		tot = bill.getOrderPrice(list,user);
	} 
	//test commissione 0.50
	@Test
	public void plus050Test() throws TakeAwayBillException {
		list.add(new MenuItem(MenuItem.type.Bevanda,"The",2.50));
		tot = bill.getOrderPrice(list, user);
		assertEquals(3,tot,Diff);
	}
	
	
	
}