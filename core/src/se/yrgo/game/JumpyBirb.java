package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.game.sprites.Birb;
import se.yrgo.game.sprites.Obstacle;

import java.util.concurrent.ThreadLocalRandom;

public class JumpyBirb implements Screen {
    private JumpyBirbGame game;

    private SpriteBatch batch;
    private Birb birb;
    private Obstacle obstacle;
    private int score;
    private Texture background;

    public JumpyBirb() {

    }

    public JumpyBirb(JumpyBirbGame game) {
        this.game = game;
        batch = new SpriteBatch();

        birb = new Birb();
        birb.create();

        obstacle = new Obstacle();
        obstacle.create();

        background = new Texture(Gdx.files.internal("Background.png"));
    }

    public void render(float delta) {
        // Calls the function to jump when user press space/mouse click
        handleUserInput();

        ScreenUtils.clear(1, 0, 0, 1);

        batch.begin();

        batch.draw(background, 0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        batch.draw(obstacle.getObstacleBotImage(), obstacle.getObstacleBotPosition().x, obstacle.getObstacleBotPosition().y);
        batch.draw(obstacle.getObstacleTopImage(), obstacle.getObstacleTopPosition().x, obstacle.getObstacleTopPosition().y);
        batch.draw(birb.getBirbImageg(), birb.getBirbPosition().x, birb.getBirbPosition().y);

        obstacle.update();
        birb.update();

        game.getSpritebatch().begin();
        game.getFont().draw(game.getSpritebatch(), Integer.toString(score), 100, 700);
        game.getSpritebatch().end();

        // Activates gravity when space is pressed.
        birb.initiateGravity();

        if (hitsGround(birb) ||
                birb.getBirbPosition().overlaps(obstacle.getObstacleBotPosition()) ||
                birb.getBirbPosition().overlaps(obstacle.getObstacleTopPosition())) {

            birb.playDeathSound();

            game.setScreen(new EndMenuScreen(game, score));
        } else if (obstacle.getObstacleBotPosition().x == birb.getBirbPosition().x - birb.getBirbPosition().width) {
            score++;
        }

        if (obstacle.getObstacleBotPosition().x < -200) {
            int randomNumber = ThreadLocalRandom.current().nextInt(-150, 400);
            obstacle.getObstacleBotPosition().setPosition(800, randomNumber - 450);
            obstacle.getObstacleTopPosition().setPosition(800, randomNumber + 450);
        }

        batch.end();
    }

    private void handleUserInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
            birb.jump();
        }
    }

    private static boolean hitsGround(Birb birb) {
        if (birb.getBirbPosition().y < -20) {
            return true;
        }
        return false;
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    // Dispose of used assets to clear up memory
    @Override
    public void dispose() {
        birb.dispose();
        obstacle.dispose();
    }
}
