//package com.ds.tree;

public class TrieTree {
    private static final int R = 256;
    private int N;
    private Node root;

    public TrieTree() {
        N = 0;
        root = null;
    }

    public void stringInsert(String key) {
        int index = 0;
        root = stringInsert(key, root, index);
    }

    private Node stringInsert(String key, Node curr, int index) {
        if(curr == null) {
            curr = new Node();
        }

        if(key.length() == index) {
            curr.isEndOfWord = true;
            N++;
            return curr;
        }
        char c = key.charAt(index);
        curr.next[c] = stringInsert(key, curr.next[c], index + 1);
        return curr;
    }

    public void stringSearch(String key) {
        int index = 0;
        stringSearch(key, root, index);
    }

    private void stringSearch(String key, Node curr, int index) {
        if(curr == null){
            System.out.println(key + " Not Found");
            return;
        }
        if(key.length() == index && curr.isEndOfWord == true){
            System.out.println(key + " Found");
            return;
        }
        if(key.length() <= index){
            System.out.println(key + " Not Found");
            return;
        }
        char c = key.charAt(index);
        stringSearch(key, curr.next[c], index + 1);
        return;
    }

    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int index = 0;
        root = delete(root, key, index);
    }

    private Node delete(Node curr, String key ,int index) {
      if (curr == null) {
          return null;
      }
      if (index == key.length()) {
          if (curr.isEndOfWord != false) {
              curr.isEndOfWord = false;
              N--;
          }
      }
      else {
          char c = key.charAt(index);
          curr.next[c] = delete(curr.next[c], key, index + 1);
      }

      if (curr.isEndOfWord != false) return curr;

      for (int c = 0; c < R; c++) {
          if (curr.next[c] != null) return curr;
      }

      return null;
    }

    public class Node {
        boolean isEndOfWord;
        Node[] next;

        public Node() {
            isEndOfWord = false;
            next = new Node[R];
        }
    }

    public static void main(String[] args) {
         TrieTree obj = new TrieTree();
         obj.stringInsert("Anchit");
         obj.stringInsert("Anchit1");
         obj.stringInsert("Anupam");
         obj.stringInsert("Bhavita");
         obj.stringSearch("Anchit1");
         obj.stringSearch("Anchit");
         obj.stringSearch("");
         obj.stringSearch("Bhavita");
         obj.delete("Anchit1");
         obj.stringSearch("Anchit");
         obj.stringSearch("Anchit1");
    }
}
