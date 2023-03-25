import java.util.Arrays;
import java.util.Scanner;

public class SimpleTicTacToe {

    public static void printField(char[][] field) {
        System.out.println("---------");
        for(int i = 0; i < field.length; i++) {
            System.out.printf("| %c %c %c |%n", field[i][0], field[i][1], field[i][2]);
        }
        System.out.println("---------");
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        char[][] field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(field[i], ' ');
        }
        int xs = 0;
        int os = 0;
        boolean isGameContinue = true;
        boolean isXMove = true;
        boolean xxx = false;
        boolean ooo = false;

        printField(field);

        while (isGameContinue) {
            //ввод координат, обработка и запись хода в поле
            while (true) {
                String[] input = scanner.nextLine().split(" ");
                if (input[0].matches("\\d+") && input[1].matches("\\d+")) {
                    int x1 = Integer.parseInt(input[0]);
                    int x2 = Integer.parseInt(input[1]);

                    if (x1 < 1 || x1> 3 || x2 < 1 || x2 > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (field[x1 - 1][x2 - 1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (isXMove) {
                            field[x1 - 1][x2 - 1] = 'X';
                            isXMove = false;
                        } else {
                            field[x1 - 1][x2 - 1] = 'O';
                            isXMove = true;
                        }
                        break;
                    }
                } else {
                    System.out.println("You should enter numbers!");
                }
            }

            //вывод поля на экран
            printField(field);

            //проверка состояния
            for (int i = 0; i < 3; i++) {
                int row = 0;
                int column = 0;
                int diag1 = 0;
                int diag2 = 0;

                for (int j = 0; j < 3; j++) {
                    row += field[i][j];
                    column += field[j][i];
                    diag1 += field[j][j];
                    diag2 += field[j][2 - j];
                }

                xxx = xxx || row == 264 || column == 264 || diag1 == 264 || diag2 == 264;
                ooo = ooo || row == 237 || column == 237 || diag1 == 237 || diag2 == 237;
            }

            if (xxx) {
                System.out.println("X wins");
                isGameContinue = false;
            } else if (ooo) {
                System.out.println("O wins");
                isGameContinue = false;
            } else if (xs + os == 9) {
                System.out.println("Draw");
                isGameContinue = false;
            }
        }
    }
}