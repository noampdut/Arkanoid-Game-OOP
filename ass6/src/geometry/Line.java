//Noam Pdut ID 315097113
package geometry;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class manage a line and has many methods.
 */
public class Line {
    private Point start; // the start point of the line.
    private Point end;   // the end point of the line.
    private double slope; // the slope of the line
    private double cuttingPointWithYAxis; // the cutting point af the line with axis Y.
    /**
     * a default constructor.
     * @param start .
     * @param end .
     */
    public Line(Point start, Point end) {
        this.end = end;
        this.start = start;
        this.slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        this.cuttingPointWithYAxis = this.start.getY() - (this.slope * this.start.getX());
    }
    /**
     * another constructor.
     * @param x1 .
     * @param x2 .
     * @param y1 .
     * @param y2 .
     * */
    public Line(double x1, double y1, double x2, double y2) {
     this.start = new Point(x1, y1);
     this.end = new Point(x2, y2);
     this.slope = (end.getY() - start.getY()) / (end.getX() - start.getX());
     this.cuttingPointWithYAxis = this.start.getY() - (this.slope * this.start.getX());
    }
    /**
     * returns the length of the line.
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }
    /**
     * calculates the middle point of the line.
     * @return the middle point.
     */
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;
        Point middle = new Point(middleX, middleY);
        return middle;
    }
    /**
     * returns the start point of the line.
     * @return the start point.
     */
    public Point start() {
        return this.start;
    }
    /**
     * returns the end point of the line.
     * @return the end point.
     */
    public Point end() {
        return this.end;
    }
    /**
     * check if a line is intersecting to another.
     * @param other .
     * @return 'true' if the lines are intersecting, 'false' otherwise.
     */
    public boolean isIntersecting(Line other) {
        // checking if both of lines are parallel to y.
        if (this.parallelToY() && other.parallelToY()) {
            return (parallelToYAndCut(other));
        }
        //check special case of a parallel to axis Y.
        if (isSpecial(other)) {
           return true;
        }
        // check convergence between the lines.
        if (this.convergence(other)) {
            return true;
        }
        // checking cases of parallel lines.
        if (other.slope == this.slope) {
            // checking case of a parallel to axis X.
            if (other.slope == 0) {
                return parallelToXAndCut(other);
            }
            // checking if the lines parallel or converges.
            if (other.cuttingPointWithYAxis == this.cuttingPointWithYAxis) {
                return true;
            }
            // means the lines parallel.
            return false;
        }
        // finding the cutting point between the lines and than check if on segment.
        Point cuttingPoint = findingCuttingPoint(other);
        return isPointInlineSegment(cuttingPoint.getX(), cuttingPoint.getY(), other);
    }

    /**
     * the method responsible for finding the cutting point.
     * @param other .
     * @return the cutting point.
     */
    public Point findingCuttingPoint(Line other) {
        double calculateSlope = other.slope - this.slope;
        double calculateParameters = this.cuttingPointWithYAxis - other.cuttingPointWithYAxis;
        double cuttingPointX = calculateParameters / calculateSlope;
        double cuttingPointY = other.cuttingPointWithYAxis + other.slope * cuttingPointX;

        return new Point(cuttingPointX, cuttingPointY);
    }
    /**
     * check if the cutting point is on both segments.
     * @param cuttingPointX .
     * @param cuttingPointY .
     * @param other .
     * @return 'true' if the cutting point is on both segments, 'false' otherwise.
     */
    public boolean isPointInlineSegment(double cuttingPointX, double cuttingPointY, Line other) {
        if (cuttingPointX < Math.min(this.start.getX(), this.end.getX())
                || cuttingPointX > Math.max(this.start.getX(), this.end.getX())) {
            return false;
        }
        if (cuttingPointY < Math.min(this.start.getY(), this.end.getY())
                || cuttingPointY > Math.max(this.start.getY(), this.end.getY())) {
            return false;
        }
        if (cuttingPointX < Math.min(other.start.getX(), other.end.getX())
                || cuttingPointX > Math.max(other.start.getX(), other.end.getX())) {
            return false;
        }
        if (cuttingPointY < Math.min(other.start.getY(), other.end.getY())
                || cuttingPointY > Math.max(other.start.getY(), other.end.getY())) {
            return false;
        }
        return true;
    }
    /**
     * the method responsible for finding the cutting point.
     * @param other .
     * @return the cutting point, if there is no cutting point or any special case- returns null.
     */
    public Point intersectionWith(Line other) {

        // checking special case of parallel to the axis.
        if (this.slope == other.slope) {
            if (this.cuttingPointWithYAxis != other.cuttingPointWithYAxis) {
                return null;
            }
            if (Math.max(this.start.getX(), this.end.getX()) == Math.min(other.start.getX(), other.end.getX())) {
                return new Point(Math.max(this.start.getX(), this.end.getX()), this.start.getY());
            }
            if (Math.max(other.start.getX(), other.end.getX()) == Math.min(this.start.getX(), this.end.getX())) {
                return new Point(Math.max(other.start.getX(), other.end.getX()), other.start.getY());
            }
            return null;
        }
        // checking case of parallel to axis Y.
        if (this.parallelToY() && other.parallelToY()) {
            if (this.start.getX() != other.start.getX()) {
               return null;
            }
            if (Math.max(this.start.getY(), this.end.getY()) == Math.min(other.start.getY(), other.end.getY())) {
                return new Point(this.start.getX(), Math.max(this.start.getY(), this.end.getY()));
            }
            if (Math.max(other.start.getY(), other.end.getY()) == Math.min(this.start.getY(), this.end.getY())) {
                return new Point(other.start.getX(), Math.max(other.start.getY(), other.end.getY()));
            }
            return null;
        }
        // checking case one of the line parallel to Y and the other parallel to X.
        if (this.parallelToY() && other.slope == 0) {
            if (isPointInlineSegment(this.start.getX(), other.start.getY(), this)) {
                return new Point(this.start.getX(), other.start.getY());
            }
        }
        // checking case one of the line parallel to Y and the other parallel to X.
        if (other.parallelToY() && this.slope == 0) {
            if (isPointInlineSegment(other.start.getX(), this.start.getY(), other)) {
                return new Point(other.start.getX(), this.start.getY());
            }
        }
        if (other.parallelToY()) {
            double y = (this.slope * other.start.getX()) + this.cuttingPointWithYAxis;
            if (isPointInlineSegment(other.start.getX(), y, other)) {
                return new Point(other.start.getX(), y);
            }
        }
        //checking case of convergence between the lines.
        if (convergence(other)) {
            return null;
        }
        // the default case.
        if (isIntersecting(other)) {
            return findingCuttingPoint(other);
        }
        // none of the cases- means there is no cutting point.
        return null;
    }
    /**
     * the method check if to points are equal.
     * @param other .
     * @return true if are equal, else- false.
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }
    /**
     * the method check  if two lines are convergent.
     * @param other .
     * @return true if convergent, else false.
     */
    public boolean convergence(Line other) {
    double maxX = Math.max(this.start.getX(), this.end.getX());
    double maxY = Math.max(this.start.getY(), this.end.getY());
    double otherMaxX = Math.max(other.start.getX(), other.end.getX());
    double otherMaxY = Math.max(other.start.getY(), other.end.getY());
    double minX = Math.min(this.start.getX(), this.end.getX());
    double minY = Math.min(this.start.getY(), this.end.getY());
    double otherMinX = Math.max(other.start.getX(), other.end.getX());
    double otherMinY = Math.max(other.start.getY(), other.end.getY());
    // in order to be convergent they must have the same slope.
    if (this.slope != other.slope) {
        return false;
    }

    if (otherMaxX <= maxX && otherMinX >= minX && otherMaxY <= maxY && otherMinY >= minY) {
        return true;
    }
        return maxX <= otherMaxX && minX >= otherMinX && maxY <= otherMaxY && minY >= otherMinY;
    }

    /**
     * the method check special case if the line parallel to Y and the other do not.
     * @param other .
     * @return true if parallel to Y, else false.
     */
    public boolean isSpecial(Line other) {
        // checking the X of the two lines
        if (other.start.getX() == other.end.getX() && this.start.getX() != this.end.getX()) {
            return true;
        }
        if (this.start.getX() == this.end.getX() && other.start.getX() != other.end.getX()) {
            return true;
        }
        return false;
    }
    /**
     * the method check special case if the line parallel to Y.
     * @return true if parallel to Y, else false.
     */
    public boolean parallelToY() {
        if (this.start.getX() == this.end.getX()) {
                return true;
        }
        return false;
    }
    /**
     * the method check special case if the lines are parallel to Y and have a cutting point.
     * @param other .
     * @return true, else false.
     */
    public boolean parallelToYAndCut(Line other) {
        // if they do not have the same X they have not a common cut point.
        if (other.start.getX() != this.start.getX()) {
            return false;

        // checking if the lines have at list one common point
        } else if (partlyConvergence(other) || convergence(other)) {
            return true;
        }
        // have the same X but have not a common point.
        return false;
    }
    /**
     * the method check special case if the line parallel to X and the other do not.
     * @param other .
     * @return true if parallel to X, else false.
     */
    public boolean parallelToXAndCut(Line other) {
        // if they do not have the same X they have not a common cut point.
        if (this.slope == 0 && other.slope == 0) {
            // checking if the lines have at list one common point
            if (partlyConvergence(other) || convergence(other)) {
                return true;
            }
        }
        // have the same Y but have not a common point.
        return false;
    }
    /**
     * the method check special case if a parallel line is partly convergent into the other.
     * @param other .
     * @return true if partly convergent, else false.
     */
    public boolean partlyConvergence(Line other) {
        // when they have the same X;
        if (this.end.getY() < other.start.getY() && this.start.getY() > other.end.getY()) {
            return true;
        }
        if (other.end.getY() < this.start.getY() && other.start.getY() > this.end.getY()) {
            return true;
        }
        // in case on having the same Y
        if (this.end.getX() < other.start.getX() && this.start.getX() > other.end.getX()) {
            return true;
        }
        if (other.end.getX() < this.start.getX() && other.start.getX() > this.end.getX()) {
            return true;
        }
        return false;
    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    /**
     * the method return the closet intersection points of a line.
     * @param rect   .
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
      double min = 3000;
      int indexMin = -1;
      // arrays of intersection points
      Point[] arr = new Point[5];
      arr[0] = intersectionWith(rect.getUpperLine());
      arr[1] = intersectionWith(rect.getLeftLine());
      arr[2] = intersectionWith(rect.getDownLine());
      arr[3] = intersectionWith(rect.getRightLine());
      // the for loop find the closet intersection point
      for (int i = 0; i < arr.length; i++) {
          if (arr[i] == null) {
              continue;
          }
          if (min > arr[i].distance(this.start())) {
              min = arr[i].distance(this.start());
              indexMin = i;
          }
      }
      // means - there is no intersection points
      if (indexMin == -1) {
          return null;
      } else {
          return arr[indexMin];
      }
    }
}



