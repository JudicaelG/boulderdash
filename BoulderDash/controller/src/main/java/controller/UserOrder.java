package controller;

public class UserOrder {
	private Order order;
	
	public UserOrder(Order order){
		this.order = order;
	}
	
	public Order getOrder(){
		return this.order;
	}
}
