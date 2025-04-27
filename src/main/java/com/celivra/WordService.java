package com.celivra;

import java.util.List;

public class WordService {
    static WordDAO wordDAO = new WordDAO();

    public static boolean insertWord(Word word) {
        return wordDAO.insertWord(word);
    }
    public static List<Word> getWords() {
        return wordDAO.getAllWords();
    }
}