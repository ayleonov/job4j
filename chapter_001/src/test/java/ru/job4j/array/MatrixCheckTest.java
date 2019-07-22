package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDateMonoTrueThenTrue(){
    MatrixCheck matrixCheck = new MatrixCheck();
    boolean[][] input = new boolean[][]{{true,false,true}, {true,true,true},{true,false,true}};
    boolean result = matrixCheck.mono(input);
    assertThat(result, is(true));
    }

    @Test
    public void whenDateNotMonoByTrueThenFalse(){
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{{true,false,false}, {true,false,true},{false,false,true}};
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDateMonoTrueAndFalseThenTrue4on4(){
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{{true,false,false,false}, {false, true,false,true},{true, false,true,true},{false,false,true,true}};
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDateNotMonoByTrueThenFalse4on4(){
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{{true,false,false,false}, {false, true,false,true},{true, false,false,true},{false,false,true,true}};
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }

}
