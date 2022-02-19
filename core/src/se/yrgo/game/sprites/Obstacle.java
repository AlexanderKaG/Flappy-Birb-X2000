package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle {
    private Texture obstacleImage;
    private Rectangle obstaclePosition;
    private int obstacleSpeed = 5;

    public void create(){
        obstacleImage = new Texture(Gdx.files.internal("TubeTwo.png"));
        obstaclePosition = new Rectangle();
        obstaclePosition.x = 800;
        obstaclePosition.y = 0;



    }

    public Texture getObstacleImage(){
        return obstacleImage;
    }
    public Rectangle getObstaclePosition(){
        return obstaclePosition;
    }
    public int getObstacleSpeed(){
        return obstacleSpeed;
    }

}
