package command;

import Instruments.Filter.CriteriaElectric;
import Instruments.StringInstrument;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DeleteIfNotElectricCommand implements Command{
    List<StringInstrument> instruments;
    List<StringInstrument> memento;

    public DeleteIfNotElectricCommand(List<StringInstrument> instruments) {
        this.instruments = instruments;
    }
    @Override
    public void execute() {
        memento = new ArrayList<StringInstrument>(instruments);
        instruments.clear();
        instruments.addAll(new CriteriaElectric().meetCriteria(memento));
    }

    @Override
    public void unexecute() {
        instruments.clear();
        instruments.addAll(memento);
    }
}
