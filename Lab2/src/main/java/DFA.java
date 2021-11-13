import java.io.FileNotFoundException;
import java.util.*;

class DFA {
    Set<Character> alphabet;
    Set<Integer> states;
    Integer startState;
    Set<Integer> finalStates;
    Map<Integer, Map<Character, Integer>> transitionFunction;

    private DFA(Scanner fileScanner) {
        String preAlphabet = "abcdefghijklmnopqrstuvwxyz";
        int alphabetSize = fileScanner.nextInt(); // <= 26
        alphabet = new HashSet<>();
        for (int i = 0; i < alphabetSize; ++i) {
            alphabet.add(preAlphabet.charAt(i));
        }

        int numberOfStates = fileScanner.nextInt();
        states = new HashSet<>(numberOfStates);
        for (int i = 0; i < numberOfStates; ++i) {
            states.add(i);
        }

        startState = fileScanner.nextInt();

        int numberOfFinalStates = fileScanner.nextInt();
        finalStates = new HashSet<>(numberOfFinalStates);
        for (int i = 0; i < numberOfFinalStates; ++i) {
            finalStates.add(fileScanner.nextInt());
        }

        transitionFunction = new HashMap<>(numberOfStates);
        for (Integer state : states) {
            transitionFunction.put(state, new HashMap<>());
        }

        while (fileScanner.hasNext()) {
            Integer fromState = fileScanner.nextInt();
            Character viaLetter = fileScanner.next().charAt(0);
            Integer toState = fileScanner.nextInt();
            transitionFunction.get(fromState).put(viaLetter, toState);
        }
    }

    DFA(String pathname) throws FileNotFoundException {
        this(Main.getScanner(pathname));
    }

    Set<Character> getNotAcceptableLetters() {
        Set<Character> acceptableLetters = alphabet;
        for (Map<Character, Integer> transitionValues : transitionFunction.values()) {
            for (Character letter : transitionValues.keySet()) {
                if(acceptableLetters.contains(letter)) acceptableLetters.remove(letter);
            }
        }
        System.out.println(acceptableLetters);
        return acceptableLetters;
    }
}