# Topic: Creational Design Patterns
### Author: Filipescu Mihail
#### Group: FAF-181
## Objectives:
1. **Study the Structural Design Patterns**<br>
2. **Expanding previous laboratory work by adding some additional functionalities using some structural design patterns**<br>

## Theory:
**Design patterns** are typical solutions to common problems
in software design. Each pattern is like a blueprint
that can be customized to solve a particular
design problem.They define a common language that helps developer teams
communicate more efficiently.<br>
<br>
In software engineering, the **Structural Design Patterns** are concerned with how classes and objects are composed
 to form larger structures.
 Structural class patterns use inheritance to create a hierarchy of classes/abstractions,
 but the structural object patterns use composition which is generally a more flexible alternative to inheritance.<br>
Some examples of from this category of design patterns are:<br>
- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy


## Implementation:<br>
In this project I've implemented 4 creational design patterns (Proxy Bridge, Filter and Facade) with 
the emphasis on the objects of type Instruments:Guitar, Violin, Bass, etc. Type Instruments contains 3 attributes, *get* and *set* methods and *toString*, which is used 
for output.<br>
**Bridge DP**, I've implemented in **Instruments Package** and added the following classes: **Location**, **StoreLocation** and **WarehouseLocation** classes. For the Bridge pattern, I have two layers of abstraction: **StringInstrument** that is located somewhere **Location** (the second layer of abstraction).
First I defined a location interface:
```
public interface Location {
    void setLocation(String locationAdress);
    String getLocation();
}
```
And with concrete classes for this interface:
```
public class StoreLocation implements Location {
    private String loc;
    @Override
    public void setLocation(String locationAdress) {...}
    @Override
    public String getLocation() {...}
}

public class WarehouseLocation implements Location {
    private String loc;
    @Override
    public void setLocation(String locationAdress) {...}
    @Override
    public String getLocation() {...}
}
```
The **StringInstrument** abstraction has it's own concrete implementation (Bass, Guitar, ...) and has an instance of **Location**:
```
public abstract class StringInstrument {
    public Location location;
    ...
}
```
Therefore,  decoupling the abstraction from its implementation so that the two can vary independently.

The __Proxy DP__ pattern allows us to create an intermediary that acts as an interface to another resource, while also hiding the underlying complexity of the component. In the project it is implemented in **FactoryProxy** class using composition. It has both instances of **BaseFactory** and **BaseRole** in order to limit access to users that do not have permission.
```
public class FactoryProxy implements BaseFactory {
    private BaseRole role;
    private BaseFactory factory;
    ...
    @Override
    public StringInstrument createInstrument(String type) {
        if(role.getPrivilegeLvl() > 1) {
            return factory.createInstrument(type);
        }
        else {
            System.out.println("Permission denied!");
            return null;
        }
    }
}
```

The __Filter__ allows to filter a set of objects using different criteria and chaining them in a decoupled way through logical operations. In the project it is implemented in **Filter** package and it has 4 different criteria: **CriteriaElectric**, **CriteriaGuitar** and **AndCriteria, OrCriteria** that can be used to combine criterias.
```
public class AndCriteria implements Criteria {
    private Criteria firstCriteria;
    private Criteria secondCriteria;
    ...
    @Override
    public List<StringInstrument> meetCriteria(List<StringInstrument> instruments) {
        List<StringInstrument> firstCriteriaInstruments = firstCriteria.meetCriteria(instruments);
        return secondCriteria.meetCriteria(firstCriteriaInstruments);
    }
}
```
All of them fall in to the same abstraction **Criteria**, that is an interface:
```
public interface Criteria {
    public List<StringInstrument> meetCriteria(List<StringInstrument> instruments);
}
```
The concrete implementations can be found in the corresponding package.

The __Facade__ is the last implemented DP and it's intent is to hide the complexities of the system and provides an interface to the client using which the client can access the system. It is implemented in **FactoryProducer** class. The method **getFactory()** allows user to get the desired factory, without knowing the details.
```
    public static BaseFactory getFactory(String type, BaseRole role) {
        return new FactoryProxy(role, getRawFactory(type));
    }
```
Wich in fact returns a proxy and not the raw object. However, from the user side it is not known.

### Program output:<br>
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/img/tmps1.png)
<br>
### Diagram of program structure:
**Bridge implementation**
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/img/bridge.png)
**Proxy implementation**
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/img/proxy.png)
**Filter implementation**
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/img/filter.png)
**Facade implementation**
![Output](https://github.com/Misanea777/TMPS/blob/master/Diagrams/img/facade.png)
