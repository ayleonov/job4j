package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Adress> collect(List<Profile> profiles) {
        List<Adress> result = profiles.stream().map(profile -> profile.getAdress()).collect(Collectors.toList());
        return result;
    }
}
