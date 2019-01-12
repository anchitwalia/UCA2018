import com.algo.tree.BSTTraversals;

public class BSTTraversalsTest {
    public static void main(String[] args) {
        BSTTraversals<Integer, String> object = new BSTTraversals<>();

        object.insert(50, "Anchit");
        object.insert(30, "Bhavita");
        object.insert(20, "Anupam");
        object.insert(40, "Divya");
        object.insert(70, "Hemant");
        object.insert(60, "Daksh");
        object.insert(80, "Bhavya");

        object.printList(object.inOrder());
        object.printList(object.preOrder());
        object.printList(object.postOrder());
        object.printList(object.levelOrder());
        object.printList(object.zigZagOrder());
    }
}
