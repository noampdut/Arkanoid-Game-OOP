//Noam Pdut ID 315097113
package management;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
import java.awt.Color;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class presents the end screen depends if the player win or lose.
 * the class presents a new screen and implements Animation class.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop; // if the animation should stop
    private String winOrLose; // by using the string the class show the right screen
    private Counter score; // the score until now
    /**
     * a constructor.
     * @param k .
     * @param score .
     * @param winOrLose .
     */
    public EndScreen(KeyboardSensor k, String winOrLose, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.winOrLose = winOrLose;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        // in case of win situation.
        if (winOrLose.equals("WINNER")) {
            d.drawText(200, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 25);
        }
        // in case the player lose.
        if (winOrLose.equals("LOSER")) {
            d.drawText(200, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(), 25);
        }
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
