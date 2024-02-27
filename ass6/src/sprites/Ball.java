//Noam Pdut ID 315097113
package sprites;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Sprite;
import biuoop.DrawSurface;
import management.GameLevel;
import management.GameEnvironment;
/**
 * @author Noam Pdut <noampdut@gmail.com>
 * the class manage a ball and has many methods.
 */
public class Ball implements Sprite {
    private int radius; // the radius of the ball
    private Point center; // the center point of the ball
    private java.awt.Color color; // the color of the ball
    private Velocity velocity; // the velocity of the ball
    private GameEnvironment gameEnvironment;
    private final int widthAndHeight = 200; // a constant- the size of the gui from ass2

    /**
     * a constructor.
     *
     * @param center          .
     * @param r               .
     * @param color           .
     * @param gameEnvironment .
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.radius = r;
        this.center = center;
        this.color = color;
        this.velocity = new Velocity(0, 0); //תוסף
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * another constructor - that create a center point.
     *
     * @param centerX         .
     * @param centerY         .
     * @param color           .
     * @param r               .
     * @param gameEnvironment .
     */
    public Ball(double centerX, double centerY, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.radius = r;
        this.color = color;
        this.center = new Point(centerX, centerY);
        this.velocity = new Velocity(0, 0);
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * the method return the X of the center point.
     *
     * @return the element.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * the method return the Y of the center point.
     *
     * @return the element.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * the method return the radius of the point.
     *
     * @return the element.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * the method return the color of the point.
     *
     * @return the element.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * the method draw the ball on the surface.
     *
     * @param surface .
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle(getX(), getY(), getSize());
    }

