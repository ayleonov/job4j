package ru.job4j.pseudo;

public class Triangle implements Shape {
	public String draw() {
		StringBuilder pic = new StringBuilder("\n");
		pic.append("   X   \n");
		pic.append("  X X  \n");
		pic.append(" X   X \n");
		pic.append("XXXXXXX\n");
		return pic.toString();
	}
}