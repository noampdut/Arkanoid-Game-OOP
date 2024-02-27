//Noam Pdut ID 315097113
package interfaces;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Ball;

/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the collidable interface.
 */
public interface Collidable {
    /**
     * the method return the collision rectangle.
     * @return the element.
     */
    Rectangle getCollisionRectangle();
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint .
     * @param currentVelocity .
     * @param hitter .
     * @return return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
