//Noam Pdut ID 315097113
package management;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import java.util.List;

/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * This class will be in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {

   private Counter score; // the score of the game
    /**
     * a constructor.
     */
    public GameFlow() {
        this.score = new Counter();
        this.score.setCount(0);
    }
    /**
     * the method change the score.
     * @param count .
     */
    public void setScore(Counter count) {
        this.score = count;
    }
    /**
     * the method get a list of levels and run those levels.
     * @param levels .
     */
    public void runLevels(List<LevelInformation> levels) {
        int flag = 0;

        for (LevelInformation levelInfo : levels) {
            flag++;

            GameLevel level = new GameLevel(levelInfo, score);

            level.initialize();

            while (!level.shouldStop()) {
                level.run();
            }
            setScore(level.getScore());

            // check if thr game is over and the player is a loser.
            if (level.getCounterOfBalls().getValue() == 0) {
                level.getRunner().run(new KeyPressStoppableAnimation(level.getKeyboard(), KeyboardSensor.SPACE_KEY,
                        new EndScreen(level.getKeyboard(), "LOSER", score)));
                level.getGui().close();
                return;
            }
            // check if the game is over and the player is a winner.
            if (levels.get(levels.size() - 1).levelName().equals(levelInfo.levelName()) && flag == levels.size()) {
                level.getRunner().run(new KeyPressStoppableAnimation(level.getKeyboard(), KeyboardSensor.SPACE_KEY,
                        new EndScreen(level.getKeyboard(), "WINNER", score)));
                level.getGui().close();
                return;
            }
        }
    }
}


