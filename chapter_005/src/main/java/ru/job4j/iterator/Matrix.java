package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Matrix implements Iterable {

    int[][] value;

    public Matrix(int[][] value) {
        this.value = value;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            int iterpositionHor = 0;
            int iterpositionVert = 0;

            @Override
            public boolean hasNext() {
                return (iterpositionHor < value[iterpositionVert].length);

            }

            @Override
            public Object next() {
                Object res = null;
                if (hasNext()) {
                    res = value[iterpositionVert][iterpositionHor];
                    if (iterpositionHor + 1 >= (value[iterpositionVert].length)) {
                        if (iterpositionVert + 1 < value.length) {
                            iterpositionVert++;
                            iterpositionHor = 0;
                        } else {
                            iterpositionHor++;
                        }

                    } else {
                        iterpositionHor++;
                    }
                } else {
                    throw new NoSuchElementException();
                }
                return res;
            }
        };
    }
}

