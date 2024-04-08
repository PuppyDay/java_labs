// В следующих заданиях требуется ввести последовательность строк из текстового
// потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
// каждая строка состоит из одного слова;
// каждая строка состоит из нескольких слов.
// Имена входного и выходного файлов, а также абсолютный путь к
// ним могут быть введены как параметры командной строки или храниться в файле.
// Найти в строке наибольшее число цифр, идущих подряд.

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
            String line;

            Pattern pattern = Pattern.compile("\\d+");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                int count = 0;
                while (matcher.find()) {
                    int tempCount = matcher.end() - matcher.start();
                    if (tempCount > count) {
                        count = tempCount;
                    }
                }
                writer.write(count + System.lineSeparator());
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}