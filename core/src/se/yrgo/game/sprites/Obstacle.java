package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.concurrent.ThreadLocalRandom;

public class Obstacle {
    private Texture obstacleBotImage, obstacleTopImage;
    private Rectangle obstacleBotPosition, obstacleTopPosition;
    private int obstacleSpeed;

    public void create() {
        obstacleBotImage = new Texture(Gdx.files.internal("BetterTubeBot.png"));
        obstacleBotPosition = new Rectangle();
        obstacleBotPosition.width = 200;
        obstacleBotPosition.height = 600;

        obstacleTopImage = new Texture(Gdx.files.internal("BetterTubeTop.png"));
        obstacleTopPosition = new Rectangle();
        obstacleTopPosition.width = 200;
        obstacleTopPosition.height = 600;

        generateObstacleStartAndGapPosition(obstacleBotPosition, obstacleTopPosition);
    }

    public void update() {
        obstacleBotPosition.x -= obstacleSpeed;
        obstacleTopPosition.x -= obstacleSpeed;
    }

    public Texture getObstacleBotImage() {
        return obstacleBotImage;
    }

    public Texture getObstacleTopImage() {
        return obstacleTopImage;
    }

    public void spawnObstacles() {
        this.obstacleSpeed = 5;
    }

    public Rectangle getObstacleBotPosition() {
        return obstacleBotPosition;
    }

    public Rectangle getObstacleTopPosition() {
        return obstacleTopPosition;
    }

    public void generateObstacleStartAndGapPosition(Rectangle obstacleBotPosition, Rectangle obstacleTopPosition) {
        int randomNumber = ThreadLocalRandom.current().nextInt(-150, 400);
        obstacleBotPosition.setPosition(800, randomNumber - 400);
        obstacleTopPosition.setPosition(800, randomNumber + 400);
    }

    public void dispose() {
        obstacleBotImage.dispose();
        obstacleTopImage.dispose();
    }
}
