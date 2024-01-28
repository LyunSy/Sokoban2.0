package model;

public class Model {
	
	private Player player;
	
	private char[][] map = {
		    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
		    {'#', '.', '.', '.', 'x', '#', '.', 'x', '#', '#'},
		    {'#', '.', '$', '#', '#', '.', '$', '.', '.', '#'},
		    {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
		    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
		};
	
	public Model() {
		this.player = new Player(3,1);
	}
	
	public int getPlayerX() {
		return this.player.getX();
	}
	
	public int getPlayerY() {
		return this.player.getY();
	}
    public char[][] getMap() {
    	return this.map;
    }
    
    
    public void moveUP() {
    	
    	this.player.setX(this.player.getX() - 1);
    	
    }
    public void moveDOWN() {
    	this.player.setX(this.player.getX() + 1);
    }
    
    public void moveLEFT() {
    	this.player.setY(this.player.getY() - 1);
    }

    public void moveRIGHT() {
    	this.player.setY(this.player.getY() + 1);
	
    }
    //TODO isValidMove
    
      
}
