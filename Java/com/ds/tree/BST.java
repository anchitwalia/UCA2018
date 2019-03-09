package com.ds.tree;

public class BST<K extends Comparable<K>, V> {
    private class Node {
        private K key;
        private V value;
        private int hd;
        private int size;
        private Node left;
        private Node right;
        public Node(K key, V value, int hd) {
            this.key = key;
            this.value = value;
            this.hd = hd;
            this.size = 1;
            this.left = this.right = null;
        }
    }

    private Node root;
    public BST() {
        this.root = null;
    }

    public void insert(K key, V value) {
        root = insert(root, key, value, 0);
    }
    private Node insert(Node curr, K key, V value, int hd) {
        if(curr == null) {
            return new Node(key, value, hd);
        }
        int cmp = key.compareTo(curr.key);
        if(cmp == 0) {
            curr.value = value;
        }
        else if(cmp > 0) {
            curr.right = insert(curr.right, key, value, hd + 1);
        }
        else {
            curr.left = insert(curr.left, key, value, hd - 1);
        }
        curr.size = 1 + sizeOf(curr.left) + sizeOf(curr.right);
        return curr;
    }

    private Node minNode(Node curr) {
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public void delete(K key) {
        root = delete(root, key);
    }
    private Node delete(Node curr,K key) {
        if(curr == null) {
            return null;
        }
        int cmp = key.compareTo(curr.key);
        if(cmp > 0) {
            curr.right = delete(curr.right, key);
        }
        else if(cmp < 0) {
          curr.left = delete(curr.left, key);
        }
        else{
          if(curr.left == null) {
              return curr.right;
          }
          else if(curr.right == null) {
              return curr.left;
          }
          else {
              Node minN = minNode(curr.right);
              curr.key = minN.key;
              curr.value = minN.value;
              curr.right = delete(curr.right, curr.key);
          }
        }
        return curr;
    }

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node curr) {
        if (curr == null) {
            return;
        }
		    inOrder(curr.left);
		    System.out.println(curr.key + " : "  + curr.value + " : " + curr.hd+  " : " + curr.size);
		    inOrder(curr.right);
    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node curr) {
        if (curr == null) {
            return;
        }
        System.out.println(curr.key + " : "  + curr.value + " : " + curr.hd+  " : " + curr.size);
		    preOrder(curr.left);
		    preOrder(curr.right);
    }

    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node curr) {
        if (curr == null) {
            return;
        }
		    postOrder(curr.left);
		    postOrder(curr.right);
        System.out.println(curr.key + " : "  + curr.value + " : " + curr.hd+  " : " + curr.size);
    }

    public int rankOf(K key) {
        if(root == null){
            return -1;
        }
        return rankOf(root, key);
    }
    private int rankOf(Node curr, K key) {
        if(curr == null) {
            return -1;
        }
        int cmp = key.compareTo(curr.key);
        if(cmp == 0) {
            return sizeOf(curr.left);
        }
        else if(cmp < 0) {
            return rankOf(curr.left, key);
        }
        else {
            return 1 + sizeOf(curr.left) + rankOf(curr.right, key);
        }
    }

    public Node getNode(K key) {
        if(root == null) {
            return null;
        }
        return getNode(root, key);
    }
    private Node getNode(Node curr, K key) {
        if(curr == null) {
            return curr;
        }
        int cmp = key.compareTo(curr.key);
        if(cmp == 0) {
            return curr;
        }
        else if(cmp > 0) {
            return getNode(curr.right, key);
        }
        else {
            return getNode(curr.left, key);
        }
    }

    public int heightOf(K key) {
        if(root == null){
            return 0;
        }
        return heightOf(getNode(key));
    }
    private int heightOf(Node curr) {
        if(curr == null) {
            return -1;
        }
        else {
            return 1 + Math.max(heightOf(curr.left), heightOf(curr.right));
        }
    }

    public int diameterOf(K key) {
        if(root == null){
            return 0;
        }
        return diameterOf(getNode(key));
    }
    private int diameterOf(Node curr) {
        if(curr == null) {
            return 0;
        }
        int lheight = heightOf(curr.left);
        int rheight = heightOf(curr.right);
        int ldiameter = diameterOf(curr.left);
        int rdiameter = diameterOf(curr.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    public int sizeOf() {
        if(root == null){
            return 0;
        }
        return sizeOf(root);
    }
    private int sizeOf(Node curr) {
        return curr == null ? 0 : curr.size;
    }

    public K ceilingOf(K key) {
        if(root == null) {
            return null;
        }
        return ceilingOf(root, key, null);
    }
    private K ceilingOf(Node curr, K key, K ceil) {
        if(curr == null) {
            return ceil;
        }
        int cmp = key.compareTo(curr.key);
        if(cmp <= 0 ) {
            return ceilingOf(curr.left, key, curr.key);
        }
        return ceilingOf(curr.right, key, ceil);
    }

    public K floorOf(K key) {
        if(root == null){
            return null;
        }
        return floorOf(root, key, null);
    }
    private K floorOf(Node curr, K key, K floor) {
        if(curr == null) {
            return floor;
        }
        int cmp = key.compareTo(curr.key);
        if(cmp < 0 ) {
        return floorOf(curr.left, key, curr.key);
        }
        return floorOf(curr.right, key, floor);
    }
}
