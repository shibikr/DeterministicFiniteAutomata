import Exceptions.InvalidDFAException;
import Tuple.*;

public class FiniteAutomata {
    private final States states;
    private final Alphabets alphabets;
    private final Transitions transitions;
    private final State initialState;
    private final States finalStates;

    public FiniteAutomata(States states, Alphabets alphabets, Transitions transitions, State initialState, States finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    private boolean isValidInitialState(){
        return this.states.isStatePresent(initialState);
    }

    private boolean isValidFinalStates(){
        return this.states.isSubSet(this.finalStates);
    }

    private boolean isValidTransition() {
        return true;
    }

    private boolean isValidFiniteAutomata(){
        return isValidFinalStates() && isValidInitialState() && isValidTransition();
    }


    public boolean isStringPassing(String string) throws InvalidDFAException {
        if(!isValidFiniteAutomata()){
            throw new InvalidDFAException();
        } else {
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
}
