package controller;

import model.GameModel;
import view.Board;

public class BoardController {

    private GameModel model;
    private Board mBoard;

    public BoardController(GameModel model,Board mBoard){

        this.model = model;
        this.mBoard = mBoard;

    }

    public void markTurn(int position){
        model.updateMove(position,this.mBoard);

    }

    public void run(){
        this.mBoard.startGame();
    }


}
