import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String pathname = "tests/a7.txt";
        DFA dfa = new DFA(pathname);

        Set<Character> notAcceptableLetters = dfa.getNotAcceptableLetters();
        System.out.println("Not acceptable letters:");
        printIterableInline(notAcceptableLetters);
    }

    private static <T> void printIterableInline(Iterable<T> iterable) {
        for (T t : iterable) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    static Scanner getScanner(String pathname) throws FileNotFoundException {
        File file = new File(pathname);

        if (!file.exists()) {
            System.out.format("File '%s' does not exist.%n", pathname);
        }

        if (!file.canRead()) {
            System.out.format("Cannot read file '%s'.%n", pathname);
        }

        return new Scanner(file);
    }
}