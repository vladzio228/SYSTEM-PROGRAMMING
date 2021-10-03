import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Parser parser = new Parser("MyDocument.txt");

        for (String word: parser.parsedWords()) {
                System.out.println(word);
        }
    }
}
