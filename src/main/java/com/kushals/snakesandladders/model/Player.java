package com.kushals.snakesandladders.model;

import java.util.UUID;

public class Player {
	String name;
	String id;
	
	public Player(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString(); 
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", id=" + id + "]";
	}
	
}
