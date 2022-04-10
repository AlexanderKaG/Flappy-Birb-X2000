package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    private final JumpyBirbGame game;
    private final Texture startBackground, imageEasy, imageMedium, imageHard;
    private final Music backgroundMusic;
    private final Rectangle positionEasyImage, positionMediumImage, positionHardImage;
    private final Vector2 touchImage;
    public static String difficulty = "Difficulty - MEDIUM";

    public MainMenuScreen(JumpyBirbGame game) {
        this.game = game;
        this.startBackground = new Texture(Gdx.files.internal("NewBackground.png"));
        this.imageEasy = new Texture(Gdx.files.internal("Easy.png"));
        this.imageMedium = new Texture(Gdx.files.internal("Medium.png"));
        this.imageHard = new Texture(Gdx.files.internal("Hard.png"));
        this.positionEasyImage = new Rectangle(80, 225, imageEasy.getWidth(), imageEasy.getHeight());
        this.positionMediumImage = new Rectangle(330, 225, imageMedium.getWidth(), imageMedium.getHeight());
        this.positionHardImage = new Rectangle(580, 225, imageHard.getWidth(), imageHard.getHeight());
        this.touchImage = new Vector2();
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("man-is-he-mega.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.1f);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        backgroundMusic.play();

        game.getSpritebatch().begin();
        game.getFont().setColor(255, 165, 0, 250);
        game.getFont().getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        game.getFont().getData().setScale(1.5f,1.5f);
        game.getSpritebatch().draw(startBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getFont().draw(game.getSpritebatch(), "JUMPY BIRB X2000", 310, 630);
        drawDifficultyImages();
        game.getFont().draw(game.getSpritebatch(), "Press space to begin", 313, 100);
        chooseDifficulty();
        game.getFont().draw(game.getSpritebatch(), difficulty, 313, 200);
        game.getSpritebatch().end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.setScreen(new JumpyBirb(game));
            dispose();
        }
    }

    public void chooseDifficulty() {
        if (Gdx.input.justTouched()) {
            touchImage.set(Gdx.input.getX(), Gdx.input.getY());
            if (positionEasyImage.contains(touchImage.x, touchImage.y - positionEasyImage.getHeight() - 50)) {
                JumpyBirb.spaceBetweenObstacles = 700;
                difficulty = "Difficulty - EASY";
            } else if (positionMediumImage.contains(touchImage.x, touchImage.y - positionMediumImage.getHeight() - 50)) {
                JumpyBirb.spaceBetweenObstacles = 600;
                difficulty = "Difficulty - MEDIUM";
            } else if (positionHardImage.contains(touchImage.x, touchImage.y - positionHardImage.getHeight() - 50)) {
                JumpyBirb.spaceBetweenObstacles = 500;
                difficulty = "Difficulty - HARD";
            }
        }
    }

    public void drawDifficultyImages() {
        game.getFont().draw(game.getSpritebatch(), "EASY", 123, 400);
        game.getFont().draw(game.getSpritebatch(), "MEDIUM", 358, 400);
        game.getFont().draw(game.getSpritebatch(), "HARD", 621, 400);
        game.getSpritebatch().draw(imageEasy, positionEasyImage.x, positionEasyImage.y);
        game.getSpritebatch().draw(imageMedium, positionMediumImage.x, positionMediumImage.y);
        game.getSpritebatch().draw(imageHard, positionHardImage.x, positionHardImage.y);
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
