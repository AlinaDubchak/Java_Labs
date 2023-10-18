package Java_Labs.Lab3;

public class StringTransform {
    public void transform(StringBuffer str) throws Exception {
        if (str == null || str.toString().trim().isEmpty()) {
            throw new Exception("String might not be null or empty");
        } else {
            String[] words = str.toString().split("\\s+");
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                char firstChar = 0;
                String input = words[i];

                for (int j = 0; j < input.length(); j++) {
                    char currentChar = input.charAt(j);

                    if (firstChar == 0) {
                        firstChar = currentChar;
                    } else if (!(Character.toLowerCase(currentChar) == Character.toLowerCase(firstChar))) {
                        result.append(currentChar);
                    }
                }

                if (i < words.length - 1) {
                    result.append(" ");
                }
            }

            str.setLength(0);
            str.append(result);
        }
    }
}

