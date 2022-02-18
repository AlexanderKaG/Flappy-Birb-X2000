package se.yrgo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.game.sprites.Birb;

public class JumpyBirb extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Birb birb;

	@Override
	public void create () {
		batch = new SpriteBatch();

		camera = new OrthographicCamera(); //skapar en kamera
		camera.setToOrtho(false);
		camera.position.set(0, 0 ,0); //camerans position

		birb = new Birb();
		birb.create();

	}

	@Override
	public void resize(int widht, int height){ //entiteten behåller sin storlek även om man har fullscreen
		camera.viewportWidth = 400;
		camera.viewportHeight = 400;
	}


	@Override
	public void render () {

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		ScreenUtils.clear(1, 0, 0, 1);

		batch.begin();
		batch.draw(birb.getImg(), birb.getPosition().x, birb.getPosition().y);

		birb.update();
		birb.jump();

//		if (birb.getPosition().y > 200){
//			birb.setGRAVITY(0);
//			birb.setVelocity(0);
//		}else if(birb.getPosition().y < -200){
//			birb.setGRAVITY(0);
//			birb.setGRAVITY(0);
//		}

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		birb.getImg().dispose();
	}
}
