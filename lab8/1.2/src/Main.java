// Реализовать многопоточное приложение “Робот”. Надо написать робота, который умеет ходить.
// За движение каждой его ноги отвечает отдельный поток.
// Шаг выражается в выводе в консоль LEFT или RIGHT.

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Робот идет гулять:");
        Robot.go();
    }
}
