package requriment_1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeAITestRepare {

    private TicTacToeAI tacToeAI;
    private String[] board = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};


    @Before
    public void init() throws Exception {
        tacToeAI = new TicTacToeAI();
    }

    @Test
    public void testWinningXWinVerticalRow1() {
        String player = "X";
        board[0] = "X";
        board[1] = "X";
        board[2] = "X";
        boolean xWin = tacToeAI.winning(board, player);
        assertEquals(true, xWin);
    }

    @Test
    public void testWinningXWinVerticalRow2() {
        String player = "X";
        board[3] = "X";
        board[4] = "X";
        board[5] = "X";
        boolean xWin = tacToeAI.winning(board, player);
        assertEquals(true, xWin);
    }

    @Test
    public void testWinningXWinVerticalRow3() {
        String player = "X";
        board[6] = "X";
        board[7] = "X";
        board[8] = "X";
        boolean xWin = tacToeAI.winning(board, player);
        assertEquals(true, xWin);
    }

    @Test
    public void testWinningXWinHorizontalRow1() {
        String player = "X";
        board[0] = "X";
        board[3] = "X";
        board[6] = "X";
        boolean xWin = tacToeAI.winning(board, player);
        assertEquals(true, xWin);
    }

    @Test
    public void testWinningXWinHorizontalRow2() {
        String player = "X";
        board[1] = "X";
        board[4] = "X";
        board[7] = "X";
        boolean xWin = tacToeAI.winning(board, player);
        assertEquals(true, xWin);
    }

    @Test
    public void testWinningXWinHorizontalRow3() {
        String player = "X";
        board[2] = "X";
        board[5] = "X";
        board[8] = "X";
        boolean xWin = tacToeAI.winning(board, player);
        assertEquals(true, xWin);
    }

    @Test
    public void testWinningXDiagonal1() {
        String player = "X";
        board[0] = "X";
        board[4] = "X";
        board[8] = "X";
        boolean xWin = tacToeAI.winning(board, player);
        assertEquals(true, xWin);
    }

    @Test
    public void testWinningXDiagonal2() {
        String player = "X";
        board[2] = "X";
        board[4] = "X";
        board[6] = "X";
        boolean xWin = tacToeAI.winning(board, player);
        assertEquals(true, xWin);
    }

    @Test
    public void tesEmptySpotIsNine() {

        int[] emptySpots = tacToeAI.emptyIndexies(board);
        assertEquals(9, emptySpots.length);
    }

    @Test
    public void tesEmptySpotIsEight() {

        board[0] = "X";
        int[] emptySpots = tacToeAI.emptyIndexies(board);
        assertEquals(8, emptySpots.length);
    }



}