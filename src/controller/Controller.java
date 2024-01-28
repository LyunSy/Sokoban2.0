package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.*;
import vue.*;

public class Controller {

    private Model model;
    private Vue vue;

    public Controller() {
        this.model = new Model();
        this.vue = new Vue();
        this.vue.addKeyListener(new KeyAdapter() {
        	
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					model.moveUP();
					break;
				case KeyEvent.VK_DOWN:
					model.moveDOWN();
					break;
				case KeyEvent.VK_LEFT:
					model.moveLEFT();
					break;
				case KeyEvent.VK_RIGHT:
					model.moveRIGHT();
					break;
				default:
					
				}
				vue.putPlayer(model.getPlayerX(), model.getPlayerY() );
			
			}
			
		});
    }

    public void startGame() {
    	char[][] map = this.model.getMap();
        this.vue.initMap(map, this.model.getPlayerX(), this.model.getPlayerY());
        vue.initView();
        
    }
    
  
    
    

}
