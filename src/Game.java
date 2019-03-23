import controller.BoardController;
import model.GameModel;
import view.Board;

public class Game {

    public static void main(String[] args) {
        Board mBoard = new Board();
        GameModel model = new GameModel();
        BoardController controller = new BoardController(model,mBoard);
        controller.run();

    }
}
