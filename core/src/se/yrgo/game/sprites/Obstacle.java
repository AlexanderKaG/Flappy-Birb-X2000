package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle {
    private Texture obstacleBotImage, obstacleTopImage;
    private Rectangle obstacleBotPosition;
    private Rectangle obstacleTopPosition;
    private int obstacleSpeed = 5;

    public void create(){
        obstacleBotImage = new Texture(Gdx.files.internal("BetterTubeBot.png"));
        obstacleBotPosition = new Rectangle();
        obstacleBotPosition.x = 800;
        obstacleBotPosition.y = -200;

        obstacleTopImage = new Texture(Gdx.files.internal("BetterTubeTop.png"));
        obstacleTopPosition = new Rectangle();
        obstacleTopPosition.x = 800;
        obstacleTopPosition.y = 600;



    }

    public Texture getObstacleBotImage(){
        return obstacleBotImage;
    }
    public Rectangle getObstacleBotPosition(){
        return obstacleBotPosition;
    }
    public int getObstacleSpeed(){
        return obstacleSpeed;

    }public Texture getObstacleTopImage(){
        return obstacleTopImage;
    }
    public Rectangle getObstacleTopPosition(){
        return obstacleTopPosition;
    }

}
