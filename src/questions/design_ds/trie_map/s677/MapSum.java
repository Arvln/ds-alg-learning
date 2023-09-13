package questions.design_ds.trie_map.s677;

import questions.design_ds.trie_map.TrieMap;

import java.util.List;

public class MapSum {
    private final TrieMap<Integer> map;

    public MapSum() {
        map=new TrieMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        List<String> keysWithPrefix = map.keysWithPrefix(prefix);
        int res=0;
        for (String key : keysWithPrefix) res+=map.get(key);
        return res;
    }
}
