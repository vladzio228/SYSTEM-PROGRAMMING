import java.util.HashSet;

public class Tools {

    public static void addNewWord(HashSet<String> set, String inputString, int firstSymb, int lastSymb) {
        if (repeatSymbols(inputString.substring(firstSymb,lastSymb))) {
            if (lastSymb - firstSymb <= 30) {
                set.add(inputString.substring(firstSymb, lastSymb));
            } else {
                set.add(inputString.substring(firstSymb, firstSymb + 30));
            }
        }
    }

    public static boolean repeatSymbols(String str) {
        for (int i = 0; i < str.length() - 1; ++i) {
            for (int j = i + 1; j < str.length(); ++j) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
