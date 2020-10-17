package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    // instance variables
    private int currPlayer;
    private int player1Score;
    private int player2Score;
    private int total;
    private int dieVal;

    public PigGameState(){
        player1Score = 0;
        player2Score = 0;
        currPlayer = 0;
        total = 0;
        dieVal = 1;
    }
    public PigGameState(int p1, int p2, int player, int tot){
        player1Score = p1;
        player2Score = p2;
        currPlayer = player;
        total = tot;
    }
    public int getCurrPlayer(){ return currPlayer; }
    public int getPlayer1Score(){ return player1Score; }
    public int getPlayer2Score(){ return player2Score; }
    public int getTotal(){ return total; }
    public int getDieVal(){ return dieVal; }

    public void setCurrPlayer(int currPlayer){
        this.currPlayer = currPlayer;
    }
    public void setPlayer1Score(int player1Score){
        this.player1Score = player1Score;
    }
    public void setPlayer2Score(int player2Score){
        this.player2Score = player2Score;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public void setDieVal(int dieVal){
        this.dieVal = dieVal;
    }







}
