package com.android.learnapp.database;

public class Word {
    private String word;
    private String translatoin;

    public Word(String word, String translatoin) {
        this.word = word;
        this.translatoin = translatoin;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translatoin;
    }
}
