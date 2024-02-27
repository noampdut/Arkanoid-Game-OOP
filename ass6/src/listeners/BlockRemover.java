//Noam Pdut ID 315097113
package listeners;
import interfaces.HitListener;
import management.Counter;
import management.GameLevel;
import sprites.Ball;
import sprites.Block;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**
     * a constructor.
     * @param gameLevel .
     * @param removedBlocks .
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }
   @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // Blocks that are hit should be removed from the game.
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
        remainingBlocks.decrease(1);
    }
}
