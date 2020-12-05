# Topic: Behavioral Design Patterns
### Author: Filipescu Mihail
#### Group: FAF-181
## Objectives:
1. **Study and understand the Behavioral Design Patterns**<br>
2. **Expanding previous laboratory work by adding some additional functionalities using some behavioral design patterns**<br>

## Theory:
**Design patterns** are typical solutions to common problems
in software design. Each pattern is like a blueprint
that can be customized to solve a particular
design problem.They define a common language that helps developer teams
communicate more efficiently.<br>
<br>
In software engineering, **behavioral design patterns** are design patterns that identify 
common communication patterns between objects and realize these patterns.
 By doing so, these patterns increase flexibility in carrying out this communication.
Some examples of from this category of design patterns are:<br>
- Chain of responsibility
- Command
- Interpreter
- Iterator
- Mediator
- Observer
- Null Object
- Strategy


## Implementation:<br>
In this project I've implemented 3 behavioral design patterns (Command, Memento and Null Object) with 
the emphasis on the objects of type Instruments: Guitar, Violin, Bass, etc. Type Instruments contains 3 attributes, *get* and *set* methods and *toString*, which is used 
for output.<br>
The __Memento DP__, I've implemented in **Instruments.memento Package** and added the following class: **StringInstrumentMemento**.
```
public class StringInstrumentMemento {
    private State state;

    public StringInstrumentMemento(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
```
Where **State** is just a placeholder for values that defines the state:
```
public class State {
    private String name;
    private String type;
    private int nrOfStrings;
    private float price;
    ...
}
```
The **StringInstrument** abstraction has **save()** and **restore()** methods that each concrete implementation (Bass, Guitar, ...) implements:
```
    ...
    abstract public StringInstrumentMemento save();
    abstract public void restore(StringInstrumentMemento memento);
    ...
}
```
In this way we can capture and externalize an object's internal state so that the object can be returned to this state later.

The __Command DP__ pattern allows us to encapsulate a request as an object, thereby letting us parametrize clients with different requests, queue or log requests, and support undoable operations.<br>

Firstly I have created the **Command Interface** that will define and group all concrete commands>
```
public interface Command {
    void execute();
    void unexecute();
}
```

There is one of the concrete classes:
```
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
```
Notice how the **undo** operation is using **Memento DP**. In fact I have implemented **Memento** primarily for this case.<br>
Also nothing stops us to create **Macro Commands** (in this case a hardcoded one):
```
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
```
Here is an example of not hardcoded **Macro Command** that repeats the same command a number of times:
```
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
```
Of course not all commands act on the same "reciver". Here the command acts on some **list** instead of **Instrument** element:
```
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
```
The **memento** in this case does not refer to the **Memento DP** because it is no need to do so, just named it memento for consistency.<br>
And finally we have a "client" that is "loaded" with commands and can execute/unexecute them anytime: 
```
public class CommandExecutor {
    private List<Command> commands = new ArrayList<Command>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeAllComands() {
        commands.clear();
    }

    public void executeAllCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void unexecuteAllCommands() {
        for(int i=commands.size()-1; i>=0; i--) {
            commands.get(i).unexecute();
        }
    }

    public void executeLastCommand() {
        commands.get(commands.size()-1).execute();
    }

    public void unexecuteLastCommand() {
        commands.get(commands.size()-1).unexecute();
    }
}
    }
```

The **Null Object DP** I have implemented as concretions for abstractions like **Command** (NullCommand concretion) and **Location** (NoLocation concretion).
That way we can encapsulate the absence of an object by providing a substitutable alternative that offers suitable default do nothing behavior. 


### Program output:<br>
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/img/L3POUT.png)
<br>
### Diagram of program structure:
**Command and Memento implementation**
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/img/bridge.png)

