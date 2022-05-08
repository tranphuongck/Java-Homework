package Ladybug3.de.uni_hannover.hci.task2.model;

/**
 * Represents a Ladybug.
 * 
 * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
 * @version 04.05.2021
 */
public class Ladybug {
    /** Array of clovers. */
    private Clover[] clovers_;
    private int cloversCounter_;
    //0=north,1=east,2=south,3=west
    /** Looking direction */
    public Direction direction_;

    /** Standard constructor with variable direction.
     *
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @param direction Initial viewing direction of Ladybug.
     */
    public Ladybug(Direction direction) {
        this.cloversCounter_ = 0;
        this.clovers_ = new Clover[10];
        this.direction_ = direction;
    }

    /** Standard constructor.
     *
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt; 
     */
    public Ladybug() {
        this(Direction.NORTH);
    }

    /**
     * Pick up clover given as parameter. Does not do anything if the clover was null.
     * 
     * @param clover clover to pick up
     * @return true if something was picked up
     */
    public boolean pickUp(Clover clover) {
        if (clover != null) {
            this.clovers_[this.cloversCounter_++] = clover;
            return true;
        }
        return false;
    }

    /**
     * Getter for direction.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return Looking direction of Ladybug.
     */
    public Direction getDirection() {
        return this.direction_;
    }
    
    public void setDirection(Direction direction) {
    	this.direction_ = direction;
    }

    //either a setDirection or a turn{left,right} function as replacement is
    //needed

    /**
     * Turn the Player object to the right vorlaufen.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     */
    public void turnRight() {
        this.direction_ = this.direction_.right();

    }

    /**
     * Turn the ladybug right.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     */
    public void turnLeft() {
        this.direction_ = this.direction_.left();
    }

    //either a getter for clovers array or accumulated value should be here.

    /**
     * Get aggregate clover point values. 
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return aggregate clover points.
     */
    public int getCloverValues() {
        int result = 0;
        for (int i = 0; i < this.clovers_.length; ++i) {
            if (this.clovers_[i] != null) result += this.clovers_[i].getValue();
        }
        return result;
    }

    /** 
     * Signals whether the player can move forward.
     * 
     * @param entity Tile to check if it is walkable.
     * @return true if player can go forward.
     */
    public boolean canEnter(Entity entity) {
        return entity == null || entity.isWalkable();
    }
    
    /** 
     * Returns string representation of the Ladybug.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return String representation of the playing field.
     */
    @Override public String toString() {
        switch (this.direction_) {
        case NORTH:
            return "N";
        case EAST:
            return "E";
        case SOUTH:
            return "S";
        case WEST:
            return "W";
        default:
            return "I"; //invalid
        }
    }
}
