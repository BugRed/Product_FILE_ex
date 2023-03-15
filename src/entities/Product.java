package entities;

import java.io.Serializable;

public class Product  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String name;
	private Double price;
	private Integer quantity;
	
	
	
	public Product() {
		
	}
	
	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	public Double totalPrice() {
		return quantity * price;
	}
	
	
	
	
	
	

}
