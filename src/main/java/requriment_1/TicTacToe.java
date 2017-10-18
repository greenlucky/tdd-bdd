package requriment_1;

public class TicTacToe {

    public static final int SIZE = 3;
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer;
    private int currentX;
    private int currentY;

    public String play(int x, int y) {
        currentX = x;
        currentY = y;
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

    public String OPlay() {
        int x = 1;
        int y = 1;
        if((currentX != 2 || currentY != 2) && board[1][1] == '\0')
            x = y = 2;
        else if(board[0][0] == 'X') {
            if ((currentX == 1 && currentY == 1 && board[0][1] == 'X') || (currentX == 1 && currentY == 2)) {
                x = 1;
                y = 3;
            } else if ((currentX == 1 && currentY == 1) || currentX == 2 && currentY == 1) {
                x = 3;
                y = 1;
            }
        } else if(board[1][2] == 'X') {
            if (currentX == 1 && currentY == 2) {
                x = 1;
                y = 1;
            }
        }  else if(board[2][1] == 'X') {
            if (currentX == 2 && currentY == 1) {
                x = 1;
                y = 1;
            }
        }

        play(x, y);
        return "O play [" + x +", " + y +"]";
    }
}
