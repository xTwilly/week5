/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Chance
 *
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Shopper shopper;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<fruit> listOfItems;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate tripDate, Shopper shopper, List<fruit> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfItems = listOfItems;
	}
	
	public ListDetails(String listName, LocalDate tripDate, Shopper shopper, List<fruit> listOfItems) {
		super();
		this.listName = listName; 
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfItems = listOfItems;
	}
	
	public ListDetails(String listName, LocalDate tripDate, Shopper shopper) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int newId) {
		this.id = newId;
	}
	public String getListName() {
		return this.listName;
	}
	public void setListName(String newListName) {
		this.listName = newListName;
	}
	
	public LocalDate getTripDate() {
		return this.tripDate;
	}
	
	public void setTripDate(LocalDate newDate) {
		this.tripDate = newDate;
	}
	
	public Shopper getShopper() {
		return this.shopper;
	}
	
	public void setShopper(Shopper newShopper) {
		this.shopper = newShopper;
	}
	
	public List<fruit> getListOfItems(){
		return this.listOfItems;
	}
	
	public void setListOfItems(List<fruit> newListOfItems) {
		this.listOfItems = newListOfItems;
	}
	
	@Override
	public String toString() {
		System.out.println( "ListDetails = [id:" + id + ", listName:" + listName + ", tripDate:" + tripDate + ", shopper:" +shopper.getShopperName() +", listOfItems:");
	for(fruit f: listOfItems) {
		System.out.print(f.getItem() + " | ");
	}
	return  "]";
	}
	
}
