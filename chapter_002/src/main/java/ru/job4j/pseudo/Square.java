package ru.job4j.pseudo;

public class Square implements Shape {
	public String draw() {
		StringBuilder pic = new StringBuilder("\n")
		.append("XXXX\n")
		.append("X  X\n")
		.append("X  X\n")
		.append("XXXX\n");
		return pic.toString();
	}
}