package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class EndMenuScreen implements Screen {
    private final JumpyBirbGame game;
    private final int endScore;
    private final Texture endBackground;
    private final MainMenuScreen mainMenuScreen;

    public EndMenuScreen(JumpyBirbGame game, int endScore) {
        this.game = game;
        this.endScore = endScore;
        this.endBackground = new Texture(Gdx.files.internal("NewBackground.png"));
        this.mainMenuScreen = new MainMenuScreen(game);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        game.getSpritebatch().begin();
        game.getSpritebatch().draw(endBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getFont().draw(game.getSpritebatch(), "Ooops... you died! Score: " + endScore, 300, 700);
        game.getFont().draw(game.getSpritebatch(), "Press space to restart", 300, 100);

        mainMenuScreen.drawDifficultyImages();
        mainMenuScreen.chooseDifficulty();

        game.getFont().draw(game.getSpritebatch(), MainMenuScreen.difficulty, 300, 200);
        game.getSpritebatch().end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
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
