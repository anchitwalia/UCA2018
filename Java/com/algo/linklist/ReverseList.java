import java.util.*;

public class ReverseList {
    private class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
    Node head;
    public ReverseList() {
        head = null;
    }

    public void addEnd(int data) {
        head = addEnd(head, data);
    }

    private Node addEnd(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        else {
            root.next = addEnd(root.next, data);
        }
        return root;
    }

    public void printList() {
        printList(head);
    }
    private void printList(Node root) {
        if(root == null) {
            System.out.println("NULL");
            return;
        }
        else {
            System.out.print(root.value + " -> ");
            printList(root.next);
        }
    }

    public void rotateListIterative() {
        head = rotateListIterative(head);
    }

    private Node rotateListIterative(Node root) {
        Node curr = root;
        Node prev = null;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        root = prev;
        return root;
    }

    public void rotateList() {
        head = rotateList(head);
    }

    private Node rotateList(Node root) {
        if(root == null) return null;
        if(root.next == null) return root;

        Node rest = root.next;
        Node temp = rotateList(rest);
        root.next = null;
        rest.next = root;

        return temp;
    }

    public static void main(String[] args) {
        ReverseList obj = new ReverseList();
        obj.addEnd(1);
        obj.addEnd(2);
        obj.addEnd(3);
        obj.addEnd(4);
        obj.addEnd(5);
        obj.printList();
        obj.rotateListIterative();
        obj.printList();
    }
}
