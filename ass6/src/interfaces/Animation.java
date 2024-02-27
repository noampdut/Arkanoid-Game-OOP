//Noam Pdut ID 315097113
package interfaces;
import biuoop.DrawSurface;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the Animation interface.
 */
public interface Animation {
    /**
     * the method responsible of the animation's frame.
     * and hold the logic from the previous run method.
     * @param d .
     */
    void doOneFrame(DrawSurface d);
    /**
     * the method check if the animation should stop and returns true if so.
     * @return boolean.
     */
    boolean shouldStop();
}

