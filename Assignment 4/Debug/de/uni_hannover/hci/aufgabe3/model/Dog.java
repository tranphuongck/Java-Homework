package Debug.de.uni_hannover.hci.aufgabe3.model;

// A monkey always has 0 arms and 4 legs
public class Dog extends Debug.de.uni_hannover.hci.aufgabe3.Animal {

  public Dog(String name) {
    super(name);
  }


  @Override
  public String getName() {
    return super.name_;
  }

  @Override
  public int getArms() {
    return 0;
  }

  @Override
  public int getLegs() {//private function cannot be accessed, change to public
    return 4;
  }

  public String toString() {
    return String.format("%s is a dog with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());//getLegs should go before getArms
  }
}

/*
Dog.java:4: error: cannot find symbol
public class Dog extends Debug.de.uni_hannover.hci.aufgabe3.Animal {
                                                           ^        
  symbol:   class Animal
  location: package Debug.de.uni_hannover.hci.aufgabe3
Dog.java:11: error: method does not override or implement a method from a supertype
  @Override
  ^
Dog.java:13: error: cannot find symbol
    return super.name_;
           ^
  symbol:   variable super
  location: class Dog
Dog.java:16: error: method does not override or implement a method from a supertype
  @Override
  ^
Dog.java:21: error: method does not override or implement a method from a supertype
  @Override
  ^
Dog.java:26: error: method does not override or implement a method from a supertype
  @Override
  ^
6 errors
*/