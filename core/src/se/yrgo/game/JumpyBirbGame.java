package se.yrgo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JumpyBirbGame extends Game {
    private SpriteBatch spritebatch;
    private BitmapFont font;

    @Override
    public void create() {
        spritebatch = new SpriteBatch(;
        font = new BitmapFont();
        this.setScreen(new MainMenuScreen(this));
    }
}
