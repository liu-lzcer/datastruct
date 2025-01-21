import static java.lang.Math.abs;
import static java.lang.Math.max;

public class BalancedBinaryTree {

    class ReturnType {
        Integer height = 0;
        boolean isBalanced;
        ReturnType() {}
        ReturnType(Integer height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {

        return process(root).isBalanced;
    }

    public ReturnType process(TreeNode root) {
        if(root == null) {
            return new ReturnType(0,true);
        }

        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);

        Integer height = max(leftData.height, rightData.height) + 1;

        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && abs(leftData.height - rightData.height) < 2;

        return new ReturnType(height, isBalanced);
    }

/*

class Solution {
    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(right - left) > 1) {
            res = false;
        }
        return Math.max(left, right);
    }
}

*/

    public static void main(String[] args) {

    }
}
