package au.bystritskaia;

import au.bystritskaia.notebooks.Notebooks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class Application
{
    private static List<Notebooks> notebooks = List.of(
            new Notebooks("Windows", "red", 2, 2, "Intel"),
            new Notebooks("Windows", "yellow", 2, 2, "Intel"),
            new Notebooks("Windows", "yellow", 2, 2, "AMD"),
            new Notebooks("Linux", "red", 2, 2, "AMD"),
            new Notebooks("Linux", "yellow", 2, 2, "AMD")

    );
    public static void main( String[] args ) throws IOException {
        Map<Integer, String> filters = new HashMap<>();
        System.out.println("""
            Введите характеристики ноутбука для фильтрации
            ,где:
            1 - Операционная система,
            2 - Цвет,
            3 - Объем оперативной памяти в Гб,
            4 - Объем HDD в Тб,
            5 - Процессор.
            Для завершения ввода, введите '.'
        """);
        do {
            System.out.println( "Введите цифру характеристики:");
            String userInput = new BufferedReader(
                    new InputStreamReader(System.in)).readLine().trim();
            if(userInput.equalsIgnoreCase("."))
                break;
            Integer number = Integer.parseInt(userInput);
            System.out.println( "Введите характеристику:");
            String filter = new BufferedReader(
                    new InputStreamReader(System.in)).readLine().trim();
            if(filter.equalsIgnoreCase("."))
                break;
            filters.put(number, filter);
        } while (true);

        notebooks.forEach(notebook -> notebook.setFilters(filters));
        System.out.println(notebooks.parallelStream().filter(Notebooks::match).map(Notebooks::toString).collect(Collectors.joining("\n")));
    }
}
