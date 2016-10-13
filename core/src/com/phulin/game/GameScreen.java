package com.phulin.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class  GameScreen extends ScreenAdapter {
	private PacmanGame pacmanGame;
	private Pacman pacman;
	World world;	
	WorldRenderer worldRenderer;
	
	public GameScreen(PacmanGame pacmanGame){
		this.pacmanGame = pacmanGame;	
		//pacman = new Pacman(100,100);
		world = new World(pacmanGame);
		pacman = world.getPacman();
		worldRenderer = new WorldRenderer(pacmanGame, world);
	}
	
	private void update(float delta){
		updatePacmanDirection();
		world.update(delta);
	}
	
	private void updatePacmanDirection(){
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			pacman.setNextDirection(Pacman.DIRECTION_LEFT);
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN)){
			pacman.setNextDirection(Pacman.DIRECTION_DOWN);
		}
		else if(Gdx.input.isKeyPressed(Keys.UP)){
			pacman.setNextDirection(Pacman.DIRECTION_UP);
		}
		else{
			pacman.setNextDirection(Pacman.DIRECTION_STILL);
		}
	}
	
	@Override
	public void render(float delta){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(delta);
		worldRenderer.render(delta);
		
	}
	
}
