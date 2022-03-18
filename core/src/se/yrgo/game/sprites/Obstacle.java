package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.concurrent.ThreadLocalRandom;

public class Obstacle {
    private Texture imageTopObstacle, imageBotObstacle;
    private Rectangle positionTopObstacle, positionBotObstacle;
    private ThreadLocalRandom randomNumber;
    private final int gapInBetweenObstacles = 225;
    private final int lowestObstacleGap = 100;
    public static int width = 200;

    public Obstacle() {

    }

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

    public void update() {
        int speedOfObstacles = 5;
        positionTopObstacle.x -= speedOfObstacles;
        positionBotObstacle.x -= speedOfObstacles;
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
