// Выполнить задания на основе варианта 1 лабораторной работы 3,
// контролируя состояние потоков ввода/вывода.
// При возникновении ошибок, связанных с корректностью выполнения математических операций,
// генерировать и обрабатывать исключительные ситуации. Предусмотреть обработку исключений,
// возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле,
// недопустимом значении поля и т.д.

// Определить класс Матрица размерности (m x n). Класс должен содержать несколько конструкторов.
// Объявить массив объектов. Передать объекты в метод, меняющий местами строки с максимальным и
// минимальным элементами k-го столбца. Создать метод, который изменяет i-ю матрицу путем возведения
// ее в квадрат.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int m, n, count;

        try {
            System.out.println("Укажите количество строк в матрицах:");
            m = sc.nextInt();

            System.out.println("Укажите количество столбцов в матрицах:");
            n = sc.nextInt();

            System.out.println("Укажите количество матриц:");
            count = sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число");
            return;
        }

        Matrix[] array = new Matrix[count];

        for (int i = 0; i < count; i++) {
            array[i] = new Matrix(m, n);
            System.out.println("Получившаяся матрица " + i + ":\n" + array[i]);
        }

        System.out.println("Укажите относительно какого столбца менять строки:");
        int k;
        try {
            k = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число");
            return;
        }
        if (k > n - 1) {
            throw new Exception("Данного столбца не существует.");
        }
        array = swapRowsInMatrix(array, k);
        System.out.println("Объекты с поменяными местами строками с максимальным и минимальным элементами " + k + "-го столбца:");
        printArray(array);

        System.out.println("Укажите какую матрицу надо возвести в квадрат:");
        int i;
        try {
            i = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число");
            return;
        }
        if (i > count - 1) {
            throw new Exception("Данной матрицы не существует.");
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