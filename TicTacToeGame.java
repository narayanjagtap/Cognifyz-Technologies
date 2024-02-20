
import java.util.Scanner;

public class TicTacToeGame {

    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = '-';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static char currentPlayer = PLAYER_X;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            initializeBoard();

            System.out.println("Starting a new game...");

            boolean gameFinished = false;
            while (!gameFinished) {
                displayBoard();
                int[] move = getPlayerMove(scanner);
                makeMove(move[0], move[1]);
                gameFinished = checkGameStatus();
                if (gameFinished) {
                    displayBoard();
                    break;
                }
                switchPlayer();
            }

            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing Tic-Tac-Toe!");
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int[] getPlayerMove(Scanner scanner) {
        int[] move = new int[2];
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Player " + currentPlayer + ", enter your move (row column): ");
            move[0] = scanner.nextInt();
            move[1] = scanner.nextInt();
            if (isValidMove(move[0], move[1])) {
                validMove = true;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        return move;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY_CELL;
    }

    private static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private static boolean checkGameStatus() {
        if (checkForWin(PLAYER_X)) {
            System.out.println("Player X wins!");
            return true;
        } else if (checkForWin(PLAYER_O)) {
            System.out.println("Player O wins!");
            return true;
        } else if (isBoardFull()) {
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }

    private static boolean checkForWin(char player) {
        // Check rows and columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
}
