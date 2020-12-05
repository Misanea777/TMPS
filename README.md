# Topic: Creational Design Patterns
### Author: Filipescu Mihail
#### Group: FAF-181
## Objectives:
1. **Study the Creational Design Patterns**<br>
2. **Implement them in real projects**<br>

## Theory:
**Design patterns** are typical solutions to common problems
in software design. Each pattern is like a blueprint
that can be customized to solve a particular
design problem.They define a common language that helps developer teams
communicate more efficiently.<br>
<br>
**Creational Design Patterns** provide various object creation mechanisms,
 which increase flexibility and reuse of existing code.<br>
Some examples of this kind of design patterns are:<br>
- Singleton
- Builder
- Prototype
- Object Pooling
- Factory Method
- Abstract Factory

## Implementation:<br>
In this project I've implemented 4 creational design patterns (Abstract Factory, Factory Method, Singleton and Builder) with 
the emphasis on the objects of type Instruments:Guitar, Violin, Bass, etc. Type Instruments contains 3 attributes, *get* and *set* methods and *toString*, which is used 
for output.<br>
**Singleton DP**, I've implemented in **AcousticFactory**, **ClassicFactory** and **ElectricalFactory** classes. For this I use a
static attribute for instance.<br><br>
`private static ElectricalFactory instance = new ElectricalFactory();`<br>
`private static ClassicFactory instance = new ClassicFactory();`<br>
`private static AcousticFactory instance = new AcousticFactory();`<br><br>
Then I declare the constructor as private:<br><br>
`private AcousticFactory(){}`<br>
`private ElectricalFactory(){}`<br>
`private ClassicFactory(){}`<br><br>
So that the class instance is unique and could be got only from *getInstance()* method which is a
static method i.e:<br>
```
public static ClassicFactory getInstance() {
        return instance;
    }
```
<br>

The __Builder DP__ ensures that a program can create different objects by the same creational process.
In my project there are 2 stages to create the instrument object.First is chosen the factory by the type of instrument(Classic, Acoustic, Electric)
and then in the coresponding factory is chosen a builder class. The creation methods are implemented in coresponding factories class.<br>
<br>
The builder methods that I've used in my project are in Builder package ,StringInstrumentBuilder interface.
There are multiple classes which implement the interface(BassBuilder, Guitarbuilder, ViolinBuilder, etc). Then based on the type parameter it is chosen one of them.<br>
<br>
Above that I have the factories which get the coresponding builder for each *style* .
These factories implements the **BaseFactory** interface. <br>
<br>
The process of creating different classes of instruments of different types is in the following lines from **Main** class:
<br>

```
public class Main {
    public static void main(String[] args){
        BaseFactory classicFactory = Factory.FactoryProducer.getFactory("classic");
        BaseFactory acousticFactory = Factory.FactoryProducer.getFactory("accustic");
        BaseFactory electicFactory = Factory.FactoryProducer.getFactory("electric");

        createAndPrintAllInstrumentsFromFactory(classicFactory);
        createAndPrintAllInstrumentsFromFactory(acousticFactory);
        createAndPrintAllInstrumentsFromFactory(electicFactory);
    }

    public static void createAndPrintAllInstrumentsFromFactory(BaseFactory factory) {
        System.out.println(factory.createInstrument("guitar"));
        System.out.println(factory.createInstrument("bass"));
        System.out.println(factory.createInstrument("doubleBass"));
        System.out.println(factory.createInstrument("harp"));
        System.out.println(factory.createInstrument("violin"));
        System.out.println();
    }
```

<br>

### Program output:<br>
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/sc.png)
<br>
### Diagram of program structure:
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/d2.png)
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/d1.png)
