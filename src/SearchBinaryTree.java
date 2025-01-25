public class SearchBinaryTree {

    class ReturnType {
        int left;
        int right;
        boolean isAllowed;
        ReturnType() {
            this.isAllowed = true;
        }
        ReturnType(int left, int right, boolean isAllowed) {
            this.right = right;
            this.left = left;
            this.isAllowed = isAllowed;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return solution(root).isAllowed;
    }
    public ReturnType solution(TreeNode root) {
        ReturnType res= new ReturnType();
        ReturnType left = new ReturnType();
        ReturnType right = new ReturnType();
        if(root.left == null)
            left.left = root.val;
        else
            left = solution(root.left);
        if(root.right == null)
            right.right = root.val;
        else
            right = solution(root.right);

        res.left = left.right;
        res.right = right.left;

        boolean isAllowed = left.isAllowed && right.isAllowed && (res.left < root.val || root.left == null) && (root.val < res.right || root.right == null);

        res.left = left.left;
        res.right = right.right;

        return new ReturnType(res.left, res.right, isAllowed);
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2,left, right);

        SearchBinaryTree searchBinaryTree = new SearchBinaryTree();
        System.out.println(searchBinaryTree.isValidBST(root));
    }
}
