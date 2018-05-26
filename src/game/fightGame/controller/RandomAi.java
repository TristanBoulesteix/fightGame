package game.fightGame.controller;

import java.util.ArrayList;
import java.util.Random;

public class RandomAi extends AI {

	public RandomAi(ArrayList<String> listClass) {
		super(listClass);
	}

	@Override
	public Order getAction() {
		Random random = new Random();
		ArrayList<Order> orders = new ArrayList<Order>();

		for (Order order : Order.values()) {
			orders.add(order);
		}

		return orders.get(random.nextInt(orders.size()));
	}

}
