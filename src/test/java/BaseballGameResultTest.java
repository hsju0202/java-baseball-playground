import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballGameResultTest {

    BaseballGameResult baseballGameResult;

    @BeforeEach
    void setUp() {
        baseballGameResult = new BaseballGameResult();
    }

    @Test
    void summary() {
        baseballGameResult.summary(BaseballType.STRIKE);
        int strikeCount = baseballGameResult.getStrikeCount();
        int ballCount = baseballGameResult.getBallCount();

        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(0);
    }

    @Test
    void winThisGame() {
        baseballGameResult.summary(BaseballType.STRIKE);
        baseballGameResult.summary(BaseballType.STRIKE);
        baseballGameResult.summary(BaseballType.STRIKE);
        boolean actual = baseballGameResult.winThisGame();

        assertThat(actual).isTrue();
    }

    @Test
    void overrideToString() {
        String nothing = baseballGameResult.toString();

        baseballGameResult.summary(BaseballType.STRIKE);
        baseballGameResult.summary(BaseballType.STRIKE);
        baseballGameResult.summary(BaseballType.STRIKE);
        String win = baseballGameResult.toString();

        assertThat(nothing).isEqualTo("낫싱");
        assertThat(win).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}