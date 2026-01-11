package Class017;

public class BinaryTreeTraversalRecursion {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public static void main(String[] args) {
            TreeNode head = new TreeNode(1);
            head.left = new TreeNode(2);
            head.right = new TreeNode(3);
            head.left.left = new TreeNode(4);
            head.left.right = new TreeNode(5);
            head.right.left = new TreeNode(6);
            head.right.right = new TreeNode(7);

            preOrder(head);
            System.out.println();
            System.out.println("PreOrder");

            inOrder(head);
            System.out.println();
            System.out.println("InOrder");

            postOrder(head);
            System.out.println();
            System.out.println("PostOrder");
        }

        public TreeNode(int v) {
            val = v;
        }
    }

    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }

    public static void postOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val + " ");
    }
}
