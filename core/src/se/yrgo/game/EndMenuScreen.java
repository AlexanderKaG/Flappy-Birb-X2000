package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class EndMenuScreen implements Screen {
    private JumpyBirbGame game;
    private int endScore;
    private Texture endBackground;

    public EndMenuScreen() {

    }

    public EndMenuScreen(JumpyBirbGame game, int endScore) {
        this.game = game;
        this.endScore = endScore;
        endBackground = new Texture(Gdx.files.internal("NewBackground.png"));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        game.getSpritebatch().begin();
        game.getSpritebatch().draw(endBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getFont().draw(game.getSpritebatch(), "Ooops... you died! Score: " + endScore, 300, 600);
        game.getFont().draw(game.getSpritebatch(), "Tap anywhere or press space to restart", 300, 500);
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
