//Noam Pdut ID 315097113
package interfaces;
import biuoop.DrawSurface;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the sprite interface.
 */
public interface Sprite {
    /**
     * the method draw the sprite on the screen.
     * @param d .
     */
    void drawOn(DrawSurface d);
    // notify the sprite that time has passed
    /**
     * the method notify the sprite that time has passed.
     */
    void timePassed();
}
