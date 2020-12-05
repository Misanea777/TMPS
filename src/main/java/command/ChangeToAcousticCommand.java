package command;

import Instruments.StringInstrument;
import Instruments.memento.StringInstrumentMemento;

public class ChangeToAcousticCommand implements Command{
    StringInstrument instrument;
    StringInstrumentMemento memento;

    public ChangeToAcousticCommand(StringInstrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public void execute() {
        memento = instrument.save();
        instrument.setType("accustic");
    }

    @Override
    public void unexecute() {
        instrument.restore(memento);
    }
}
