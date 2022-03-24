package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.concurrent.ThreadLocalRandom;

public class Obstacle {
    private Texture imageTopObstacle, imageBotObstacle;
    private Rectangle positionTopObstacle, positionBotObstacle;
    private ThreadLocalRandom randomNumber;
    private final int GAP_IN_BETWEEN_OBSTACLES = 225;
    private final int LOWEST_OBSTACLE_GAP = 100;
    public static int width = 200;

    public Obstacle() {

    }

    public Obstacle(float x) {
        randomNumber = ThreadLocalRandom.current();

        imageTopObstacle = new Texture(Gdx.files.internal("FixedTopTube.png"));
        positionTopObstacle = new Rectangle();
        positionTopObstacle.x = x;
        positionTopObstacle.y = randomNumber.nextInt(0, 400) + GAP_IN_BETWEEN_OBSTACLES + LOWEST_OBSTACLE_GAP;
        positionTopObstacle.width = imageTopObstacle.getWidth();
        positionTopObstacle.height = imageTopObstacle.getHeight();

        imageBotObstacle = new Texture(Gdx.files.internal("FixedTubeBot.png"));
        positionBotObstacle = new Rectangle();
        positionBotObstacle.x = x;
        positionBotObstacle.y = positionTopObstacle.y - GAP_IN_BETWEEN_OBSTACLES - imageBotObstacle.getHeight();
        positionBotObstacle.width = imageBotObstacle.getWidth();
        positionBotObstacle.height = imageBotObstacle.getHeight();
    }

    public Texture getImageTopObstacle() {
        return imageTopObstacle;
    }

    public Texture getImageBotObstacle() {
        return imageBotObstacle;
    }

    public Rectangle getTopObstaclePosition() {
        return positionTopObstacle;
    }

    public Rectangle getBotObstaclePosition() {
        return positionBotObstacle;
    }

    public void generateObstacleStartAndGapPosition(float x) {
        positionTopObstacle.setPosition(x, randomNumber.nextInt(0, 400) + GAP_IN_BETWEEN_OBSTACLES + LOWEST_OBSTACLE_GAP);
        positionBotObstacle.setPosition(x, positionTopObstacle.y - GAP_IN_BETWEEN_OBSTACLES - imageBotObstacle.getHeight());
    }

    public void dispose() {
        imageTopObstacle.dispose();
        imageBotObstacle.dispose();
    }
}
