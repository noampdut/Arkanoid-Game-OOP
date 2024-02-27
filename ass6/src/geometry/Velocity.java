//Noam Pdut ID 315097113
package geometry;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class manage a velocity of a ball and has many methods.
 */
public class Velocity {
    private double dx; // the dx of the point.
    private double dy; // the dy of the point.
    /**
     * the default constructor.
     * @param dx .
     * @param dy .
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * the method calculates the velocity in other way.
     * @param angle .
     * @param speed .
     * @return a velocity.
     */
    public Velocity fromAngleAndSpeed(double angle, double speed) {
        double dX = speed * Math.sin(Math.toRadians(angle));
        double dY = -1 * speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dX, dY);
    }
    /**
     * the method change the X and Y of the point in order to make a move.
     * @param p .
     * @return the new point.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
    /**
     * the method returns the dx od the point.
     * @return the dx.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * the method returns the dy od the point.
     * @return the dy.
     */
    public double getDy() {
        return dy;
    }
}
