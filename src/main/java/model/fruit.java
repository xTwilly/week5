/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 13, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Chance
 *
 */

@Entity
@Table(name="items")
public class fruit {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="STORE")
	private String store;
	@Column(name="ITEM")
	private String item;
	
	public fruit() {
		super();
	}
	
	public fruit(String store, String item) {
		super();
		this.store = store;
		this.item = item;
	}
	
	public void setStore(String newStore) {
		this.store = newStore;
	}
	
	public void setItem(String newItem) {
		this.item = newItem;
	}
	
	public void setID(int newID) {
		this.id = newID;
	}
	
	public String getStore() {
		return this.store;
	}
	
	public String getItem() {
		return this.item;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String returnItemDetails() {
		return this.store + ": " + this.item;
	}

}
