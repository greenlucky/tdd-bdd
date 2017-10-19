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
    public void whenPlayXBottomRightCenterThenOPlayCenter() {
        ticTacToe.play(3,3);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
    }

    @Test
    public void whenPlayXMidRightCenterThenOPlayCenter() {
        ticTacToe.play(3,2);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
    }

    @Test
    public void whenPlayXMidBottomMidThenOPlayCenter() {
        ticTacToe.play(2,3);
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

    @Test
    public void whenXPlayTopLeftMidLeftTopMidThenOPlayCenterBottomLeftRightMid() {
        ticTacToe.play(1,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(1,2);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 3]", actual);
        ticTacToe.play(2,1);
        actual = ticTacToe.OPlay();
        assertEquals("O is the winner", actual);
    }

    @Test
    public void whenXPlayTopLeftMidLeftTopRightThenOPlayCenterBottomLeftTopMid() {
        ticTacToe.play(1,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(1,2);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 3]", actual);
        ticTacToe.play(3,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [2, 1]", actual);
    }

    @Test
    public void whenXPlayBottomLeftMidBottomMidLeftThenOPlayCenterBottomRightTopLeft() {
        ticTacToe.play(1,3);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(2,3);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 3]", actual);
        ticTacToe.play(1,2);
        actual = ticTacToe.OPlay();
        assertEquals("O is the winner", actual);
    }

    @Test
    public void whenXPlayBottomRightMidBottomMidRightThenOPlayCenterBottomLeftTopRight() {
        ticTacToe.play(3,3);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(2,3);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 3]", actual);
        ticTacToe.play(3,2);
        actual = ticTacToe.OPlay();
        assertEquals("O is the winner", actual);
    }

    @Test
    public void whenXPlayTopLeftMidTopBottomLeftThenOPlayCenterRightTopMidLeft() {
        ticTacToe.play(1,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(2,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 1]", actual);
        ticTacToe.play(1,3);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 2]", actual);
    }

    @Test
    public void whenXPlayRightTopMidTopBottomRightThenOPlayCenterLeftTopMidRight() {
        ticTacToe.play(3,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(2,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 1]", actual);
        ticTacToe.play(3,3);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 2]", actual);
    }

    @Test
    public void whenXPlayBottomLeftBottomMidTopLeftThenOPlayCenterRightBottomMidLeft() {
        ticTacToe.play(1,3);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(2,3);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 3]", actual);
        ticTacToe.play(1,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 2]", actual);
    }

    @Test
    public void whenXPlayBottomRightMidRightBottomLeftThenOPlayCenterTopRightMidBottom() {
        ticTacToe.play(3,3);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(3,2);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 1]", actual);
        ticTacToe.play(1,3);
        actual = ticTacToe.OPlay();
        assertEquals("O play [2, 3]", actual);
    }


    @Test
    public void whenXPlayRightTopMidRightTopLeftThenOPlayCenterBottomRightMidTop() {
        ticTacToe.play(3,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(3,2);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 3]", actual);
        ticTacToe.play(1,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [2, 1]", actual);
    }

    @Test
    public void whenXPlayTopLeftTopMidTopLeftBottomLeftMidBottomThenOPlayCenterRightTopMidLeftRightBottom() {
        ticTacToe.play(1,1);
        String actual = ticTacToe.OPlay();
        assertEquals("O play [2, 2]", actual);
        ticTacToe.play(2,1);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 1]", actual);
        ticTacToe.play(1,3);
        actual = ticTacToe.OPlay();
        assertEquals("O play [1, 2]", actual);
        ticTacToe.play(3,2);
        actual = ticTacToe.OPlay();
        assertEquals("O play [3, 3]", actual);
        String raw = ticTacToe.play(2,3);
        assertEquals("The result is draw", raw);
    }





}
