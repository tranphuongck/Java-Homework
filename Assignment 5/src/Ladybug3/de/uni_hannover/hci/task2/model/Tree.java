package Ladybug3.de.uni_hannover.hci.task2.model;

/**
 * Represents a Tree on the playing board.
 * 
 * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
 * @version 04.05.2021
 */
public class Tree extends Entity {
    //Tree does not have any variables or special behavior yet,
    //so omitting constructor is fine.

    /**
     * Signals whether this Entity can be walked on. Trees cannot be walked on.
     * 
     * @return walkability
     */
    public boolean isWalkable() {
        return false;
    }


    /** 
     * Returns string representation of the Tree.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return String representation of the playing field.
     */
    @Override public String toString() {
        return "X";
    }
}
