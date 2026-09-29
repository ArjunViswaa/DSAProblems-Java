package basics;

import java.util.HashMap;

public class WordCount {
    public static void main(String[] args) {
        wordsCount("the cat and the dog and the bird");
    }

    public static void wordsCount(String sentence) {
        HashMap<String, Integer> hm = new HashMap<>();
//        String[] words = sentence.split(" ");

        String[] words = sentence.split("\\s+"); // Regex for eliminating any amount of wordspaces between

//        for(int i=0; i<words.length; i++) {
//            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
//        }

        // Enhanced for loop for segregation
        for(String word: words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        System.out.println(hm);
    }
}
