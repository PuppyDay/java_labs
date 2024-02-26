// Ввести с консоли n – размерность матрицы a[n][n].
// Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
// Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.

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

        int max = 0, current = 0;
        int prev = arr[0][0] - 1;

        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if (prev < arr[i][j]) {
                    current++;
                    prev = arr[i][j];

                    if (current > max) {
                        max = current;
                    }

                    continue;
                }

                current = 1;
                prev = arr[i][j];
            }

        }

        System.out.println("Наибольшее число возрастающих элементов матрицы, идущих подряд: " + max);

        sc.close();
    }
}