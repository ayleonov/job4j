package ru.job4j.storage2;

import org.junit.Test;
import ru.job4j.storage2.storages.StoragePlace;
import ru.job4j.storage2.goods.Carrot;
import ru.job4j.storage2.goods.Food;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ControlQualityTest {
    @Test
    public void whenTestingMethodExecute() {

        ControlQuality controlQuality = new ControlQuality();
        String expireDate = "2020-12-03";
        String createDate = "2019-11-30";
        Food food = new Carrot(createDate, expireDate, 20, 10);
        controlQuality.init();
        Food res =  controlQuality.executeStrategy(food);
        List<StoragePlace> list = controlQuality.getList();
        assertThat(list.size(), is(3));
        assertThat(res, is(food));
    }
}