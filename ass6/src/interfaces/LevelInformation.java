//Noam Pdut ID 315097113
package interfaces;
import geometry.Point;
import geometry.Velocity;
import sprites.Block;
import java.awt.Color;
import java.util.List;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the LevelInformation interface, represent the information of each level.
 */
public interface LevelInformation {
    /**
     * the method return the number of balls.
     * @return int.
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    /**
     * the method return the initial velocity of each ball.
     * @return list of Velocity.
     */
    List<Velocity> initialBallVelocities();
    /**
     * the method return the paddle speed.
     * @return int.
     */
    int paddleSpeed();
    /**
     * the method return the paddle width.
     * @return int.
     */
    int paddleWidth();
    /**
     * the method return the name of the level.
     * @return string.
     */
    String levelName();
    /**
     * the method return a sprite with the background of the level.
     * @return Sprite.
     */
    Sprite getBackground();
    /**
     * the method return the Blocks that make up this level, each block contains
     * its size, color and location.
     * @return  List<Block> .
     */
    List<Block> blocks();
    /**
     * the method return the number of blocks to remove.
     * @return int.
     */
    int numberOfBlocksToRemove();
    // methods I add to the interface.
    /**
     * the method return the paddle start point - the left one.
     * @return Point.
     */
     Point paddleStartsPoint();
    /**
     * the method return the paddle middle point.
     * @return Point.
     */
     Point paddleMiddlePoint();
    /**
     * the method return the paddle middle point.
     * @return Color.
     */
     Color paddleColor();
}

