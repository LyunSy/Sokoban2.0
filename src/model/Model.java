package model;

import java.util.ArrayList;

import entity.Box;
import entity.Player;

public class Model {

	private Player player;

	private ArrayList<Box> boxs;
	
	private int goalReached;
	
	private int goal;

	private char[][] map2 = { { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', '.', '.', '.', 'x', '#', '.', 'x', '#', '#' }, 
			{ '#', '.', '.', '#', '#', '.', '.', '.', '.', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', 'x', '.', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }, };
	
	private char[][] map = {
		    { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
		    { '#', '#', '#', '#', '#', 'x', 'x', 'x', '.', 'x', 'x', 'x', 'x', '#', '#', '#', '#', '#', '#' },
		    { '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '#', '#', '#' },
		    { '#', '.', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#', '.', '.', '#', '#', '#' },
		    { '#', '.', '#', '.', '.', '.', '.', '#', '#', '.', '#', '.', '.', '#', '.', '.', 'x', '.', '#' },
		    { '#', '.', '#', '.', '.', '.', '.', 'x', 'x', 'x', '#', '.', '.', '#', '.', '.', '#', 'x', '#' },
		    { '#', '.', '#', '.', '.', '.', '.', '#', '.', '.', '.', 'x', '.', '#', '.', '.', 'x', '.', '#' },
		    { '#', '.', '#', '.', '.', '#', '#', '#', '.', '#', '#', 'x', '.', '.', '.', '.', '#', 'x', '#' },
		    { '#', '.', '#', '#', '#', '.', '.', '#', '.', '.', '#', '.', '.', '#', '.', '.', 'x', '.', '#' },
		    { '#', '.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '#', '#', '#', '.', '.', '#', 'x', '#' },
		    { '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', 'x', '.', '#' },
		    { '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '#', '.', '.', '#', 'x', '#' },
		    { '#', '#', '#', '#', '.', '.', '#', '#', '#', '.', '.', '.', '.', '#', '.', '.', 'x', '.', '#' },
		    { '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', 'x', 'x', 'x', 'x', '#' },
		    { '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
		    { '#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
		    { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
		    };
		    
	public Model() {
		initData();
		countGoal();

	}
	
	private void initData() {
		this.player = new Player(2, 14);
		this.boxs = new ArrayList<Box>();

		boxs.add(new Box(2, 8));
		boxs.add(new Box(2, 11));
		boxs.add(new Box(3, 9));
		boxs.add(new Box(4, 14));
		boxs.add(new Box(6, 14));
		boxs.add(new Box(8, 14));
		boxs.add(new Box(10, 14));
		boxs.add(new Box(12, 14));
		boxs.add(new Box(7, 13));
		boxs.add(new Box(5, 4));
		boxs.add(new Box(6, 4));
		boxs.add(new Box(5, 5));	
		boxs.add(new Box(11, 5));
		boxs.add(new Box(12, 5));
		boxs.add(new Box(9, 6));
		boxs.add(new Box(9, 9));
		boxs.add(new Box(10, 7));
		
		boxs.add(new Box(10, 3));
		boxs.add(new Box(11, 9));
		boxs.add(new Box(11, 11));
		boxs.add(new Box(10, 10));
		boxs.add(new Box(11, 5));

		boxs.add(new Box(13, 6));
		boxs.add(new Box(13, 3));
		boxs.add(new Box(13, 8));
		boxs.add(new Box(13, 9));



		this.goalReached = 0;
	}

	public ArrayList<Box> getBoxs() {
		return this.boxs;
	}

	public Player getPlayer() {
		return this.player;
	}

	public char[][] getMap() {
		return this.map;
	}

	private void countGoal() {
		this.goal = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'x') {
					goal++;
				}
			}
		}
	}

	public void moveUP() {
		int destX = this.getPlayer().getX() - 1;
		int destY = this.getPlayer().getY();
		int boxPosX = destX - 1;
		int boxPosY = destY;

		if (validMove(destX, destY, boxPosX, boxPosY)) {
			this.player.setX(destX);

		}

	}

	public void moveDOWN() {
		int destX = this.getPlayer().getX() + 1;
		int destY = this.getPlayer().getY();
		int boxPosX = destX + 1;
		int boxPosY = destY;

		if (validMove(destX, destY, boxPosX, boxPosY)) {
			this.player.setX(destX);
		}

	}

	public void moveLEFT() {
		int destX = this.getPlayer().getX();
		int destY = this.getPlayer().getY() - 1;
		int boxPosX = destX;
		int boxPosY = destY - 1;

		if (validMove(destX, destY, boxPosX, boxPosY)) {
			this.player.setY(destY);
		}

	}

	public void moveRIGHT() {
		int destX = this.getPlayer().getX();
		int destY = this.getPlayer().getY() + 1;
		int boxPosX = destX;
		int boxPosY = destY + 1;

		if (validMove(destX, destY, boxPosX, boxPosY)) {
			this.player.setY(destY);
		}

	}

	private boolean validMove(int newPosX, int newPosY, int newPosBoxX, int newPosBoxY) {

		if (newPosX >= 0 && newPosX < map.length && newPosY >= 0 && newPosY < map[0].length) {
			Box box = checkCollision(newPosX, newPosY);
			if (box != null) {

				if (manageCollision(box, newPosBoxX, newPosBoxY)) {
					
					char destBox = map[newPosBoxX][newPosBoxY];
					
					if (destBox == 'x') {
		
						goalReached++;
						box.setGoaled(true);
					
					}
					else if (box.getGoaled()) {

						goalReached--;
						box.setGoaled(false);
					}
					return true;
				}
				return false;
			}

			char destination = map[newPosX][newPosY];

			if (destination == '#') {
				return false;
			}

			if (destination == 'x' || destination == '.') {
				return true;
			}

		}
		return false;
	}

	private boolean manageCollision(Box box, int newPosBoxX, int newPosBoxY) {

		if (map[newPosBoxX][newPosBoxY] != '#' && checkCollision(newPosBoxX, newPosBoxY) == null) {

			box.setX(newPosBoxX);
			box.setY(newPosBoxY);
			return true;
		}

		return false;
	}

	private Box checkCollision(int newPosX, int newPosY) {
		for (Box box : this.boxs) {

			if (newPosX == box.getX() && newPosY == box.getY()) {
				return box;
			}
		}
		return null;
	}
	
	public boolean isWin() {
		return goal == goalReached;
	}
	
	public void resetData() {
		this.initData();

	}

}
