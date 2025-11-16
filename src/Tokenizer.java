import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static List<Token> TokenizeInput(String inputString) {
        List<Token> tokenList = new ArrayList<>();
        int i = 0;

        while (i < inputString.length()) {
            char c = inputString.charAt(i);

            if (Character.isDigit(c)) {
                double value = c - '0';
                i++;

                while (i < inputString.length() && Character.isDigit(inputString.charAt(i))) {
                    value = value * 10 + (inputString.charAt(i) - '0');
                    i++;
                }

                tokenList.add(Token.numberToken(Type.NUMBER, value));
            } else {
                switch (c) {
                    case '/':
                        tokenList.add(Token.operatorToken(Type.DIVISION, "/"));
                        break;
                    case '*':
                        tokenList.add(Token.operatorToken(Type.MULTIPLICATION, "*"));
                        break;
                    case '+':
                        tokenList.add(Token.operatorToken(Type.ADDITION, "+"));
                        break;
                    case '-':
                        tokenList.add(Token.operatorToken(Type.SUBTRACTION, "-"));
                        break;
                    default:
                        throw new RuntimeException("Unknown character: " + c);
                }
                i++;
            }
        }

        if (tokenList.isEmpty()) {
            throw new RuntimeException("Token list is empty.");
        }

        return tokenList;
    }
}
