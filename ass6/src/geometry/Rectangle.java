//Noam Pdut ID 315097113
package geometry;
import java.util.ArrayList;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class manage a rectangle.
 * the rectangle created by 4 lines and 4 points, has a width and height.
 */
public class Rectangle {
    private double width;
    private double height;
    //his 4 points
    private Point upperLeft;
    private Point upperRight;
    private Point downLeft;
    private Point downRight;
    // his 4 lines
    private Line upperLine;
    private Line leftLine;
    private Line downLine;
    private Line rightLine;
    /**
     * constructor.
     * @param width .
     * @param upperLeft .
     * @param height .
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.height = height;
        this.upperLeft = upperLeft;
        this.width = width;
        //points
        this.upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.downLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        this.downRight =  new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        //lines
        this.upperLine = new Line(this.upperLeft, this.upperRight);
        this.leftLine = new Line(this.upperLeft, this.downLeft);
        this.downLine = new Line(this.downLeft, downRight);
        this.rightLine = new Line(this.upperRight, this.downRight);
    }
    /**
     * the method return the width of the center point.
     * @return the element.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * the method return the height of the center point.
     * @return the element.
     */
    public double getHeight() {
        return  this.height;
    }
    /**
     * the method return the upper line of the center point.
     * @return the element.
     */
    public Line getUpperLine() {
        return  this.upperLine;
    }
    /**
     * the method return the right line of the center point.
     * @return the element.
     */
    public Line getRightLine() {
        return rightLine;
    }
    /**
     * the method return the left line of the center point.
     * @return the element.
     */
    public Line getLeftLine() {
        return leftLine;
    }
    /**
     * the method return the down line of the center point.
     * @return the element.
     */
    public Line getDownLine() {
        return downLine;
    }
    /**
     * the method return the upper line of the center point.
     * @return the element.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * the method set the down left point velocity.
     * @param downAndLeft .
     */
    public void setDownLeft(Point downAndLeft) {
        this.downLeft = downAndLeft;
    }
    /**
     * the method set the down right point velocity.
     * @param downAndRight .
     */
    public void setDownRight(Point downAndRight) {
        this.downRight = downAndRight;
    }
    /**
     * the method set the upper left point velocity.
     * @param upAndLeft .
     */
    public void setUpperLeft(Point upAndLeft) {
        this.upperLeft = upAndLeft;
    }
    /**
     * the method set the upper right point velocity.
     * @param upAndRight .
     */
    public void setUpperRight(Point upAndRight) {
        this.upperRight = upAndRight;
    }
    /**
     * the method return the down left point of the center point.
     * @return the element.
     */
    public Point getDownLeft() {
        return downLeft;
    }
    /**
     * the method return the upper right point of the center point.
     * @return the element.
     */
    public Point getUpperRight() {
        return upperRight;
    }
    /**
     * the method return the down right point of the center point.
     * @return the element.
     */
    public Point getDownRight() {
        return downRight;
    }
    /**
     * the method return a list of intersection points.
     * @param line .
     * @return a list of points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> cuttingPoints = new ArrayList<>();
        if (line.intersectionWith(getUpperLine()) != null) {
            cuttingPoints.add(line.intersectionWith(getUpperLine()));
        }
        if (line.intersectionWith(getLeftLine()) != null) {
            cuttingPoints.add(line.intersectionWith(getLeftLine()));
        }
        if (line.intersectionWith(getDownLine()) != null) {
            cuttingPoints.add(line.intersectionWith(getDownLine()));
        }
        if (line.intersectionWith(getRightLine()) != null) {
            cuttingPoints.add(line.intersectionWith(getRightLine()));
        }
        return cuttingPoints;
    }
}
