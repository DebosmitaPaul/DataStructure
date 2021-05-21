/**horizontal distance : reference point -root,left->+1,right->-1
 * depth
 *              6
 *           5     7
 *         4   9
 *           8   0
 *         2   1
 *       5  9
 *      8 9
 */
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopView_BinaryTree {
    public static void main(String[] args) {
        TopView_BinaryTree tree = new TopView_BinaryTree();
        Node root = tree.createBinaryTree();
        tree.printTopView(root, 0 ,0);
        map.keySet().stream().sorted(Comparator.reverseOrder()).forEach(i->{
                System.out.print(map.get(i).peek().data+ " ");
        });
    }

    static Map<Integer, PriorityQueue<NodeDepth>> map = new HashMap<>();
    private void printTopView(Node root, int hDist, int depth) {
        if(root == null){
            return;
        }

        PriorityQueue<NodeDepth> nodeQueue = map.getOrDefault(hDist,new PriorityQueue<>());
        nodeQueue.add(new NodeDepth(root.data, depth));

        if(!map.containsKey(hDist)) {
            map.put(hDist, nodeQueue);
        }

        printTopView(root.left,hDist+1, depth+1 );
        printTopView(root.right,hDist-1,depth+1);
    }

    class NodeDepth implements Comparable {
        int depth;
        int data;
        public NodeDepth(int data, int depth) {
            this.depth = depth;
            this.data = data;
        }

        @Override
        public int compareTo(Object o) {
            NodeDepth nodeDepth = (NodeDepth)o;
            return this.depth - nodeDepth.depth;
        }
    }
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node createBinaryTree() {
        Node root = new Node(1);
        //root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

//        root.left = new Node(2);
//        root.left.left = new Node(10);
//        root.left.right = new Node(4);
//
//        root.right = new Node(3);
//        root.right.left = new Node(5);
//        root.right.right = new Node(6);
//        root.right.right.right = new Node(60);
//        root.right.left.left = new Node(7);
//        root.right.left.right = new Node(8);

        return root;
    }
}
