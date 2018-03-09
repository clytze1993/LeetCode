import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;

/**
 * Created by liuwenxiu on 2018/3/4.
 */
public class IsSymmetric {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int sval,TreeNode sleft,TreeNode sright){
            this.val = sval;
            this.left = sleft;
            this.right = sright;
        }
    }
    public void ZXBL(ArrayList list ,TreeNode node){//中序遍历的方式，有问题，badcase：[1,2,3,3,null,2,null]
        if(node==null){
            return;
        }
        if (node.left!=null){
            ZXBL(list,node.left);
        }
        list.add(node.val);
        if (node.right!=null){
            ZXBL(list,node.right);
        }
        return;
    }
    public Boolean isSymmetric1(TreeNode root){//将二叉树中序遍历得到arraylist，然后判断arraylist是否对称，部分case无法通过
        ArrayList tree = new ArrayList();
        ZXBL(tree,root);
        int len = tree.size();
        if(len % 2 == 0){
            return false;
        }
        else {
            for (int i = 0; i < len / 2; i++) {
                if (tree.get(i) != tree.get(len - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
    public boolean isSymmetric(TreeNode root){
        boolean result = isMirror(root,root);
        return result;
    }
    //重点是把判断是否对称问题，转化成两课子树是否是镜面的问题；
    public boolean isMirror(TreeNode left, TreeNode right){
            if(left==null&&right==null){
                return true;
            }
            if(left==null || right == null){
                return false;
            }
            return (left.val==right.val) &&
                    (isMirror(left.left,right.right)) &&
                    (isMirror(left.right,right.left));
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
        Boolean resulst = new  IsSymmetric().isSymmetric(tree);
        System.out.println(resulst);
    }
}
