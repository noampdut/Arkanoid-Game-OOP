//Noam Pdut ID 315097113
package interfaces;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the HitNotifier interface.
 * The HitNotifier interface indicate the objects that implement it to send notifications when they are being hit.
 */
public interface HitNotifier {
    /**
     * This method responsible of adding hl as a listener to hit events.
     * @param hl .
     */
    void addHitListener(HitListener hl);
    /**
     * This method responsible to remove hl as a listener to hit events.
     * @param hl .
     */
    void removeHitListener(HitListener hl);
}
