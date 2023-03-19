import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private char[] board = new char[10];
    private char playerLetter;
    private char computerLetter;
    private boolean playerTurn;

    public TicTacToeGame() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        playerTurn = false;
    }

    public void displayBoard() {
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + " ");
    }

    public void showBoard() {
        System.out.println("Current board:");
        displayBoard();
        System.out.println();
    }

    public void chooseLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your letter: X or O");
        playerLetter = scanner.nextLine().toUpperCase().charAt(0);
        while (playerLetter != 'X' && playerLetter != 'O') {
            System.out.println("Invalid input. Choose your letter: X or O");
            playerLetter = scanner.nextLine().toUpperCase().charAt(0);
        }
        if (playerLetter == 'X') {
            computerLetter = 'O';
        } else {
            computerLetter = 'X';
        }
        System.out.println("You chose " + playerLetter + ". Computer will be " + computerLetter + ".");
    }

    public boolean makeMove(int index, char letter) {
        if (index < 1 || index > 9) {
            System.out.println("Invalid input. Choose a number from 1 to 9.");
            return false;
        }
        if (board[index] != ' ') {
            System.out.println("That cell is already occupied. Choose a different cell.");
            return false;
        }
        board[index] = letter;
        return true;
    }

    public void tossCoin() {
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            System.out.println("Heads! You play first.");
            playerTurn = true;
        } else {
            System.out.println("Tails! Computer plays first.");
        }
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.chooseLetter();
        game.showBoard();
        game.tossCoin();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (game.playerTurn) {
                System.out.println("Enter the index to make a move:");
                int index = scanner.nextInt();
                if (game.board[index] != ' ') {
                    System.out.println("That cell is already occupied. Choose a different cell.");
                    continue;
                }
                if (game.makeMove(index, game.playerLetter)) {
                    game.showBoard();
                    game.playerTurn = false;
                }
            } else {
                System.out.println("Computer's turn:");
                // Computer logic here
                game.showBoard();
                game.playerTurn = true;
            }
        }
    }
}