package com.ripjava.java.core.tostring;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ToStringTest {
	@Test
	public void test_CustomertoString() {
		System.out.println(new Customer("justin", "tt"));
	}

	@Test
	public void test_CustomerPrimitiveToString() {
		System.out.println(new CustomerPrimitiveToString("justin", "tt", 1100000L));
	}

	@Test
	public void test_ComplexObjectToToString() {
		CustomerComplexObjectToString customer = new CustomerComplexObjectToString("justin", "tt");
		Order order = new Order();
		order.setOrderId("A1111");
		order.setDesc("Game");
		order.setStatus("Complete");
		customer.setOrder(order);
		System.out.println(customer);
	}

	@Test
	public void test_CustomerArrayToString() {
		CustomerArrayToString customer = new CustomerArrayToString("justin", "tt");
		Order order1 = new Order();
		order1.setOrderId("A1111");
		order1.setDesc("Game");
		order1.setStatus("Complete");
		Order order2 = new Order();
		order2.setOrderId("A1111");
		order2.setDesc("Game");
		order2.setStatus("Complete");
		Order order3 = new Order();
		order3.setOrderId("A1111");
		order3.setDesc("Game");
		order3.setStatus("Complete");
		customer.setOrders(new Order[] { order1, order2, order3 });
		System.out.println(customer);
	}

	@Test
	public void test_CustomerWrapperCollectionToString() {
		CustomerWrapperCollectionToString customer = new CustomerWrapperCollectionToString("justin", "tt");

		customer.setScore(129);
		Order order1 = new Order();
		order1.setOrderId("A1111");
		order1.setDesc("Game");
		order1.setStatus("Complete");
		Order order2 = new Order();
		order2.setOrderId("A1111");
		order2.setDesc("Game");
		order2.setStatus("Complete");
		Order order3 = new Order();
		order3.setOrderId("A1111");
		order3.setDesc("Game");
		order3.setStatus("Complete");
		customer.setOrders(Arrays.asList(order1, order2, order3));

		StringBuffer fullname = new StringBuffer();
		fullname.append(customer.getLastName() + ", " + customer.getFirstName());
		customer.setFullname(fullname);

		System.out.println(customer);
	}
}