    /**
     * the method call the function moveOneStep().
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * the method set the ball velocity.
     *
     * @param v .
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * the method set the ball velocity  by creating first the velocity.
     *
     * @param dx .
     * @param dy .
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * the method return the velocity of the point.
     *
     * @return the element.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * the method set the radius to a legal one.
     *
     * @param guiSize .
     */
    public void checkingBallSize(int guiSize) {
        // change the size of the ball in this case.
        if (this.getSize() <= 0 || this.getSize() > guiSize / 2) {
            this.setRadius(30);
        }
    }
    /**
     * the method set the radius.
     *
     * @param r .
     */
    public void setRadius(int r) {
        this.radius = r;
    }
    /**
     * the same method as above but with parameters. ass 2
     * the method responsible for make a move of the ball.
     * the method check that the ball is not out of the frame.
     * the method set the velocity each time the ball touch the frame.
     *
     * @param endFrame   .
     * @param startFrame .
     */
    public void moveOneStep(int startFrame, int endFrame) {
        ballIntoFrame(startFrame, endFrame);
        if (this.center.getX() + this.radius == endFrame || this.center.getX() - this.radius == startFrame) {
            this.setVelocity(-1 * getVelocity().getDx(), getVelocity().getDy());
        }
        if (this.center.getY() + this.radius == endFrame || this.center.getY() - this.radius == startFrame) {
            this.setVelocity(getVelocity().getDx(), -1 * getVelocity().getDy());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
        ballIntoFrame(startFrame, endFrame);
    }

    /**
     * the same method as above but with parameters. ass2
     * the method check that the ball is not out of the frame.
     * the method set the center point of the ball.
     *
     * @param startFrame .
     * @param endFrame   .
     */
    public void ballIntoFrame(int startFrame, int endFrame) {
        if (this.center.getX() < this.radius + startFrame) {
            this.center = new Point(this.radius + startFrame, this.center.getY());
        }
        if (this.center.getY() < this.radius + startFrame) {
            this.center = new Point(this.center.getX(), this.radius + startFrame);
        }
        if (this.center.getX() > endFrame - this.radius) {
            this.center = new Point(endFrame - this.radius, this.center.getY());
        }
        if (this.center.getY() > endFrame - this.radius) {
            this.center = new Point(this.center.getX(), endFrame - this.radius);
        }
    }
    /**
     * the method check if the paddle was hit and change his velocity.
     *
     */
    public void paddleWasHit() {
        // creating a vector.
        double vector = Math.sqrt(Math.pow(velocity.getDx(), 2) + Math.pow(velocity.getDy(), 2));
        // divide the paddle into 5 regions.
        double regionLength = gameEnvironment.getCollidableList().get(4).getCollisionRectangle().getWidth() / 5;
        Rectangle paddle = gameEnvironment.getCollidableList().get(4).getCollisionRectangle();

        // creating 6 points for 5 regions
        Point one = paddle.getUpperLeft();
        Point two = new Point(paddle.getUpperLeft().getX() + regionLength, paddle.getUpperLeft().getY());
        Point three = new Point(paddle.getUpperLeft().getX() + 2 * regionLength, paddle.getUpperLeft().getY());
        Point four = new Point(paddle.getUpperLeft().getX() + 3 * regionLength, paddle.getUpperLeft().getY());
        Point five = new Point(paddle.getUpperLeft().getX() + 4 * regionLength, paddle.getUpperLeft().getY());
        Point six = new Point(paddle.getUpperLeft().getX() + 5 * regionLength, paddle.getUpperLeft().getY());

        if (this.center.getX() <= two.getX() && this.center.getX() >= one.getX()) {
            if (this.center.getY() + radius < paddle.getDownLine().start().getY()
                    && this.center.getY() + radius >= paddle.getUpperLine().start().getY()) {
                setVelocity(velocity.fromAngleAndSpeed(300, vector));
                return;
            }
        }
        if (this.center.getX() <= three.getX() && this.center.getX() >= two.getX()) {
            if (this.center.getY() + radius < paddle.getDownLine().start().getY()
                    && this.center.getY() + radius >= paddle.getUpperLine().start().getY()) {
                setVelocity(velocity.fromAngleAndSpeed(330, vector));
                return;
            }
        }
        if (this.center.getX() <= four.getX() && this.center.getX() >= three.getX()) {
            if (this.center.getY() + radius < paddle.getDownLine().start().getY()
                    && this.center.getY() + radius >= paddle.getUpperLine().start().getY()) {
                setVelocity(velocity.getDx(), -1 * velocity.getDy());
                return;
            }
        }
        if (this.center.getX() <= five.getX() && this.center.getX() >= four.getX()) {
            if (this.center.getY() + radius < paddle.getDownLine().start().getY()
                    && this.center.getY() + radius >= paddle.getUpperLine().start().getY()) {
                setVelocity(velocity.fromAngleAndSpeed(30, vector));
                return;
            }
        }
        if (this.center.getX() <= six.getX() && this.center.getX() >= five.getX()) {
            if (this.center.getY() + radius < paddle.getDownLine().start().getY()
                    && this.center.getY() + radius >= paddle.getUpperLine().start().getY()) {
                setVelocity(velocity.fromAngleAndSpeed(60, vector));
                return;
            }
        }
    }
    /**
     * the method add the ball into the game.
     *
     * @param g .
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * the method responsible to remove a sprite from the game.
     *
     * @param g .
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
    /**
     * the method responsible for bringing back the ball into frame.
     *
     * @param trajectory .
     */
    public void ballIntoFrame(Line trajectory) {
        double right = gameEnvironment.getCollidableList().get(3).getCollisionRectangle().getLeftLine().end().getX();
        double left = gameEnvironment.getCollidableList().get(2).getCollisionRectangle().getRightLine().end().getX();
        double top = gameEnvironment.getCollidableList().get(0).getCollisionRectangle().getDownLine().end().getY();
        double downer = gameEnvironment.getCollidableList().get(1).getCollisionRectangle().getUpperLine().end().getY();
        Rectangle paddle = gameEnvironment.getCollidableList().get(4).getCollisionRectangle();
        // for the last case - the collision object is needed.
        Rectangle block = gameEnvironment.getClosestCollision(trajectory).collisionObject().getCollisionRectangle();
        // flag if the ball is out of frame

        int flag = 0;
        // checking the left side of the frame
        if (this.center.getX() < left + this.radius) {
            this.center = new Point(left + this.radius, this.center.getY());
            flag = 1;
        }
        // checking the top side of the frame
        if (this.center.getY() < top + this.radius) {
            this.center = new Point(this.center.getX(), top + this.radius);
            flag = 2;
        }
        // checking the right side of the frame
        if (this.center.getX() > right - this.radius) {
            this.center = new Point(right - this.radius, this.center.getY());
            flag = 3;
        }
        // checking the downer side of the frame
        if (this.center.getY() > downer - this.radius) {
            this.center = new Point(this.center.getX(), downer - this.radius);
            flag = 4;
        }
        // checking special case - the ball is into a inner block. if his x between the two lines.
        if (this.center.getY() != downer
                && this.center.getX() > gameEnvironment.getClosestCollision(trajectory).collisionPoint().getX()
                && flag == 0
                && block != paddle
                && gameEnvironment.getClosestCollision(trajectory).collisionPoint().getX()
                < block.getRightLine().start().getX()) {
            double x = gameEnvironment.getClosestCollision(trajectory).collisionPoint().getX() - this.radius;
            double y = this.center.getY();
            this.center = new Point(x, y);
        }
    }
    /**
     * the method responsible for moving the ball.
     */
    public void moveOneStep() {
        Line trajectory = new Line(center, velocity.applyToPoint(center));
        // in case there is no collision point
        Rectangle paddle = gameEnvironment.getCollidableList().get(4).getCollisionRectangle();
        // checking if the ball hit the paddle
        if (this.center.getY() + radius >= paddle.getUpperLeft().getY()
                && this.center.getY() <= paddle.getDownLeft().getY()) {
            if (this.center.getX() >= paddle.getUpperLeft().getX()
                    && this.center.getX() <= paddle.getUpperLeft().getX() + paddle.getWidth()) {
                Point p = new Point(this.center.getX(), paddle.getUpperLeft().getY() - radius);
                this.center = p;
                paddleWasHit();
                this.center = this.getVelocity().applyToPoint(center);
                moveOneStep();
                return;
            }
        }
        if (this.gameEnvironment.getClosestCollision(trajectory) == null) {
            this.center = this.getVelocity().applyToPoint(center);
        } else {
            this.center = new Point(gameEnvironment.getClosestCollision(trajectory).collisionPoint().getX(),
                    gameEnvironment.getClosestCollision(trajectory).collisionPoint().getY());
            // the third frame on the list!
            Point right = gameEnvironment.getCollidableList().get(3).getCollisionRectangle().getLeftLine().end();
            if (center.getX() == right.getX()) {
                this.center = new Point(center.getX() - velocity.getDx(), center.getY() - velocity.getDy());
            }
            // check if the ball is into the frame.
            ballIntoFrame(trajectory);
            // set the velocity by calling the Hit function that change the velocity in case of collision
            setVelocity(gameEnvironment.getClosestCollision(trajectory).collisionObject()
                    .hit(this, center, getVelocity()));
            // change the center in order to move the ball
            this.center = this.getVelocity().applyToPoint(center);
            // check again that the ball is not out of the frame
            // ballIntoFrame(trajectory);
        }
    }
// the unneeded functions from ass2
/**
 /**
 * the method responsible for make a move of the ball.
 * the method check that the ball is not out of the frame.
 * the method set the velocity each time the ball touch the frame.
 */
/**
 public void moveOneStep() {
 //checking first the ball is not out of the frame.
 ballIntoFrame();
 // checking his location and change the velocity each time the ball touch the frame.
 if (this.center.getX() + this.radius == widthAndHeight || this.center.getX() - this.radius == 0) {
 this.setVelocity(-1 * getVelocity().getDx(), getVelocity().getDy());
 }
 if (this.center.getY() + this.radius == widthAndHeight || this.center.getY() - this.radius == 0) {
 this.setVelocity(getVelocity().getDx(), -1 * getVelocity().getDy());
 }
 this.center = this.getVelocity().applyToPoint(this.center);
 //check again the ball is not out of the frame.
 ballIntoFrame();
 }
 /**
 * the method check that the ball is not out of the frame.
 * the method set the center point of the ball.
 */
/**
 public void ballIntoFrame() {
 if (this.center.getX() < this.radius) {
 this.center = new Geometry.Point(this.radius, this.center.getY());
 }
 if (this.center.getY() < this.radius) {
 this.center = new Geometry.Point(this.center.getX(), this.radius);
 }
 if (this.center.getX() > widthAndHeight - this.radius) {
 this.center = new Geometry.Point(widthAndHeight - this.radius, this.center.getY());
 }
 if (this.center.getY() > widthAndHeight - this.radius) {
 this.center = new Geometry.Point(this.center.getX(), widthAndHeight - this.radius);
 }
 }
 */
}
