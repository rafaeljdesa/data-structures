package br.com.example.data.structures;

import java.util.HashMap;

public class Trie {

    private Node root = new Node();

    class Node {
        private HashMap<String, Node> children = new HashMap<>();
        private boolean isEndOfWord;
    }

    public void insert(String word) {
        String[] chars = word.split("");
        Node current = this.root;
        for (String c : chars) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new Node());
            }
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        String[] chars = word.split("");
        Node current = this.root;
        for (String c : chars) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String word) {
        String[] chars = word.split("");
        Node current = this.root;
        for (String c : chars) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

}
