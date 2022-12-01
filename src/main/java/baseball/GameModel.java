package baseball;

import utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameModel {

    private List<Integer> answer = RandomNumberGenerator.generate();

    private List<Integer> ballAndStrike;

    private int strikeCount = 0;

    public GameModel() {}

    public int getBallCount() {
        return this.ballAndStrike.get(0);
    }

    public int getStrikeCount() {
        return this.ballAndStrike.get(1);
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public void countBall(String[] numbers) {
        for (String s : numbers) {
            if (answer.contains(Integer.parseInt(s))) {
                ballAndStrike.set(0, ballAndStrike.get(0) + 1);
            }
        }
    }

    public void countStrike(String[] numbers) {
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == Integer.parseInt(numbers[i])) {
                ballAndStrike.set(1, ballAndStrike.get(1)+1);
                ballAndStrike.set(0, ballAndStrike.get(0)-1);
            }
        }
    }

    public void count(String input) {
        String[] numbers = input.split("");
        countBall(numbers);
        countStrike(numbers);
    }

    private void changeAnswer() {
        this.answer = RandomNumberGenerator.generate();
    }
}
