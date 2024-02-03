package vue;

import java.util.ArrayList;

import entity.*;
import entity.Box;

import javax.swing.*;

@SuppressWarnings("serial")
public class Vue extends JFrame {

	private final int WIDTH = 776;
	private final int HEIGHT = 719;
	private final int CELLSIZE = 40;
	private JLabel labelPlayer;
	private ArrayList<JLabel> labelBoxs;
	private ImageIcon imageWall;
	private ImageIcon imageBox;
	private ImageIcon imageGoal;
	private ImageIcon imageEmptySpace;
	private ImageIcon imagePlayer;
	private JButton restartButton;

	public Vue() {
		this.imageWall = new ImageIcon(this.getClass().getResource("/image/wall.png"));
		this.imageBox = new ImageIcon(this.getClass().getResource("/image/box.png"));
		this.imageGoal = new ImageIcon(this.getClass().getResource("/image/goal.png"));
		this.imageEmptySpace = new ImageIcon(this.getClass().getResource("/image/emptySpace.png"));
		this.imagePlayer = new ImageIcon(this.getClass().getResource("/image/player.png"));
		this.labelPlayer = new JLabel();
		this.labelBoxs = new ArrayList<JLabel>();

		restartButton = new JButton("Restart");
		restartButton.setBounds(610, 605, 100, 30);
		restartButton.setFocusable(false);
		getContentPane().add(restartButton);

		labelPlayer.setIcon(imagePlayer);
		getContentPane().add(labelPlayer);

	}

	/**
	 * Initialize the game screen
	 */
	public void initView() {
		setTitle("Sokoban");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	/**
	 * Initialize Boxs
	 * 
	 * @param boxs
	 */
	private void initBoxs(ArrayList<Box> boxs) {
		for (int i = 0; i < boxs.size(); i++) {
			JLabel label = new JLabel();
			label.setIcon(imageBox);
			getContentPane().add(label);
			this.labelBoxs.add(label);
		}
	}

	public void initMap(char[][] map, Player player, ArrayList<Box> boxs) {
		this.initBoxs(boxs);
		getContentPane().setLayout(null);
		this.putPlayer(player);
		this.putBoxs(boxs);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				JLabel label = new JLabel();
				if (map[i][j] == '#') {
					label.setIcon(imageWall);
				} else if (map[i][j] == '.') {
					label.setIcon(imageEmptySpace);
				} else if (map[i][j] == 'x') {
					label.setIcon(imageGoal);
				}

				label.setBounds(j * CELLSIZE, i * CELLSIZE, CELLSIZE, CELLSIZE);
				getContentPane().add(label);
			}
		}

	}

	public void putPlayer(Player player) {
		labelPlayer.setBounds(player.getY() * CELLSIZE, player.getX() * CELLSIZE, CELLSIZE, CELLSIZE);
	}

	public void putBoxs(ArrayList<Box> boxs) {
		for (int i = 0; i < boxs.size(); i++) {
			this.labelBoxs.get(i).setBounds(boxs.get(i).getY() * CELLSIZE, boxs.get(i).getX() * CELLSIZE, CELLSIZE,
					CELLSIZE);
		}
	}

	public void showWinMessage() {
		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(this, "Congratulations! You won!", "You Won", JOptionPane.YES_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

	}

	public JButton getRestartButton() {
		return this.restartButton;
	}
}
