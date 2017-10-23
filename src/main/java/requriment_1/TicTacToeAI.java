package requriment_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicTacToeAI {

    public boolean winning(String[] board, String player) {
        if((board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
                || (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player)
                || (board[0] == player && board[4] == player && board[8] == player)
                || (board[2] == player && board[4] == player && board[6] == player))
            return true;
        return false;
    }

    public int[] emptyIndexies(String[] board) {
       return IntStream.range(0, board.length)
               .filter(i -> board[i] != "O" && board[i] != "X")
               .toArray();
    }

    private String huPlayer = "O";
    private String aiPlayer = "X";

    public int minimax(String[] newBoard, String player) {
        int[] availSpot = emptyIndexies(newBoard);
        if(winning(newBoard, aiPlayer))
            return 10;
        else if(winning(newBoard, huPlayer))
            return - 10;
        else if(newBoard.length == 0)
            return 0;

        int[] moveScope = new int[availSpot.length];
        int[] moveIndex = new int[availSpot.length];

        for(int i = 0; i < availSpot.length; i++) {

            newBoard[availSpot[i]] = player;

            if(player == aiPlayer) {
                moveScope[i] = minimax(newBoard, huPlayer);
            } else {
                moveScope[i] = minimax(newBoard, huPlayer);
            }

        }

        int bestMove = 0;
        if(player == aiPlayer) {
            int bestScore = -10000;
            for(int i = 0; i < moveScope.length; i++) {
                if(moveScope[i] > bestScore) {
                    bestMove = i;
                }
            }
        }


        return moveIndex[bestMove];
    }
}
