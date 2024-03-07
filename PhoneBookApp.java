import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class PhoneBook {
    private HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        // Если запись с именем уже существует, добавляем новый номер в существующий список
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            // Если записи с таким именем нет, создаем новую запись с именем и номером телефона
            ArrayList<Integer> phoneNumList = new ArrayList<>();
            phoneNumList.add(phoneNum);
            phoneBook.put(name, phoneNumList);
        }
    }

    public ArrayList<Integer> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public void showPhoneBook() {
        // Сортируем записи по убыванию числа телефонов
        phoneBook.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

public class PhoneBookApp {
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Alice", 123456);
        myPhoneBook.add("Alice", 789012);
        myPhoneBook.add("Bob", 789012);

        System.out.println("Phone numbers for Alice: " + myPhoneBook.find("Alice"));

        System.out.println("\nPhone book:");
        myPhoneBook.showPhoneBook();
    }
}
