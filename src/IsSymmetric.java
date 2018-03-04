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
    public void ZXBL(ArrayList list ,TreeNode node){
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
    public Boolean isSymmetric(TreeNode root){
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
