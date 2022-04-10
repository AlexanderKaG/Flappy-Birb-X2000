package se.yrgo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class EndMenuScreen implements Screen {
    private final JumpyBirbGame game;
    private final Texture endBackground;
    private final MainMenuScreen mainMenuScreen;

    public EndMenuScreen(JumpyBirbGame game) {
        this.game = game;
        this.endBackground = new Texture(Gdx.files.internal("NewBackground.png"));
        this.mainMenuScreen = new MainMenuScreen(game);

        addScoreToScoreboard();
    }

    private void addScoreToScoreboard() {
        game.getScoreboard().add(JumpyBirb.getScore());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        int highScore = 0;
        int scoreYPositionInScoreboard = 650;
        game.getSpritebatch().begin();
        game.getSpritebatch().draw(endBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getFont().draw(game.getSpritebatch(), "Ooops... you died! Score: " + JumpyBirb.getScore(), 270, 680);
        game.getFont().draw(game.getSpritebatch(), "Previous scores:", 300, scoreYPositionInScoreboard);

        for (int score : game.getScoreboard()) {
            game.getFont().draw(game.getSpritebatch(), Integer.toString(score), 300, scoreYPositionInScoreboard - 20);
            scoreYPositionInScoreboard -= 20;
            if (score > highScore) {
                highScore = score;
            }
        }

        game.getFont().draw(game.getSpritebatch(), "High-score: " + highScore, 500, 650);

        game.getFont().draw(game.getSpritebatch(), "Press space to restart", 310, 100);

        mainMenuScreen.drawDifficultyImages();
        mainMenuScreen.chooseDifficulty();

        game.getFont().draw(game.getSpritebatch(), MainMenuScreen.difficulty, 313, 200);
        game.getSpritebatch().end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            JumpyBirb.setScore(0);
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
