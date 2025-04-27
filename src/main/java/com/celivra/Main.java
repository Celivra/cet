package com.celivra;
import java.util.List;
import java.util.Random;

public class Main {
    static List<Word> words = WordService.getWords();
    static Random random = new Random();
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            getRandomWord();
        }
    }
    public static void getRandomWord(){
        int randomIndex;
        do{
            randomIndex = index();
        } while(words.get(randomIndex) == null);

        Word word = words.get(randomIndex);
        words.set(randomIndex, null);
        System.out.println(word);
    }
    public static int index(){
        random = new Random();
        int result = random.nextInt(words.size());

        return result;
    }
}
