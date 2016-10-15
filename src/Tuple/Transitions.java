package Tuple;

import java.util.ArrayList;

public class Transitions {
    private final ArrayList<Transition> transitions;

    public Transitions(){
        this.transitions = new ArrayList<Transition>();
    }

    public void add(Transition transition){
        this.transitions.add(transition);
    }

    public Transition getMatchingTransition(State state,Alphabet alphabet){
        for (Transition transition : transitions) {
            if (transition.getState().getState().equals(state.getState()) && transition.getAlphabet().getAlphabet().equals(alphabet.getAlphabet())) {
                return transition;
            }
        }
        return null;
    }

    public boolean isAllTransitionsPresent(States states, Alphabets alphabets) {
        for (State state: states.getStates()) {
            for (Alphabet alphabet:alphabets.getAlphabets()) {
               if(getMatchingTransition(state,alphabet)== null) return false;
            }
        }
        return true;
    }
}
