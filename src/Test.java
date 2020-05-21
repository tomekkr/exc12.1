import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Test {
    public static void main(String[] args) {
        final String fileName = "liczby.txt";
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            Service.readFileAndPrintInfo(scanner);
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Nieprawidłowe dane w pliku: " + fileName);
        }
    }
}