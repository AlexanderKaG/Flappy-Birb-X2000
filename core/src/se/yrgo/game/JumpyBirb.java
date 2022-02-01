package se.yrgo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class JumpyBirb extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Rectangle birb;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("badlogic.jpg"));

		birb = new Rectangle();
		birb.x = 100;
		birb.y = 400;
		birb.width = 64;
		birb.height = 64;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		batch.begin();
		batch.draw(img, birb.x, birb.y);
		batch.end();

		birb.y -= 500 * Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
