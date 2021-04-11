package org.mindidea.datastructure_015Trie字典树;

import java.util.HashMap;

/**
 * 字典树
 *      使用 trie 存储 cat, dog, doggy, does, cast, add 六个单词
 *      查询上述单词中是否存在 dog 开头的单词
 *
 * @param <V>
 */
public class DemoTrie<V> {

    private int size;
    private Node<V> root = new Node<>();

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public V get(String key) {
        Node<V> node = node(key);
        return node == null ? null: node.value;
    }

    public boolean contains(String key) {
        return node(key) != null;
    }

    public V add(String key, V value) {
        keyCheck(key);

        Node<V> node = this.root;
        int length = key.length();
        for (int i = 0; i < length; i++) {
            char c = key.charAt(i);
            Node<V> childNode = node.getChildren().get(c);
            if (childNode == null) {
                childNode = new Node<>();
                node.getChildren().put(c, childNode);
            }
            node = childNode;
        }

        // 已经存在这个单词
        if (node.word) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        // 新增一个单词
        node.word = true;
        node.value = value;
        size++;
        return null;
    }

    public V remove(String key) {

        return null;
    }

    public boolean startWith(String prefix) {

        return false;
    }

    public Node<V> node(String key) {
        if (root == null) {
            return null;
        }
        keyCheck(key);
        Node<V> node = root;

        int length = key.length();
        for (int i = 0; i < length; i++) {
            // dog, d, o, g
            char c = key.charAt(i);
            node = node.getChildren().get(c);
            if (node == null) {
                return null;
            }
        }
        return node.word ? node : null;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("key must not be empty");
        }
    }

    private static class Node<V> {
        HashMap<Character, Node<V>> children;
        V value;
        // 是否为单词的结尾
        boolean word;

        public HashMap<Character, Node<V>> getChildren() {
            return children == null ? (children = new HashMap<>()) : children;
        }
    }


}
