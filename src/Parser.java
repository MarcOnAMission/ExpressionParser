

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Parser {
    private static Map<String,Integer> precedence = Map.of(
            "+",1,
            "-",1,
            "*",2,
            "/",2
    );
    private static int getPrec(String op){
        return precedence.getOrDefault(op,0);
    }
    public static TreeNode parseIntoNodes(List<Token> tokenList){
        Deque<String> operatorStack = new ArrayDeque<>();
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        for(Token t : tokenList){
            if(t.getT()==Type.NUMBER){
                nodeStack.push(TreeNode.numberNode(t.getValue()));
            }
            else{
                String currentOperator = t.getOperator();
                while(!operatorStack.isEmpty()){
                    String topOperator = operatorStack.peek();
                    if(topOperator==null) break;
                    int currentPrecedence=getPrec(currentOperator);
                    int topPrecedence=getPrec(topOperator);
                    if(currentPrecedence<=topPrecedence){
                        operatorStack.pop();
                        buildNodeFromTheTop(nodeStack,topOperator);
                    }
                    else {
                        break;
                    }
                }
                operatorStack.push(currentOperator);
            }
        }
        while(!operatorStack.isEmpty()){
            String op = operatorStack.pop();
            buildNodeFromTheTop(nodeStack,op);
        }
        if(nodeStack.isEmpty()){
            throw new RuntimeException("Parser produced no nodes");
        }
        TreeNode rootNode = nodeStack.pop();
        if(!nodeStack.isEmpty()){
            throw new RuntimeException("Parser left nodes in the stack");
        }
        return rootNode;
    }
    private static void buildNodeFromTheTop(Deque<TreeNode> nodeStack, String operator){
        TreeNode right = nodeStack.poll();
        TreeNode left = nodeStack.poll();
        if(left==null || right== null){
            throw new RuntimeException("Expression is not in right shape, missing node");
        }
        TreeNode builtNode = TreeNode.combinedNode(left,right,operator);
        nodeStack.push(builtNode);
    }
    public static double EvaluateRoot(TreeNode rootNode){
        if(rootNode.getValue()!=null) return rootNode.getValue();
        double r = EvaluateRoot(rootNode.getRight());
        double l = EvaluateRoot(rootNode.getLeft());
        if(rootNode.getOperator().equals("/")){
            if(r==0){
                throw new RuntimeException("Cannot divide with 0");
            }
        }
        return switch (rootNode.getOperator()) {
            case "+" -> l + r;
            case "-" -> l - r;
            case "*" -> l * r;
            case "/" -> l / r;
            default -> throw new RuntimeException("Operator not identifiable: " + rootNode.getOperator());
        };
    }
}
