package baseball;

import view.Announce;
import view.Input;
import view.Output;

public class GameController {

    private final Input input = new Input();

    private final Output output = new Output();

    private GameModel gameModel = new GameModel();

    public void finishGame() {
        output.printHint(gameModel.getBallCount(), gameModel.getStrikeCount());
        output.printResult();
        String finishInput = input.finishEnterNumber();
        if (finishInput.equals("1")) {
            gameModel = new GameModel();
            startGame();
        }
    }

    public void startGame() {
        //System.out.println(gameModel.getAnswer());
        String number = input.enterNumber();
        gameModel.count(number);
        while (gameModel.getStrikeCount() != 3) {
            output.printHint(gameModel.getBallCount(), gameModel.getStrikeCount());
            gameModel.clearBallAndStrike();
            startGame();
        }
        finishGame();
    }
}
