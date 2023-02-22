/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Shopper;

/**
 * @author Chance
 *
 */
public class ShopperHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("shoppingList2");
	
	public void insertShopper(Shopper s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Shopper> showAllShoppers(){
		EntityManager em = emfactory.createEntityManager();
		List<Shopper> allShoppers = em.createQuery("SELECT s FROM Shopper s").getResultList();
		return allShoppers;
	}

}
