package Instruments;

import Factory.BaseFactory;
import Factory.FactoryProducer;
import Instruments.Locations.Location;
import Instruments.StringInstrument;
import Roles.BaseRole;
import Roles.Producer;

public class StringInstrumentMemento {

    StringInstrument instrument;

    public StringInstrumentMemento(StringInstrument instrument) {
        this.instrument = instrument.clone();
    }

    public StringInstrument getState() {
        return instrument;
    }
}
