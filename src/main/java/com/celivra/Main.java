package com.celivra;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static List<Word> words = WordService.getWords();
    static Random random = new Random();
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            getRandomWord();
        }
    }
    public static boolean test(Word word){
        Scanner scanner = new Scanner(System.in);
        System.out.println("="+word.getChinese()+"=");
        System.out.println("Enter English word: ");
        String ans= scanner.nextLine();
        if(!ans.equals(word.getEnglish())){
            System.out.println("Wrong English word");
            System.out.println("correct: "+word.getEnglish());
            scanner.nextLine();
            return false;
        }
        return true;

    }
    public static void getRandomWord(){
        int randomIndex;
        do{
            randomIndex = index();
        } while(words.get(randomIndex) == null);

        Word word = words.get(randomIndex);

        if(test(word)) words.set(randomIndex, null);

    }
    public static int index(){
        random = new Random();
        int result = random.nextInt(words.size());

        return result;
    }
}
