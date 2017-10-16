package requriment_1;

public class TicTacToe {

    public static final int SIZE = 3;
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer;

    public String play(int x, int y) {

        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y);

        if (isWin(x, y))
            return lastPlayer + " is the winner";
        else if(isDraw()) {
            return "The result is draw";
        }
        return "No winner";
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE ; x++) {
            for (int y = 0; y < SIZE ; y++) {
                if(board[x][y]=='\0')
                    return false;
            }
        }
        return true;
    }

    public boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * SIZE;
        char diagonal1, diagonal2, horizontal, vertical;
        diagonal1 = diagonal2 = horizontal = vertical = '\0';

        for (int index = 0; index < SIZE; index++) {
            diagonal1 += board[index][index];
            diagonal2 += board[index][SIZE - index - 1];
            horizontal += board[index][y - 1];
            vertical += board[x - 1][index];
        }

        if (horizontal == playerTotal
                || vertical == playerTotal
                || diagonal1 == playerTotal
                || diagonal2 == playerTotal) {
            return true;
        }

        return false;
    }

    public void checkAxis(int axis) {
        if (axis < 1 || axis > 3)
            throw new RuntimeException("X is outside board");
    }

    public void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied!");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X')
            return 'O';
        return 'X';
    }
}
