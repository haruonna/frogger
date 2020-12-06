package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case myPosition;
	private Direction direction;
	private Boolean gameLose;

	public Frog(Game game){
		this.game = game;
		this.myPosition = new Case(game.width/2,  0);
		this.direction = Direction.up;
		this.gameLose = false;
	}


	public Case getPosition(){
		return this.myPosition;
	}


	public Direction getDirection(){
		return this.direction;
	}


	public void move(Direction key){

		if (!this.gameLose) {

			if (key.equals(Direction.up) && (myPosition.ord < game.height - 1)) {
				myPosition.ord = myPosition.ord + 1;
				this.direction = Direction.up;
			}
			if (key.equals(Direction.down) && (myPosition.ord > 0)) {
				myPosition.ord = myPosition.ord - 1;
				this.direction = Direction.down;
			}
			if (key.equals(Direction.right) && (myPosition.absc < game.width - 1)) {
				myPosition.absc = myPosition.absc + 1;
				this.direction = Direction.right;
			}
			if (key.equals(Direction.left) && (myPosition.absc > 0)) {
				myPosition.absc = myPosition.absc - 1;
				this.direction = Direction.left;
			}
		}
	}

	public Boolean getGameLose(){
		return this.gameLose;
	}

}
