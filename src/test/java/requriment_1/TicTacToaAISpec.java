package requriment_1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToaAISpec {

    private TicTacToe ticTacToe;

    @Before
    public void init() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenPlayXNotCenterThenOPlayCenter() {
        ticTacToe.play(1,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
    }

    @Test
    public void whenPlayXNotCenterLeftMidThenOPlayCenterBottomLeft() {
        ticTacToe.play(1,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(1,2);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 3]", actual);
    }

    @Test
    public void whenPlayXNotCenterRightMidThenOPlayCenterTopRight() {
        ticTacToe.play(1,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(2,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 1]", actual);
    }

    @Test
    public void whenPlayXNotCenterLeftMidThenOPlayCenterTopLeft() {
        ticTacToe.play(1,3);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(1,2);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 1]", actual);
    }

    @Test
    public void whenPlayXNotCenterRightMidThenOPlayCenterTopLeft() {
        ticTacToe.play(3,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(2,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 1]", actual);
    }

    @Test
    public void whenXPlayMidLeftTopLeftThenOPlayCenterBottomLeft() {
        ticTacToe.play(1,2);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(1,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 3]", actual);
    }

    @Test
    public void whenXPlayMidTopTopLeftThenOPlayCenterTop() {
        ticTacToe.play(2,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(1,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 1]", actual);
    }
}
