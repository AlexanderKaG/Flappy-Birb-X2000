package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle {
    private Texture obstacleBotImage, obstacleTopImage;
    private Rectangle obstacleBotPosition, obstacleTopPosition;
    private int obstacleSpeed = 5;

    public void create(){
        obstacleBotImage = new Texture(Gdx.files.internal("BetterTubeBot.png"));
        obstacleBotPosition = new Rectangle();
        obstacleBotPosition.x = 800;
        obstacleBotPosition.y = -200;
        obstacleBotPosition.width = 200;
        obstacleBotPosition.height = 600;

        obstacleTopImage = new Texture(Gdx.files.internal("BetterTubeTop.png"));
        obstacleTopPosition = new Rectangle();
        obstacleTopPosition.x = 800;
        obstacleTopPosition.y = 600;
        obstacleTopPosition.width = 200;
        obstacleTopPosition.height = 600;
    }

    public Texture getObstacleBotImage(){
        return obstacleBotImage;
    }

    public Texture getObstacleTopImage(){
        return obstacleTopImage;
    }

    public Rectangle getObstacleBotPosition(){
        return obstacleBotPosition;
    }

    public Rectangle getObstacleTopPosition(){
        return obstacleTopPosition;
    }

    public int getObstacleSpeed(){
        return obstacleSpeed;
    }
}
