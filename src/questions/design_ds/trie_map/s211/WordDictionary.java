package questions.design_ds.trie_map.s211;

import questions.design_ds.trie_map.TrieMap;

public class WordDictionary {
    private final TrieMap<Object> map;

    public WordDictionary() {
        map=new TrieMap<>();
    }

    public void addWord(String word) {
        map.put(word, new Object());
    }

    public boolean search(String word) {
        return map.hasKeyWithPattern(word);
    }
}
