package baseball;

import view.Announce;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        System.out.println(Announce.start.getAnnounce());
        gameController.startGame();
    }
}
