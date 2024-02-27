//Noam Pdut ID 315097113
package sprites;
import biuoop.DrawSurface;
import interfaces.Sprite;
import java.awt.Color;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class implements Sprite
 * and display the back goround of each level.
 */
public class BackGround implements Sprite {
    private String nameOfLevel; // the name of level
    private Color color; // the color of the background
    /**
     * a constructor.
     * @param color .
     * @param nameOfLevel .
     */
    public BackGround(String nameOfLevel, Color color) {
        this.nameOfLevel = nameOfLevel;
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 800);
    }

    @Override
    public void timePassed() {

    }
}
