/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 13, 2023
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.fruit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chance
 *
 */
public class fruitHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("shoppingList2");
	
	public void insertItem(fruit li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<fruit> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<fruit> allItems = em.createQuery("SELECT i FROM fruit i").getResultList();
		return allItems;
	}
	
	public void deleteItem(fruit toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<fruit> typedQuery = em.createQuery("select li from fruit where li.store = :selectedStore and li.item = :selectedItem", fruit.class);
		
		//substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStore", toDelete.getStore());
		typedQuery.setParameter("selectedItem", toDelete.getItem());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		fruit result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public fruit searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		fruit found = em.find(fruit.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(fruit toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param storeName
	 * @return
	 */
	public List<fruit> searchForItemByStore(String storeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<fruit> typedQuery = em.createQuery("select li from fruit li where li.store = :selectedStore", fruit.class);
		typedQuery.setParameter("selectedStore", storeName);
		
		List<fruit> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param itemName
	 * @return
	 */
	public List<fruit> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<fruit> typedQuery = em.createQuery("select li from fruit where li.item = :selectedItem", fruit.class);
		typedQuery.setParameter("selectedItem", itemName);
		
		List<fruit> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
