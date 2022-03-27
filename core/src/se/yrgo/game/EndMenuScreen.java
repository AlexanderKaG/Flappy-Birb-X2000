package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class EndMenuScreen implements Screen {
    private final JumpyBirbGame game;
    private final int endScore;
    private final Texture endBackground, imageEasy, imageMedium, imageHard;

    public EndMenuScreen(JumpyBirbGame game, int endScore) {
        this.game = game;
        this.endScore = endScore;
        this.imageEasy = new Texture(Gdx.files.internal("EASY.png"));
        this.imageMedium = new Texture(Gdx.files.internal("MEDIUM.png"));
        this.imageHard = new Texture(Gdx.files.internal("HARD.png"));
        this.endBackground = new Texture(Gdx.files.internal("NewBackground.png"));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        game.getSpritebatch().begin();
        game.getSpritebatch().draw(endBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getFont().draw(game.getSpritebatch(), "Ooops... you died! Score: " + endScore, 300, 600);
        game.getFont().draw(game.getSpritebatch(), "easy left alt, medium right alt, hard left shift", 300, 550);
        game.getFont().draw(game.getSpritebatch(), "Press space or click to restart", 300, 300);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ALT_LEFT)) {
            JumpyBirb.spaceBetweenObstacles = 700;
            MainMenuScreen.difficulty = "EASY";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ALT_RIGHT)) {
            JumpyBirb.spaceBetweenObstacles = 600;
            MainMenuScreen.difficulty = "MEDIUM";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) {
            JumpyBirb.spaceBetweenObstacles = 500;
            MainMenuScreen.difficulty = "HARD";
        }

        game.getFont().draw(game.getSpritebatch(), MainMenuScreen.difficulty, 300, 500);
        game.getSpritebatch().end();

        if (Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.setScreen(new JumpyBirb(game));
            dispose();
        }
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
        endBackground.dispose();
    }
}
