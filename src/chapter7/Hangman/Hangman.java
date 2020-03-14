package chapter7.Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static String pickWord(String[] words){
        int wordIndex = new Random().nextInt(words.length);
        return words[wordIndex];
    }
    public static void displayWord(String word, boolean[] guessed) {
        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) {
                System.out.print(word.charAt(i));
            }
            else {
                System.out.print("*");
            }
        }
    }
    public static boolean checkGuess(String word, boolean[] guessed, char guess) {
        boolean correct = false;
        if (!Character.isLetter(guess)) {
            System.out.println("You have to enter a letter!");
            return true;
        }
        else if (Character.isUpperCase(guess)) {
            Character.toLowerCase(guess);
        }
        int index = word.indexOf(guess);
        if (index < 0) {
            System.out.println(guess + " is not in the word");
            correct = false;
        }
        else if (guessed[index]) {
            System.out.println(guess + " is already in the word");
            correct = true;
        }
        else {
             while (index >= 0) {
                 guessed[index] = true;
                 index = word.indexOf(guess, index + 1);
                 correct = true;
             }
        }
        return correct;
    }
    public static boolean checkWordStatus(boolean[] guessed) {
        boolean status = true;
        for (boolean letter: guessed) {
            if (!letter) {
                status = false;
                break;
            }
        }
        return status;
    }
    public static boolean playAnotherGame(Scanner input) {
        char inputLetter = Character.toLowerCase(input.next().charAt(0));
            while (inputLetter != 'y' && inputLetter != 'n') {
                System.out.print("Enter y or n> ");
                inputLetter = Character.toLowerCase(input.next().charAt(0));
            }
        return (inputLetter == 'y' ? true : false);
    }
    public static void main(String[] args) {
        final String[] words = {
            "telefon",
            "komputer",
            "rewolwer",
            "autostrada",
            "programowanie",
            "huragan",
            "kompresja",
            "kasztan",
            "helikopter",
            "kamper",
            "butelka",
            "kaskader",
            "laptop",
            "komputer",
            "myszka",
            "telefon",
            "pilot",
            "koniunkcja",
            "operator",
            "stolik",
            "wyrewolwerowany",
            "pastuch",
            "owca",
            "paluszki",
            "krakersy",
            "serwis",
            "mieszkanie",
            "balon",
            "obiad",
            "karygodny",
            "krokodyl",
            "autostrada",
            "policja",
            "konfident",
            "bachor",
            "kataklizm",
            "wariatka",
            "kontakt"
        };
        Scanner input = new Scanner(System.in);
        boolean playGame = true;
        while (playGame) {
            playGame = false;
            int misses = 0;
            String word = pickWord(words);
            boolean[] guessed = new boolean[word.length()];
            while (!checkWordStatus(guessed)) {
                System.out.print("(Guess) Enter a letter in word ");
                displayWord(word, guessed);
                System.out.print(" > ");
                char guess = input.next().charAt(0);
                if(!checkGuess(word, guessed, guess)) {
                    misses++;
                }
            }
            System.out.println("The word is " + word + ". You missed "
                                + misses + (misses > 1 ? " times" : " time"));
            System.out.print("Do you want to guess another word? Enter y or n> ");
            
            playGame = playAnotherGame(input);
        }
        input.close();
    }    
}