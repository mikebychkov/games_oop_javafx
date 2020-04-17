package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        Cell[] rsl = new Cell[10];
        int rslLen = 0;
        int wegX = source.x;
        int wegY = source.y;
        Cell resent = source;
        do {
            resent = Cell.findBy(wegX, wegY);
            rsl[rslLen++] = resent;
            if (dest.x > source.x) {wegX++;} else {wegX--;};
            if (dest.y > source.y) {wegY++;} else {wegY--;};
        } while (!resent.equals(dest));
        return Arrays.copyOf(rsl, rslLen);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return source.x + source.y == dest.x + dest.y || source.x - source.y == dest.x - dest.y;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
