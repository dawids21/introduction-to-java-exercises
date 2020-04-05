package chapter7.Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static String pickWord(ArrayList<String> words) {
        int wordIndex = new Random().nextInt(words.size());
        return words.get(wordIndex);
    }

    private static void displayWord(String word, boolean[] guessed) {
        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("*");
            }
        }
    }

    private static boolean checkGuess(String word, boolean[] guessed, char guess) {
        boolean correct = false;
        if (!Character.isLetter(guess)) {
            System.out.println("You have to enter a letter!");
            return true;
        } else if (Character.isUpperCase(guess)) {
            Character.toLowerCase(guess);
        }
        int index = word.indexOf(guess);
        if (index < 0) {
            System.out.println(guess + " is not in the word");
            correct = false;
        } else if (guessed[index]) {
            System.out.println(guess + " is already in the word");
            correct = true;
        } else {
            while (index >= 0) {
                guessed[index] = true;
                index = word.indexOf(guess, index + 1);
                correct = true;
            }
        }
        return correct;
    }

    private static boolean checkWordStatus(boolean[] guessed) {
        boolean status = true;
        for (boolean letter : guessed) {
            if (!letter) {
                status = false;
                break;
            }
        }
        return status;
    }

    private static boolean playAnotherGame(Scanner input) {
        char inputLetter = Character.toLowerCase(input.next().charAt(0));
        while (inputLetter != 'y' && inputLetter != 'n') {
            System.out.print("Enter y or n> ");
            inputLetter = Character.toLowerCase(input.next().charAt(0));
        }
        return (inputLetter == 'y' ? true : false);
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        getWords(words);
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
                if (!checkGuess(word, guessed, guess)) {
                    misses++;
                }
            }
            System.out.println("The word is " + word + ". You missed " + misses + (misses > 1 ? " times" : " time"));
            System.out.print("Do you want to guess another word? Enter y or n> ");

            playGame = playAnotherGame(input);
        }
        input.close();
    }

    private static void getWords(ArrayList<String> words) {
        File file = new File("Hangman.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("File with words does not exist");
            System.exit(1);
        }
    }
}