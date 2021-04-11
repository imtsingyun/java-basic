package org.mindidea.datastructure_015Trie字典树;

public class Main {
    public static void main(String[] args) {
        DemoTrie<Integer> trie = new DemoTrie<>();
        trie.add("cat", 1);
        trie.add("dog", 2);
        trie.add("catalog", 3);
        trie.add("cast", 4);
        trie.add("测试键", 5);

        System.out.println(trie);
    }
}
