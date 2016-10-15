import Exceptions.InvalidDFAException;
import Tuple.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FiniteAutomataTest {
    private State state1;
    private State state2;
    private Alphabet alphabet1;
    private Alphabet alphabet2;
    private States states;
    private Alphabets alphabets;

    @Before
    public void initObjects() {
        state1 = new State("q1");
        state2 = new State("q2");
        states = new States();
        states.add(state1);
        states.add(state2);
        alphabet1 = new Alphabet("1");
        alphabet2 = new Alphabet("0");
        alphabets = new Alphabets();
        alphabets.add(alphabet1);
        alphabets.add(alphabet2);
    }

    @Test
    public void isStringPassing_should_return_true_for_powers_of_two() throws InvalidDFAException {
        Transition transition1 = new Transition(state1, alphabet1, state2);
        Transition transition2 = new Transition(state2, alphabet2, state2);
        Transitions transitions = new Transitions();
        transitions.add(transition1);
        transitions.add(transition2);
        States finalStates = new States();
        finalStates.add(state2);

        String language = "1000";

        FiniteAutomata automata = new FiniteAutomata(states, alphabets, transitions, state1, finalStates);
        assertTrue(automata.isStringPassing(language));
    }

    @Test
    public void isStringPassing_should_return_false_for_powers_of_two() throws InvalidDFAException {
        Transition transition1 = new Transition(state1, alphabet1, state2);
        Transition transition2 = new Transition(state2, alphabet2, state2);
        Transitions transitions = new Transitions();
        transitions.add(transition1);
        transitions.add(transition2);
        States finalStates = new States();
        finalStates.add(state2);

        String language = "10001";

        FiniteAutomata automata = new FiniteAutomata(states, alphabets, transitions,state1,finalStates);
        assertFalse(automata.isStringPassing(language));
    }

    @Test
    public void isStringPassing_should_return_true_for_odd_number_of_zeros() throws InvalidDFAException {
        Transition transition1 = new Transition(state1, alphabet2, state2);
        Transition transition2 = new Transition(state1, alphabet1, state1);
        Transition transition3 = new Transition(state2, alphabet2, state1);
        Transition transition4 = new Transition(state2, alphabet1, state2);
        Transitions transitions = new Transitions();
        transitions.add(transition1);
        transitions.add(transition2);
        transitions.add(transition3);
        transitions.add(transition4);
        States finalStates = new States();
        finalStates.add(state2);
        String string1 = "0";
        String string2 = "000";
        String string3 = "00000";
        String string4 = "10";
        String string5 = "101010";
        String string6 = "010101";

        FiniteAutomata automata = new FiniteAutomata(states, alphabets, transitions,state1,finalStates);
        assertTrue(automata.isStringPassing(string1));
        assertTrue(automata.isStringPassing(string2));
        assertTrue(automata.isStringPassing(string3));
        assertTrue(automata.isStringPassing(string4));
        assertTrue(automata.isStringPassing(string5));
        assertTrue(automata.isStringPassing(string6));

    }

    @Test
    public void isStringPassing_should_return_false_for_odd_number_of_zeros() throws InvalidDFAException {
        Transition transition1 = new Transition(state1, alphabet2, state2);
        Transition transition2 = new Transition(state1, alphabet1, state1);
        Transition transition3 = new Transition(state2, alphabet2, state1);
        Transition transition4 = new Transition(state2, alphabet1, state2);
        Transitions transitions = new Transitions();
        transitions.add(transition1);
        transitions.add(transition2);
        transitions.add(transition3);
        transitions.add(transition4);
        States finalStates = new States();
        finalStates.add(state2);
        String string1 = "00";
        String string2 = "0000";
        String string3 = "1001";
        String string4 = "1010";
        String string5 = "001100";
        String string6 = "0101010";

        FiniteAutomata automata = new FiniteAutomata(states, alphabets, transitions,state1,finalStates);
        assertFalse(automata.isStringPassing(string1));
        assertFalse(automata.isStringPassing(string2));
        assertFalse(automata.isStringPassing(string3));
        assertFalse(automata.isStringPassing(string4));
        assertFalse(automata.isStringPassing(string5));
        assertFalse(automata.isStringPassing(string6));

    }
}