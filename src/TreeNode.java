
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private Double value;
    private String operator;
    TreeNode(TreeNode left,TreeNode right,Double value, String operator){
        this.left=left;
        this.right=right;
        this.value=value;
        this.operator=operator;
    }
    public static TreeNode numberNode(Double value){
        return new TreeNode(null,null,value,null);
    }
    public static TreeNode combinedNode(TreeNode left,TreeNode right,String operator){
        return new TreeNode(left,right,null,operator);
    }
    @Override
    public String toString() {
        if (this.value!=null) return String.valueOf(value);
        return "(" + (left != null ? left.toString() : "?") +
                " " + operator + " " +
                (right != null ? right.toString() : "?") + ")";
    }
    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
