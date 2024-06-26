import java.util.Random;

public class Matrix {
    private final int[][] data;
    private final int size;

    public Matrix(int[][] data) {
        this.data = data;
        this.size = data.length;
    }

    public Matrix(int size) {
        this.size = size;
        this.data = new int[size][size];

        Random r = new Random();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.data[i][j]=r.nextInt() % 100;
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for(int[] arr: this.data) {
            for (int el : arr) {
                result.append(el).append("\t");
            }
            result.append("\n");
        }
        return String.valueOf(result);
    }

    public int[][] getData(){
        return this.data;
    }

    private void checkSize(int[][] matrix) throws MatrixException {
        if (this.size != matrix.length) {
            throw new MatrixException("Матрицы должны иметь одинаковую размерность");
        }
    }

    public Matrix add(Matrix matrix) throws MatrixException {
        this.checkSize(matrix.getData());

        int[][] result = new int[this.size][this.size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                result[i][j] = this.data[i][j] + matrix.getData()[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix sub(Matrix matrix) throws MatrixException {
        this.checkSize(matrix.getData());

        int[][] result = new int[this.size][this.size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                result[i][j] = this.data[i][j] - matrix.getData()[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix mul(Matrix matrix) throws MatrixException {
        this.checkSize(matrix.getData());

        int[][] result = new int[this.size][this.size];

        for(int l = 0; l < size; l++) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    result[l][i] += this.data[l][j] * matrix.getData()[j][i];
                }
            }
        }

        return new Matrix(result);
    }

    public int norm1() {
        Integer max_sum = null;

        for(int[] arr: this.data) {
            int sum = 0;
            for(int el: arr) {
                sum += Math.abs(el);
            }

            if ((max_sum == null) || (sum > max_sum)) {
                max_sum = sum;
            }
        }

        return max_sum;
    }

    public int norm2() {
        Integer max_sum = null;

        for(int i = 0; i < size; i++) {
            int sum = 0;
            for(int j = 0; j < size; j++) {
                sum += Math.abs(this.data[j][i]);
            }

            if ((max_sum == null) || (sum > max_sum)) {
                max_sum = sum;
            }
        }

        return max_sum;
    }
}

class MatrixException extends Exception {
    public MatrixException(String message) {
        super(message);
    }
}