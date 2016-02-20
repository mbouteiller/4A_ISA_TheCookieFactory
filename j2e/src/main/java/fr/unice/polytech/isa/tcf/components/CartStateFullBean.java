package fr.unice.polytech.isa.tcf.components;

import fr.unice.polytech.isa.tcf.entities.Customer;
import fr.unice.polytech.isa.tcf.entities.Item;

import javax.ejb.Stateful;
import java.util.*;


@Stateful(name = "cart-statefull")
public class CartStateFullBean extends AbstractCartBean {

	private Map<Customer, Set<Item>> carts = new HashMap<>();

	@Override
	public boolean add(Customer c, Item item) {
		carts.put(c, updateCart(c, item));
		return true;
	}

	@Override
	public Set<Item> contents(Customer c) {
		return carts.getOrDefault(c, new HashSet<Item>());
	}

}
