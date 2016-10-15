import Exceptions.InvalidDFAException;
import Tuple.*;

public class FiniteAutomata {
    private final States states;
    private final Alphabets alphabets;
    private final Transitions transitions;
    private final State initialState;
    private final States finalStates;

    private FiniteAutomata(States states, Alphabets alphabets, Transitions transitions, State initialState, States finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    public static FiniteAutomata createFiniteAutomata(States states, Alphabets alphabets, Transitions transitions, State initialState, States finalStates) throws InvalidDFAException {
        if (!isValidFiniteAutomata(states, alphabets, transitions, initialState, finalStates)) {
            throw new InvalidDFAException();
        } else {
            return new FiniteAutomata(states, alphabets, transitions, initialState, finalStates);
        }
    }

    private static boolean isValidInitialState(States states, State initialState) {
        return states.isStatePresent(initialState);
    }

    private static boolean isValidFinalStates(States states, States finalStates) {
        return states.isSubSet(finalStates);
    }

    private static boolean isValidTransitions(Transitions transitions, States states, Alphabets alphabets) {
        return transitions.isAllTransitionsPresent(states, alphabets);
    }

    private static boolean isValidFiniteAutomata(States states, Alphabets alphabtes,Transitions transitions, State initialState, States finalStates) {
        return isValidFinalStates(states,finalStates) && isValidInitialState(states,initialState) && isValidTransitions(transitions, states, alphabtes);
    }

    public boolean isStringPassing(String string) throws InvalidDFAException {

            String[] text = string.split("");
            State inputTransitionState = this.initialState;
            for (String letter : text) {
                Alphabet alphabet = new Alphabet(letter);
                Transition currentTransitionState = this.transitions.getMatchingTransition(inputTransitionState, alphabet);
                if (currentTransitionState != null) {
                    inputTransitionState = currentTransitionState.getTransitionState();
                } else {
                    return false;
                }
            }
            return this.finalStates.isStatePresent(inputTransitionState);
        }
}

