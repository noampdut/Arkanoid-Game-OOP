//Noam Pdut ID 315097113
package sprites;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;
import biuoop.DrawSurface;
import management.GameLevel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class manage a block and has many methods.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private static final int EPSILON = 2; // a constant epsilon for accuracy
    private List<HitListener> hitListeners = new ArrayList<HitListener>();
    /**
     * a constructor.
     * @param rectangle .
     * @param color .
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }
    @Override
    /**
     * the method return the collision rectangle.
     * @return the element.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * the method draw the block.
     * @param d .
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int x = (int) this.rectangle.getUpperLeft().getX();
        int y = (int) this.rectangle.getUpperLeft().getY();
        d.fillRectangle(x, y, (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }
    @Override
    /**
     * the method is empty.
     */
    public void timePassed() {
    }
    /**
     * the method add the block to the game.
     * @param g .
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    @Override
    /**
     * the method change the velocity of the ball when touching the block.
     * @param collisionPoint .
     * @param currentVelocity .
     * @return a new velocity of the ball.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
    if (collisionPoint.getY() <= this.rectangle.getUpperLine().start().getY() + EPSILON) {
        return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
    }
        if (collisionPoint.getY() + EPSILON >= this.rectangle.getDownLine().start().getY()) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        if (collisionPoint.getX() >= this.rectangle.getLeftLine().start().getX() - EPSILON) {
            if (collisionPoint.getY() <= this.rectangle.getUpperLine().start().getY() + EPSILON) {
                return new Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());
            }
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        if (collisionPoint.getX() <= this.rectangle.getRightLine().start().getX() + EPSILON) {
            if (collisionPoint.getY() <= this.rectangle.getUpperLine().start().getY() + EPSILON) {
                return new Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());
            }
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        return new Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());
    }
    /**
     * the method remove the block from the game.
     * @param gameLevel .
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * the method notify all listeners about a hit event.
     * @param hitter .
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * the method set a new color.
     * @param colorOfBall .
     */
    public void setColor(Color colorOfBall) {
        this.color = colorOfBall;
    }
}
