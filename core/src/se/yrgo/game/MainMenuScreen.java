package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    private final JumpyBirbGame game;
    private final Texture startBackground;


    public MainMenuScreen(JumpyBirbGame game) {
        this.game = game;
        this.startBackground = new Texture(Gdx.files.internal("NewBackground.png"));
        Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("man-is-he-mega.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.1f);
        backgroundMusic.play();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        game.getSpritebatch().begin();
        game.getSpritebatch().draw(startBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getFont().draw(game.getSpritebatch(), "Jumpy Birb X2000", 300, 600);
        game.getFont().draw(game.getSpritebatch(), "easy left alt, medium right alt, hard left shift", 300, 500);
        game.getFont().draw(game.getSpritebatch(), "Press space to begin", 300, 300);
        game.getSpritebatch().end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ALT_LEFT)) {
            JumpyBirb.spaceBetweenObstacles = 700;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ALT_RIGHT)) {
            JumpyBirb.spaceBetweenObstacles = 600;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) {
            JumpyBirb.spaceBetweenObstacles = 500;
        }

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
        startBackground.dispose();
    }
}
