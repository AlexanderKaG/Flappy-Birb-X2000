package se.yrgo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.game.sprites.Birb;
import se.yrgo.game.sprites.Obstacle;

import java.util.concurrent.ThreadLocalRandom;

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
		batch.draw(obstacle.getObstacleBotImage(), obstacle.getObstacleBotPosition().x, obstacle.getObstacleBotPosition().y);
		batch.draw(obstacle.getObstacleTopImage(), obstacle.getObstacleTopPosition().x, obstacle.getObstacleTopPosition().y);
		batch.draw(birb.getImg(), birb.getPosition().x, birb.getPosition().y);

		obstacle.getObstacleBotPosition().x -= obstacle.getObstacleSpeed();
		obstacle.getObstacleTopPosition().x -= obstacle.getObstacleSpeed();


		// Activates gravity when space is pressed.
		birb.initiateGravity();

		// If Birb hits the ground the game resets.
		if(birb.getPosition().y < 0) {
			birb.getPosition().setPosition(100, 400);
			birb.setGravity(0.0f);
			birb.setVelocity(0.0f);

			birb.initiateGravity();
		}

		if(obstacle.getObstacleBotPosition().x < -200){
			int randomNumber = ThreadLocalRandom.current().nextInt(-150, 400);
			obstacle.getObstacleBotPosition().setPosition(900, randomNumber - 420);
			obstacle.getObstacleTopPosition().setPosition(900, randomNumber + 420);
		}

		birb.update();
		batch.end();
	}

	// Dispose of used assets to clear up memory
	@Override
	public void dispose () {
		batch.dispose();
		birb.getImg().dispose();
		obstacle.getObstacleBotImage().dispose();
	}
}
