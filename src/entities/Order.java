package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List <OrderItem> itens = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOi() {
		return itens;
	}
	
	public void addItem (OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		Double totalItem = 0.0;
		for (OrderItem orderItem: itens) {
			totalItem += orderItem.subTotal();
		}
		return totalItem;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: "+sdf.format(moment));
		sb.append("\nOrder Status: "+ status);
		sb.append("\nClient: "+client +"\n");
		sb.append("Order items: \n");
		for (OrderItem item: itens) {
			sb.append(item + "\n");
		}
		sb.append("Total Price: "+total());
		
		return sb.toString();
		
	}
	
}
