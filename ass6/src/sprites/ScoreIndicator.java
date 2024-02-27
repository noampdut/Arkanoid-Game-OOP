//Noam Pdut ID 315097113
package sprites;
import interfaces.Sprite;
import biuoop.DrawSurface;
import management.Counter;

import java.awt.Color;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class sprites.ScoreIndicator implements Interfaces.Sprite
 * and manage to show the score counter on the screen and the level name.
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter; // the counter
    private String levelName;
    /**
     * a constructor.
     * @param scoreCounter .
     * @param levelName .
     */
    public ScoreIndicator(Counter scoreCounter, String levelName) {
        this.scoreCounter = scoreCounter;
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.PINK);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.black);
        d.drawText(350, 15, "Score: " + scoreCounter.getValue(), 15);
        d.drawText(490, 15, "Level Name: " + levelName, 15);

    }

    @Override
    public void timePassed() {

    }
}
