package ticTacToe;

import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    // Task 1: Create an array with three rows of '_' characters.

    char[][] ticTacToeBoard = new char[3][3];
    for (int i = 0; i < ticTacToeBoard.length; ++i) {
      for (int j = 0; j < ticTacToeBoard[i].length; ++j) {
        ticTacToeBoard[i][j] = '_';
      }
    }

    // Task 2: Call the function printBoard();
    printBoard(ticTacToeBoard);

    /*
     * Task 3 - Loop through the turns
     */

    /*
     * if (X) turn {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value.
     * } else {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value. Then, print it.
     * }
     */

    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("Turn: X");
        int[] spot = askUser(ticTacToeBoard);
        ticTacToeBoard[spot[0]][spot[1]] = 'X';
      } else {
        System.out.println("Turn: O");
        int[] spot = askUser(ticTacToeBoard);
        ticTacToeBoard[spot[0]][spot[1]] = 'O';
      }
      printBoard(ticTacToeBoard);

      int count = checkWin(ticTacToeBoard);
      if (count == 3) {
        System.out.println("X wins!!!");
      } else if (count == -3) {
        System.out.println("O wins!!!");
      } else if (i == 8) {
        System.out.println("Its a TIE!!!");
      }

    }

    /*
     * 
     * Task 6 - Call the function.
     * if return value == 3 {
     * print: X wins and break the loop
     * } else if return value == -3 {
     * print: O wins and break the loop
     * }
     * 
     * }
     */

    scan.close();
  }

  /**
   * Task 2 - Write a function that prints the board.
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   *              Inside the function:
   *              1. print a new line.
   *              2. print the board.
   *              • separate each row by two lines.
   *              • each row precedes a tab of space
   *              • each character in the grid has one space from the other
   *              character
   */
  public static void printBoard(char[][] board) {
    for (int i = 0; i < board.length; ++i) {
      System.out.print("\n");
      for (int j = 0; j < board[i].length; ++j) {
        System.out.print("\t" + board[i][j]);
      }
    }
    System.out.print("\n\n");
  }

  /**
   * Task 4 - Write a function that lets the user choose a spot
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */
  public static int[] askUser(char[][] board) {
    System.out.print(" - pick a row and a column number:  ");
    int row = scan.nextInt();
    int column = scan.nextInt();
    while (board[row][column] == 'X' || board[row][column] == 'O') {
      System.out.print("Spot taken, try again: ");
      row = scan.nextInt();
      column = scan.nextInt();
    }
    return new int[] { row, column };
  }

  /**
   * Task 6 - Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */

  public static int checkWin(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          count++;
        } else if (board[i][j] == 'O') {
          count--;
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] == 'X') {
          count++;
        } else if (board[j][i] == 'O') {
          count--;
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (board[i][i] == 'X') {
        count++;
      } else if (board[i][i] == 'O') {
        count--;
      }
    }

    if (count == 3 || count == -3) {
      return count;
    } else {
      count = 0;
    }

    for (int i = 0; i < 3; i++) {
      int rowIndex = 2 - i;
      if (board[rowIndex][i] == 'X') {
        count++;
      } else if (board[rowIndex][i] == 'O') {
        count--;
      }
    }

    if (count == 3 || count == -3) {
      return count;
    } else {
      count = 0;
    }

    return count;
  }

}
