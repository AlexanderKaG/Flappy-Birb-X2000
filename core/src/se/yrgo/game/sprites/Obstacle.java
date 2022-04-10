package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.concurrent.ThreadLocalRandom;

public class Obstacle {
    private final Texture imageTopObstacle, imageBotObstacle;
    private final Rectangle positionTopObstacle, positionBotObstacle;
    private final ThreadLocalRandom randomNumber;
    private final int gapInBetweenObstacles = 235;
    private final int lowestObstacleGap = 100;
    public static final int WIDTH = 200;

    public Obstacle(float x) {
        randomNumber = ThreadLocalRandom.current();

        imageTopObstacle = new Texture(Gdx.files.internal("FixedTopTube.png"));
        positionTopObstacle = new Rectangle();
        positionTopObstacle.x = x;
        positionTopObstacle.y = randomNumber.nextInt(0, 400) + gapInBetweenObstacles + lowestObstacleGap;
        positionTopObstacle.width = imageTopObstacle.getWidth();
        positionTopObstacle.height = imageTopObstacle.getHeight();

        imageBotObstacle = new Texture(Gdx.files.internal("FixedTubeBot.png"));
        positionBotObstacle = new Rectangle();
        positionBotObstacle.x = x;
        positionBotObstacle.y = positionTopObstacle.y - gapInBetweenObstacles - imageBotObstacle.getHeight();
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
        positionTopObstacle.setPosition(x, randomNumber.nextInt(0, 400) + gapInBetweenObstacles + lowestObstacleGap);
        positionBotObstacle.setPosition(x, positionTopObstacle.y - gapInBetweenObstacles - imageBotObstacle.getHeight());
    }

    public void dispose() {
        imageTopObstacle.dispose();
        imageBotObstacle.dispose();
    }
}
