package tree02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 二叉树中的最大路径和
 *
 * 路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中至多出现一次 。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 路径和是路径中各节点值的总和。
 * 给一个二叉树的根节点 root，返回其最大路径和。
 */

public class MaxRouteByTree {
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // 1. 输入相关数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入节点个数（含null节点）：");
        int num = sc.nextInt(); //节点个数

        int[] treeVal = new int[num];
        System.out.println("输入节点的值（逗号隔开）：");
        String valStr = sc.next();
        String[] valArray = valStr.split(",");

        // 2. 先创建一个根节点
        TreeNode root = new TreeNode(Integer.parseInt(valArray[0]));
        ArrayList<TreeNode> treeList = TreeConstruct.createTree(valArray, root);

        // 3. 从根节点开始，利用后序遍历法找最长路径
        oneSideMax(root);
        System.out.println(ans);
    }

    /**
     * 单边最大值
     * @param root
     * @return
     */
    public static int oneSideMax(TreeNode root){
        if (root == null){
            return 0;
        }

        // 计算左子树的路径值
        int left = Math.max(0, oneSideMax(root.left));

        // 计算右子树的路径值
        int right = Math.max(0, oneSideMax(root.right));

        // 求当前路径，以及这些路径值
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

}
