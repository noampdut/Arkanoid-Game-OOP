//Noam Pdut ID 315097113
package management;
import geometry.Line;
import geometry.Point;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class manage the game environment and has many methods.
 */
public class GameEnvironment {
    private List<Collidable> collidableList; // the collidable list of the game
    /**
     * a constructor.
     * @param collidableList .
     */
    public GameEnvironment(List<Collidable> collidableList) {
        this.collidableList = new ArrayList<Collidable>();
    }
    /**
     * the method return the collidable list.
     * @return the element.
     */
    public List<Collidable> getCollidableList() {
        return collidableList;
    }
    /**
     * the method add a colloidal to the list.
     * @param c .
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }
    /**
     * the method return the information about the closest collision that is going to occur.
     * @param trajectory .
     * @return If this object will not collide with any of the collidables in this collection, return null,
     * else, the closet intersection point
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> collisionPoints = new ArrayList<Point>();
        List<Collidable> collidableListTwo = new ArrayList<>(collidableList);
        for (Collidable collidable: collidableListTwo) {
           collisionPoints.add(trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle()));
        }
        int indexOfClosetCollision = checkForTheClosetPoint(collisionPoints, trajectory);
        if (indexOfClosetCollision == -1) {
            return null;
        }
        CollisionInfo setInfo = new CollisionInfo(collisionPoints.get(indexOfClosetCollision),
                collidableList.get(indexOfClosetCollision));
        return setInfo;
    }
    /**
     * the method return the index of the closet intersection point.
     * @param trajectory .
     * @param collisionPoints .
     * @return If this object will not collide with any of the collidables in this collection, return -1,
     * else, the index of the closet intersection point
     */
    public int checkForTheClosetPoint(List<Point> collisionPoints, Line trajectory) {
        double minDistance = 10000;
        int minIndex = -1;
        for (Point point: collisionPoints) {
            if (point != null) {
                if (point.distance(trajectory.start()) < minDistance) {
                    minDistance = point.distance(trajectory.start());
                    minIndex = collisionPoints.indexOf(point);
                }
            }
        }
        if (minIndex == -1) {
            return -1;
        }
        return minIndex;
    }
    /**
     * the method remove colloidal from the list.
     * @param c .
     */
    public void removeCollidable(Collidable c) {
        this.collidableList.remove(c);
    }
}
