//Noam Pdut ID 315097113
package sprites;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import management.GameLevel;

import java.awt.Color;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class manage a paddle and has many methods.
 * the paddle moves and change the velocity of the ball after hitting him.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard; // the keyboard in order to move
    private Rectangle rectangle; // thee paddle is a rectangle
    private Color color; // the paddle's color
    private static final int NUMBER_OF_MOVES = 3; // static number of moves when calling move left of right functions
    private static final int NUMBER_OF_REGIONS = 5; // static number of regions
    /**
     * a constructor.
     * @param keyboard .
     * @param rectangle .
     * @param color .
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rectangle, Color color) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.color = color;
    }
    /**
     * the function responsible for moving the paddle left.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() <= 25) {
            return;
        }
        this.rectangle.setDownRight(rectangle.getDownLeft());
        this.rectangle.setUpperRight(rectangle.getUpperLeft());
        rectangle.getUpperLeft().setX(rectangle.getUpperLeft().getX() - NUMBER_OF_MOVES);
        rectangle.getDownLeft().setX(rectangle.getDownLeft().getX() - NUMBER_OF_MOVES);
    }
    /**
     * the function responsible for moving the paddle right.
     */
    public void moveRight() {
        if (this.rectangle.getUpperRight().getX() >= 775 - this.rectangle.getWidth()) {
            return;
        }
        this.rectangle.setDownLeft(rectangle.getDownRight());
        this.rectangle.setUpperLeft(rectangle.getUpperRight());
        rectangle.getDownRight().setX(rectangle.getDownRight().getX() + NUMBER_OF_MOVES);
        rectangle.getUpperRight().setX(rectangle.getUpperRight().getX() + NUMBER_OF_MOVES);
    }
    // Interfaces.Sprite
    /**
     * the function responsible for moving the paddle, when the user click the left of right key.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    /**
     * the function responsible for drawing the paddle.
     * @param d .
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int x = (int) this.rectangle.getUpperLeft().getX();
        int y = (int) this.rectangle.getUpperLeft().getY();
        d.fillRectangle(x, y, (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }
    // Interfaces.Collidable
    /**
     * the function responsible for return the rectangle.
     * @return the element .
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * the function responsible for setting the velocity after hitting the paddle.
     * @param collisionPoint .
     * @param currentVelocity .
     * @param hitter .
     * @return a new velocity .
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // creating a vector.
        double vector = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        // divide the paddle into 5 regions.
        double regionLength = rectangle.getWidth() / NUMBER_OF_REGIONS;
        // creating 6 points for 5 regions
        Point one   = rectangle.getUpperLeft();
        Point two   = new Point(rectangle.getUpperLeft().getX() + regionLength, rectangle.getUpperLeft().getY());
        Point three = new Point(rectangle.getUpperLeft().getX() + 2 * regionLength, rectangle.getUpperLeft().getY());
        Point four  = new Point(rectangle.getUpperLeft().getX() + 3 * regionLength, rectangle.getUpperLeft().getY());
        Point five  = new Point(rectangle.getUpperLeft().getX() + 4 * regionLength, rectangle.getUpperLeft().getY());
        Point six   = new Point(rectangle.getUpperLeft().getX() + 5 * regionLength, rectangle.getUpperLeft().getY());

        //checking the collision point and his region, after that set the velocity as needed
        if (collisionPoint.getX()  <= two.getX() && collisionPoint.getX()  >= one.getX()) {
            return currentVelocity.fromAngleAndSpeed(300, vector);
        }
        if (collisionPoint.getX() <= three.getX() && collisionPoint.getX()  >= two.getX()) {
            return currentVelocity.fromAngleAndSpeed(330, vector);
        }
        if (collisionPoint.getX() <= four.getX() && collisionPoint.getX()  >= three.getX()) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        if (collisionPoint.getX()  <= five.getX() && collisionPoint.getX()  >= four.getX()) {
            return currentVelocity.fromAngleAndSpeed(30, vector);
        }
        if (collisionPoint.getX()  <= six.getX() && collisionPoint.getX()  >= five.getX()) {
            return currentVelocity.fromAngleAndSpeed(60, vector);
        }
        //worse case- instead of putting NULL
        //return new Geometry.Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());
        return currentVelocity;
    }
    /**
     * the function responsible for adding the paddle to the game.
     * @param g .
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
