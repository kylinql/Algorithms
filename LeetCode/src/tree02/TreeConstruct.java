package tree02;

import java.util.*;

public class TreeConstruct {
    public static ArrayList<TreeNode> createTree(String[] valArray, TreeNode root){
        ArrayList<TreeNode> treeList = new ArrayList<>();
        treeList.add(root);

        int num = valArray.length;

        for (int i = 1; i < num; i++) {
            TreeNode treeNode;
            if("null".equals(valArray[i])){
                treeNode = new TreeNode(Integer.MIN_VALUE);
            }
            else{
                treeNode = new TreeNode(Integer.parseInt(valArray[i]));
            }
            treeList.add(treeNode);
        }

        //根据层次遍历，建立连接
        for (int i = 0; i < num; i++) {
            TreeNode treeNode;
            if(2*i+1 < num && 2*i+2 < num){
                treeNode = treeList.get(i);
                treeNode.left = treeList.get(2*i+1);
                treeNode.right = treeList.get(2*i+2);
            }
        }

        return treeList;
    }

    /**
     * 先序遍历
     * 先遍历根节点，然后左子树，右子树
     * @param root
     */
    public static void preTraverse(TreeNode root){
        if(root == null){
            return;
        }
        int value = root.val;
        if (value == Integer.MIN_VALUE){
            System.out.print("null ");
        }
        else{
            System.out.print(root.val + " ");
        }
        preTraverse(root.left);
        preTraverse(root.right);
    }

    /**
     * 中序遍历
     * 先左子树，输出根节点，右子树
     * @param root
     */
    public static void middleTraverse(TreeNode root){
        if(root == null){
            return;
        }
        middleTraverse(root.left);
        int value = root.val;
        if (value == Integer.MIN_VALUE){
            System.out.print("null ");
        }
        else{
            System.out.print(root.val + " ");
        }
        middleTraverse(root.right);
    }

    /**
     * 后序遍历
     * 先左子树，再右子树，最后输出根节点
     * @param root
     */
    public static void postTraverse(TreeNode root){
        if(root == null){
            return;
        }
        middleTraverse(root.left);
        middleTraverse(root.right);

        int value = root.val;
        if (value == Integer.MIN_VALUE){
            System.out.print("null ");
        }
        else{
            System.out.print(root.val + " ");
        }

    }

    /**
     * 层次遍历:
     * 利用队列这种数据结构
     * @param root
     */
    public static void levelTraverse(TreeNode root){
        List<String> levelList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        if(root == null){
            return;
        }

        deque.addLast(root);

        TreeNode current = root;
        while(!deque.isEmpty()){
            current = deque.pollFirst();
            if(current.left != null){
                deque.addLast(current.left);
            }
            if(current.right != null){
                deque.addLast(current.right);
            }

            int value = current.val;
            if (value == Integer.MIN_VALUE){
                levelList.add("null");
            }
            else{
                levelList.add(Integer.toString(value));
            }
        }
        System.out.println(levelList);
    }

}
