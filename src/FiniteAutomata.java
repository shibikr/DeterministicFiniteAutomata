
public class FiniteAutomata {
    private final String[] states;
    private final char[] alphabets;
    private final String[][] transitions;
    private final String[] finalStates;
    private String initialState;

    public FiniteAutomata(String[] states, char[] alphabets, String[][] transitions, String initialState, String[] finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.transitions = transitions;
        this.finalStates = finalStates;
        this.initialState = initialState;
    }

    private String[] getMatchingTransition(String initialState, String letter) {
        String[] machingTransition = {};
        for (String[] transition : this.transitions) {
            if (transition[0].equals(initialState) && transition[1].equals(letter)) {
                machingTransition = transition;
            }
        }
        return machingTransition;
    }

    private boolean isFinalState(String lastState) {
        boolean result = false;
        for (String state : this.finalStates) {
            if (lastState.equals(state)) result = true;
        }
        return result;
    }

    public boolean isStringPassing(String string) {
        String[] text = string.split("");
        String inputTransitionState = this.initialState;
        for (String letter : text) {
            String[] currentTransitionState = getMatchingTransition(inputTransitionState, letter);
            if (currentTransitionState.length > 0) {
                inputTransitionState = currentTransitionState[2];
            } else {
                return false;
            }
        }
        return isFinalState(inputTransitionState);
    }
}
