package com.kushals.snakesandladders.model;

public class Snake {
	private int start;
	private int end;
	
	public Snake(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return "Snake [start=" + start + ", end=" + end + "]";
	}
	
}
