//Noam Pdut ID 315097113
package management;
import geometry.Point;
import interfaces.Collidable;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class hold the infornation about a collision between a ball and an object.
 */
public class CollisionInfo {
    private Point collisionPoint; // the point of the collision
    private Collidable collisionObject; // the collision object
    /**
     * a constructor.
     * @param collisionObject .
     * @param collisionPoint .
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }
    /**
     * the method return the collision point.
     * @return the element.
     */
    public Point collisionPoint() {
        return collisionPoint;
    }
    /**
     * the method set the collision point.
     * @param collision .
     */
    public void setCollisionPoint(Point collision) {
        this.collisionPoint = collision;
    }
    /**
     * the method set the collision object.
     * @param object .
     */
    public void setCollisionObject(Collidable object) {
        this.collisionObject = object;
    }
    /**
     * the method return the collision object.
     * @return the element.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}
