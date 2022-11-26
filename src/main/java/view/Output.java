package view;

public class Output {

    public void printHint(int ballCount, int strikeCount) {
        String hint = "";
        if (ballCount > 0) {
            hint += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            hint += strikeCount + "스트라이크";
        }
        if (ballCount == 0 && strikeCount == 0) {
            hint = "낫싱";
        }
        System.out.println(hint);
    }

    public void printResult() {
        System.out.println(Announce.finish.getAnnounce());
        System.out.println(Announce.enterFinishNumber.getAnnounce());
    }
}
