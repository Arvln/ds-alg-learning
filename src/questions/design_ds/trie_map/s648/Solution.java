package questions.design_ds.trie_map.s648;

import questions.design_ds.trie_map.TrieMap;

import java.util.List;

public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieMap<Object> map=new TrieMap<>();
        for (String root : dictionary) map.put(root, new Object());

        StringBuilder sb = new StringBuilder();
        String[] words=sentence.split(" ");
        for(int i=0; i<words.length; i++) {
            String prefix=map.shortestPrefixOf(words[i]);

            if (prefix.isEmpty()) sb.append(words[i]);
            else sb.append(prefix);

            if (i!=words.length-1) sb.append(" ");
        }
        return sb.toString();
    }
}
