import java.util.List;

import controller.ShopperHelper;
import model.Shopper;

/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */

/**
 * @author Chance
 *
 */
public class ShopperTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shopper bill = new Shopper("Bill");
		ShopperHelper sh = new ShopperHelper();
		
		sh.insertShopper(bill);
		List<Shopper> allShoppers = sh.showAllShoppers();
		for(Shopper a: allShoppers) {
			System.out.println(a.toString());
		}
		

	}

}
