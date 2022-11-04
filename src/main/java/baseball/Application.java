package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void startAnnounce() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void finishAnnounce() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while(randomNumber.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(randomNum)) {
                randomNumber.add(randomNum);
            }
        }
        return randomNumber;
    }
    public static boolean enterNumberLengthExcept(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        if (userEnterNumber.length() != 3) {
            isEnterNumberExcept = true;
        }
        return isEnterNumberExcept;
    }
    public static boolean isEnterNumberRepeat(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        if (userEnterNumber.charAt(0) == userEnterNumber.charAt(1) || userEnterNumber.charAt(1) == userEnterNumber.charAt(2)
                || userEnterNumber.charAt(0) == userEnterNumber.charAt(2)) {
            isEnterNumberExcept = true;
        }
        return isEnterNumberExcept;
    }
    public static boolean hasEnterNumberNoNumber(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        List<Integer> OneToNine = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 3; i++) {
            if (!OneToNine.contains(Character.getNumericValue(userEnterNumber.charAt(i)))) {
                isEnterNumberExcept = true;
            }
        }
        return isEnterNumberExcept;
    }
    public static boolean isEnterNumberExcept(String userEnterNumber) {
        boolean isExcepted = false;
        if (enterNumberLengthExcept(userEnterNumber) || isEnterNumberRepeat(userEnterNumber) || hasEnterNumberNoNumber(userEnterNumber)) {
            isExcepted = true;
        }
        return isExcepted;
    }
    public static List<Integer> getEnterNumber(String userEnterNumber) {
        List<Integer> enterNumber = new ArrayList<>();
        if (!isEnterNumberExcept(userEnterNumber)) {
            for (int i = 0; i < 3; i++) {
                enterNumber.add(Character.getNumericValue(userEnterNumber.charAt(i)));
            }
        }
        if (isEnterNumberExcept(userEnterNumber)) {
            throw new IllegalArgumentException("정확한 세 자리 숫자를 입력해주세요");
        }
        return enterNumber;
    }
    public static List<Integer> countBallAndStrike(List<Integer> randomNumber, List<Integer> enterNumber) {
        List<Integer> ballAndStrike = new ArrayList<>(Arrays.asList(0, 0));
        for (int i = 0; i < 3; i++) {
            if (randomNumber.contains(enterNumber.get(i))) {
                ballAndStrike.set(0, ballAndStrike.get(0)+1);
            }
            if (randomNumber.get(i) == enterNumber.get(i)) {
                ballAndStrike.set(1, ballAndStrike.get(1)+1);
                ballAndStrike.set(0, ballAndStrike.get(0)-1);
            }
        }
        return ballAndStrike;
    }
    public static void caseOfAllStrike(String enterOneOrTwo) {
        if (enterOneOrTwo.equals("1")) {
            game();
        }
        if (!enterOneOrTwo.equals("1") && !enterOneOrTwo.equals("2")) {
            throw new IllegalArgumentException("숫자를 1, 2 중에 하나를 입력해주세요!");
        }
    }
    public static void caseOfAllBallAndStrike(List<Integer> ballAndStrikeNumber) {
        String announceBallAndStrike = "";
        if (ballAndStrikeNumber.get(0) == 0 && ballAndStrikeNumber.get(1) == 0) {
            announceBallAndStrike += "낫싱";
        }
        if (ballAndStrikeNumber.get(0) > 0) {
            announceBallAndStrike += String.valueOf(ballAndStrikeNumber.get(0)) + "볼 ";
        }
        if (ballAndStrikeNumber.get(1) > 0) {
            announceBallAndStrike += String.valueOf(ballAndStrikeNumber.get(1)) + "스트라이크";
        }
        System.out.println(announceBallAndStrike);
    }
    public static void announceBallAndStrike(List<Integer> randomNumber, List<Integer> ballAndStrikeNumber) {
        if (ballAndStrikeNumber.get(1) == 3) {
            finishAnnounce();
            String oneOrTwo = Console.readLine();
            caseOfAllStrike(oneOrTwo);
        }
        if (ballAndStrikeNumber.get(1) < 3) {
            caseOfAllBallAndStrike(ballAndStrikeNumber);
            repeatGameUntilSuccess(randomNumber);
        }
    }
    public static void repeatGameUntilSuccess(List<Integer> randomNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String userEnterNumber = Console.readLine();
        List<Integer> enterNumber = getEnterNumber(userEnterNumber);
        List<Integer> ballAndStrikeNumber = countBallAndStrike(randomNumber, enterNumber);
        announceBallAndStrike(randomNumber, ballAndStrikeNumber);
    }
    public static void game() {
        List<Integer> randomNumber = getRandomNumber();
        System.out.print("숫자를 입력해주세요 : ");
        String userEnterNumber = Console.readLine();
        List<Integer> enterNumber = getEnterNumber(userEnterNumber);
        List<Integer> ballAndStrikeNumber = countBallAndStrike(randomNumber, enterNumber);
        announceBallAndStrike(randomNumber, ballAndStrikeNumber);
    }

    public static void main(String[] args) {
        startAnnounce();
        game();
    }
}
