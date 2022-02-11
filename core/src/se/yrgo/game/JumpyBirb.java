package se.yrgo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class JumpyBirb extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Rectangle birb;
	private static float GRAVITY = 0.2f;
	private float velocity = 0.0f;
	private OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("Bird.png"));

		birb = new Rectangle();
		birb.x = -100;
		birb.y = 200;
		birb.width = 64;
		birb.height = 64;

		camera = new OrthographicCamera(); //skapar en kamera
		camera.setToOrtho(false);
		camera.position.set(0, 0 ,0); //camerans position


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
		batch.draw(img, birb.x, birb.y);

		velocity += GRAVITY;
		birb.y -= velocity;
		jump();

		if (birb.y > 200){
			GRAVITY = 0;
			velocity = 0;
		}else if(birb.y < -200 ){
			GRAVITY = 0;
			velocity = 0;
		}


		batch.end();
	}

	public void jump() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isTouched()) {
			velocity = -5;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
