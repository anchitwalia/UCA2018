import java.util.*;

public class PallindromeList {
    private class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
    Node head;
    public PallindromeList() {
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

    private boolean checkPallindrome(Node head1, Node head2) {
        while(head1 != null && head2 != null) {
            if(head1.value == head2.value) {
                head1 = head1.next;
                head2 = head2.next;
            }
            else {
                return false;
            }
        }
        if((head1 == null && head2 == null) ||  ( head1 == null && head2.next == null)){
            return true;
        }
        return false;
    }

    public boolean isPallindrome() {
        return isPallindrome(head);
    }

    private boolean isPallindrome(Node root) {
        if(root.next == null) {
            return true;
        }
        Node ptr1 = root;
        Node ptr2 = root;
        Node Prev = root;
        Node midNode = null;

        while(ptr2 != null && ptr2.next != null) {
            Prev = ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }

        if(ptr2 != null) {
            midNode = ptr1;
            ptr1 = ptr1.next;
        }

        Node firstHead = root;
        Node secondHead = rotateList(ptr1);
        Prev.next = null;

        boolean result = checkPallindrome(firstHead, secondHead);

        secondHead = rotateList(secondHead);
        Prev.next = secondHead;

        if(midNode != null) {
            midNode.next = secondHead;
            Prev.next = midNode;
        }
        return result;
    }

    public static void main(String[] args) {

        PallindromeList obj1 = new PallindromeList();
        PallindromeList obj2 = new PallindromeList();
        PallindromeList obj3 = new PallindromeList();
        PallindromeList obj4 = new PallindromeList();
        PallindromeList obj5 = new PallindromeList();

        int[] A1 = {3, 3, 4, 4, 4, 4, 3, 3};
        int[] A2 = {1, 2, 3, 4, 5};
        int[] A3 = {4 ,2, 1};
        int[] A4 = {3};
        int[] A5 = {6, 7};

        for(int i : A1) { obj1.addEnd(i); }
        for(int i : A2) { obj2.addEnd(i); }
        for(int i : A3) { obj3.addEnd(i); }
        for(int i : A4) { obj4.addEnd(i); }
        for(int i : A5) { obj5.addEnd(i); }


        System.out.println();
        System.out.print("Obj1 = "+ obj1.isPallindrome());
        System.out.println();
        System.out.print("Obj2 = "+ obj2.isPallindrome());
        System.out.println();
        System.out.print("Obj3 = "+ obj3.isPallindrome());
        System.out.println();
        System.out.print("Obj4 = "+ obj4.isPallindrome());
        System.out.println();
        System.out.print("Obj5 = "+ obj5.isPallindrome());
        System.out.println();
        System.out.println();

        obj1.printList();
        obj2.printList();
        obj3.printList();
        obj4.printList();
        obj5.printList();

    }
}
