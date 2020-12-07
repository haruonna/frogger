package environment;

import environment.Lane;
import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;
import java.util.Iterator;

public class EnvInf implements IEnvironment {

        private ArrayList<Lane> roadLines;
        private Game game;
        private int bottomLane ;

        public EnvInf(Game game) {
            this.game = game;
            this.roadLines = new ArrayList();
            this.roadLines.add(new Lane(game, 0, 0.0D));
            this.roadLines.add(new Lane(game, 1, 0.0D));
            bottomLane = 2;

            for (int i = bottomLane; i < game.height ; ++i) {
                this.roadLines.add(new Lane(game, i));
            }
        }

        public void addLane() {
           this.roadLines.add(new Lane (game, this.roadLines.size()));
        }

        public boolean isSafe(Case c) {
            return ((Lane) this.roadLines.get(c.ord)).isSafe(c);
        }

        public boolean isWinningPosition(Case c) {
            return c.ord == this.game.height - 1;
        }

        public void update() {
            Iterator var2 = this.roadLines.iterator();

            while(var2.hasNext()) {
                Lane lane = (Lane)var2.next();
                lane.update();
            }
        }
    }

