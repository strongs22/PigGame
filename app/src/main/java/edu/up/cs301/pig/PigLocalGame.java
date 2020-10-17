package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState pgs;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        pgs = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (pgs.getCurrPlayer() == playerIdx){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        int currPlayerNum = pgs.getCurrPlayer();

        if (action instanceof PigHoldAction){
            if (currPlayerNum == 0){
                pgs.setPlayer1Score(pgs.getPlayer1Score() + pgs.getTotal());
                if (playerNames.length == 2){
                    pgs.setCurrPlayer(1);
                }
                pgs.setTotal(0);
                return true;
            }
            if (currPlayerNum == 1){
                pgs.setPlayer2Score(pgs.getPlayer1Score() + pgs.getTotal());
                pgs.setCurrPlayer(0);
                pgs.setTotal(0);
                return true;
            }
        } else if (action instanceof PigRollAction) {
            pgs.setDieVal((int) (Math.random()) * 6);
            if (pgs.getDieVal() == 1) {
                pgs.setTotal(pgs.getTotal() + pgs.getDieVal());
                return true;
            } else {
                pgs.setTotal(0);
                if (playerNames.length == 2) {
                    if (currPlayerNum == 0) {
                        pgs.setCurrPlayer(1);
                    }
                    if (currPlayerNum == 1) {
                        pgs.setCurrPlayer(0);
                    }
                }
                return true;
            }
        }
        //TODO  You will implement this method
        return false;
    }//makeMove
    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState gameState = pgs;
        p.sendInfo(pgs);

    }//sendUpdatedSate
    /**
     * Check if the game is over
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if (pgs.getPlayer1Score() >= 50){
            return "Player 1 wins. Score: " + pgs.getPlayer1Score();
        }
        if (pgs.getPlayer1Score() >= 50){
            return "Player 2 wins. Score: " + pgs.getPlayer1Score();
        }
        return null;
    }

}// class PigLocalGame
