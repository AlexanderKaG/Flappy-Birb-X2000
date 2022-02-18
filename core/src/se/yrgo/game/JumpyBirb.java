package se.yrgo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.game.sprites.Birb;

public class JumpyBirb extends ApplicationAdapter {
	private SpriteBatch batch;
	private Birb birb;

	@Override
	public void create () {
		batch = new SpriteBatch();

		birb = new Birb();
		birb.create();
	}

	@Override
	public void render () {
		// Adds the function to jump with space/mouse
		birb.jump();

		ScreenUtils.clear(1, 0, 0, 1);

		batch.begin();
		batch.draw(birb.getImg(), birb.getPosition().x, birb.getPosition().y);

		// Activates gravity when space is pressed.
		birb.initiateGravity();

		// If Birb hits the ground the game resets.
		if(birb.getPosition().y < 0) {
			birb.getPosition().setPosition(100, 400);
			birb.setGravity(0.0f);
			birb.setVelocity(0.0f);

			birb.initiateGravity();
		}

		birb.update();
		batch.end();
	}

	// Dispose of used assets to clear up memory
	@Override
	public void dispose () {
		batch.dispose();
		birb.getImg().dispose();
	}
}
