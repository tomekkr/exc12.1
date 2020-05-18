import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Test {
    public static void main(String[] args) {
        final String fileName = "liczby.txt";
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<String> elements = List.of(line.split(";"));
                System.out.println(elements);

                List<Integer> integers = new ArrayList<>();
                for (String element : elements) {
                    int number = Integer.parseInt(element);
                    integers.add(number);
                }

                Set<String> resultSet = new TreeSet<>();
                for (int i = 0; i < integers.size(); i++) {
                    resultSet.add(integers.get(i) + " – liczba wystąpień:  " + Collections.frequency(integers, integers.get(i)));
                }
                System.out.println(resultSet);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Nieprawidłowe dane w pliku: " + fileName);
        }
    }
}
