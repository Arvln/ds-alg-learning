package questions.design_ds.trie_map.s1804;

import questions.design_ds.trie_map.TrieMap;

public class Trie {
    private final TrieMap<Integer> map;

    public Trie() {
        map=new TrieMap<>();
    }

    private int count(String word) {
        int count=0;
        if (map.containsKey(word)) count=map.get(word);

        return count;
    }

    public void insert(String word) {
        map.put(word, count(word)+1);
    }

    public int countWordsEqualTo(String word) {
        return count(word);
    }

    public int countWordsStartingWith(String prefix) {
        return map.keysWithPrefix(prefix).size();
    }

    public void erase(String word) {
        int count=count(word);
        if (count==0) return;
        if (count==1) map.remove(word);
        else map.put(word, count-1);
    }
}
