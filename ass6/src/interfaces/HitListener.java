//Noam Pdut ID 315097113
package interfaces;
import sprites.Ball;
import sprites.Block;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the HitListener interface.
 * the HitListener responsible of a method that called whenever the beingHit object is hit.
 * the method make a change on the game when the object is hit.
 * Objects that want to be notified of hit events, should implement this interface
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the sprites.Ball that's doing the hitting.
     * @param beingHit .
     * @param hitter .
     */
    void hitEvent(Block beingHit, Ball hitter);
}

