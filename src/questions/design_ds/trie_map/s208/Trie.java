package questions.design_ds.trie_map.s208;

import questions.design_ds.trie_map.TrieMap;

public class Trie {
    private final TrieMap<Object> map;
    public Trie() {
        map=new TrieMap<>();
    }

    public void insert(String word) {
        map.put(word, new Object());
    }

    public boolean search(String word) {
        return map.containsKey(word);
    }

    public boolean startsWith(String prefix) {
        return map.hasKeyWithPrefix(prefix);
    }
}
