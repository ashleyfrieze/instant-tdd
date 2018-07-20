package uk.co.ashleyfrieze.wordcount;

import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    private Set<String> wordsSoFar = new HashSet<>();

    public void add(String sentence) {
        if (sentence.isEmpty()) {
            return;
        }

        for(String word : sentence.trim().split("[., ]+")) {
            wordsSoFar.add(word.toLowerCase());
        }
    }

    public int getUniqueWordsCount() {
        return wordsSoFar.size();
    }
}
