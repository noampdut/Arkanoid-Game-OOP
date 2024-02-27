//Noam Pdut ID 315097113
package listeners;
import interfaces.HitListener;
import management.Counter;
import sprites.Ball;
import sprites.Block;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class listeners.ScoreTrackingListener implements Interfaces.HitListener.
 * and manage to update this counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore; // the current score on the game will be updated
    private static final int ADD_POINTS_TO_SCORE = 5; // each time the block was hit add this number to the score
    /**
     * a constructor.
     * @param scoreCounter .
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //each time the ball hit a block, add 5 points to the current score
       currentScore.setCount(currentScore.getValue() + ADD_POINTS_TO_SCORE);
    }
}
