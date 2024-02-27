//Noam Pdut ID 315097113
package levels;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.BackGround;
import sprites.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the LevelOne hold the information of level one.
 */
public class LevelOne implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l1 = new ArrayList<>();
        l1.add(new Velocity(0, 3));
        return l1;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        // the background is a sprite with a special draw
        BackGround backGround = new BackGround(levelName(), Color.black);
        return backGround;
    }

    @Override
    public List<Block> blocks() {
       List<Block> block = new ArrayList<>();
       Color color = Color.red;
       Block b1 = new Block(new Rectangle(new Point(365, 205), 50, 50), color);
       block.add(b1);
       return block;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
    @Override
    public Point paddleStartsPoint() {
        return new Point(350, 575);
    }
    @Override
    public Point paddleMiddlePoint() {
        return new Point(400, 575);
    }
    @Override
    public Color paddleColor() {
        return Color.red;
    }
}
