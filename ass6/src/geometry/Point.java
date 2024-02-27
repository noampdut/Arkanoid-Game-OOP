//Noam Pdut ID 315097113
package geometry;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class manage a point and has many methods.
 */
public class Point {

    private  double x; // the X of the point.
    private  double y; // the Y of the point.

    /**
     * constructor.
     * @param x .
     * @param y .
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * check if a point equals to another.
     * @param other .
     * @return 'true' if the points are equal, 'false' otherwise.
     */
    public boolean equals(Point other) {
        return (other.getX() == this.getX()) && (other.getY() == this.getY());
    }
    /**
     * the method calculates the distance between two points.
     * @param other .
     * @return a distance.
     */
    public double distance(Point other) {
        double lengthPartOne = Math.pow((other.getX()) - this.x, 2);
        double lengthPartTwo = Math.pow((other.getY()) - this.y, 2);
        return (Math.sqrt(lengthPartOne + lengthPartTwo));
    }
    /**
     * the method return the X of the point.
     * @return the element.
     */
    public double getX() {
        return this.x;
    }

    /**
     * the method return the Y of the point.
     * @return the element.
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param number
     * the method set the X of the point.
     */
    public void setX(double number) {
        this.x = number;
    }

    /**
     *  * @param number
     * the method set the Y of the point.
     */
    public void setY(double number) {
        this.y = number;
    }

}
