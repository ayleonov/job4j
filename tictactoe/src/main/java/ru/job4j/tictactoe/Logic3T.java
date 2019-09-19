package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return (table[0][0].hasMarkX() && table[1][0].hasMarkX() && table[2][0].hasMarkX())
                || (table[0][1].hasMarkX() && table[1][1].hasMarkX() && table[2][1].hasMarkX())
                || (table[0][2].hasMarkX() && table[1][2].hasMarkX() && table[2][2].hasMarkX())
                || (table[0][0].hasMarkX() && table[0][1].hasMarkX() && table[0][2].hasMarkX())
                || (table[1][0].hasMarkX() && table[1][1].hasMarkX() && table[1][2].hasMarkX())
                || (table[2][0].hasMarkX() && table[2][1].hasMarkX() && table[2][2].hasMarkX())
                || (table[0][0].hasMarkX() && table[1][1].hasMarkX() && table[2][2].hasMarkX())
                || (table[2][0].hasMarkX() && table[1][1].hasMarkX() && table[0][2].hasMarkX());
    }


    public boolean isWinnerO() {
        return (table[0][0].hasMarkO() && table[1][0].hasMarkO() && table[2][0].hasMarkO())
                || (table[0][1].hasMarkO() && table[1][1].hasMarkO() && table[2][1].hasMarkO())
                || (table[0][2].hasMarkO() && table[1][2].hasMarkO() && table[2][2].hasMarkO())
                || (table[0][0].hasMarkO() && table[0][1].hasMarkO() && table[0][2].hasMarkO())
                || (table[1][0].hasMarkO() && table[1][1].hasMarkO() && table[1][2].hasMarkO())
                || (table[2][0].hasMarkO() && table[2][1].hasMarkO() && table[2][2].hasMarkO())
                || (table[0][0].hasMarkO() && table[1][1].hasMarkO() && table[2][2].hasMarkO())
                || (table[2][0].hasMarkO() && table[1][1].hasMarkO() && table[0][2].hasMarkO());

    }

    public boolean isWinnerX2() {
        return
                isAnybodyWin('X');
    }

    public boolean isWinnerO2() {
        return
                isAnybodyWin('O');
    }

    public  Predicate refactor(char sign ) {
        Predicate predicate = null;
        if  (sign == 'X') {
            predicate = Figure3T::hasMarkX;
        }   else {
            predicate = Figure3T::hasMarkO;
        }
        return predicate;
    }

    public boolean isAnybodyWin(char sign) {
        return this.fillBy(refactor(sign), 0, 0, 1, 0)
                || this.fillBy(refactor(sign), 0, 1, 1, 0)
                || this.fillBy(refactor(sign), 0, 2, 1, 0)
                || this.fillBy(refactor(sign), 0, 0, 0, 1)
                || this.fillBy(refactor(sign), 1, 0, 0, 1)
                || this.fillBy(refactor(sign), 2, 0, 0, 1)
                || this.fillBy(refactor(sign), 0, 0, 1, 1)
                || this.fillBy(refactor(sign), 2, 0, -1, 1);
    }

    public boolean hasGap() {
        boolean res = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j].hasMarkX()) {
                    continue;
                }
                if (table[i][j].hasMarkO()) {
                    continue;
                } else {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean res = true;
        for (int i = 0; i < this.table.length; i++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                res = false;
                break;
            }
        }
        return res;
    }
}
