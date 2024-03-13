// Определить класс Матрица размерности (n x n). Класс должен содержать несколько конструкторов.
// Реализовать методы для сложения, вычитания, умножения матриц. Объявить массив объектов.
// Создать методы, вычисляющие первую и вторую нормы матрицы.
// Определить, какая из матриц имеет наименьшую первую и вторую нормы.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Укажите размер матриц:");
        int size = sc.nextInt();

        System.out.println("Укажите количество матриц:");
        int count = sc.nextInt();

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
    }
}

