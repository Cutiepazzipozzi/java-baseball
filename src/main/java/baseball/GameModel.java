package baseball;

import utils.RandomNumberGenerator;
import java.util.List;

public class GameModel {

    private List<Integer> answer = RandomNumberGenerator.generate();

    private int ballCount = 0;

    private int strikeCount = 0;

    public GameModel() {}

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public void count(String input) {
        String[] numbers = input.split("");

        this.countStrike(numbers);
        this.countBall(numbers);
    }

    private void countStrike(String[] numbers) {
        int strikeCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == Integer.parseInt(numbers[i])) {
                strikeCount++;
            }
        }

        this.strikeCount = strikeCount;
    }

    private void countBall(String[] numbers) {
        int ballCount = 0;

        for (String s : numbers) {
            if (answer.contains(Integer.parseInt(s))) {
                ballCount++;
            }
        }

        this.ballCount = ballCount - this.strikeCount;
    }

    private void changeAnswer() {
        this.answer = RandomNumberGenerator.generate();
    }
}
