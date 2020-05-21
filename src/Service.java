import java.util.*;

class Service {
    public static void readFileAndPrintInfo(Scanner scanner) {
        while (scanner.hasNextLine()) {
            List<Integer> integersList = Service.createIntegersList(scanner);
            System.out.println(integersList);
            Map<Integer, Integer> numbersMap = Service.createIntegersMap(integersList);
            Service.getInfo(numbersMap);
        }
    }

    private static List<Integer> createIntegersList(Scanner scanner) {
        List<Integer> integersList = new ArrayList<>();
        scanner.useDelimiter(";");
        while (scanner.hasNextInt()) {
            Integer number = scanner.nextInt();
            integersList.add(number);
        }
        return integersList;
    }

    private static Map<Integer, Integer> createIntegersMap(List<Integer> integersList) {
        Map<Integer, Integer> numbersMap = new TreeMap<>();
        for (int i = 0; i < integersList.size(); i++) {
            int key = integersList.get(i);
            int value = Collections.frequency(integersList, integersList.get(i));
            numbersMap.put(key, value);
        }
        return numbersMap;
    }

    private static void getInfo(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " – liczba wystąpień: " + entry.getValue().toString());
        }
    }
}