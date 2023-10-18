package Java_Labs.Lab3;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuffer inputString = new StringBuffer("It was sixty years ago, in 1963, that Marin Luther King made one of the great speeches that defined the United States of modern times. ");
        System.out.println("Main string:\n" + inputString);
        StringTransform string = new StringTransform();

        string.transform(inputString);

        System.out.println("Transform string:\n" + inputString);
    }

}

