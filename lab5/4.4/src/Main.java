// При выполнении следующих заданий для вывода результатов создавать
// новую директорию и файл средствами класса File
// В файле, содержащем фамилии студентов и их оценки, записать
// прописными буквами фамилии тех студентов, которые имеют средний балл более “7”.

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("./output/out.txt");
            file.getParentFile().mkdirs();
            file.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                String name = parts[0].trim();
                String marksStr = parts[1].trim();

                String[] marks = marksStr.split(", ");
                int sum = Arrays.stream(marks).mapToInt(Integer::parseInt).sum();

                if ((float)sum / marks.length > 7) {
                    writer.write(name.toUpperCase() + System.lineSeparator());
                }
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}