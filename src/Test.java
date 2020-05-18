import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Test {
    public static void main(String[] args) {
        final String fileName = "liczby.txt";
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                List<Integer> integersList = new ArrayList<>();
                scanner.useDelimiter(";");
                while (scanner.hasNextInt()) {
                    Integer number = scanner.nextInt();
                    integersList.add(number);
                }
                System.out.println(integersList);

                Map<Integer, Integer> numbersMap = new TreeMap<>();
                for (int i = 0; i < integersList.size(); i++) {
                    int key = integersList.get(i);
                    int value = Collections.frequency(integersList, integersList.get(i));
                    numbersMap.put(key, value);
                }

                String result = numbersMap.toString().replaceAll("=", " – liczba wystąpień: ");
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Nieprawidłowe dane w pliku: " + fileName);
        }
    }

}
