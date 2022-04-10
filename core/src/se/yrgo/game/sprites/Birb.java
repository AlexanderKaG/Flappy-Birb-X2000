package se.yrgo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Birb {
    private final Texture imageBirb, imageBirbFire;
    private final Rectangle positionBirb;
    private float gravity;
    private float velocity = 0.0f;
    private final Sound jumpSound, deathSound;

    public Birb(int x, int y) {
        imageBirb = new Texture(Gdx.files.internal("purple.png"));
        imageBirbFire = new Texture(Gdx.files.internal("purplefire.png"));
        positionBirb = new Rectangle();
        positionBirb.x = x;
        positionBirb.y = y;
        positionBirb.width = imageBirb.getWidth();
        positionBirb.height = imageBirb.getHeight();

        jumpSound = Gdx.audio.newSound(Gdx.files.internal("small-hit-game.wav"));
        deathSound = Gdx.audio.newSound(Gdx.files.internal("death.wav"));
    }

    public void update() {
        velocity += gravity;
        positionBirb.y += velocity;
    }

    public void jump() {
        velocity = 10;
        jumpSound.play(0.25f);
    }

    public void initiateGravity() {
        this.gravity = -0.5f;
    }

    public Texture getImageBirb() {
        return imageBirb;
    }

    public Texture getImageBirbFire() {
        return imageBirbFire;
    }

    public float getVelocity() {
        return velocity;
    }

    public Rectangle getPositionBirb() {
        return positionBirb;
    }

    public void setPositionBirbY(int y) {
        this.positionBirb.y = y;
    }

    public void playDeathSound() {
        deathSound.play(0.25f);
    }

    public void dispose() {
        imageBirb.dispose();
        jumpSound.dispose();
        deathSound.dispose();
    }
}
