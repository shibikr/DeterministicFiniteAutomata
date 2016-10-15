package Tuple;

import java.util.ArrayList;

public class States {
    private final ArrayList<State> states;

    public States(){
        this.states = new ArrayList<State>();
    }

    public void add(State state){
        this.states.add(state);
    }

    public boolean isStatePresent(State state){
        return this.states.contains(state);
    }

    public boolean isSubSet(States subset){
        for (State state: subset.states) {
            if (!isStatePresent(state)) return false;
        }
        return true;
    }

}
