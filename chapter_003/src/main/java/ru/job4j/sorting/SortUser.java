package ru.job4j.sorting;
import java.util.*;

public class SortUser {

    public Set<User> sort (List<User> list)	{
        Set<User> set = new TreeSet();
        for (User user : list)	{
            set.add(user);
        }
        return set;
    }



}
