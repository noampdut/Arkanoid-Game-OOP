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
 * the LevelThree hold the information of level three.
 */
public class LevelThree implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l1 = new ArrayList<>();
        l1.add(new Velocity(2, 3));
        l1.add(new Velocity(2, 3));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        BackGround backGround = new BackGround(levelName(), Color.green);
        return backGround;
    }

    @Override
    public List<Block> blocks() {
        Color color = Color.gray;
        List<Block> block = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Block b1 = new Block(new geometry.Rectangle(new Point(266 + i * 50 + i, 174), 50, 30),
                    color);
            block.add(b1);
        }
        color = Color.red;
        for (int i = 0; i < 9; i++) {
            Block b1 = new Block(new geometry.Rectangle(new Point(317 + i * 50 + i, 205), 50, 30),
                    color);
            block.add(b1);

        }
        color =  Color.yellow;
        for (int i = 0; i < 8; i++) {
            Block b1 = new Block(new geometry.Rectangle(new Point(368 + i * 50 + i, 236), 50, 30),
                    color);
            block.add(b1);
        }
        color = Color.blue;
        for (int i = 0; i < 7; i++) {
            Block b1 = new Block(new Rectangle(new Point(419 + i * 50 + i, 267), 50, 30), color);
            block.add(b1);
        }
        color = Color.white;
        for (int i = 0; i < 6; i++) {
            Block b1 = new Block(new Rectangle(new Point(470 + i * 50 + i, 298), 50, 30), color);
            block.add(b1);
        }
        return block;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }

    @Override
    public Point paddleStartsPoint() {
        return new Point(350, 576);
    }

    @Override
    public Point paddleMiddlePoint() {
        return new Point(450, 576);
    }

    @Override
    public Color paddleColor() {
        return Color.yellow;
    }
}
