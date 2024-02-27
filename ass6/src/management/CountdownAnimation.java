//Noam Pdut ID 315097113
package management;
import biuoop.DrawSurface;
import interfaces.Animation;
import sprites.SpriteCollection;
import java.awt.Color;

/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    /**
     * a constructor.
     * @param countFrom .
     * @param gameScreen .
     * @param numOfSeconds .
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
    }
    /**
     * the method return the number of seconds.
     * @return double number of seconds.
     */
    public double getNumOfSeconds() {
        return numOfSeconds;
    }
    /**
     * the method return the number we start counting from.
     * @return int number of start counting from.
     */
    public int getCountFrom() {
        return countFrom;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.pink);
        d.drawText(370, 100, String.valueOf(countFrom), 70);
        countFrom--;
    }
    @Override
    public boolean shouldStop() {
        if (countFrom == 0) {
            return true;
        }
        return false;
    }
}

