import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    private static final int SIZE = 8;
    private static int[][] colors = new int[SIZE][SIZE];

    @BeforeEach
    void setUp() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = i + j;
                //System.out.print(i+j);
            }
            System.out.println();
        }
    }

    @Test
    void rotatedColors90Test() {
        int[][] extendsRotatedColors = new int [SIZE][SIZE];
        int y = 0;
        for (int i = 0; i < SIZE; i++) {
            int x = 1;
            for (int j = 0; j < SIZE; j++) {
                extendsRotatedColors[i][j] = colors[SIZE - x][y];
                x++;
            }
            y++;
        }

        int[][] rotatedColors = Main.rotatedColors90(colors);

        Assertions.assertEquals(extendsRotatedColors[0][7], rotatedColors[0][7]);
        Assertions.assertEquals(extendsRotatedColors[3][3], rotatedColors[3][3]);
        Assertions.assertEquals(extendsRotatedColors[5][5], rotatedColors[5][5]);
    }

    @Test
    void rotatedColors180Test() {
        int[][] extendsRotatedColors90 = new int [SIZE][SIZE];
        int[][] extendsRotatedColors180 = new int [SIZE][SIZE];
        int y = 0;
        for (int i = 0; i < SIZE; i++) {
            int x = 1;
            for (int j = 0; j < SIZE; j++) {
                extendsRotatedColors90[i][j] = colors[SIZE - x][y];
                x++;
            }
            y++;
        }

        y = 0;
        for (int i = 0; i < SIZE; i++) {
            int x = 1;
            for (int j = 0; j < SIZE; j++) {
                extendsRotatedColors180[i][j] = extendsRotatedColors90[SIZE - x][y];
                x++;
            }
            y++;
        }


        int[][] rotatedColors = Main.rotatedColors180(colors);

        Assertions.assertEquals(extendsRotatedColors180[0][7], rotatedColors[0][7]);
        Assertions.assertEquals(extendsRotatedColors180[2][3], rotatedColors[2][3]);
        Assertions.assertEquals(extendsRotatedColors180[7][2], rotatedColors[7][2]);
    }

    @Test
    void rotatedColors270() {
        int[][] extendsRotatedColors270 = Main.rotatedColors90(Main.rotatedColors90(Main.rotatedColors90(colors)));
        int[][] rotatedColors = Main.rotatedColors270(colors);

        Assertions.assertEquals(extendsRotatedColors270[0][7], rotatedColors[0][7]);
        Assertions.assertEquals(extendsRotatedColors270[0][0], rotatedColors[0][0]);
        Assertions.assertEquals(extendsRotatedColors270[5][5], rotatedColors[5][5]);
    }
}