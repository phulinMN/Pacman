package com.phulin.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public static final int BLOCK_SIZE = 40;
	private PacmanGame pacmanGame;
	private World world;
	private Texture pacmanImg;
	private Pacman pacman;
	private MazeRenderer mazeRenderer;

	public WorldRenderer(PacmanGame pacmanGame, World world){
		this.pacmanGame = pacmanGame;
		SpriteBatch batch = pacmanGame.batch;

		this.world = world;
		pacman = world.getPacman();
		pacmanImg = new Texture("pacman.png");
		mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
	}
	
	public void render(float delta){
		mazeRenderer.render();
		SpriteBatch batch = pacmanGame.batch;
        Vector2 pos = world.getPacman().getPosition();
        batch.begin();
        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, 
                PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        batch.end();
	}
}
