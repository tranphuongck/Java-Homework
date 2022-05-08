package Ladybug3.de.uni_hannover.hci.task2.model;


/**
 * This class represents an entity on the playing field.
 * Other classes are supposed to inherit from this class, but this class should
 * not be instantiated.
 */
public class Entity {

    // this class does not need any methods to be implemented to work as a
    // superclass for playing field entities. There are however many different
    // approaches like having an entity method handle whether a tile is
    // walkable.
    // We will use such a method, as it together with some additional work on
    // this class (to be interface) may simplify further work down the line.
    // However the question whether walkability should be implemented here or
    // in the Ladybug class is up to your ideas on how you want to model your
    // classes.

    /**
     * Signals whether this entity can be walked on by a Ladybug that is
     * walking on the ground.
     * 
     * This method is intended to be overwritten.
     * 
     * @return walkabiliy of this entity
     */
    public boolean isWalkable() {
        return false;
    }

    /**
     * Overwritten to signal that this class should not be instantiated.
     * 
     * @return invalid string
     */
    @Override public String toString() {
        return "INVALID";
    }
}
