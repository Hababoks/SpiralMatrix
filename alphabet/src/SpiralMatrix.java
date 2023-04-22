public class SpiralMatrix {
    //Создайте двумерный массив и заполните его буквами русского алфавита.
    // (по желанию) Пусть в двумерном массиве N элементов.
    // Заполните двумерный массив целыми числами от 1 до N по спирали.
    public static void main(String[] args) {
        int N = 4; // Матрица N x N т.е.4x4
        char[][] alphabetMatrix = new char[N][N]; // Создаем двумерный массив для хранения букв

        // Заполняем двумерный массив буквами
        char letter = 'А';
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                alphabetMatrix[i][j] = letter;
                letter++;
            }
        }

        // Заполняем двумерный массив числами от 1 до N x N по спирали
        int[][] spiralMatrix = new int[N][N];
        int value = 1;
        int rowStart = 0;
        int rowEnd = N - 1;
        int colStart = 0;
        int colEnd = N - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Заполняем верхнюю строку слева направо
            for (int i = colStart; i <= colEnd; i++) {
                spiralMatrix[rowStart][i] = value++;
            }
            rowStart++;

            // Заполняем правый столбец сверху вниз
            for (int i = rowStart; i <= rowEnd; i++) {
                spiralMatrix[i][colEnd] = value++;
            }
            colEnd--;

            // Заполняем нижнюю строку справа налево
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    spiralMatrix[rowEnd][i] = value++;
                }
                rowEnd--;
            }

            // Заполняем левый столбец снизу вверх
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    spiralMatrix[i][colStart] = value++;
                }
                colStart++;
            }
        }

        // Вывод матрицы с буквами
        System.out.println("Матрица с буквами русского алфавита:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(alphabetMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Вывод матрицы со значениями от 1 до N x N по спирали
        System.out.println("\nМатрица со значениями от 1 до N x N по спирали:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%02d ", spiralMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
