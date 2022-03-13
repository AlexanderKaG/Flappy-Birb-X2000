package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.game.sprites.Birb;
import se.yrgo.game.sprites.Obstacle;

public class JumpyBirb implements Screen {
    private JumpyBirbGame game;
    private SpriteBatch batch;
    private Birb birb;
    private Obstacle obstacle;
    private Texture gameBackground;
    private int score;

    public JumpyBirb() {

    }

    public JumpyBirb(JumpyBirbGame game) {
        this.game = game;
        batch = new SpriteBatch();

        birb = new Birb();
        birb.create();

        obstacle = new Obstacle();
        obstacle.create();

        gameBackground = new Texture(Gdx.files.internal("NewBackground.png"));
    }

    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        handleUserInput();

        batch.begin();
        batch.draw(gameBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(obstacle.getObstacleBotImage(), obstacle.getObstacleBotPosition().x, obstacle.getObstacleBotPosition().y);
        batch.draw(obstacle.getObstacleTopImage(), obstacle.getObstacleTopPosition().x, obstacle.getObstacleTopPosition().y);
        batch.draw(birb.getBirbImage(), birb.getBirbPosition().x, birb.getBirbPosition().y);

        obstacle.update();
        birb.update();

        if (obstacle.getObstacleBotPosition().x < -obstacle.getObstacleBotPosition().width) {
            obstacle.generateObstacleStartAndGapPosition(obstacle.getObstacleBotPosition(), obstacle.getObstacleTopPosition());
        }

        game.getSpritebatch().begin();
        game.getFont().draw(game.getSpritebatch(), Integer.toString(score), 100, 700);
        game.getSpritebatch().end();

        if (hitsGround(birb) ||
                birb.getBirbPosition().overlaps(obstacle.getObstacleBotPosition()) ||
                birb.getBirbPosition().overlaps(obstacle.getObstacleTopPosition())) {

            birb.playDeathSound();
            game.setScreen(new EndMenuScreen(game, score));
        } else if (obstacle.getObstacleBotPosition().x == birb.getBirbPosition().x - obstacle.getObstacleBotPosition().width) {
            score++;
        }

        batch.end();
    }

    private void handleUserInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
            birb.jump();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
            birb.initiateGravity();
            obstacle.spawnObstacles();
        }
    }

    private static boolean hitsGround(Birb birb) {
        return birb.getBirbPosition().y < -20;
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

    @Override
    public void dispose() {
        birb.dispose();
        obstacle.dispose();
    }
}
