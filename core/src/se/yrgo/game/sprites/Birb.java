package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Birb {
    private Texture birbImage;
    private Rectangle birbPosition;
    private float gravity;
    private float velocity = 0.0f;
    private Sound jumpSound, deathSound;

    public void create() {
        birbImage = new Texture(Gdx.files.internal("Pixelbird.png"));

        birbPosition = new Rectangle();
        birbPosition.x = 100;
        birbPosition.y = 400;
        birbPosition.width = 100;
        birbPosition.height = 100;

        jumpSound = Gdx.audio.newSound(Gdx.files.internal("small-hit-game.wav"));
        deathSound = Gdx.audio.newSound(Gdx.files.internal("death.wav"));
    }

    public void update() {
        velocity += gravity;
        birbPosition.y -= velocity;
    }

    public void jump() {
        velocity = -10;
        jumpSound.play(0.25f);
    }

    public void initiateGravity() {
        this.gravity = 0.5f;
    }

    public Texture getBirbImage() {
        return birbImage;
    }

    public Rectangle getBirbPosition() {
        return birbPosition;
    }

    public void playDeathSound() {
        deathSound.play(0.25f);
    }

    public void dispose() {
        birbImage.dispose();
        jumpSound.dispose();
        deathSound.dispose();
    }
}
