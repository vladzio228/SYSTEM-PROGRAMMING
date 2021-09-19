import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Parser {

    private File file;
    private Scanner scanner;

    public Parser(String path) throws FileNotFoundException {
        file = new File(path);
        scanner = new Scanner(file);
    }

    public Set<String> parsedWords() {
        String inputString = "";
        Set<String> words = new HashSet<>();

        while (scanner.hasNext())
            inputString += scanner.nextLine() + "\r\n";
        scanner.close();

        int firstSymb = 0;
        for (int lastSymb = 0; lastSymb < inputString.length(); ++lastSymb) {
            if (lastSymb - 1 >= 0) {
                if (!(Character.isLetter(inputString.charAt(lastSymb)))) {
                    if (Character.isLetter(inputString.charAt(lastSymb - 1))) {
                        Tools.addNewWord(words, inputString, firstSymb, lastSymb);
                    }
                    firstSymb = lastSymb;
                } else {
                    if (!Character.isLetter(inputString.charAt(lastSymb - 1))) {
                        firstSymb = lastSymb;
                    }
                    if (lastSymb == inputString.length() - 1) {
                        Tools.addNewWord(words, inputString, firstSymb, lastSymb);
                    }
                }
            }
        }
        return words;
    }
}
