package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenAddresesWithoutRepeats() {
        Profiles profileadresses = new Profiles();
        Profile pr1 = new Profile();
        Profile pr2 = new Profile();
        Profile pr3 = new Profile();
        Profile pr4 = new Profile();
        Adress ad1 = new Adress("city1", "street1", 1, 12);
        Adress ad2 = new Adress("city2", "street2", 2, 13);
        Adress ad3 = new Adress("city1", "street1", 1, 12);
        Adress ad4 = new Adress("city2", "street2", 2, 13);
        pr1.setAdress(ad1);
        pr2.setAdress(ad2);
        pr3.setAdress(ad3);
        pr4.setAdress(ad4);
        List<Adress> expect = List.of(ad1, ad3, ad2, ad4);
        List<Profile> profiles = List.of(pr1, pr2, pr3, pr4);
        List<Adress> result = profileadresses.collect(profiles);

        assertThat(result, is(expect));
    }
}
