import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

/**
 * Created by liuwenxiu on 2018/3/6.
 */
public class MaxDepth {
    private int max_depth = 0;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int sval,TreeNode sright,TreeNode sleft){
            this.val = sval;
            this.right = sright;
            this.left = sleft;
        }
    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int result = ZXBL(1,root);
        return result;
    }
    public int ZXBL(int depth,TreeNode tree){
        if(depth >this.max_depth){
            this.max_depth = depth;
        }
        if(tree.left!=null){
            ZXBL(depth+1,tree.left);
        }
        if(tree.right!=null){
            ZXBL(depth+1,tree.right);
        }
        return this.max_depth;
    }
    public static void main(String[] args){
        TreeNode tree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,null,null),
                        new TreeNode(4,null,null)
                ),
                new TreeNode(2,
                        new TreeNode(4,null,null),
                        new TreeNode(3,null,null))
        );
        int result = new MaxDepth().maxDepth(tree);
        System.out.print(result);
    }
}
