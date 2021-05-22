/*
Input :
        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Output :1 2 4 5 6

 */

import java.util.*;

public class BinaryTree_LeftSideView {
    public static void main(String[] args) {
        BinaryTree_LeftSideView lsv = new BinaryTree_LeftSideView();
        TreeNode root = lsv.createBinaryTree();
        leftSideView(root,0,0);
        map.keySet().stream().sorted().forEach(i->{
            System.out.println(map.get(i).get(0).data);
        });
    }
    static Map<Integer, List<NodeHD>> map = new HashMap<>();
    private static void leftSideView(TreeNode root, int hDist, int depth) {
        if(root == null){
            return;
        }
        List<NodeHD> list = map.getOrDefault(depth, new ArrayList<>());
        list.add(new NodeHD(root.data,hDist));

        if(!map.containsKey(depth)){
            map.put(depth,list);
        }

        leftSideView(root.left, hDist+1, depth+1);
        leftSideView(root.right, hDist-1, depth+1);
    }
    static class NodeHD implements Comparable{
        int data;
        int hd;

        public NodeHD(int data, int hd) {
            this.data = data;
            this.hd = hd;
        }

        @Override
        public int compareTo(Object o) {
            NodeHD nd = (NodeHD)o;
            return this.hd - nd.hd;
        }
    }
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }
    private TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        root.right = new TreeNode(3);

        return root;
    }
}
