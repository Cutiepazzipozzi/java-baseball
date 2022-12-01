package view;

public class Output {

    public void printHint(int ballCount, int strikeCount) {
        String hint = "";

        hint = this.addBallHint(ballCount, hint);
        hint = this.addStrikeHint(strikeCount, hint);
        if (hint.equals("")) hint = "낫싱";

        System.out.println(hint);
    }

    public void printResult() {
        System.out.println(Announce.finish.getAnnounce());
        System.out.println(Announce.enterFinishNumber.getAnnounce());
    }

    public String addBallHint(int ballCount, String hint) {
        if (ballCount > 0) hint += ballCount + "볼 ";

        return hint;
    }

    public String addStrikeHint(int strikeCount, String hint) {
        if (strikeCount > 0) hint += strikeCount + "스트라이크";

        return hint;
    }
}
