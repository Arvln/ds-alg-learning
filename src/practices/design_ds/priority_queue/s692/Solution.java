package practices.design_ds.priority_queue.s692;

import java.util.*;

public class Solution {
    private HashMap<String, Integer> wordToFreq=new HashMap<>();

    public List<String> topKFrequent(String[] words, int k) {
        for (String word : words) {
            wordToFreq.put(word, wordToFreq.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b)->{
                    if (a.getValue() == b.getValue()) {
                        return b.getKey().compareTo(a.getKey());
                    }
                    return a.getValue()-b.getValue();
                }
        );
        for (Map.Entry<String, Integer> entry : wordToFreq.entrySet()) {
            pq.offer(entry);
            if (pq.size()>k) pq.poll();
        }

        LinkedList<String> res=new LinkedList<>();
        while(!pq.isEmpty()) {
            res.addFirst(pq.poll().getKey());
        }
        return res;
    }
}
