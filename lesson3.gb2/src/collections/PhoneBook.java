package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String, HashSet<Human>> phonebook = new HashMap<>();

    public void add(Human human) {
        String name = human.getName().toLowerCase().trim(); //toLowerCase() - преобразует буквы к нижнему регистру, trim() - удаляет пробелы
        HashSet<Human> people = phonebook.get(name);
        if (people == null) {
            people = new HashSet<>();
            phonebook.put(name, people);
        }
        people.add(human);
    }

    public ArrayList<String> getPhones(String name) {
        String nameToNeed = name.toLowerCase().trim();
        HashSet<Human> people = phonebook.get(nameToNeed);
        ArrayList<String> phones = new ArrayList<>();
        for (Human human : people) {
            phones.addAll(human.getPhone());
        }
        return phones;
    }
}
