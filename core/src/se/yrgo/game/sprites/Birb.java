package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Birb {
    private Texture birbImage;
    private Rectangle birbPosition;
    private float gravity;
    private float velocity = 0.0f;
    private Sound jumpSound;

    public void create() {
        birbImage = new Texture(Gdx.files.internal("Pixelbird.png"));

        birbPosition = new Rectangle();
        birbPosition.x = 100;
        birbPosition.y = 400;
        birbPosition.width = 100;
        birbPosition.height = 100;

        jumpSound = Gdx.audio.newSound(Gdx.files.internal("small-hit-game.wav"));
    }

    public void update() {
        velocity += gravity;
        birbPosition.y -= velocity;
    }

    public void jump() {
        velocity = -5;
        jumpSound.play(0.25f);
    }

    public void initiateGravity() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isTouched()) {
            this.gravity = 0.2f;
        }
    }

    public Texture getBirbImageg() {
        return birbImage;
    }

    public Rectangle getBirbPosition() {
        return birbPosition;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public void dispose() {
        birbImage.dispose();
        jumpSound.dispose();
    }
}
