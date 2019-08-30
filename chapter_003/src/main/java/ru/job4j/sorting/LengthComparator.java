package ru.job4j.sorting;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Set;

public class LengthComparator implements Comparator<User> {

	public int compare(User a, User b)	{
		return a.getName().toCharArray().length-b.getName().toCharArray().length;
	}


}