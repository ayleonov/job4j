package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Adress> collect(List<Profile> profiles) {

        List<Adress> result = profiles.stream().distinct().map(profile -> profile.getAdress()).collect(Collectors.toList());
        result.sort(new Comparator<Adress>() {
            @Override
            public int compare(Adress o1, Adress o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        });
        return result;
    }

}
