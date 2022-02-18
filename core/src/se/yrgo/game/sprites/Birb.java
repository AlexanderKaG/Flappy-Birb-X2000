package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Birb {
    private Texture img;
    private Rectangle position;
    private float gravity = 0.0f;
    private float velocity = 0.0f;

    public void create() {
        img = new Texture(Gdx.files.internal("Bird.png"));

        position = new Rectangle();
        position.x = 100;
        position.y = 400;
    }

    public void update() {
        velocity += gravity;
        position.y -= velocity;
    }

    public void jump() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isTouched()) {
            velocity = -5;
        }
    }

    public Texture getImg() {
        return img;
    }

    public Rectangle getPosition() {
        return position;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }
}

