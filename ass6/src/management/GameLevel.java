//Noam Pdut ID 315097113
package management;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import biuoop.DrawSurface;
import biuoop.GUI;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import sprites.Ball;
import sprites.Block;
import sprites.SpriteCollection;
import sprites.Paddle;
import sprites.ScoreIndicator;
import java.awt.Color;
import java.util.ArrayList;
/**
 * @author      Noam Pdut <noampdut@gmail.com>
 * the class responsible of manage the game.
 * the class mathods create the elements.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites; // the sprites
    private GameEnvironment environment; // the game environment
    private GUI gui; // the gui
    private Counter counterOfBlocks; // counter for the blocks.
    private Counter counterOfBalls; // counter for the balls.
    private Counter score;
    private static final int NUMBER_OF_BLOCKS = 57; // not relevant ass5
    private static final int NUMBER_OF_BALLS = 3; // not relevant ass5
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * a constructor.
     * @param environment .
     * @param sprites .
     * @param levelInformation .
     */
    public GameLevel(SpriteCollection sprites, GameEnvironment environment, LevelInformation levelInformation) {
        this.sprites = sprites;
        this.environment = environment;
        this.gui = new GUI("Game Window", 800, 600);
        this.levelInformation = levelInformation;
    }
    /**
     * another constructor.
     * @param levelInformation .
     * @param score .
     */
    public GameLevel(LevelInformation levelInformation, Counter score) {
        this.gui = new GUI("Game Window", 800, 600);
        this.sprites = new SpriteCollection(new ArrayList<Sprite>());
        this.environment = new GameEnvironment(new ArrayList<Collidable>());
        this.counterOfBlocks = new Counter();
        this.counterOfBalls = new Counter();
        this.levelInformation = levelInformation;
        this.runner = new AnimationRunner(this.gui, levelInformation.levelName());
        this.running = true;
        this.keyboard = gui.getKeyboardSensor();
        this.counterOfBlocks.setCount(this.levelInformation.numberOfBlocksToRemove());
        this.counterOfBalls.setCount(this.levelInformation.numberOfBalls());
        this.score = score;
    }
    /**
     * the method return the gui of the game.
     * @return the element.
     */
    public GUI getGui() {
        return gui;
    }
    /**
     * the method add a colloidal to the game.
     * @param c .
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * the method add a sprite to the game.
     * @param s .
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * the method from ass5 not relevant.
     * the method Initialize a new game: create the Blocks,Balls and sprites.Paddle
     * and add them to the game.
     */
    public void initialize1() {
        // create the balls
        Ball ballOne = new Ball(350, 355, 5, Color.darkGray, environment);
        Ball ballTwo = new Ball(400, 355, 5, Color.darkGray, environment);
        Ball ballThree = new Ball(150, 150, 5, Color.darkGray, environment);

        // set the velocity of the balls
        ballOne.setVelocity(2, 5);
        ballTwo.setVelocity(3, 2);
        ballThree.setVelocity(2, 1);

        // add the 3 balls to the game
        ballOne.addToGame(this);
        ballTwo.addToGame(this);
        ballThree.addToGame(this);
        // create four block - the gui frames
        Block topBlock = new Block(new Rectangle(new Point(20, 0), 760, 45), Color.darkGray);
        Block downBlock = new Block(new Rectangle(new Point(20, 600), 760, 15), Color.darkGray);
        Block leftBlock = new Block(new Rectangle(new Point(0, 0), 25, 600), Color.darkGray);
        Block rightBlock = new Block(new Rectangle(new Point(775, 0), 25, 600), Color.darkGray);
        // create the paddle
        Paddle player = new Paddle(keyboard, new Rectangle(new Point(450, 575), 100, 15), Color.cyan);
        // add the blocks and the paddle to the game
        topBlock.addToGame(this);
        downBlock.addToGame(this);
        leftBlock.addToGame(this);
        rightBlock.addToGame(this);
        player.addToGame(this);

        BlockRemover blockRemover = new BlockRemover(this, counterOfBlocks);
        // create the ball remover
        BallRemover ballRemover = new BallRemover(this, counterOfBalls);
        downBlock.addHitListener(ballRemover);

        ScoreTrackingListener trackingListener = new ScoreTrackingListener(score);
        // create the sprite with the score count on it.
        ScoreIndicator scoreIndicator = new ScoreIndicator(score, levelInformation.levelName());
        addSprite(scoreIndicator);
        // call a function for creating the inners blocks
        createBlocksAndToGame(blockRemover, trackingListener);
    }
    /**
     * the method run the game and start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }
    /**
     * used on ass5 only
     * the method create the inner blocks and add them to the game, and add the listeners.
     * @param blockRemover .
     * @param trackingListener .
     */
    public void createBlocksAndToGame(BlockRemover blockRemover, ScoreTrackingListener trackingListener) {
        Color color = Color.blue;
        for (int i = 0; i < 12; i++) {
            Block block = new Block(new Rectangle(new Point(164 + i * 50 + i, 110), 50, 30), color);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            // the score listener
            block.addHitListener(trackingListener);
        }
        color = Color.pink;
        for (int i = 0; i < 11; i++) {
            Block block = new Block(new Rectangle(new Point(215 + i * 50 + i, 142), 50, 30), color);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(trackingListener);
        }
        color = Color.yellow;
        for (int i = 0; i < 10; i++) {
            Block block = new Block(new Rectangle(new Point(266 + i * 50 + i, 174), 50, 30), color);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(trackingListener);

        }
        color = Color.CYAN;
        for (int i = 0; i < 9; i++) {
            Block block = new Block(new Rectangle(new Point(317 + i * 50 + i, 205), 50, 30), color);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(trackingListener);

        }
        color =  Color.MAGENTA;
        for (int i = 0; i < 8; i++) {
            Block block = new Block(new Rectangle(new Point(368 + i * 50 + i, 236), 50, 30), color);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(trackingListener);
        }
        color = Color.red;
        for (int i = 0; i < 7; i++) {
            Block block = new Block(new Rectangle(new Point(419 + i * 50 + i, 267), 50, 30), color);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(trackingListener);
        }
    }
    /**
     * The method remove a colloidal from the game.
     * @param c .
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * The method remove a sprite from the game.
     * @param s .
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        // if there is no balls or inners blocks end the game
        if (counterOfBlocks.getValue() == 0 || counterOfBalls.getValue() == 0) {
            // if the player passed a level
            if (counterOfBlocks.getValue() == 0) {
                score.setCount(score.getValue() + 100);
            }
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.getKeyboard(), KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this.getKeyboard())));
        }

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * the method Initialize a new game: create the Blocks,Balls and sprites.Paddle
     * and add them to the game.
     */
    public void initialize() {
        // add the back ground for this level
        addSprite(levelInformation.getBackground());
        // create four block - the gui frames
        Block topBlock = new Block(new Rectangle(new Point(20, 0), 760, 45), Color.darkGray);
        Block downBlock = new Block(new Rectangle(new Point(20, 600), 760, 15), Color.darkGray);
        Block leftBlock = new Block(new Rectangle(new Point(0, 0), 25, 600), Color.darkGray);
        Block rightBlock = new Block(new Rectangle(new Point(775, 0), 25, 600), Color.darkGray);

        // add the blocks and the paddle to the game
        topBlock.addToGame(this);
        downBlock.addToGame(this);
        leftBlock.addToGame(this);
        rightBlock.addToGame(this);
        BlockRemover blockRemover = new BlockRemover(this, counterOfBlocks);
        // create the ball remover
        BallRemover ballRemover = new BallRemover(this, counterOfBalls);
        downBlock.addHitListener(ballRemover);

        ScoreTrackingListener trackingListener = new ScoreTrackingListener(score);
        // create the sprite with the score count on it.
        ScoreIndicator scoreIndicator = new ScoreIndicator(score, levelInformation.levelName());
        addSprite(scoreIndicator);

        Paddle player = new Paddle(keyboard, new Rectangle(levelInformation.paddleStartsPoint(),
                levelInformation.paddleWidth(), 15), levelInformation.paddleColor());
        player.addToGame(this);
        addBallsToGame();

        for (Block block : levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(trackingListener);
        }
    }
    /**
     * the method return the level information.
     * @return LevelInformation .
     */
    public LevelInformation getLevelInformation() {
        return levelInformation;
    }
    /**
     * the method return the score.
     * @return Counter .
     */
    public Counter getScore() {
        return score;
    }
    /**
     * the method return the count Of Balls.
     * @return Counter .
     */
    public Counter getCounterOfBalls() {
        return counterOfBalls;
    }
    /**
     * the method return the runner.
     * @return AnimationRunner .
     */
    public AnimationRunner getRunner() {
        return runner;
    }
    /**
     * the method return the keyboard.
     * @return KeyboardSensor .
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }
    /**
     * the method add the balls to the game in different sizes, colors and count.
     */
    public void addBallsToGame() {
        // depends of number of balls
        if (levelInformation.numberOfBalls() == 1) {
            Ball ballOne = new Ball(levelInformation.paddleMiddlePoint().getX(),
                    570, 5, Color.blue, environment);
            ballOne.setVelocity(levelInformation.initialBallVelocities().get(0));
            ballOne.addToGame(this);
        } else if (levelInformation.numberOfBalls() == 3) {
                Ball ballOne = new Ball(levelInformation.paddleStartsPoint().getX(),
                        570, 5, Color.blue, environment);
                ballOne.setVelocity(levelInformation.initialBallVelocities().get(0));
                ballOne.addToGame(this);
                //second ball
                Ball ballTwo = new Ball(levelInformation.paddleMiddlePoint().getX(),
                        570, 5, Color.blue, environment);
                ballTwo.setVelocity(levelInformation.initialBallVelocities().get(1));
                ballTwo.addToGame(this);
                //third ball
                Ball ballThree = new Ball(levelInformation.paddleStartsPoint().getX()
                        + getLevelInformation().paddleWidth(),  570, 5, Color.blue, environment);
                ballThree.setVelocity(levelInformation.initialBallVelocities().get(2));
                ballThree.addToGame(this);
        } else if (levelInformation.numberOfBalls() > 2) {
            for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
                Ball ballOne = new Ball(levelInformation.paddleStartsPoint().getX() + i * 70,  570, 5,
                        Color.blue, environment);
                ballOne.setVelocity(levelInformation.initialBallVelocities().get(i));
                ballOne.addToGame(this);
            }
        } else {
            Ball ballOne = new Ball(levelInformation.paddleStartsPoint().getX() + 2,  570, 5,
                    Color.blue, environment);
            ballOne.setVelocity(levelInformation.initialBallVelocities().get(0));
            ballOne.addToGame(this);
            // second ball
            Ball ballTwo = new Ball(levelInformation.paddleStartsPoint().getX() + levelInformation.paddleWidth() - 2,
                    570, 5, Color.blue, environment);
            ballTwo.setVelocity(levelInformation.initialBallVelocities().get(1));
            ballTwo.addToGame(this);
        }
    }

}