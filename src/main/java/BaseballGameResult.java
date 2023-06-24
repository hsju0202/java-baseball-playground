public class BaseballGameResult {

    private int strikeCount;
    private int ballCount;

    public BaseballGameResult() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public boolean winThisGame() {
        if (this.strikeCount == 3) {
            return true;
        }

        return false;
    }

    public void summary(BaseballType type) {
        if (type.equals(BaseballType.STRIKE)) {
            strikeCount++;
        }

        if (type.equals(BaseballType.BALL)) {
            ballCount++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.ballCount == 0 && this.strikeCount == 0) {
            sb.append("낫싱");

            return sb.toString();
        }

        if (this.strikeCount == 3) {
            sb.append("3스트라이크")
              .append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return sb.toString();
        }

        if (this.ballCount > 0) {
            sb.append(this.ballCount)
              .append("볼 ");
        }

        if (this.strikeCount > 0) {
            sb.append(this.strikeCount)
              .append("스트라이크");
        }

        return sb.toString();
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
