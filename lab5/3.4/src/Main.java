// В следующих заданиях требуется ввести последовательность строк из текстового потока
// и выполнить указанные действия. При этом могут рассматриваться два варианта:
//каждая строка состоит из одного слова;
//каждая строка состоит из нескольких слов.
//Имена входного и выходного файлов, а также абсолютный путь к ним могут быть
// введены как параметры командной строки или храниться в файле.
// Найти и вывести слова текста, для которых последняя буква одного слова
// совпадает с первой буквой следующего слова.

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                String previosWord = " ";
                for (String word: words) {
                    String tempStr = word.replaceAll("[.,?!:;]+$", "");
                    if (previosWord.substring(previosWord.length() - 1).equals(tempStr.substring(0, 1))) {
                        writer.write(previosWord + " " + tempStr + System.lineSeparator());
                    }
                    previosWord = tempStr;
                }
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}