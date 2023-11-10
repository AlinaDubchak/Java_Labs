package Java_Labs.Lab5;
import java.util.ArrayList;
import java.util.List;

class Letter {
    private final char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}

class Word {
    private final List<Letter> letters = new ArrayList<>();

    public Word(String word) {
        for (int i = 0; i < word.length(); i++) {
            letters.add(new Letter(word.charAt(i)));
        }
    }

    public List<Letter> getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder wordString = new StringBuilder();
        for (Letter letter : letters) {
            wordString.append(letter.toString());
        }
        return wordString.toString();
    }
}

class Sentence {
    private final List<Object> elements = new ArrayList<>();

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

    public List<Object> getElements() {
        return elements;
    }

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
    private final List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        String[] sentencesArray = text.split("\\. ");
        for (String sentence : sentencesArray) {
            sentences.add(new Sentence(sentence));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder textString = new StringBuilder();
        for (Sentence sentence : sentences) {
            textString.append(sentence.toString()).append(". ");
        }
        return textString.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String inputText = "It was sixty years ago, in 1963, that Martin Luther King made one of the great speeches that defined the United States of modern times";
        System.out.println("Main string:\n" + inputText);

        Text text = new Text(inputText);
        transform(text);

        System.out.println("Transformed string:\n" + text);
    }

    public static void transform(Text text) {
        for (Sentence sentence : text.getSentences()) {
            for (Object element : sentence.getElements()) {
                if (element instanceof Word word) {
                    transform(word);
                }
            }
        }
    }

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
