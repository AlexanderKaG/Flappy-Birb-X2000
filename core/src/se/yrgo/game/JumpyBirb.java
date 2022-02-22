package se.yrgo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.game.sprites.Birb;
import se.yrgo.game.sprites.Obstacle;

import java.util.concurrent.ThreadLocalRandom;

public class JumpyBirb extends ApplicationAdapter {
    private SpriteBatch batch;
    private Birb birb;
    private Obstacle obstacle;

    @Override
    public void create() {
        batch = new SpriteBatch();

        birb = new Birb();
        birb.create();

        obstacle = new Obstacle();
        obstacle.create();
    }

    @Override
    public void render() {
        // Calls the function to jump when user press space/mouse click
        handleUserInput();

        ScreenUtils.clear(1, 0, 0, 1);

        batch.begin();
        batch.draw(obstacle.getObstacleBotImage(), obstacle.getObstacleBotPosition().x, obstacle.getObstacleBotPosition().y);
        batch.draw(obstacle.getObstacleTopImage(), obstacle.getObstacleTopPosition().x, obstacle.getObstacleTopPosition().y);
        batch.draw(birb.getBirbImageg(), birb.getBirbPosition().x, birb.getBirbPosition().y);

        obstacle.update();
        birb.update();

        // Activates gravity when space is pressed.
        birb.initiateGravity();

        // If Birb hits the ground or the obstacles the game resets.
        if (hitsGround(birb) || hitsTopObstacle(birb, obstacle) || hitsBotObstacle(birb, obstacle)) {
            birb.getBirbPosition().setPosition(100, 400);
            birb.setGravity(0.0f);
            birb.setVelocity(0.0f);

            birb.initiateGravity();
        }

        if (obstacle.getObstacleBotPosition().x < -200) {
            int randomNumber = ThreadLocalRandom.current().nextInt(-150, 400);
            obstacle.getObstacleBotPosition().setPosition(800, randomNumber - 450);
            obstacle.getObstacleTopPosition().setPosition(800, randomNumber + 450);
        }

        batch.end();
    }

    private void handleUserInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isTouched()) {
            birb.jump();
        }
    }

    private static boolean hitsGround(Birb birb) {
        if (birb.getBirbPosition().y < -20) {
            return true;
        }
        return false;
    }

    private static boolean hitsTopObstacle(Birb birb, Obstacle obstacle) {
        if (birb.getBirbPosition().x > obstacle.getObstacleTopPosition().x - 100
                && birb.getBirbPosition().y > obstacle.getObstacleTopPosition().y - 100
                && birb.getBirbPosition().x < obstacle.getObstacleTopPosition().x + 200) {
            return true;
        }
        return false;
    }

    private static boolean hitsBotObstacle(Birb birb, Obstacle obstacle) {
        if (birb.getBirbPosition().x > obstacle.getObstacleBotPosition().x - 100
                && birb.getBirbPosition().y < obstacle.getObstacleBotPosition().y + 580
                && birb.getBirbPosition().x < obstacle.getObstacleBotPosition().x + 200) {
            return true;
        }
        return false;
    }

    // Dispose of used assets to clear up memory
    @Override
    public void dispose() {
        batch.dispose();
    }
}
