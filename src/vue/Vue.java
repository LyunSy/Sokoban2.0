package vue;

import javax.swing.*;


public class Vue extends JFrame {

    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int CELLSIZE = 40;
    private JLabel labelPlayer;
	private ImageIcon imageWall;
	private ImageIcon imageBox;
	private ImageIcon imageGoal;
	private ImageIcon imageEmptySpace;
	private ImageIcon imagePlayer;


    public Vue() {
    	this.imageWall = new ImageIcon("src/image/wall.png");
    	this.imageBox = new ImageIcon("src/image/box.png");
    	this.imageGoal = new ImageIcon("src/image/goal.png");
    	this.imageEmptySpace = new ImageIcon("src/image/emptyspace.png");
    	this.imagePlayer = new ImageIcon("src/image/player.png");
    	this.labelPlayer = new JLabel();
    	labelPlayer.setIcon(imagePlayer);
       
        getContentPane().add(labelPlayer);
    	

    }

    public void initView() {
    	setTitle("Sokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    
    
    public void initMap(char[][] map, int playerX, int playerY) {
    	getContentPane().setLayout(null);
    	this.putPlayer(playerX, playerY);
       
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
                  else if (map[i][j] == '$') {
                	label.setIcon(imageBox);
                }
                
                
                label.setBounds(j * CELLSIZE, i * CELLSIZE, CELLSIZE, CELLSIZE);
                getContentPane().add(label);
            }
        }
        
        pack(); 
   
    }
    
    public void putPlayer(int playerX, int playerY) {
    	labelPlayer.setBounds(playerY * CELLSIZE, playerX * CELLSIZE, CELLSIZE, CELLSIZE);
    }
}


