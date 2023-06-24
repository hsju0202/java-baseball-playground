import java.util.Random;

public class BaseballGame {

    public void start() {
        String answer = generateAnswer();
        View view = new View();

        String input;
        BaseballGameResult result;
        String outMessage;

        do {
            input = view.read("숫자를 입력해 주세요 : ");
            result = compareToAnswer(answer, input);
            outMessage = result.toString();
            view.out(outMessage);
        }
        while(!result.winThisGame());

        String newGameFlag = view.read("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if ("1".equals(newGameFlag)) {
            start();
        }
    }

    private BaseballGameResult compareToAnswer(String answer, String input) {
        BaseballGameResult result = new BaseballGameResult();

        for (int i = 0; i < answer.length(); i++) {
            char answerChar = answer.charAt(i);
            char inputChar = input.charAt(i);
            BaseballType type = getBaseballType(answer, answerChar, inputChar);
            result.summary(type);
        }

        return result;
    }

    private BaseballType getBaseballType(String answer, char answerChar, char inputChar) {
        if (answerChar == inputChar) {
            return BaseballType.STRIKE;
        }

        if (answer.contains(String.valueOf(inputChar))) {
            return BaseballType.BALL;
        }

        return BaseballType.OUT;
    }

    private String generateAnswer() {
        StringBuilder sb = new StringBuilder();

        while (sb.length() < 3) {
            int number = getNotExistNumber(sb);
            sb.append(number);
        }

        return sb.toString();
    }

    private int getNotExistNumber(StringBuilder sb) {
        int number = generateRandomNumber();
        boolean isExist = checkExist(sb, number);

        if (!isExist) {
            return number;
        }

        return getNotExistNumber(sb);
    }

    private boolean checkExist(StringBuilder sb, int number) {
        String numberString = String.valueOf(number);
        return sb.toString().contains(numberString);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

}
