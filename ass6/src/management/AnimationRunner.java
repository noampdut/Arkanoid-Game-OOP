//Noam Pdut ID 315097113
package management;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the AnimationRunner class takes an Animation object and runs it.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    private String levelName;
    /**
     * a constructor.
     * @param levelName .
     * @param gui .
     */
    public AnimationRunner(GUI gui, String levelName) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
        this.levelName = levelName;
    }
    /**
     * the method drive the game.
     * @param animation .
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
    /**
     * the method drive the count down Animation the bonus part of ass6.
     * @param countdownAnimation .
     */
    public void run(CountdownAnimation countdownAnimation) {

        long milliSecondLeftToSleep =
                (long) countdownAnimation.getNumOfSeconds() * 1000 / countdownAnimation.getCountFrom();
        while (!countdownAnimation.shouldStop()) {
            DrawSurface d = gui.getDrawSurface();

            countdownAnimation.doOneFrame(d);

            gui.show(d);
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
