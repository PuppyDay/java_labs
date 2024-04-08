// Во входном файле хранятся наименования некоторых объектов.
// Построить список C1, элементы которого содержат наименования и шифры данных объектов,
// причем элементы списка должны быть упорядочены по возрастанию шифров. Затем “сжать” список C1,
// удаляя дублирующие наименования объектов.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    record Node(String name, int code) {
        public Node(String name) {
            this(name, name.hashCode());
        }

        public int getCode() {
            return this.code;
        }
    }

    public static void main(String[] args) {
        List<Node> list = new LinkedList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input_file.txt"));
            String line = reader.readLine();

            while (line != null) {
                list.add(new Node(line));
                line = reader.readLine();
            }

            list.sort((n1, n2) -> n2.getCode() - n1.getCode());

            System.out.println("Исходный отсортированный список:");
            System.out.println(list);
            System.out.println("Исходное количество элементов:");
            System.out.println(list.size());

            list = removeDuplicates(list);

            System.out.println("Итоговый список без дубликатов:");
            System.out.println(list);
            System.out.println("Мтоговое количество элементов:");
            System.out.println(list.size());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Node> removeDuplicates(List<Node> list) {
        List<Node> result = new LinkedList<>();
        Set<String> names = new HashSet<>();
        for(Node node: list) {
            if (names.contains(node.name)) {
                continue;
            }
            names.add(node.name);
            result.add(node);
        }
        return result;
    }
}