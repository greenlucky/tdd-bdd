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

        int x = 0;
        int y = 0;
        int playerTotal = lastPlayer * (SIZE - 1);
        char diagonal1, diagonal2, horizontal, vertical;
        diagonal1 = diagonal2 = horizontal = vertical = '\0';

        for (int index = 0; index < SIZE; index++) {
            diagonal1 += board[index][index];
            diagonal2 += board[index][SIZE - index - 1];
            horizontal += board[index][currentY - 1];
            vertical += board[currentX - 1][index];
        }

        if(vertical == playerTotal) {
            for(int i = 0; i < SIZE ; i ++) {
                if(board[currentX - 1][i] == '\0') {
                    x = currentX;
                    y = i + 1;
                }
            }
        } else if(horizontal == playerTotal) {
            for(int j = 0; j < SIZE; j++) {
                if(board[j][currentY - 1] == '\0') {
                    x = j + 1;
                    y = currentY;
                }
            }
        } else if(diagonal1 == playerTotal) {
            for (int d1 = 0; d1 < SIZE; d1++) {
                if( board[d1][d1] != '\0') {
                    x = y = d1 + 1;
                }
            }
        } else  if(diagonal2 == playerTotal) {
            for (int d2 = 0; d2 < SIZE; d2++) {
                if( board[d2][SIZE - d2 - 1] != '\0') {
                    x = d2 + 1;
                    y = SIZE - d2;
                }
            }
        } else {
            if((currentX != 2 || currentY != 2) && board[1][1] == '\0')
                x = y = 2;
            else {
                x = y = 3;
            }
        }

        String result = play(x, y);
        if("O is the winner".equals(result) || "The result is draw".equals(result))
            return result;

        return "O play [" + x +", " + y +"]";
    }
}
