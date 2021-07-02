package Debug.de.uni_hannover.hci.aufgabe3;

import Debug.de.uni_hannover.hci.aufgabe3.model.*;

public class Debug {
  public static void main(String[] args) {
    Animal[] animals = new Animal[3];
    animals[0] = new Animal("Kangaroo Bob", 2, 2);
    animals[1] = new Dog("Barks");
    animals[2] = new Monkey("King Kong");
    for (int i = 0; i < animals.length; ++i) {
      System.out.println(animals[i]);
    }
  }
}
/*
import de.uni_hannover.hci.aufgabe3.model.*;
^
Debug.java:7: error: cannot find symbol
    Animal[] animals = new Animal[3];  
    ^
  symbol:   class Animal
  location: class Debug
Debug.java:7: error: cannot find symbol
    Animal[] animals = new Animal[3];  
                           ^
  symbol:   class Animal
  location: class Debug
Debug.java:8: error: cannot find symbol
    animals[0] = new Animal("Kangaroo Bob", 2, 2);
                     ^
  symbol:   class Animal
  location: class Debug
Debug.java:9: error: cannot find symbol
    animals[1] = new Dog("Barks");
                     ^
  symbol:   class Dog
  location: class Debug
Debug.java:10: error: cannot find symbol
    animals[2] = new Monkey("King Kong");
                     ^
  symbol:   class Monkey
  location: class Debug
6 errors
 */