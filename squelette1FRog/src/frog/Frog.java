package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case myPosition;

	public Frog(Game game){
		this.game = game;
		this.myPosition = new Case(game.width/2,  0);
	}


	public Case getPosition(){
	return this.myPosition;
	}


	public Direction getDirection(){
	return null;
	}


	public void move(Direction key){
		if (myPosition.ord == 0){
			if(key.equals(Direction.down)){
				myPosition.ord = myPosition.ord;
			}
		}
		if (key.equals(Direction.up)){
			myPosition.ord = myPosition.ord + 1;
		}
		if (key.equals(Direction.down)){
			myPosition.ord = myPosition.ord - 1;
		}
		if (key.equals(Direction.right)){
			myPosition.absc = myPosition.absc + 1;
		}
		if (key.equals(Direction.left)){
			myPosition.absc = myPosition.absc - 1;
		}
	}

}
