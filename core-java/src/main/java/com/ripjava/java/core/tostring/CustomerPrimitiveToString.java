package com.ripjava.java.core.tostring;

public class CustomerPrimitiveToString extends Customer {

	private long balance;

    @Override
    public String toString() {
        return "Customer [balance=" + balance + ", getFirstName()=" + getFirstName()
          + ", getLastName()=" + getLastName() + "]";
    }

	public CustomerPrimitiveToString(String firstName, String lastName, long balance) {
		super(firstName, lastName);
		this.balance = balance;
	}
}
