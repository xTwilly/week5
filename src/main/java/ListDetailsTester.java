import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ShopperHelper;
import model.ListDetails;
import model.Shopper;
import model.fruit;

/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */

/**
 * @author Chance
 *
 */
public class ListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shopper cameron = new Shopper("Cameron");
		ListDetailsHelper ldh = new ListDetailsHelper();
		fruit shampoo = new fruit("Target", "Shampoo");
		fruit brush = new fruit("Target", "Brush");
		
		List<fruit> cameronsItems = new ArrayList<fruit>();
		cameronsItems.add(shampoo);
		cameronsItems.add(brush);
		
		ListDetails cameronsList = new ListDetails("Cameron's ShoppingList", LocalDate.now(), cameron);
		cameronsList.setListOfItems(cameronsItems);
		
		ldh.insertNewListDetails(cameronsList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}

	}

}
