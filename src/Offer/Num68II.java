package Offer;

/**
 * @Author: Waterless
 * @Date: 2022/07/19/23:24
 * @Description: 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Num68II {
    TreeNode node;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root,p,q);
        return node;
    }

    private Boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return  false;
        }
        //去左右子树中寻找 找到一个就算找到
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0;
        //当前结点就是要找的结点
        int mid = (root == p || root == q) ? 1 : 0;
        //通过判断数值是否等于2来确定当前root结点是否是公共祖先
        if (left + right + mid == 2) {
            node = root;
        }
        //只要找到1个就算找到了
        return left + right + mid > 0;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
