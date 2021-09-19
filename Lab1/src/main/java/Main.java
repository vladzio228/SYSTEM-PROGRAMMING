import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Parser parser = new Parser("MyDocument.txt");

        for (String word: parser.parsedWords()) {
            if(Tools.repeatSymbols(word)){
                System.out.println(word);
            };
        }
    }
}
