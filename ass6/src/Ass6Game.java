//Noam Pdut ID 315097113
import interfaces.LevelInformation;
import levels.LevelFour;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;
import management.GameFlow;
import java.util.ArrayList;
import java.util.List;

/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class has a main function that responsile for run the game
 */
public class Ass6Game {
    /**
     * the main is responsible of running the game.
     * @param args .
     */
    public static void main(String[] args) {
        LevelOne levelOne = new LevelOne();
        LevelTwo levelTwo = new LevelTwo();
        LevelThree levelThree = new LevelThree();
        LevelFour levelFour = new LevelFour();

        List<LevelInformation> levels = new ArrayList<>();
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(levels);
        for (int i = 0; i < args.length; i++) {
            if (args[i].length() > 1) {
                continue;
            }
            int level = Integer.parseInt(args[i]);
            if (level == 1) {
                levels.add(levelOne);
            }
            if (level == 2) {
                levels.add(levelTwo);

            }
            if (level == 3) {
                levels.add(levelThree);
            }
            if (level == 4) {
                levels.add(levelFour);
            }
        }
        // in case the args are illegal of empty
        if (levels.size() == 0) {
            levels.add(levelOne);
            levels.add(levelTwo);
            levels.add(levelThree);
            levels.add(levelFour);
        }
        gameFlow.runLevels(levels);
    }
}
