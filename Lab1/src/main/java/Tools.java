import java.util.Set;

public class Tools {
    public static boolean addNewWord(Set<String> set, String inputString, int firstSymb, int lastSymb) {
        if (lastSymb - firstSymb <= 30) {
            set.add(inputString.substring(firstSymb, lastSymb));
            return true;
        } else {
            set.add(inputString.substring(firstSymb, firstSymb + 30));
            return false;
        }
    }

    public static boolean repeatSymbols(String str) {
        char[] myArray = str.toCharArray();
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
