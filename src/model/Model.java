package model;

import java.util.ArrayList;
import entity.Box;
import entity.Player;

public class Model {

	private Player player;

	private ArrayList<Box> boxs;

	private int goalReached;

	private int goal;

	private char[][] map = { { ' ', ' ', '#', '#', '#', '#', '#' },
			{ ' ', ' ', '#', '.', '.', '.', '#' },
			{ '#', '#', '#', '.', '#', '.', '#' },
			{ '#', '.', '.', '.', 'x', '.', '#' },
			{ '#', '.', 'x', '.', '.', '#', '#' },
			{ '#', '#', '.', '.', '#', '#', ' ' },
			{ ' ', '#', '.', '.', '#', ' ', ' ' },
			{ ' ', '#', '#', '#', '#', ' ', ' ' }, };

	public Model() {
		initData();
		countGoal();

	}

	/**
	 * Initialize elements on the map
	 */
	private void initData() {

		this.boxs = new ArrayList<Box>();
		this.player = new Player(3, 5);
		boxs.add(new Box(3, 2));
		boxs.add(new Box(3, 3));
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

	/**
	 * Count the number of Goal on the map
	 */
	private void countGoal() {
		this.goal = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'x') {
					goal++;
				}
			}
		}
	}

	/**
	 * Player's movement below
	 */
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

	/**
	 * Check if the player's movement is valid
	 * 
	 * @param newPosX
	 * @param newPosY
	 * @param newPosBoxX
	 * @param newPosBoxY
	 * @return
	 */
	private boolean validMove(int newPosX, int newPosY, int newPosBoxX, int newPosBoxY) {
		// the move had to be inside the map size
		if (newPosX >= 0 && newPosX < map.length && newPosY >= 0 && newPosY < map[0].length) {

			Box boxCollision = checkCollision(newPosX, newPosY);

			// if there is a box, manage the collision
			if (boxCollision != null) {

				if (manageCollision(boxCollision, newPosBoxX, newPosBoxY)) {

					char destBox = map[newPosBoxX][newPosBoxY];

					if (destBox == 'x') {

						goalReached++;
						boxCollision.setGoaled(true);

					} else if (boxCollision.getGoaled()) {

						goalReached--;
						boxCollision.setGoaled(false);
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

	/**
	 * Manage the box's collision
	 * 
	 * @param box
	 * @param newPosBoxX
	 * @param newPosBoxY
	 * @return
	 */
	private boolean manageCollision(Box box, int newPosBoxX, int newPosBoxY) {

		if (map[newPosBoxX][newPosBoxY] != '#' && checkCollision(newPosBoxX, newPosBoxY) == null) {

			box.setX(newPosBoxX);
			box.setY(newPosBoxY);
			return true;
		}

		return false;
	}

	/**
	 * Player check if there is a box
	 * 
	 * @param newPosX
	 * @param newPosY
	 * @return
	 */
	private Box checkCollision(int newPosX, int newPosY) {
		for (Box box : this.boxs) {

			if (newPosX == box.getX() && newPosY == box.getY()) {
				return box;
			}
		}
		return null;
	}

	/**
	 * Check is the game is win
	 * 
	 * @return
	 */
	public boolean isWin() {
		return goal == goalReached;
	}

	/**
	 * resetData for the restart Button
	 */
	public void resetData() {
		this.initData();

	}

}
