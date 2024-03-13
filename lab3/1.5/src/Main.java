// Определить класс Матрица размерности (m x n). Класс должен содержать несколько конструкторов.
// Объявить массив объектов. Передать объекты в метод, меняющий местами строки с максимальным и
// минимальным элементами k-го столбца. Создать метод, который изменяет i-ю матрицу путем возведения
// ее в квадрат.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Укажите количество строк в матрицах:");
        int m = sc.nextInt();

        System.out.println("Укажите количество столбцов в матрицах:");
        int n = sc.nextInt();

        System.out.println("Укажите количество матриц:");
        int count = sc.nextInt();

        Matrix[] array = new Matrix[count];

        for (int i = 0; i < count; i++) {
            array[i] = new Matrix(m, n);
            System.out.println("Получившаяся матрица " + i + ":\n" + array[i]);
        }

        System.out.println("Укажите относительно какого столбца менять строки:");
        int k = sc.nextInt();
        if (k > n - 1) {
            System.out.println("Данного столбца не существует.");
            return;
        }
        array = swapRowsInMatrix(array, k);
        System.out.println("Объекты с поменяными местами строками с максимальным и минимальным элементами " + k + "-го столбца:");
        printArray(array);

        System.out.println("Укажите какую матрицу надо возвести в квадрат:");
        int i = sc.nextInt();
        if (i > count - 1) {
            System.out.println("Данной матрицы не существует.");
            return;
        }

        try {
            array = squaringCertainMatrix(array, i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Объекты с возведенной в квадрат " + i + " матрицей:");
        printArray(array);
    }

    public static Matrix[] swapRowsInMatrix(Matrix[] array, int k) {
        Matrix[] result = new Matrix[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].swapRowsInMatrix(k);
        }
        return result;
    }

    public static Matrix[] squaringCertainMatrix(Matrix[] array, int i) throws Exception {
        Matrix[] result = new Matrix[array.length];
        for (int j = 0; j < array.length; j++) {
            if (j == i) {
                result[j] = array[j].squaring();
                continue;
            }
            result[j] = array[j];
        }

        return result;
    }

    public static void printArray(Matrix[] array) {
        for (Matrix matrix: array){
            System.out.println(matrix);
        }
    }
}

