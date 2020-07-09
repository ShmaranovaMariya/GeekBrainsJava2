package collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task {
    public static void main(String[] args) {
        String[] words = new String[]{"Класс", "HashSet", "служит", "для", "создания", "коллекции", "содержащей", "только", "уникальные",
                "элементы", "особое", "внимание", "необходимо", "уделить", "словосочетанию", "только", "уникальные", "элементы"};
        System.out.println(taskFirst(words));
        sameWords(words);
    }

    public static ArrayList<String> taskFirst(String[] words) {
        HashSet<String> finishSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            finishSet.add(words[i]);
        }
        return new ArrayList<>(finishSet);
    }

    public static void sameWords(String[] words) {
        HashMap<String, Integer> finish = new HashMap<>();
        for (String word : words) {
            if (!finish.containsKey(word)) {
                finish.put(word, 1);
            } else {
                finish.put(word, finish.get(word) + 1);
            }
        }
        System.out.println(finish);

    }
}