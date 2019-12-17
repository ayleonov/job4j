package ru.job4j.exam;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.exam.Org;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringsComparatorTest {
        Set<String[]> set;
        List<String[]> expect;
        @Before
        public void setUp() {
            set = new TreeSet();
            String[] a1 = {"K1"};
            String[] a2 = {"K2"};
            String[] a3 = {"K1","SK1"};
            String[] a4 = {"K1","SK2"};
            String[] a5 = {"K1","SK1","SSK1"};
            String[] a6 = {"K1","SK1","SSK2"};
            String[] a7 = {"K2","SK1","SSK1"};
            String[] a8 = {"K2","SK1","SSK2"};
            String[] a9 = {"K2","SK1"};
           /* String[] expect = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                    "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
            };*/
            set.add(a1);
            set.add(a2);
            set.add(a3);
            set.add(a4);
            set.add(a5);
            set.add(a6);
            set.add(a7);
            set.add(a8);
            set.add(a9);

            expect = new ArrayList();
            expect.add(a1);
            expect.add(a3);
            expect.add(a5);
            expect.add(a6);
            expect.add(a4);
            expect.add(a2);
            expect.add(a9);
            expect.add(a7);
            expect.add(a8);
        }

        @Test
        public void whenDirectSorting() {

            List<String[]> res = new ArrayList();
            for (String[] el: set) {
                System.out.println(Arrays.asList(el));
                res.add(el);
                //System.out.println(el.toString());
            }

            /*String[] expect = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                    "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
            }; */
            assertThat(res, is(expect));
        }

      /*  @Test
        public void whenReverseSorting() {
            Org secondSorting = new Org(list);
            secondSorting.sorting(1);
            List<String> result = secondSorting.getNamestring();
            String[] expect = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                    "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
            assertThat(result, is(Arrays.asList(expect)));
        }
    }*/


}