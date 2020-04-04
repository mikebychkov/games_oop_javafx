package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.BishopWhite;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void way() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] rsl = bb.way(Cell.C1, Cell.H6);
        Cell[] exp = {Cell.C1, Cell.D2, Cell.E3, Cell.F4, Cell.G5, Cell.H6};
        assertThat(rsl, is(exp));
    }
}
