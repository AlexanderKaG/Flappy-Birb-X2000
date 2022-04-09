package se.yrgo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class JumpyBirbGame extends Game {
    private SpriteBatch spritebatch;
    private BitmapFont font;

    private Array<Integer> scoreboard;

    @Override
    public void create() {
        this.spritebatch = new SpriteBatch();
        this.font = new BitmapFont();
        scoreboard = new Array<>();
        this.setScreen(new MainMenuScreen(this));
    }

    public Array<Integer> getScoreboard() {
        return scoreboard;
    }

    public SpriteBatch getSpritebatch() {
        return spritebatch;
    }

    public BitmapFont getFont() {
        return font;
    }

    @Override
    public void dispose() {
        spritebatch.dispose();
        font.dispose();
    }
}
