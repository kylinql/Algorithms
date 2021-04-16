package tree02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 树的构造测试
 */
public class TreeConstructTest {
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

        //先序遍历
        System.out.println("先序遍历：");
        TreeConstruct.preTraverse(root);
        System.out.println();

        //中序遍历
        System.out.println("中序遍历：");
        TreeConstruct.middleTraverse(root);
        System.out.println();

        //后序遍历
        System.out.println("后序遍历：");
        TreeConstruct.postTraverse(root);
        System.out.println();

        //层次遍历
        System.out.println("层次遍历：");
        TreeConstruct.levelTraverse(root);
    }
}
