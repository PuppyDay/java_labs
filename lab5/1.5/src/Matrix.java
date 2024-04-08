import java.util.Random;
public class Matrix {
    private final int[][] data;
    private final int m;
    private final int n;

    public Matrix(int[][] data) {
        this.data = data;
        this.m = data.length;
        this.n = data[0].length;
    }

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.data = new int[m][n];

        Random r = new Random();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                this.data[i][j]=r.nextInt() % 100;
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for(int[] arr: this.data) {
            for (int el : arr) {
                result.append(el).append("\t\t");
            }
            result.append("\n");
        }
        return String.valueOf(result);
    }

    public Matrix squaring() throws Exception {
        if (this.m != this.n) {
            throw new Exception("Возводить в квадрат можно только квадратные матрицы.");
        }

        int[][] result = new int[this.m][this.n];

        for(int l = 0; l < m; l++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    result[l][i] += this.data[l][j] * this.data[j][i];
                }
            }
        }

        return new Matrix(result);
    }

    public Matrix swapRowsInMatrix(int k) {
        int[][] result = new int[this.m][this.n];
        int min = this.data[0][k], max = this.data[0][k];
        int indexMin = 0, indexMax = 0;

        for (int i = 0; i < this.m; i++){
            if (this.data[i][k] < min) {
                min = this.data[i][k];
                indexMin = i;
            }

            if (this.data[i][k] > max) {
                max = this.data[i][k];
                indexMax = i;
            }
        }

        for (int i = 0; i < this.m; i++){
            for (int j = 0; j < this.n; j++) {
                if (i == indexMin) {
                    result[i][j] = this.data[indexMax][j];
                    continue;
                }

                if (i == indexMax) {
                    result[i][j] = this.data[indexMin][j];
                    continue;
                }

                result[i][j] = this.data[i][j];
            }
        }
        return new Matrix(result);
    }
}
