package ru.job4j.calculate;
/**
* Class Calculate for calculations.
* 
* @author Aleksey Leonov (allesh002@mail.ru)
*/
public class Calculate {
/**
* Main.
* Displays the result string.
* @param args Incoming arguments
*/
	public static void main(String[] args) {
		System.out.println("Hello, Job4j.");
	}
	
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/ 
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}	
}