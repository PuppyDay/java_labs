// Ввести с консоли n – размерность матрицы a[n][n].
// Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
// Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите размерность матрицы");

        int size = 0;
        if (sc.hasNextInt()) {
            size = sc.nextInt();
        }

        sc.nextLine();

        int[][] arr = new int[size][size];
        Random r = new Random();

        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                arr[i][j]=r.nextInt(2*size+1) - size;
                System.out.print(arr[i][j]+"\t");
            }

            System.out.print("\n");
        }

        for(int i = 0; i < size; i++)
        {
            int sum = 0;
            boolean key = false;

            for(int j = 0; j < size; j++)
            {
                if (arr[i][j] > 0) {
                    if (key) {
                        System.out.println("Для строки " + i + " сумма равна " + sum);
                        break;
                    }

                    key = true;
                    continue;
                }

                if (key) {
                    sum += arr[i][j];
                }
            }
        }

        sc.close();
    }
}