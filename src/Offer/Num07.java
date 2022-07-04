package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/04/11:58
 * @Description: 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Num07 {
    //记录当前遍历到前序遍历的哪个位置
    static  int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,inorder,0,inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }
        if (index == preorder.length) {
            return  null;
        }
        //每次从前序遍历的第一个结点一定是根节点
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        //找到对应的节点值在中序遍历结果中的位置
        int pos = find(root.val,inorder);
        //递归左右子树
        root.left = buildTreeHelper(preorder,inorder,left,pos - 1);
        root.right= buildTreeHelper(preorder,inorder,pos + 1,right);
        return  root;
    }

    private int find(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return  i;
            }
        }
        return  -1;
    }

    //结点类
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
}
