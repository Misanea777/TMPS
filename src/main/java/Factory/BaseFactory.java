package Factory;

import Instruments.StringInstrument;

public interface BaseFactory {
    StringInstrument createInstrument(String type);
}
