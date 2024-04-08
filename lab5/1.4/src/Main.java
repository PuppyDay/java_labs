// Выполнить задания на основе варианта 1 лабораторной работы 3,
// контролируя состояние потоков ввода/вывода.
// При возникновении ошибок, связанных с корректностью выполнения математических операций,
// генерировать и обрабатывать исключительные ситуации. Предусмотреть обработку исключений,
// возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле,
// недопустимом значении поля и т.д.

// Определить класс Матрица размерности (n x n). Класс должен содержать несколько конструкторов.
// Реализовать методы для сложения, вычитания, умножения матриц. Объявить массив объектов.
// Создать методы, вычисляющие первую и вторую нормы матрицы.
// Определить, какая из матриц имеет наименьшую первую и вторую нормы.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Укажите размер матриц:");
        int size = 0;

        try {
            size = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число");
            return;
        }

        System.out.println("Укажите количество матриц:");
        int count = 0;

        try {
            count = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число");
            return;
        }

        Matrix[] array = new Matrix[count];

        for (int i = 0; i < count; i++) {
            array[i] = new Matrix(size);
            System.out.println("Получившаяся матрица " + i + ":\n" + array[i]);
        }

        System.out.println("1 и 2 нормы матриц:");
        int min1Norm = array[0].norm1(), min2Norm = array[0].norm2();
        int min1NormIndex = 0, min2NormIndex = 0;

        for(int i = 0; i < count; i++) {
            int norm1 = array[i].norm1(), norm2 = array[i].norm2();
            System.out.println(i + " матрица: 1 норма = " + norm1 + ", 2 норма = " + norm2);

            if (norm1 < min1Norm) {
                min1Norm = norm1;
                min1NormIndex = i;
            }

            if (norm2 < min2Norm) {
                min2Norm = norm2;
                min2NormIndex = i;
            }
        }
        System.out.println("\nНаименьшую 1 норму имеет матрица " + min1NormIndex + ":\n" + array[min1NormIndex]);
        System.out.println("Наименьшую 2 норму имеет матрица " + min2NormIndex + ":\n" + array[min2NormIndex]);

        try {
            System.out.println("Сложение первых двух матриц:\n" + array[0].add(array[1]));
            System.out.println("Вычитание первых двух матриц:\n" + array[0].sub(array[1]));
            System.out.println("Умножение первых двух матриц:\n" + array[0].mul(array[1]));
        } catch (MatrixException e) {
            System.out.println("Возникла ошибка: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Указано меньше чем 2 матрицы");
        }
    }
}