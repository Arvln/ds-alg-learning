package questions.design_ds.trie_map;

import java.util.LinkedList;
import java.util.List;

public class TrieMap<T> {
    private static class Node<T> {
        private T val;
        private Node<T>[] children=new Node[R];
    }
    private final static int R=256;
    private Node<T> root;
    private int size=0;

    private Node<T> put(Node<T> node, String key, T val, int i) {
        if (node==null) node=new Node<>();
        if (i==key.length()) {
            node.val=val;
            return node;
        }

        char c=key.charAt(i);
        node.children[c]=put(node.children[c], key, val, i+1);
        return node;
    }

    public void put(String key, T val) {
        if (!containsKey(key)) size++;

        root=put(root, key, val, 0);
    }

    private Node<T> remove(Node<T> node, String key, int i) {
        if (node==null) return null;
        if (i==key.length()) {
            node.val=null;
        } else {
            char c=key.charAt(i);
            node.children[c]=remove(node.children[c], key, i+1);
        }

        if (node.val!=null) return node;

        for (char j = 0; j < R; j++) {
            if (node.children[j]!=null) return node;
        }
        return null;
    }

    public void remove(String key) {
        if (!containsKey(key)) return;

        root=remove(root, key, 0);
        size--;
    }

    private Node<T> getNode(Node<T> node, String key) {
        for (int i = 0; i < key.length()&&node != null; i++) {
            char c=key.charAt(i);
            node=node.children[c];
        }
        return node;
    }

    public T get(String key) {
        Node<T> node=getNode(root, key);

        if (node!=null&&node.val!=null) return node.val;
        return null;
    }

    public boolean containsKey(String key) {
        return get(key)!=null;
    }

    public String shortestPrefixOf(String query) {
        Node<T> node=root;
        for (int i = 0; i < query.length()&&node != null; i++) {
            if (node.val!=null) return query.substring(0, i);

            char c=query.charAt(i);
            node=node.children[c];
        }

        if (node!=null&&node.val!=null) return query;
        return "";
    }

    public String longestPrefixOf(String query) {
        Node<T> node=root;
        int maxLen=0;
        for (int i = 0; i < query.length()&&node != null; i++) {
            if (node.val!=null) maxLen=i;

            char c=query.charAt(i);
            node=node.children[c];
        }

        if (node!=null&&node.val!=null) return query;
        return query.substring(0, maxLen);
    }

    private void traverse(Node<T> node, StringBuilder path, List<String> res) {
        if (node==null) return;
        if (node.val!=null) res.add(path.toString());

        for (char c = 0; c < R; c++) {
            path.append(c);
            traverse(node.children[c], path, res);
            path.deleteCharAt(path.length()-1);
        }
    }

    public List<String> keysWithPrefix(String prefix) {
        List<String> res=new LinkedList<>();
        traverse(getNode(root, prefix), new StringBuilder(prefix), res);
        return res;
    }

    public boolean hasKeyWithPrefix(String prefix) {
        return getNode(root, prefix)!=null;
    }

    private void traverse(Node<T> node, StringBuilder path, String pattern, int i, List<String> res) {
        if (node==null) return;
        if (i==pattern.length()) {
            if (node.val!=null) res.add(path.toString());
            return;
        }

        char c=pattern.charAt(i);
        if (c=='.') {
            for (char j = 0; j < R; j++) {
                path.append(j);
                traverse(node.children[j], path, pattern, i+1, res);
                path.deleteCharAt(path.length()-1);
            }
        } else {
            path.append(c);
            traverse(node.children[c], path, pattern, i+1, res);
            path.deleteCharAt(path.length()-1);
        }
    }

    public List<String> keysWithPattern(String pattern) {
        List<String> res=new LinkedList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }

    private boolean hasKeyWithPattern(Node<T> node, String pattern, int i) {
        if (node==null) return false;
        if (i==pattern.length()) return node.val!=null;

        char c=pattern.charAt(i);
        if (c!='.') return hasKeyWithPattern(node.children[c], pattern, i+1);

        for (char j = 0; j < R; j++) {
            if (hasKeyWithPattern(node.children[j], pattern, i+1)) return true;
        }

        return false;
    }

    public boolean hasKeyWithPattern(String pattern) {
        return hasKeyWithPattern(root, pattern, 0);
    }

    public int size() { return size; }
}
