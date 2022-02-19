package se.yrgo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.game.sprites.Birb;
import se.yrgo.game.sprites.Obstacle;

public class JumpyBirb extends ApplicationAdapter {
	private SpriteBatch batch;
	private Birb birb;
	private Obstacle obstacle;

	@Override
	public void create () {
		batch = new SpriteBatch();

		birb = new Birb();
		birb.create();

		obstacle = new Obstacle();
		obstacle.create();

	}

	@Override
	public void render () {
		// Adds the function to jump with space/mouse
		birb.jump();

		ScreenUtils.clear(1, 0, 0, 1);

		batch.begin();
		batch.draw(obstacle.getObstacleImage(), obstacle.getObstaclePosition().x, obstacle.getObstaclePosition().y);
		batch.draw(birb.getImg(), birb.getPosition().x, birb.getPosition().y);

		obstacle.getObstaclePosition().x -= obstacle.getObstacleSpeed();

		// Activates gravity when space is pressed.
		birb.initiateGravity();

		// If Birb hits the ground the game resets.
		if(birb.getPosition().y < 0) {
			birb.getPosition().setPosition(100, 400);
			birb.setGravity(0.0f);
			birb.setVelocity(0.0f);

			birb.initiateGravity();
		}

		if(obstacle.getObstaclePosition().x < -50){
			obstacle.getObstaclePosition().setPosition(900, 0);
		}

		birb.update();
		batch.end();
	}

	// Dispose of used assets to clear up memory
	@Override
	public void dispose () {
		batch.dispose();
		birb.getImg().dispose();
		obstacle.getObstacleImage().dispose();
	}
}
