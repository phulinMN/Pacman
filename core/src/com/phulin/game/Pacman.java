package com.phulin.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
	private Vector2 position;
	private int currentDirection;
    private int nextDirection;
	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 5;
    
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
	 
    public Pacman(int x, int y) {
        position = new Vector2(x,y);
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
    }    
    
    public void setNextDirection(int dir) {
        nextDirection = dir;
    }
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int dir) { 
    	 position.x += 10 * DIR_OFFSETS[dir][0];
         position.y += 10 * DIR_OFFSETS[dir][1];
    }
    
    public void update() {
        if(isAtCenter()) {
            currentDirection = nextDirection;
        }
        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
        position.y += SPEED * DIR_OFFSETS[currentDirection][1];
    }

	private boolean isAtCenter() {
		int blockSize = WorldRenderer.BLOCK_SIZE;
		 
        return ((((int)position.x - blockSize/2) % blockSize) == 0) &&
                ((((int)position.y - blockSize/2) % blockSize) == 0);
	}
}
