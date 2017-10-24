package requriment_1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeAITest {

    private TicTacToeAI tacToeAI;
    private String[] board = {"O", "1", "X",
                              "X", "4", "X",
                              "6", "O", "O"};


    @Before
    public void init() throws Exception {
        tacToeAI = new TicTacToeAI();
    }

    @Test
    public void whenXPlayCenterThenXWin() {
        String player = "X";
        board[4] = "X";
        int actual = tacToeAI.minimax(board, player);
        assertEquals(10, actual);
    }

    @Test
    public void whenOPlayBottomLeftThenOWin() {
        String player = "O";
        board[6] = "O";
        int actual = tacToeAI.minimax(board, player);
        assertEquals(-10, actual);
    }

    @Test
    public void whenAllFillIsFullThenDraw() {
        String player = "O";
        board[0] = "X";
        board[1] = "O";
        board[2] = "X";
        board[3] = "X";
        board[4] = "O";
        board[5] = "O";
        board[6] = "O";
        board[7] = "X";
        board[8] = "O";
        int actual = tacToeAI.minimax(board, player);
        assertEquals(0, actual);
    }


    @Test
    public void whenOChooseBestMoveThenCenter() {
        String player = "X";
        int actual = tacToeAI.minimax(board, player);
        assertEquals(4, actual);
    }

    @Test
    public void whenXPlayTopMidThenBestMoveOIsCenter() {
        String player = "O";
        board[1] = "X";
        int actual = tacToeAI.minimax(board, player);
        assertEquals(4, actual);
    }

    @Test
    public void whenXPlayBottomLeftThenBestMoveOIsCenter() {
        String player = "O";
        board[6] = "X";
        int actual = tacToeAI.minimax(board, player);
        assertEquals(4, actual);
    }

    @Test
    public void whenXPlayBottomLeftOPlayTopMidThenBestMoveXIsCenter() {
        String player = "X";
        board[6] = "X";
        board[1] = "O";
        int actual = tacToeAI.minimax(board, player);
        assertEquals(4, actual);
    }
}