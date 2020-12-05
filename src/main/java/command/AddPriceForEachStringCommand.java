package command;

import Instruments.StringInstrument;
import Instruments.memento.StringInstrumentMemento;

public class AddPriceForEachStringCommand implements Command{
    StringInstrument instrument;
    StringInstrumentMemento memento;

    public AddPriceForEachStringCommand(StringInstrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public void execute() {
        memento = instrument.save();
        instrument.setPrice(instrument.getPrice() + instrument.getNrOfStrings() * 100);
    }

    @Override
    public void unexecute() {
        instrument.restore(memento);
    }
}
