package Tuple;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransitionsTest {

    private State state1;
    private State state2;
    private Alphabet alphabet1;
    private Alphabet alphabet2;

    @Test
    public void getMatchingTransition_should_return_transition_if_matching(){
        state1 = new State("q1");
        state2 = new State("q2");
        alphabet1 = new Alphabet("1");
        alphabet2 = new Alphabet("0");
        Transition transition1 = new Transition(state1, alphabet1, state2);
        Transition transition2 = new Transition(state2, alphabet2, state2);
        Transitions transitions = new Transitions();
        transitions.add(transition1);
        transitions.add(transition2);

        Transition matchingTransition = transitions.getMatchingTransition(state1, alphabet1);
        assertTrue(transition1.equals(matchingTransition));
    }

    @Test
    public void getMatchingTransition_should_return_null_if_not_matching(){
        state1 = new State("q1");
        state2 = new State("q2");
        alphabet1 = new Alphabet("1");
        alphabet2 = new Alphabet("0");
        Transition transition1 = new Transition(state1, alphabet1, state2);
        Transition transition2 = new Transition(state2, alphabet2, state2);
        Transitions transitions = new Transitions();
        transitions.add(transition1);
        transitions.add(transition2);

        Transition matchingTransition = transitions.getMatchingTransition(state2, alphabet1);
        assertFalse(transition1.equals(matchingTransition));
    }

}