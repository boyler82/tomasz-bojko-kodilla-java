package com.kodilla.stream.mirror;

import java.util.ArrayList;
import java.util.List;

public class MirrorString {
    private final String word;
    private final List<String> wordList = new ArrayList<>();

    public MirrorString(String word) {
        this.word = word;
    }
    public void addWord(String word) {
        wordList.add(word);
    }

    public String getWord() {
        return word;
    }

    public List<String> getWordList() {
        return wordList;
    }

}
