package entities;

import java.text.SimpleDateFormat;

public class OrderItem {
	private Integer quantity;
	private Double price;
	
	private Products product;
	
	public OrderItem() {
		
	}

	public OrderItem(Integer quantity, Double price, Products product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double subTotal() {
		return quantity*price;
	}
	
	public String toString() {
		return product.getName() +
				", $"+ String.format("%.2f",product.getPrice())+
				", Quantity: "+getQuantity()+
				", Subtotal $: "+ String.format("%.2f",subTotal());
		
	}
}
