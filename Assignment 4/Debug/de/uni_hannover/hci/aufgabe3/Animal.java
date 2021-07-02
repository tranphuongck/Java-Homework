package Debug.de.uni_hannover.hci.aufgabe3;

public class Animal { //class not visible
	//private variables cannot be accessed by deprived classes, change to protected
  protected String name_;
  private int legs_;
  private int arms_;


  Animal(String name, int legs, int arms) {
    this.name_ = name;
    this.legs_ = legs;
    this.arms_ = arms;
  }

  public Animal(String name) {
    this(name, 0, 0);
  }


  public String getName() {
    return this.name_;
  }

  protected int getArms() {
    return this.arms_;
  }

  protected int getLegs() {
    return this.legs_;
  }

  @Override
  public String toString() {
    return String.format("%s is an animal with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}