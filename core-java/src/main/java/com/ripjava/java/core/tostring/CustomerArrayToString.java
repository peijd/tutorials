package com.ripjava.java.core.tostring;

import java.util.Arrays;

public class CustomerArrayToString extends Customer {

	private Order[] orders;

	@Override
	public String toString() {
		return "Customer [orders=" + Arrays.toString(orders)
				+ ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + "]";
	}

	public CustomerArrayToString(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Order[] getOrders() {
		return orders;
	}

	public void setOrders(Order[] orders) {
		this.orders = orders;
	}


}
