package Debug.de.uni_hannover.hci.aufgabe3.model;

// A monkey always has 2 arms and 2 legs
public class Monkey extends Debug.de.uni_hannover.hci.aufgabe3.Animal {

  public Monkey(String name) {
    super(name);
  }


  @Override
  public String getName() {
    return super.name_;
  }

  @Override
  public int getArms() {//monkeys should have 4 arms 0 leg
    return 4;
  }
  
  @Override
  public int getLegs() {//private function cannot be accessed, change to public
    return 0;
  }

  public String toString() {
    return String.format("%s is a monkey with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());//false string, change dog to monkey
  }
}
/*

Monkey.java:4: error: package de.uni_hannover.hci.aufgabe3 does not exist
public class Monkey extends de.uni_hannover.hci.aufgabe3.Animal {
                                                        ^        
Monkey.java:11: error: method does not override or implement a method from a supertype
  @Override
  ^
Monkey.java:13: error: cannot find symbol
    return super.name_;
           ^
  symbol:   variable super
  location: class Monkey
Monkey.java:16: error: method does not override or implement a method from a supertype
  @Override
  ^
Monkey.java:21: error: method does not override or implement a method from a supertype
  @Override
  ^
Monkey.java:26: error: method does not override or implement a method from a supertype
  @Override
  ^
6 errors
*/