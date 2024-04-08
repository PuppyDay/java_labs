// При выполнении следующих заданий для вывода результатов создавать
// новую директорию и файл средствами класса File
// Файл содержит символы, слова, целые числа и числа с плавающей запятой.
// Определить все данные, тип которых вводится из командной строки.

import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String type = args[0];

        try {
            File file = new File("./output/out.txt");
            file.getParentFile().mkdirs();
            file.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line = reader.readLine();
            String[] elements = line.split(" ");

            StringBuilder result = new StringBuilder();

            for (String el: elements) {
                if (el.matches("[-+]?\\d+")) {
                    if (Objects.equals(type, "int")) {result.append(el).append(" ");}
                } else if (el.matches("[-+]?[0-9]+\\.[0-9]+")) {
                    if (Objects.equals(type, "float")) {result.append(el).append(" ");}
                } else if (el.length() == 1) {
                    if (Objects.equals(type, "char")) {result.append(el).append(" ");}
                } else if (Objects.equals(type, "string")) {
                    result.append(el).append(" ");
                }
            }

            writer.write(String.valueOf(result));

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}