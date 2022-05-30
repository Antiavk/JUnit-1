import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static int[][] colors = new int [SIZE][SIZE];

    public static void menu() {

        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Вывести массив и после повернуть на 90 градусов");
        System.out.println("2. Вывести массив и после повернуть на 180 градусов");
        System.out.println("3. Вывести массив и после повернуть на 270 градусов");
        System.out.println("4. Выход");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        while (true) {
            menu();
            String input = scanner.nextLine();
            if ("4".equals(input))
            {
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Поворот массива на 90 градусов");
                        rotatedColors90(colors);
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Поворот массива на 180 градусов");
                        rotatedColors180(colors);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Поворот массива на 270 градусов");
                        rotatedColors270(colors);
                        System.out.println();
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }
            }
            System.out.println("Программа завершена!");
        }
    }

    public static int[][] rotatedColors(int[][] colors) {
        int[][] rotatedColors = new int [SIZE][SIZE];
        int y = 0;
        for (int i = 0; i < SIZE; i++) {
            int x = 1;
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[i][j] = colors[SIZE - x][y];
                x++;
            }
            y++;
        }
        return rotatedColors;
    }


    public static int[][] rotatedColors90(int[][] colors) {
        int[][] rotatedColors;
        rotatedColors = rotatedColors(colors);
        arrayPrint(colors);
        System.out.println();
        arrayPrint(rotatedColors);
        return rotatedColors;
    }

    public static int[][] rotatedColors180(int[][] colors) {
        int[][] rotatedColors;
        rotatedColors = rotatedColors(rotatedColors(colors));
        arrayPrint(colors);
        System.out.println();
        arrayPrint(rotatedColors);
        return rotatedColors;
    }

    public static int[][] rotatedColors270(int[][] colors) {
        int[][] rotatedColors;
        rotatedColors = rotatedColors(rotatedColors(rotatedColors(colors)));
        arrayPrint(colors);
        System.out.println();
        arrayPrint(rotatedColors);
        return rotatedColors;
    }


    public static void arrayPrint(int[][] rotatedColors) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", rotatedColors[i][j]);
            }
            System.out.println();
        }
    }
}