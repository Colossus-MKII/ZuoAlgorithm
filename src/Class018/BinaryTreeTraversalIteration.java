package Class018;

import Class017.BinaryTreeTraversalRecursion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversalIteration {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        System.out.println();
    }

    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    public static void posOrderTwoStacks(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collections = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                collections.push(top);
                if (top.left != null) {
                    stack.push(top.left);
                }
                if (top.right != null) {
                    stack.push(top.right);
                }
            }
            while (!collections.isEmpty()) {
                System.out.print(collections.pop().val + " ");
            }
            System.out.println();
        }
    }

    public static void posOrderOneStack(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode top = stack.peek();
                if (top.left != null && head != top.left && head != top.right) {
                    stack.push(top.left);
                } else if (top.right != null && head != top.right) {
                    stack.push(top.right);
                } else {
                    System.out.print(top.val + " ");
                    head = stack.pop();
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        preOrder(head);
        System.out.println("PreOrder Traversal");
        inOrder(head);
        System.out.println("InOrder Traversal");
        posOrderTwoStacks(head);
        System.out.println("PosOrderTwoStacks Traversal");
        posOrderOneStack(head);
        System.out.println("PosOrderOneStack Traversal");
    }

    public static List<Integer> preorderTraversal(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                result.add(top.val);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    ans.add(head.val);
                    head = head.right;
                }
            }
        }
        return ans;
    }


//    public static List<Integer> postorderTraversal(TreeNode head) {
//        List<Integer> ans = new ArrayList<>();
//        if (head != null) {
//            Stack<TreeNode> stack = new Stack<>();
//            Stack<TreeNode> collections = new Stack<>();
//            stack.push(head);
//            while (!stack.isEmpty()) {
//                TreeNode top = stack.pop();
//                collections.push(top);
//                if (top.left != null) {
//                    stack.push(top.left);
//                }
//                if (top.right != null) {
//                    stack.push(top.right);
//                }
//            }
//            while (!collections.isEmpty()) {
//                ans.add(collections.pop().val);
//            }
//        }
//        return ans;
//    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && cur.left != root && cur.right != root) {
                    stack.push(cur.left);
                } else if (cur.right != null && cur.right != root) {
                    stack.push(cur.right);
                } else {
                    ans.add(cur.val);
                    root = stack.pop();
                }
            }
        }
        return ans;
    }

}

