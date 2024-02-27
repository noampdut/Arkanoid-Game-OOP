//Noam Pdut ID 315097113
package management;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class used for counting things.
 */
public class Counter {
    private int count = 0; // the counter
    /**
     * the method used for increase a number from the current count.
     * @param number .
     */
    public void increase(int number) {
        this.count += number;
    }
    /**
     * the method used for decrease a number from the current count.
     * @param number .
     */
    public void decrease(int number) {
        this.count -= number;
    }
    /**
     * the method return the current count.
     * @return int count .
     */
    public int getValue() {
        return count;
    }
    /**
     * the method set a new count.
     * @param newCount .
     */
    public void setCount(int newCount) {
        this.count = newCount;
    }
}
