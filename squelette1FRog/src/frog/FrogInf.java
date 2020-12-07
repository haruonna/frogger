package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Case;
import util.Direction;

import java.awt.*;


public class FrogInf implements IFrog {


    private Game game;
    private Case myPosition;
    private Direction direction;
    private Boolean gameLose;

    public FrogInf(Game game) {
        this.game = game;
        this.myPosition = new Case(game.width / 2, 1);
        this.direction = Direction.up;
        this.gameLose = false;
    }


    public Case getPosition() {
        return this.myPosition;
    }


    public Direction getDirection() {
        return this.direction;
    }


    public void move(Direction key) {

        if (!this.gameLose) {

            if (key.equals(Direction.up)) {
                myPosition.ord = myPosition.ord + 1;
                this.direction = Direction.up;
                this.game.currentScore++;
                if (this.game.currentScore > this.game.maxScore) {
                    this.game.addLane();
                    this.game.maxScore = this.game.currentScore;
                }
            }
            if (key.equals(Direction.down) && this.myPosition.ord > 1) {
                myPosition.ord = myPosition.ord - 1;
                this.direction = Direction.down;
                this.game.currentScore--;
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


        public Boolean getGameLose () {
            return this.gameLose;
        }

    }


