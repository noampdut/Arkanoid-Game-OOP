//Noam Pdut ID 315097113
package listeners;
import interfaces.HitListener;
import management.Counter;
import management.GameLevel;
import sprites.Ball;
import sprites.Block;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class a BallRemover is in charge of removing balls from the game, as well as keeping count
 * of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;              // a field of the game
    private Counter remainingBalls; // a field of a counter remaining blocks
    /**
     * a constructor.
     * @param gameLevel .
     * @param remainingBalls .
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        this.remainingBalls.decrease(1);
    }
}
