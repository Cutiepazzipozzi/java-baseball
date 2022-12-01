package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String enterUserNumber() {
        System.out.print(Announce.enterNumber.getAnnounce());
        String input = Console.readLine();
        Valid.isInputValid(input);
        return input;
    }

    public String enterFinishCommand() {
        String input = Console.readLine();
        Valid.isInputFinishValid(input);
        return input;
    }
}
