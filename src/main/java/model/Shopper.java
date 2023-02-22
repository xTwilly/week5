/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Chance
 *
 */
@Entity
@Table(name="shopper")
public class Shopper {
	@Id
	@GeneratedValue
	private int id;
	private String shopperName;
	
	public Shopper() {
		super();
	}
	
	public Shopper(int id, String shopperName) {
		super();
		this.id=id;
		this.shopperName = shopperName;
	}
	
	public Shopper(String shopperName) {
		super();
		this.shopperName = shopperName;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getShopperName() {
		return this.shopperName;
	}
	
	public void setShopperName(String shopperName) {
		this.shopperName=shopperName;
	}
	
	@Override
	public String toString() {
		return "Shopper [id =" + id + ", shopperName=" + shopperName + "]";
	}

}
