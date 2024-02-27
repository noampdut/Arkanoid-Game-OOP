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
 * the LevelFour hold the information of level four.
 */
public class LevelFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l1 = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            l1.add(new Velocity(3 * i, 2));
        }
        return l1;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        BackGround backGround = new BackGround(levelName(), Color.lightGray);
        return backGround;
    }

    @Override
    public List<Block> blocks() {
        List<Block> block = new ArrayList<>();
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 15; i++) {
                Block b1 = new Block(new geometry.Rectangle(new Point(23 + i * 49 + i, 100 + 31 * j), 49,
                        30), Color.pink);
                block.add(b1);
                if (j == 0) {
                    b1.setColor(Color.gray);
                } else if (j == 1) {
                    b1.setColor(Color.red);
                } else if (j == 2) {
                    b1.setColor(Color.yellow);
                } else if (j == 3) {
                    b1.setColor(Color.green);
                } else if (j == 4) {
                    b1.setColor(Color.white);
                } else if (j == 5) {
                    b1.setColor(Color.pink);
                } else if (j == 6) {
                    b1.setColor(Color.cyan);
                }
            }
        }
        return block;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }

    @Override
    public Point paddleStartsPoint() {
        return new Point(350, 575);
    }

    @Override
    public Point paddleMiddlePoint() {
        return new Point(450, 575);
    }

    @Override
    public Color paddleColor() {
        return Color.yellow;
    }

}
