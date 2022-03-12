package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    private JumpyBirbGame game;

    public MainMenuScreen() {

    }

    public MainMenuScreen(JumpyBirbGame game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        game.getSpritebatch().begin();
        game.getFont().draw(game.getSpritebatch(), "Jumpy Birb X2000", 300, 600);
        game.getFont().draw(game.getSpritebatch(), "Tap anywhere or press space to begin", 300, 500);
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

    }
}
