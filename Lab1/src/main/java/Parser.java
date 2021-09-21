import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Parser {

    private File file;
    private Scanner scanner;

    public Parser(String path) throws FileNotFoundException {
        file = new File(path);
        scanner = new Scanner(file);
    }

    public HashSet<String> parsedWords() {
        HashSet<String> words = new HashSet<>();
        String thisLine ="";

        while (scanner.hasNext()) {
            thisLine += scanner.nextLine() + "\r\n";
        }
        scanner.close();
            int firstSymb = 0;
            for (int lastSymb = 0; lastSymb < thisLine.length(); ++lastSymb) {
                if (lastSymb - 1 >= 0) {
                    boolean letter = Character.isLetter(thisLine.charAt(lastSymb - 1));
                    if (!(Character.isLetter(thisLine.charAt(lastSymb)))) {
                        if (letter) {
                            Tools.addNewWord(words,thisLine, firstSymb, lastSymb);
                        }
                        firstSymb = lastSymb;
                    } else {
                        if (!letter) {
                            firstSymb = lastSymb;
                        }
                        if (lastSymb == thisLine.length() - 1) {
                            Tools.addNewWord(words, thisLine, firstSymb, lastSymb);
                        }
                    }
                }
            }
        return words;
    }
}
