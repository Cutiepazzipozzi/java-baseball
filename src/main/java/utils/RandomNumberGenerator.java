package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> generate(){
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);

            if (!answer.contains(number)) {
                answer.add(number);
            }
        }

        return answer;
    }
}
