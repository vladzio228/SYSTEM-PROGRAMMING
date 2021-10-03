import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Parser {

    private final BufferedReader bufferedReader;
    private final FileReader fileReader;

    public Parser(String path) throws FileNotFoundException {
        fileReader = new FileReader(path);
        bufferedReader = new BufferedReader(fileReader);
    }

    public HashSet<String> parsedWords() throws IOException {
        HashSet<String> words = new HashSet<>();
        StringBuilder temps = new StringBuilder();
        while (bufferedReader.ready()) {
            char temp = (char) bufferedReader.read();
            boolean letter = Character.isLetter(temp);

            if (letter) {
                temps.append(temp);
            } else {
                Tools.addNewWord(words,temps.toString());
                temps = new StringBuilder();
            }
        }
        return words;
    }
}
