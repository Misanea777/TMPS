package command;

import Instruments.StringInstrument;
import Instruments.memento.StringInstrumentMemento;

public class RepeatCommand implements Command{
    StringInstrument instrument;
    StringInstrumentMemento memento;
    int repetitions;
    Command command;

    public RepeatCommand(StringInstrument instrument, int repetitions, Command command) {
        this.instrument = instrument;
        this.repetitions =repetitions;
        this.command = command;
    }
    @Override
    public void execute() {
        memento = instrument.save();
        for(int i=0; i<repetitions; i++) {
            command.execute();
        }
    }

    @Override
    public void unexecute() {
        instrument.restore(memento);
    }
}
