package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.game.sprites.Birb;
import se.yrgo.game.sprites.Obstacle;

public class JumpyBirb implements Screen {
    private final JumpyBirbGame game;
    private final SpriteBatch batch;
    private final Birb birb;
    private final Texture gameBackground;
    private final Array<Obstacle> obstacles;
    private static int score;
    public static int spaceBetweenObstacles = 600;
    private static final int NUMBER_OF_OBSTACLES = 4;
    private static int speedOfObstacles;

    public JumpyBirb(JumpyBirbGame game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.birb = new Birb(100, 400);
        this.gameBackground = new Texture(Gdx.files.internal("NewBackground.png"));
        this.obstacles = new Array<>();

        for (int i = 1; i <= NUMBER_OF_OBSTACLES; i++) {
            obstacles.add(new Obstacle(i * spaceBetweenObstacles + Obstacle.WIDTH));
        }
    }

    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        handleUserInput();

        batch.begin();
        batch.draw(gameBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for (Obstacle obstacle : obstacles) {
            batch.draw(obstacle.getImageTopObstacle(), obstacle.getTopObstaclePosition().x, obstacle.getTopObstaclePosition().y);
            batch.draw(obstacle.getImageBotObstacle(), obstacle.getBotObstaclePosition().x, obstacle.getBotObstaclePosition().y);
            obstacle.getTopObstaclePosition().x -= speedOfObstacles;
            obstacle.getBotObstaclePosition().x -= speedOfObstacles;

            if (obstacle.getTopObstaclePosition().x == birb.getPositionBirb().x - 200) {
                score++;
            }

            if (obstacle.getTopObstaclePosition().x < -obstacle.getTopObstaclePosition().width) {
                obstacle.generateObstacleStartAndGapPosition((obstacle.getTopObstaclePosition().x - 200) + (Obstacle.WIDTH + spaceBetweenObstacles * NUMBER_OF_OBSTACLES));
            }

            if (hitsGround(birb) ||
                    birb.getPositionBirb().overlaps(obstacle.getTopObstaclePosition()) ||
                    birb.getPositionBirb().overlaps(obstacle.getBotObstaclePosition())) {

                birb.playDeathSound();
                birb.setPositionBirbY(-19);
                stopObstacles();
                game.setScreen(new EndMenuScreen(game));
            }
        }

        batch.draw(birb.getImageBirb(), birb.getPositionBirb().x, birb.getPositionBirb().y);
        birb.update();

        game.getSpritebatch().begin();
        game.getFont().draw(game.getSpritebatch(), Integer.toString(score), 100, 700);
        game.getSpritebatch().end();

        batch.end();
    }

    private void handleUserInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
            birb.jump();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
            birb.initiateGravity();
            moveObstacles();
        }
    }

    private static boolean hitsGround(Birb birb) {
        return birb.getPositionBirb().y <= -20;
    }

    private static void moveObstacles() {
        speedOfObstacles = 5;
    }

    private static void stopObstacles() {
        speedOfObstacles = 0;
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

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        JumpyBirb.score = score;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        birb.dispose();
        gameBackground.dispose();
        for (Obstacle obstacle : obstacles) {
            obstacle.dispose();
        }
    }
}
