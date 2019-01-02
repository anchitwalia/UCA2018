import com.ds.tree.BST;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer, String> object = new BST<>();
        object.insert(50, "abc");
        object.insert(30, "def");
        object.insert(20, "ghi");
        object.insert(40, "jkl");
        object.insert(70, "mno");
        object.insert(60, "pqr");
        object.insert(80, "stu");
        object.delete(50);
        object.inOrder();
    }
}
