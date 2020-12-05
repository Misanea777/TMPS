package Instruments.memento;

public class StringInstrumentMemento {
    private State state;

    public StringInstrumentMemento(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
