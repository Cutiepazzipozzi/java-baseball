package view;

public enum Announce {
    start("숫자 야구 게임을 시작합니다."),
    enterNumber("숫자를 입력해주세요 : "),
    finish("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    enterFinishNumber("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String announce;
    private Announce(String announce) {
        this.announce = announce;
    }

    public String getAnnounce() {
        return this.announce;
    }
}
