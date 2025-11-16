
import java.util.List;

public class EvaluateData {
    public static double evaluateExpression(String expression){
        List<Token> tokenList = Tokenizer.TokenizeInput(expression);
        TreeNode rootNode = Parser.parseIntoNodes(tokenList);
        return  Parser.EvaluateRoot(rootNode);
    }
}
