package Tuple;

import java.util.ArrayList;

public class Alphabets {

    private final ArrayList<Alphabet> alphabets;

    public Alphabets(){
        this.alphabets = new ArrayList<Alphabet>();
    }

    public void add(Alphabet alphabet){
        this.alphabets.add(alphabet);
    }
}
