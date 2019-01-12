package com.algo.tree;
import java.util.Stack;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class BSTTraversals<K extends Comparable<K>, V> {
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;
    public BSTTraversals() {
        this.root = null;
    }

    public void printList(List<K> l) {
        Iterator<K> itr = l.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }
    private Node insert(Node curr, K key, V value) {
        if(curr == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(curr.key);
        if(cmp == 0) {
            curr.value = value;
        }
        else if(cmp > 0) {
            curr.right = insert(curr.right, key, value);
        }
        else {
            curr.left = insert(curr.left, key, value);
        }
        return curr;
    }

    public List<K> inOrder() {
        return inOrder(root);
    }

    private List<K> inOrder(Node curr) {
        List<K> l = new ArrayList<K>();
        if(curr == null) {
            return l;
        }
        Stack<Node> s = new Stack<Node>();
        while(curr != null || s.size() > 0) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            l.add(curr.key);
            curr = curr.right;
        }
        return l;
    }
    public List<K> preOrder() {
        return preOrder(root);
    }

    private List<K> preOrder(Node curr) {
        List<K> l = new ArrayList<K>();
        if(curr == null) {
            return l;
        }
        Stack<Node> s = new Stack<Node>();
        s.push(curr);
        while(s.empty() == false) {
            curr = s.pop();
            l.add(curr.key);
            if(curr.right != null) {
                s.push(curr.right);
            }
            if(curr.left != null) {
                s.push(curr.left);
            }
        }
        return l;
    }

    public List<K> postOrder() {
        return postOrder(root);
    }

    private List<K> postOrder(Node curr) {
        List<K> l = new ArrayList<K>();
        if(curr == null) {
            return l;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(curr);
        while(s1.empty() == false) {
            curr = s1.pop();
            s2.push(curr);
            if(curr.left != null) {
                s1.push(curr.left);
            }
            if(curr.right != null) {
                s1.push(curr.right);
            }
        }
        while(s2.empty() == false) {
            curr = s2.pop();
            l.add(curr.key);
        }
        return l;
    }

    public List<K> levelOrder() {
        return levelOrder(root);
    }
    private List<K> levelOrder(Node curr) {
        List<K> l = new ArrayList<>();
        if(curr == null) {
            return l;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(curr);
        while(!q.isEmpty()) {
            Node temp = q.remove();
            l.add(temp.key);
            if(temp.left != null) {
                q.add(temp.left);
            }
            if(temp.right != null) {
                q.add(temp.right);
            }
        }
        return l;
    }

    public List<K> zigZagOrder() {
        return zigZagOrder(root);
    }
    private List<K> zigZagOrder(Node curr) {
        List<K> l = new ArrayList<>();
        if(curr == null) {
            return l;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        boolean leftToRight = true;

        s1.push(curr);

        while(!s1.isEmpty()) {
            Node temp = s1.pop();
            l.add(temp.key);
            if(leftToRight) {
                if(temp.left != null) {
                    s2.push(temp.left);
                }
                if(temp.right != null) {
                    s2.push(temp.right);
                }
            }
            else {
                if(temp.right != null) {
                    s2.push(temp.right);
                }
                if(temp.left != null) {
                    s2.push(temp.left);
                }
            }
            if (s1.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp2 = s1;
                s1 = s2;
                s2 = temp2;
            }

        }
        return l;
    }
}
