package requriment_1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public void init() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException1() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(0, 2);
    }

    @Test
    public void whenXInsideBoard() {
        ticTacToe.play(1, 2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException1() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 0);
    }

    @Test
    public void whenYInsideBoard() {
        ticTacToe.play(2, 2);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX() {
        assertEquals('X', ticTacToe.nextPlayer());
    }
    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO() {
        ticTacToe.play(2, 2);
        assertEquals('O', ticTacToe.nextPlayer());
        ticTacToe.play(2, 1);
        assertNotEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToe.play(1, 1);
        assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(3, 1); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 1); // O
        ticTacToe.play(1, 2); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(1, 3); // O
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() {
        ticTacToe.play(1, 3); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(1, 2); // O
        String actual = ticTacToe.play(3, 1); // O
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(2, 1); // O
        String actual = ticTacToe.play(3, 3); // O
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw() {
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(1, 3); //X
        ticTacToe.play(2, 1); //O
        ticTacToe.play(2, 3); //X
        ticTacToe.play(2, 2); //O
        ticTacToe.play(3, 1); //X
        ticTacToe.play(3, 3); //O
        String actual = ticTacToe.play(3, 2); //X
        assertEquals("The result is draw", actual);
    }
}
