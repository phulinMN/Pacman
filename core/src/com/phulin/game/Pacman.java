package com.phulin.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
	private Vector2 position;
	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
	 
    public Pacman(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int dir) { 
        switch(dir) {
        case DIRECTION_UP:
            position.y -= 10;
            break;
        case DIRECTION_RIGHT:
            position.x += 10;
            break;
        case DIRECTION_DOWN:
            position.y += 10;
            break;
        case DIRECTION_LEFT:
            position.x -= 10;
            break;
        }
    }
}
