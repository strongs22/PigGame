package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState pgs = (PigGameState)info;

        if (this.playerNum != pgs.getCurrPlayer()){
            return;
        }
        if ((int)(Math.random())*2 == 1){
            PigHoldAction pha = new PigHoldAction(this);
            game.sendAction(pha);
        } else {
            PigRollAction pra = new PigRollAction(this);
            game.sendAction(pra);
        }
    }//receiveInfo

}
