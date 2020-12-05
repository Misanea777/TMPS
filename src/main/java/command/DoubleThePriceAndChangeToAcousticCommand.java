package command;

import Instruments.StringInstrument;
import Instruments.memento.StringInstrumentMemento;

public class DoubleThePriceAndChangeToAcousticCommand implements Command{
    StringInstrument instrument;
    StringInstrumentMemento memento;

    public DoubleThePriceAndChangeToAcousticCommand(StringInstrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public void execute() {
        memento = instrument.save();
        new DoubleThePriceCommand(instrument).execute();
        new ChangeToAcousticCommand(instrument).execute();
    }

    @Override
    public void unexecute() {
        instrument.restore(memento);
    }
}
