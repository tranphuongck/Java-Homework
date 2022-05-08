package Ladybug3.de.uni_hannover.hci.task2;

import Ladybug3.de.uni_hannover.hci.task2.model.Clover;
import Ladybug3.de.uni_hannover.hci.task2.model.Ladybug;
import Ladybug3.de.uni_hannover.hci.task2.model.*;

/**
 * This class represents a Ladybug Game.
 * 
 * So far this class does not handle {@link de.uni_hannover.hci.task2.model.Clover} so far.
 * While this class has an goal point, nothing happens yet, when the {@link de.uni_hannover.hci.task2.model.Ladybug} enters the goal.
 * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
 * @version 04.05.2021
 */
public class Game {
    /** Represents obstacle trees. First arg determines y, second the x coordinate. */
    private Entity[][] fieldData_;
    /** Player object. */
    private Ladybug player_;
    /** Player x coordinate. */
    private int playerPosX;
    /** Player y coordinate. */
    private int playerPosY;
    /** Goal x coordinate. */
    private int endPosX;
    /** Goal y coordinate. */
    private int endPosY;
    
    /** Standard constructor.
     * 
     * Initializes all necessary parameters.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @param width Width of the playing board (max x + 1)
     * @param height Height of the playing board (max y + 1)
     * @param startX Initial x coordinate of the player.
     * @param startY Initial y coordinate of the player.
     * @param endX Goal x coordinate.
     * @param endY Goal y coordinate.
     * @param initialDirection Initial direction of the player.
     */
    public Game(int width, int height, int startX, int startY, int endX, int endY, Direction initialDirection) {
        this.fieldData_ = new Entity[height][width];
        this.player_ = new Ladybug(initialDirection);
        this.playerPosX = startX;
        this.playerPosY = startY;
        this.endPosX = endX;
        this.endPosY = endY;
    }

    /**
     * Place and remove trees onto the playing board.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param treePresent True to place tree, false to remove tree.
     */
    public void toggleTree(int x, int y, boolean treePresent) {
        if (treePresent) {
            if (this.playerPosX == x && this.playerPosY == y) {
                System.err.printf("Trying to create tree below Ladybug (Position (%d, %d)).", x, y);
                System.exit(1);
            }
            this.fieldData_[y][x] = new Tree();
        } else {
            this.fieldData_[y][x] = null;
        }
    }

    public void toggleClover(int x, int y, boolean cloverPresent, int value) {
        if (cloverPresent) {
            this.fieldData_[y][x] = new Clover(value);
        } else {
            this.fieldData_[y][x] = null;
        }
    }

    /** 
     * Returns string representation of the playing field.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return String representation of the playing field.
     */
    @Override public String toString() {
        String result = "";
        for (int y = 0; y < this.fieldData_.length; y++) {
            for (int x = 0; x < this.fieldData_[y].length; x++) {
                if (this.playerPosX == x && this.playerPosY == y) {
                    result += this.player_.toString();
                } else if (this.fieldData_[y][x] != null) {
                    result += this.fieldData_[y][x].toString();
                } else {
                    result += " ";
                }
            }
            if (y < this.fieldData_.length - 1) {
                result += "\n";
            }
        }
        result += String.format("%nPoints=%d", this.player_.getCloverValues());
        return result;
    }

    /**
     * Turn the player left by 90 degrees.
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     */
    public void turnLeft() {
        this.player_.turnLeft();
    }

    /**
     * Turn the player right by 90 degrees.
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     */
    public void turnRight() {
        this.player_.turnRight();
    }

    /**
     * Return the coordinates of the field the Player looks towards.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return the coordinates of the field the Player looks towards.
     */
    private int[] getPlayerViewCoordinates() {
        int dx, dy;
        switch (this.player_.getDirection()) {
            case NORTH:
                dx = 0; dy = -1; break;
            case SOUTH:
                dx = 0; dy = 1; break;
            case EAST:
                dx = 1; dy = 0; break;
            case WEST:
                dx = -1; dy = 0; break;
            default:
                dx=0 ; dy = 0; System.exit(1);
        }
        int[] result = {this.playerPosX + dx, this.playerPosY + dy};
        return result;
    }

    /** 
     * Checks whether the given coordinate is stil within the bounds of the playingnfield.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @retrun true if coordinate is within bounds.
     */
    private boolean isValidCoordinate(int[] coordinates) {
        return coordinates != null && coordinates.length == 2 && coordinates[0] >= 0 && coordinates[0] < this.fieldData_[0].length && coordinates[1] >= 0 && coordinates[1] < this.fieldData_.length;
    }

    /**
     * Checks whether player can walk on tile in front of him.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return true if tile is walkable.
     */
    public boolean canEnter() {
        int[] coordinates = this.getPlayerViewCoordinates();
        return this.isValidCoordinate(coordinates) && this.player_.canEnter(this.fieldData_[coordinates[1]][coordinates[0]]);
    }

    /**
     * Picks up the Clover below the player if there is one.
     */
    public void pickUp() {
        if (this.fieldData_[this.playerPosY][this.playerPosX] instanceof Clover) {
            if (this.player_.pickUp((Clover) this.fieldData_[this.playerPosY][this.playerPosX])) {
                this.fieldData_[this.playerPosY][this.playerPosX] = null;
            }
        }
    }

    /**
     * Move player forward if possible.
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     */
    public void forward() {
        if (this.canEnter()) {
            int[] coordinates = this.getPlayerViewCoordinates();
            this.playerPosX = coordinates[0];
            this.playerPosY = coordinates[1];
        }
    }

    /**
     * Checks if player is on goal.
     * 
     * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
     * @return true if player is on goal.
     */
    public boolean atGoal() {
        return this.playerPosX == this.endPosX && this.playerPosY == this.endPosY;
    }
}