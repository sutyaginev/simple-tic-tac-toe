package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static char[][] array = new char[3][3];
    public static boolean isGameFinished = false;
    public static Scanner scanner = new Scanner(System.in);
    public static int counter = 0;

    public static void main(String[] args) {
        // write your code here
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], ' ');
        }
        printGrid(array);

        while (!isGameFinished) {
            makeMove(array);
            counter++;
            printGrid(array);
            isGameFinished = checkGameState(array);
        }
    }

    public static void printGrid(char[][] array) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    public static void makeMove(char[][] array) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String coordinates = scanner.nextLine();
            int y = 0;
            int x = 0;
            char ch;
            if (counter % 2 == 0) {
                ch = 'X';
            } else {
                ch = 'O';
            }

            try {
                y = Integer.parseInt(coordinates.split(" ")[0]);
                x = Integer.parseInt(coordinates.split(" ")[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (array[y - 1][x - 1] == 'X' || array[y - 1][x - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                array[y - 1][x - 1] = ch;
                break;
            }
        }
    }

    public static boolean checkGameState(char[][] array) {
        int line1 = array[0][0] + array[0][1] + array[0][2];
        int line2 = array[1][0] + array[1][1] + array[1][2];
        int line3 = array[2][0] + array[2][1] + array[2][2];
        int line4 = array[0][0] + array[1][0] + array[2][0];
        int line5 = array[0][1] + array[1][1] + array[2][1];
        int line6 = array[0][2] + array[1][2] + array[2][2];
        int line7 = array[0][0] + array[1][1] + array[2][2];
        int line8 = array[0][2] + array[1][1] + array[2][0];

        boolean xLineIsPresent = line1 == 264 || line2 == 264 || line3 == 264 || line4 == 264 ||
                line5 == 264 || line6 == 264 || line7 == 264 || line8 == 264;
        boolean oLineIsPresent = line1 == 237 || line2 == 237 || line3 == 237 || line4 == 237 ||
                line5 == 237 || line6 == 237 || line7 == 237 || line8 == 237;

        if (xLineIsPresent) {
            System.out.println("X wins");
            return true;
        }
        if (oLineIsPresent) {
            System.out.println("O wins");
            return true;
        }
        if (counter == 9) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}