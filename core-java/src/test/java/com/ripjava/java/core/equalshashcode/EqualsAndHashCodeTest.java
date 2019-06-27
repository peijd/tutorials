package com.ripjava.java.core.equalshashcode;


import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EqualsAndHashCodeTest {

    @Test
    public void test_DefaultEqualsMethod(){
        Money income = new Money(60, "JPY");
        Money expenses = new Money(60, "JPY");
        assertThat(income.equals(expenses), is(true));
    }

    @Test
    public void test_SymmetricEqualsMethod(){
        Money cash = new Money(42, "USD");
        WrongVoucher voucher = new WrongVoucher(42, "USD", "Amazon");
        // 这个不能通过
        assertThat(voucher.equals(cash), is(cash.equals(voucher)));
    }
    @Test
    public void test_SymmetricHashMethod(){
        Team one = new Team("Tokyo", "dev");
        Team two = new Team("Tokyo", "dev");

        assertThat(one.hashCode() == two.hashCode(), is(false));
    }

    @Test
    public void test_HashMapKey(){
        Map<Team,String> leaders = new HashMap<>();
        leaders.put(new Team("New York", "development"), "Anne");
        leaders.put(new Team("Boston", "development"), "Brian");
        leaders.put(new Team("Boston", "marketing"), "Charlie");

        Team myTeam = new Team("New York", "development");
        assertThat(leaders.get(myTeam), is("Anne"));
    }
    @Test
    public void equalsHashCodeContracts() {
        EqualsVerifier.forClass(Team.class).verify();
    }

}
