import java.util.HashSet;

public class Tools {

    public static void addNewWord(HashSet<String> set, String str) {
        if (repeatSymbols(str)) {
            if (str.length() <= 30) {
                set.add(str);
            } else {
                set.add(str.substring(0, 30));
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
