package Ladybug3.de.uni_hannover.hci.task2.model;

/**
 * This class represents a Clover (collectible) on a {@link de.uni_hannover.hci.task2.Game}.
 * 
 * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
 * @version 04.05.2021
 */
public class Clover extends Entity {
    /** Point value. */
    private int value_;

    /**
     * Simple constructor.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @param value Clover value.
     */
    public Clover(int value) {
        this.value_ = value;
    }

    /**
     * Getter for value.
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return value of clover.
     */
    public int getValue() {
        return this.value_;
    }

    /**
     * Signals whether this Entity can be walked on. Clovers can be walked on.
     * 
     * @return walkability
     */
    public boolean isWalkable() {
        return true;
    }

    /** 
     * Returns string representation of the Clover.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return String representation of the playing field.
     */
    @Override public String toString() {
        return "O";
    }
}
