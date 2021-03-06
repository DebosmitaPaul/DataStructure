import java.util.*;

/*

    3
   / \
  9   20
     / \
    15  7

o/p:   [3], [20,9], [15,7]

 */
public class BinaryTree_ZigZagLevelOrder {
    public static void main(String[] args) {
        BinaryTree_ZigZagLevelOrder zigZag = new BinaryTree_ZigZagLevelOrder();
        TreeNode root = zigZag.createBinaryTree();
        List<List<Integer>> lists =zigZag.zigzagLevelOrder(root);
        System.out.println(lists);
//        lists.forEach(i->{
//            System.out.println(i);
//        });
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 1;
            while (!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                while (size>0) {
                    size--;
                    TreeNode curr = queue.poll();
                    list.add(curr.data);
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
                if(level%2 != 0){
                    result.add(list);
                }else{
                    List<Integer> revList = new ArrayList<>();
                    for (int i = list.size()-1; i>=0 ; i--) {
                        revList.add(list.get(i));
                    }
                    result.add(revList);
                }
                level++;
            }
        }
        return result;
    }

    //Method 2 -> my implementation
    static Map<Integer, List<Integer>> maplist = new HashMap<>();
    List<List<Integer>> zigzagLevelOrder_02(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        addDepthOfNodes(root,0);
        maplist.keySet().stream().sorted().forEach(i->{
            if(i%2 !=0){
                Collections.reverse(maplist.get(i));
            }
            resultList.add(maplist.get(i));
        });
        return resultList;
    }

    private void addDepthOfNodes(TreeNode root, int depth) {
        if(root == null){
            return;
        }
            List<Integer> list = maplist.getOrDefault(depth, new ArrayList<>());
            list.add(root.data);
            if (!maplist.containsKey(depth)) {
                maplist.put(depth, list);
            }

        addDepthOfNodes(root.left,depth+1);
        addDepthOfNodes(root.right,depth+1);
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
        TreeNode rootNode = new TreeNode(1);
        rootNode.left= new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(7);
        rootNode.left.right = new TreeNode(6);
        rootNode.right.left = new TreeNode(5);
        rootNode.right.right = new TreeNode(4);

        return rootNode;
    }
}
