import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String operation="20+5*7/2+3+15";
        List<Token> tokens = Tokenizer.TokenizeInput(operation);

        TreeNode rootNode = Parser.parseIntoNodes(tokens);
        System.out.println(rootNode);
        System.out.println("Value is: "+Parser.EvaluateRoot(rootNode));
    }
}