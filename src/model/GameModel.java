package model;

import view.Board;

public class GameModel {

    private int playerId;
    private char[] symbol;
    int totalMoves=0;
    public GameModel(){
        playerId = 1;
        symbol= new char[2];
        symbol[0]='X';
        symbol[1]='O';


    }

    public void updateMove(int position,Board mBoard){
        if(mBoard.getButtonText(position).equals("")){
            if(this.playerId==1){
                mBoard.changeSymbol(this.symbol[0],position);
            }
            else{
                mBoard.changeSymbol(this.symbol[1],position);

            }
        }
        else{

            return;
        }
        totalMoves++;

        if(checkWin(mBoard))
            reset(mBoard);

        else if(totalMoves==9){
            Board.infoBox("Draw","Match Result");
            reset(mBoard);
        }
        else{
            changePlayer();
        }





    }

    private boolean checkWin(Board mBoard){
        String x,o;
        x = String.valueOf(symbol[0]);
        o = String.valueOf(symbol[1]);
        if( (mBoard.getButtonText(0).equals(x) && mBoard.getButtonText(1).equals(x) && mBoard.getButtonText(2).equals(x))
                ||(mBoard.getButtonText(3).equals(x) && mBoard.getButtonText(4).equals(x) && mBoard.getButtonText(5).equals(x))
                ||(mBoard.getButtonText(6).equals(x) && mBoard.getButtonText(7).equals(x) && mBoard.getButtonText(8).equals(x))
                ||(mBoard.getButtonText(0).equals(x) && mBoard.getButtonText(3).equals(x) && mBoard.getButtonText(6).equals(x))
                ||(mBoard.getButtonText(1).equals(x) && mBoard.getButtonText(4).equals(x) && mBoard.getButtonText(7).equals(x))
                ||(mBoard.getButtonText(2).equals(x) && mBoard.getButtonText(5).equals(x) && mBoard.getButtonText(8).equals(x))
                ||(mBoard.getButtonText(0).equals(x) && mBoard.getButtonText(4).equals(x) && mBoard.getButtonText(8).equals(x))
                ||(mBoard.getButtonText(2).equals(x) && mBoard.getButtonText(4).equals(x) && mBoard.getButtonText(6).equals(x))){
            Board.infoBox("Player 1 won","Match Result");
            return true;

        }
        else if ((mBoard.getButtonText(0).equals(o) && mBoard.getButtonText(1).equals(o) && mBoard.getButtonText(2).equals(o))
                ||(mBoard.getButtonText(3).equals(o) && mBoard.getButtonText(4).equals(o) && mBoard.getButtonText(5).equals(o))
                ||(mBoard.getButtonText(6).equals(o) && mBoard.getButtonText(7).equals(o) && mBoard.getButtonText(8).equals(o))
                ||(mBoard.getButtonText(0).equals(o) && mBoard.getButtonText(3).equals(o) && mBoard.getButtonText(6).equals(o))
                ||(mBoard.getButtonText(1).equals(o) && mBoard.getButtonText(4).equals(o) && mBoard.getButtonText(7).equals(o))
                ||(mBoard.getButtonText(2).equals(o) && mBoard.getButtonText(5).equals(o) && mBoard.getButtonText(8).equals(o))
                ||(mBoard.getButtonText(0).equals(o) && mBoard.getButtonText(4).equals(o) && mBoard.getButtonText(8).equals(o))
                ||(mBoard.getButtonText(2).equals(o) && mBoard.getButtonText(4).equals(o) && mBoard.getButtonText(6).equals(o))) {
            Board.infoBox("Player 2 won","Match Result");
            return true;
        }
        else {
            return false;
        }
    }


    private void changePlayer(){
        if (this.playerId==1){
            this.playerId=2;
        }
        else{
            this.playerId=1;
        }
    }

    private void reset(Board mBoard){
        mBoard.resetBoard();
        this.playerId=1;

    }


}
