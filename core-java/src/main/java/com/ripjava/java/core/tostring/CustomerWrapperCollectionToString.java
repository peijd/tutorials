package com.ripjava.java.core.tostring;

import java.util.List;

public class CustomerWrapperCollectionToString extends Customer {

	private Integer score; // Wrapper class
    private List<Order> orders; // Collection
    private StringBuffer fullname; // StringBuffer

    @Override
    public String toString() {
        return "Customer [score=" + score + ", orders=" + orders + ", fullname=" + fullname
          + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + "]";
    }

    public CustomerWrapperCollectionToString(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public StringBuffer getFullname() {
		return fullname;
	}

	public void setFullname(StringBuffer fullname) {
		this.fullname = fullname;
	}




}
