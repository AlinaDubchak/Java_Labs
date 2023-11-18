package Java_Labs.Lab5;
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Letter {
    /**
     * Constructs a Letter object with the given character.
     *
     * @param character The character representing the letter.
     */

    private final char character;

    public Letter(char character) {
        this.character = character;
    }

    /**
     * Gets the character of the letter.
     *
     * @return The character of the letter.
     */

    public char getCharacter() {
        return character;
    }

    /**
     * Returns a string representation of the letter.
     *
     * @return A string representation of the letter.
     */

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}

/**
 * Represents a word composed of letters.
 */

class Word {
    private final List<Letter> letters = new ArrayList<>();

    /**
     * Constructs a Word object with the given word string.
     *
     * @param word The input word string.
     */

    public Word(String word) {
        for (int i = 0; i < word.length(); i++) {
            letters.add(new Letter(word.charAt(i)));
        }
    }

    /**
     * Gets the list of letters in the word.
     *
     * @return The list of letters in the word.
     */

    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Returns a string representation of the word.
     *
     * @return A string representation of the word.
     */

    @Override
    public String toString() {
        StringBuilder wordString = new StringBuilder();
        for (Letter letter : letters) {
            wordString.append(letter.toString());
        }
        return wordString.toString();
    }

    /**
     * Checks if two words are equal based on their letters.
     *
     * @param o The object to compare with.
     * @return True if the words are equal, false otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(letters, word.letters);
    }

    /**
     * Computes the hash code of the word based on its letters.
     *
     * @return The hash code of the word.
     */

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }
}

/**
 * Represents a sentence composed of words and punctuation.
 */

class Sentence {

    private final List<Object> elements = new ArrayList<>();

    /**
     * Constructs a Sentence object with the given sentence string.
     *
     * @param sentence The input sentence string.
     */

    public Sentence(String sentence) {
        String[] wordsAndPunctuation = sentence.split("\\s+");
        for (String element : wordsAndPunctuation) {
            if (element.matches("[.,;!?]")) {
                elements.add(element);
            } else {
                elements.add(new Word(element));
            }
        }
    }

    /**
     * Gets the list of elements in the sentence.
     *
     * @return The list of elements in the sentence.
     */

    public List<Object> getElements() {
        return elements;
    }

    /**
     * Returns a string representation of the sentence.
     *
     * @return A string representation of the sentence.
     */

    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        for (Object element : elements) {
            sentenceString.append(element.toString()).append(" ");
        }
        return sentenceString.toString().trim();
    }
}

class Text {
    /**
     * Constructs a Text object with the given text string.
     *
     * @param text The input text string.
     */

    private final List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        String[] sentencesArray = text.split("\\. ");
        for (String sentence : sentencesArray) {
            sentences.add(new Sentence(sentence));
        }
    }

    /**
     * Gets the list of sentences in the text.
     *
     * @return The list of sentences in the text.
     */

    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Returns a string representation of the text.
     *
     * @return A string representation of the text.
     */

    @Override
    public String toString() {
        StringBuilder textString = new StringBuilder();
        for (Sentence sentence : sentences) {
            textString.append(sentence.toString()).append(". ");
        }
        return textString.toString().trim();
    }
}

/**
 * The main class containing the entry point for the program.
 */

public class Main {
    /**
     * The main method to demonstrate the transformation of the text.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) throws Exception {
        String inputText = "It was sixty years ago, thaT Martin Luther King made one of the great speeches that defined the United States of modern times. ";

        if (inputText.isEmpty()) {
            throw new Exception("Input text is empty");
        }

        System.out.println("Main string:\n" + inputText);

        Text text = new Text(inputText);
        transform(text);

        System.out.println("Transformed string:\n" + text);
    }

    /**
     * Transforms the given text by applying a specific transformation to each word.
     *
     * @param text The text to be transformed.
     */

    public static void transform(Text text) {
        for (Sentence sentence : text.getSentences()) {
            for (Object element : sentence.getElements()) {
                if (element instanceof Word word) {
                    transform(word);
                }
            }
        }
    }

    /**
     * Transforms the given word by removing duplicate consecutive letters.
     *
     * @param word The word to be transformed.
     */

    public static void transform(Word word) {
        List<Letter> letters = word.getLetters();
        List<Letter> transformedLetters = new ArrayList<>();

        char firstChar = 0;

        for (Letter letter : letters) {
            char currentChar = letter.getCharacter();

            if (firstChar == 0) {
                firstChar = currentChar;
            } else if (!(Character.toLowerCase(currentChar) == Character.toLowerCase(firstChar))) {
                transformedLetters.add(letter);
            }
        }

        word.getLetters().clear();
        word.getLetters().addAll(transformedLetters);
    }
}
