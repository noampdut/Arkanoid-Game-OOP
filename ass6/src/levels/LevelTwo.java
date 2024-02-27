//Noam Pdut ID 315097113
package levels;
import geometry.Point;
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
 * the LevelTwo hold the information of level two.
 */
public class LevelTwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l1 = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            l1.add(new Velocity(2 * i, 3));
        }
        return l1;
    }
    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 650;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        BackGround backGround = new BackGround(levelName(), Color.white);
        return backGround;
    }
    @Override
    public List<Block> blocks() {
        List<Block> block = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Block b1 = new Block(new geometry.Rectangle(new Point(23 + i * 49 + i, 310), 49, 30),
                    Color.pink);
            if (i < 2) {
                b1.setColor(Color.red);
            } else if (i < 4) {
                b1.setColor(Color.orange);
            } else if (i < 6) {
                b1.setColor(Color.yellow);
            } else if (i < 9) {
                b1.setColor(Color.green);
            } else if (i < 11) {
                b1.setColor(Color.blue);
            } else if (i < 13) {
                b1.setColor(Color.pink);
            } else {
                b1.setColor(Color.cyan);
            }
            block.add(b1);
        }
        return block;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
    @Override
    public Point paddleStartsPoint() {
        return new Point(60, 575);
    }
    @Override
    public Point paddleMiddlePoint() {
        return new Point(60 + (paddleWidth() / 2), 575);
    }
    @Override
    public Color paddleColor() {
        return Color.yellow;
    }
}
