//Noam Pdut ID 315097113
package sprites;
import interfaces.Sprite;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class manage a sprite collection - al sprite list, and has many methods.
 */
public class SpriteCollection {
    private List<Sprite> spriteList;
    /**
     * a constructor.
     * @param spriteList .
     */
    public SpriteCollection(List<Sprite> spriteList) {
        // create an array list of sprites
        this.spriteList = new ArrayList<>();
    }
    /**
     * the method add a sprite to the list.
     * @param s .
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }
    /**
     * the method call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteListTwo = new ArrayList<>(spriteList);
        for (Sprite sprite: spriteListTwo) {
            sprite.timePassed();
        }
    }
    /**
     * the method call drawOn(d) on all sprites.
     * @param d .
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> spriteListTwo = new ArrayList<>(spriteList);
        for (Sprite sprite: spriteListTwo) {
            sprite.drawOn(d);
        }
    }
    /**
     * the method remove a sprite from the list.
     * @param s .
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }
}