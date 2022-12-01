package baseball;

import view.Announce;
import view.Input;
import view.Output;

public class GameController {

    private final Input input = new Input();

    private final Output output = new Output();

    private GameModel gameModel = new GameModel();

    public void startGame() {
        System.out.println(Announce.start.getAnnounce());

        this.inputUserNumber();
    }

    public void restartGame() {
        this.gameModel = new GameModel();

        this.inputUserNumber();
    }

    public void inputFinishCommand() {
        String finishInput = input.enterFinishCommand();

        if (finishInput.equals("1")) {
            this.restartGame();
        }
    }

    public void inputUserNumber() {
        String number = input.enterUserNumber();

        gameModel.count(number);

        this.printHint();
        this.judgeSuccess();
    }

    public void printHint() {
        output.printHint(gameModel.getBallCount(), gameModel.getStrikeCount());
    }

    public void printSuccess() {
        output.printHint(gameModel.getBallCount(), gameModel.getStrikeCount());
        output.printResult();
    }

    public void judgeSuccess() {
        if (gameModel.getStrikeCount() == 3) {
            this.printSuccess();
            this.inputFinishCommand();
            return;
        }
        this.inputUserNumber();
    }
}
