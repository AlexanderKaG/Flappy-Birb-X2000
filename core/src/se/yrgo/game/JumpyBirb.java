package se.yrgo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class JumpyBirb extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Rectangle birb;
	private static final float GRAVITY = 0.2f;
	private float velocity = 0.0f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("badlogic.jpg"));

		birb = new Rectangle();
		birb.x = 100;
		birb.y = 400;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		batch.begin();
		batch.draw(img, birb.x, birb.y);

		velocity += GRAVITY;
		birb.y -= velocity;
		jump();

		batch.end();
	}

	public void jump() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			velocity = -5;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
