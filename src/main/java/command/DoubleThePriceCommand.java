package command;

import Instruments.StringInstrument;
import Instruments.memento.StringInstrumentMemento;

public class DoubleThePriceCommand implements Command{
    StringInstrument instrument;
    StringInstrumentMemento memento;

    public DoubleThePriceCommand(StringInstrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public void execute() {
        memento = instrument.save();
        instrument.setPrice(instrument.getPrice() * 2);
    }

    @Override
    public void unexecute() {
        instrument.restore(memento);
    }
}
