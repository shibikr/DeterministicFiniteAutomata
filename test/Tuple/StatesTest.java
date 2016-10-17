package Tuple;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatesTest {
    @Test
    public void isStatePresent_should_return_true_if_the_given_state_present(){
        State state1 = new State("q1");
        State state2 = new State("q2");
        State state3 = new State("q3");
        States states = new States();
        states.add(state1);
        states.add(state2);
        states.add(state3);

        assertTrue(states.isStatePresent(state1));
    }

    @Test
    public void isStatePresent_should_return_false_if_the_given_state_not_present(){
        State state1 = new State("q1");
        State state2 = new State("q2");
        State state3 = new State("q3");
        States states = new States();
        states.add(state1);
        states.add(state2);

        assertFalse(states.isStatePresent(state3));
    }

    @Test
    public void isSubSet_should_return_true_if_it_is_a_subset(){
        State state1 = new State("q1");
        State state2 = new State("q2");
        State state3 = new State("q3");

        States states = new States();
        states.add(state1);
        states.add(state2);
        states.add(state3);

        States states1 = new States();
        states.add(state1);
        states.add(state2);

        assertTrue(states.isSubSet(states1));
    }

    @Test
    public void isSubSet_should_return_false_if_it_is_not_a_subset(){
        State state1 = new State("q1");
        State state2 = new State("q2");
        State state3 = new State("q3");
        State state4 = new State("q4");

        States states = new States();
        states.add(state1);
        states.add(state2);
        states.add(state3);

        States states1 = new States();
        states1.add(state1);
        states1.add(state4);

        assertFalse(states.isSubSet(states1));
    }

}