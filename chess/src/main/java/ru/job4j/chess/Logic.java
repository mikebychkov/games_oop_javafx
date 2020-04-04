package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = new Cell[0];
            try {
                steps = this.figures[index].way(source, dest);
            } catch (IllegalStateException e) {
                return false;
            }
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                if (this.isWayClear(steps)) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        }
        return rst;
    }

    public boolean isWayClear(Cell[] way) {
        for (int i = 1; i < way.length - 1; i++) {
            if (this.findBy(way[i]) != -1) return false;
        }
        return true;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
