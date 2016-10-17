package Tuple;

public class Transition {

    private final State state;
    private final Alphabet alphabet;
    private final State transitionState;

    public Transition(State state, Alphabet alphabet, State transitionState){
        this.state = state;
        this.alphabet = alphabet;
        this.transitionState = transitionState;
    }

    public State getState(){
        return this.state;
    }

    public Alphabet getAlphabet(){
        return this.alphabet;
    }

    public State getTransitionState(){
        return this.transitionState;
    }

}
