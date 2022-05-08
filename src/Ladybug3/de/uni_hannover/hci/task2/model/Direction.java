package Ladybug3.de.uni_hannover.hci.task2.model;


/**
 * Enum represents the cardinal direction
 * 
 * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
 * @version 04.05.2021
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    Direction left() {
        switch (this) {
            case NORTH:
                return Direction.WEST;
            case EAST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.EAST;
            case WEST:
                return Direction.SOUTH;
            default:
                return null;
        }
    }

    Direction right() {
        switch (this) {
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.WEST;
            case WEST:
                return Direction.NORTH;
            default:
                return null;
        }
    }
}