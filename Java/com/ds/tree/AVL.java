package com.ds.tree;

public class AVL<K extends Comparable<K>, V> {
    class Node {
        private K key;
        private V value;
        private int height;
        private Node left;
        private Node right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public AVL() {
          root = null;
    }

    private int heightOf(Node n) {
        if(n == null) return 0;
        return n.height;
    }

    public void insert(K key, V value) {
          root = insert(key, value, root);
    }

    private Node insert(K key, V value, Node root) {
          if(root == null) return new Node(key, value);

          int cmp = key.compareTo(root.key);

          if(cmp == 0) root.value = value;
          else if(cmp > 0) root.right = insert(key, value, root.right);
          else root.left = insert(key, value, root.left);

          root.height = 1 + Math.max(heightOf(root.left), heightOf(root.right));

          int balance = heightOf(root.left) - heightOf(root.right);

          if(balance > 1) {
              if(key.compareTo(root.left.key) > 0) {
                  root.left = leftRotate(root.left);
              }
              root = rightRotate(root);
          }
          else if (balance < -1) {
              if(key.compareTo(root.right.key) < 0) {
                  root.right = rightRotate(root.right);
              }
              root = leftRotate(root);
          }
          return root;
    }

    private Node leftRotate(Node n) {
          Node t = n.right;
          n.right = t.left;
          t.left = n;
          n.height = 1 + Math.max(heightOf(n.left), heightOf(n.right));
          t.height = 1 + Math.max(heightOf(t.left), heightOf(t.right));
          return t;
    }

    private Node rightRotate(Node n) {
          Node t = n.left;
          n.left = t.right;
          t.right = n;
          n.height = 1 + Math.max(heightOf(n.left), heightOf(n.right));
          t.height = 1 + Math.max(heightOf(t.left), heightOf(t.right));
          return t;
    }

    public void printList(List<K> l) {
        Iterator<K> itr = l.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
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
 }
