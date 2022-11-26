package view;

public class Valid {

    public static boolean isInputEmpty(String number) {
        return number.equals("");
    }

    public static boolean isInputLetter(String number) {
        return !number.replaceAll("[0-9]", "").equals("");
    }

    public static boolean isInputOverLength(String number) {
        return number.length() != 3;
    }

    public static void isInputValid(String number) {
        if (isInputEmpty(number) | isInputLetter(number) | isInputOverLength(number)) {
            throw new IllegalArgumentException("[ERROR] 1-9까지의 수 중 중복되지 않는 3개의 숫자를 입력하세요.");
        }
    }

    public static boolean isInputIsNotOneOrTwo(String number) {
        return !number.equals("1") && !number.equals("2");
    }

    public static void isInputFinishValid(String number) {
        if (isInputEmpty(number) || isInputIsNotOneOrTwo(number)) {
            throw new IllegalArgumentException("[ERROR] 1 or 2 중 하나의 숫자를 입력해 주세요.");
        }
    }
}
