package SumRootToLeafNumbers;

/**
 * 思路：这题比较奇怪的地方在于转换思路：：
 * 10*root.val+root.left+root.right+10*root.val
 * 问题在于    如果没有定义中间变量  就会无法做
 *
 * 因为这样迭代过程中  只会陈一次  肯定是不行的  就必须要转化思路  化为两个函数参数  temp来记忆
 *
 *
 */
public class SumRootToLeafNumbers{
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int summary = 0;
        summary =sum(root,0);
        return summary;
    }
    public int sum(TreeNode root,int temp){
        if(root.left != null && root.right != null){
            return sum(root.left,10*(root.val+temp))+sum(root.right,10*(root.val+temp));
        }
        if(root.left != null){
            return sum(root.left,10*(root.val+temp));

        }else if(root.right != null){
            return sum(root.right,10*(root.val+temp));
        }else{
            return root.val+temp;
        }
    }
}

